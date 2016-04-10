package lj.testmain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

public class testfilereader {
	@Test
	public void test(){
		fileread("E:\\net_data_AAL\\2D_after\\chengjiamin\\FCMap_Chenjiamin_3b_wras_detrend_filtered.txt");
	}
	
	public void fileread(String path){
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
					System.out.println(linetext);
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
	}
}
