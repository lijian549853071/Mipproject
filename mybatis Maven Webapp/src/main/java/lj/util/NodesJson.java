package lj.util;

import java.util.ArrayList;
import java.util.List;

import lj.jsonmodel.Links;
import lj.jsonmodel.Nodes;

public class NodesJson {

	//为转化为json之前写入List之中,输入数据为节点名字与社团划分结果
	public static List<Nodes> toNodesJson(String[] clusterflag,List nodesname){
		
		List<Nodes> nodes=new ArrayList<Nodes>();
		int size=nodesname.size();
		for(int i=0;i<size;i++){
			Nodes node=new Nodes();
			node.setName((String)nodesname.get(i));
			node.setGroup(Integer.parseInt(clusterflag[i+1]));
			nodes.add(node);
		}		
		return nodes;		
	};
	//输入数据为二维矩阵double[][]
	public static List<Links> toLinksJson(double[][] cor){
		
		List<Links> links=new ArrayList<Links>();
		int size=cor.length;
		for(int i=1;i<size;i++){
			for(int j=0;j<i;j++){
				if(cor[i][j]!=0){
					Links link=new Links();
					link.setSource(i);
					link.setTarget(j);
					link.setValue(cor[i][j]);
					links.add(link);
				}else continue;			
			}			
		}		
		return links;		
	};
}
