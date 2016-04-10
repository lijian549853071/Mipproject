package lj.service;

import java.util.List;

import lj.model.Resource;

public interface ResourceServiceI {
	public void updateByPrimaryKey(Resource res);
	public List<Resource> getAll();
}
