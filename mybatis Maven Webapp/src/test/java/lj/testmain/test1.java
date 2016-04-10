package lj.testmain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import lj.jsonmodel.Links;
import lj.jsonmodel.Nodes;
import lj.model.Resource;
import lj.model.User;
import lj.service.FileReaderServiceI;
import lj.service.ResourceServiceI;
import lj.service.UserServiceI;
import lj.util.NodesJson;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cluster.Cluster;

import com.alibaba.fastjson.JSON;
import com.mathworks.toolbox.javabuilder.MWArray;
import com.mathworks.toolbox.javabuilder.MWClassID;
import com.mathworks.toolbox.javabuilder.MWException;
import com.mathworks.toolbox.javabuilder.MWNumericArray;

import TestMatlab.matlabadd;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring.xml","classpath:spring-mybatis.xml"})
public class test1 {
	private FileReaderServiceI filereaderService;

	public FileReaderServiceI getFilereaderService() {
		return filereaderService;
	}
	@Autowired
	public void setFilereaderService(FileReaderServiceI filereaderService) {
		this.filereaderService = filereaderService;
	}

//	@Test
//	public void test(){
////		ApplicationContext ac=new ClassPathXmlApplicationContext(new String[]{"spring.xml","spring-mybatis.xml"});
////		userService=(UserServiceI)ac.getBean("userService");
//		User u=userService.getUserById("1");
//		Resource res=new lj.model.Resource();
//		res.setDescription("测试用例");
//		res.setId(1);
//		//resourceService.updateByPrimaryKey(res);
//		//System.out.println(u.getName());
//		List<Resource> l=resourceService.getAll();
//		System.out.println(JSON.toJSONStringWithDateFormat(l,"yyyy-MM-dd HH:mm:ss"));
//	}
	
	@Test
	public void test1(){
		try {
			List st=common_fileread("E:\\net_data_AAL\\2D_before\\chengjiamin\\demo.txt");
			matlabadd add=new matlabadd();
			Cluster cluster=new Cluster();
			Object[] result=null;
			Object[] resultcluster=null;
			MWNumericArray input=null;//用于保存矩阵
			int a=10,b=2;
			result=add.add(1,a,b);
			System.out.println(result[0].toString());
			
			double[][] out= filereaderService.matrix_fileread("E:\\net_data_AAL\\2D_before\\chengjiamin\\FCMap_Chenjiamin_3b_wras_detrend_filtered.txt");
			//System.out.println(out);
			List<Links> linktest=NodesJson.toLinksJson(out);
			input=new MWNumericArray(out,MWClassID.DOUBLE);
			
			
			resultcluster=cluster.Cluster(1,out,a);
			//MWArray.disposeArray(resultcluster);
			String []se=resultcluster[0].toString().split("\\D+");//正则表达式形式
			List<Nodes> nodetest=NodesJson.toNodesJson(se, st);
			System.out.println(resultcluster[0].toString());
		} catch (MWException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			//MWArray.disposeArray(input);
			//cluster.dispose();
		}
		
	}
	
	
	public List common_fileread(String path) {
		// TODO Auto-generated method stub
		File file=new File(path);
		List<String> result=new ArrayList<String>();
		if(file.isFile()&&file.exists()){
			try {
				InputStreamReader reader=new InputStreamReader(new FileInputStream(file));
				BufferedReader bufferedReader=new BufferedReader(reader);
				String linetext=null;
				int i=0;
				
				while((linetext=bufferedReader.readLine())!=null){
					result.add(linetext);
					++i;
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return result;
	}
}
