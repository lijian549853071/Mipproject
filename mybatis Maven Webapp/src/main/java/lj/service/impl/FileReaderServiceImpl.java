package lj.service.impl;
/**
 * 读取数据库中的文件路径
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lj.dao.ResourceMapper;
import lj.model.Resource;
import lj.service.FileReaderServiceI;
@Service("filereaderService")
public class FileReaderServiceImpl implements FileReaderServiceI{
	private ResourceMapper resourceMapper;
	
	public ResourceMapper getResourceMapper() {
		return resourceMapper;
	}
	@Autowired
	public void setResourceMapper(ResourceMapper resourceMapper) {
		this.resourceMapper = resourceMapper;
	}
	@Override
	public void fileReaderByResource(Resource res) {
		// TODO Auto-generated method stub
		double[][] result=matrix_fileread(resourceMapper.selectByPrimaryKey(res.getId()).getSavepath());
	}
	
	
	
	
	//矩阵读取，需改进
	public double[][] matrix_fileread(String path){
		double[][] out=new double[90][90];//需改进
		File file=new File(path);
		if(file.isFile()&&file.exists()){
			try {
				InputStreamReader read=new InputStreamReader(new FileInputStream(file),"UTF-8");
				BufferedReader bufferedReader=new BufferedReader(read);
				String linetext=null;
				//i行j列
				int i=0;
				while((linetext=bufferedReader.readLine())!=null){
					String []se=linetext.split(" ");
					int j=0;
					for(int k=0;k<se.length;k++){
						if("".equals(se[k]))
							continue;
						else{
							out[i][j++]=Double.parseDouble(se[k]);
						}					
					}
					++i;
					//System.out.println(linetext);
					//System.out.println();
				}
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return out;
	}
	
	@Override
	//普通行标记文件读取,list可变数组
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
