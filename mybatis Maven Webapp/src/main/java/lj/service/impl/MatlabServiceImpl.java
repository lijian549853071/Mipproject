package lj.service.impl;

import org.springframework.stereotype.Service;

import com.mathworks.toolbox.javabuilder.MWClassID;
import com.mathworks.toolbox.javabuilder.MWException;
import com.mathworks.toolbox.javabuilder.MWNumericArray;

import cluster.Cluster;
import lj.service.MatlabServiceI;
@Service("matlabService")
public class MatlabServiceImpl implements MatlabServiceI {

	@Override
	public String[] matlabCluster(double[][] cor, int counts) {
		// TODO 处理相关矩阵社团划分
		try {
			Cluster cluster=new Cluster();
			Object[] resultcluster=null;
//			MWNumericArray input=null;//用于保存矩阵
//			input=new MWNumericArray(cor,MWClassID.DOUBLE);
			resultcluster=cluster.Cluster(1,cor,counts);
			String []se=resultcluster[0].toString().split("\\D+");
			return se;
		} catch (MWException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
		return null;
	}

}
