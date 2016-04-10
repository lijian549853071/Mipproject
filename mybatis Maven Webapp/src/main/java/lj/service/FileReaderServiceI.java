package lj.service;

import java.util.List;

import lj.model.Resource;

public interface FileReaderServiceI {

	public void fileReaderByResource(Resource res);
	public double[][] matrix_fileread(String path);
	public List common_fileread(String path);
}
