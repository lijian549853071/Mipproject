package lj.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import lj.jsonmodel.Links;
import lj.jsonmodel.Nodes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.alibaba.fastjson.JSON;

import lj.jsonmodel.NetNode;
import lj.model.Resource;
import lj.model.User;
import lj.service.FileReaderServiceI;
import lj.service.MatlabServiceI;
import lj.service.ResourceServiceI;
import lj.service.UserServiceI;
import lj.util.NodesJson;

@Controller
@RequestMapping("/userController")
public class UserController {

	private UserServiceI userService;
	private ResourceServiceI resourceService;
	private FileReaderServiceI fileReaderService;
	private MatlabServiceI matlabService;
	public MatlabServiceI getMatlabService() {
		return matlabService;
	}
	@Autowired
	public void setMatlabService(MatlabServiceI matlabService) {
		this.matlabService = matlabService;
	}
	public FileReaderServiceI getFileReaderService() {
		return fileReaderService;
	}
	@Autowired
	public void setFileReaderService(FileReaderServiceI fileReaderService) {
		this.fileReaderService = fileReaderService;
	}
	public ResourceServiceI getResourceService() {
		return resourceService;
	}
	@Autowired
	public void setResourceService(ResourceServiceI resourceService) {
		this.resourceService = resourceService;
	}

	public UserServiceI getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserServiceI userService) {
		this.userService = userService;
	}

	@RequestMapping("/{id}/showUser")
	public String showUser(@PathVariable String id, HttpServletRequest request) {
		User u = userService.getUserById(id);
		request.setAttribute("user", u);
		return "showUser";
	}
	
	
	
	//测试json与ajax
	@RequestMapping(value="testjson",method=RequestMethod.GET)
	public void testjson(HttpServletResponse response){
	//测试读取节点文件，处理并显示	
	double[][] out= fileReaderService.matrix_fileread("E:\\net_data_AAL\\2D_before\\chengjiamin\\ab.txt");	
	List st=fileReaderService.common_fileread("E:\\net_data_AAL\\2D_before\\chengjiamin\\demo.txt");
	String[] se=matlabService.matlabCluster(out, 10);
	
	NetNode datanodes=new NetNode();
	List<Nodes> nodes=NodesJson.toNodesJson(se, st);
	List<Links> links=NodesJson.toLinksJson(out);
	datanodes.setLinks(links);
	datanodes.setNodes(nodes);
	try {
		response.getWriter().write(JSON.toJSONString(datanodes));
		response.getWriter().flush();
		response.getWriter().close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	//实现文件上传
	@RequestMapping(value="upload",method=RequestMethod.POST)
	@ResponseBody
	public void upload(HttpServletRequest request,HttpServletResponse response){
		// 此部分使用解析器，在web.xml中不能重复配置此解析器。可使用springmvc解析器重构，需配置，更简便一些 
		response.setContentType("text/html;charset=UTF-8");
		String upload="WEB-INF/upload";
		String temp="WEB-INF/temp";
		Map<String,String> map=new HashMap<String,String>();
		try{
		//1、将文件上传到服务器
		//创建上传文件的工厂类
		DiskFileItemFactory factory=new DiskFileItemFactory();
		factory.setSizeThreshold(1024*1024*80);
		factory.setRepository(new File(request.getSession().getServletContext().getRealPath(temp)));//????????
		//获取上传文件的核心类
		ServletFileUpload fileload=new ServletFileUpload(factory);
		fileload.setHeaderEncoding("UTF-8");
		fileload.setFileSizeMax(1024*1024*100);
		fileload.setSizeMax(1024*1024*200);
		if(!fileload.isMultipartContent(request)){
			throw new RuntimeException("表单类型错误");
		}
		//编码文件名
		String uuidname=UUID.randomUUID().toString();
		map.put("uuidname",uuidname);
		//文件分目录存储  
        String hash = Integer.toHexString(uuidname.hashCode());  
        for(char c:hash.toCharArray()){  
            upload += "/"+c;  
        }  
        map.put("savepath", upload); 
		//解析文件数据
		List<FileItem> list=fileload.parseRequest(request);	
		
		for(FileItem item:list){
			if(item.isFormField()){
				String name=item.getFieldName();
				String val=item.getString("UTF-8");
				map.put(name, val);
			}else{
				String realname=item.getName();
				map.put(item.getFieldName(), realname);//数据库中节点或边的文件名
                //创建目录结构  
                new File(request.getSession().getServletContext().getRealPath(upload)).mkdirs();    
                InputStream is = item.getInputStream();  
                OutputStream os = new FileOutputStream(request.getSession().getServletContext()  
                        .getRealPath(upload)+"/"+realname);  
                byte [] b = new byte[1024];  
                int len = 0;  
                while((len=is.read(b))!=-1){  
                    os.write(b, 0, len);  
                }  
                is.close();  
                os.close();  
                item.delete();  
			}
		}
		 //------------2将文件信息保存到数据库中---------------------------》  
        //以下发生错误时，会调转到isMultipartContent()--判断中抛出的异常--  
        Resource res = new Resource();  
        BeanUtils.populate(res,map);    //封装数据  
        res.setUploadtime(new java.sql.Date(System.currentTimeMillis()));
        resourceService.updateByPrimaryKey(res);          
        //------------3返回到首页----------------------------------------》  
        response.getWriter().write("上传成功！3秒后回到主页！");  
        response.setHeader("Refresh", "3;URl="+request.getContextPath()+"/index.jsp");  
          
    }catch(FileSizeLimitExceededException e){  
        try {
			response.getWriter().write("文件大小不能超过100M!");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
    }catch (Exception e) {  
        e.printStackTrace();  
        throw new RuntimeException(e);
		}
	}

}
