package lj.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import lj.jsonmodel.NetNode;
import lj.service.DataServiceI;

public class DataServiceImpl implements DataServiceI {

	//读取txt文件,out为输出对称矩阵
	public double[][] fileread(String path){
		double[][] out=new double[90][90];
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
	
	//将矩阵文件转换为json格式，满足前端D3.js   ???????未完成，继续
	@Override
	public NetNode jsonPreData(String path) {
		// TODO Auto-generated method stub
		double[][] data=fileread(path);
		
		return null;
	}

}
