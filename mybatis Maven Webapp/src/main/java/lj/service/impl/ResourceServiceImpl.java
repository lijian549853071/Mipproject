package lj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lj.dao.ResourceMapper;
import lj.model.Resource;
import lj.service.ResourceServiceI;
import lj.util.PageBean;
@Service("resourceService")
public class ResourceServiceImpl implements ResourceServiceI {

	private ResourceMapper resourceMapper;
	
	public ResourceMapper getResourceMapper() {
		return resourceMapper;
	}
	@Autowired
	public void setResourceMapper(ResourceMapper resourceMapper) {
		this.resourceMapper = resourceMapper;
	}

	@Override
	public void updateByPrimaryKey(Resource res) {
		// TODO Auto-generated method stub
		resourceMapper.insert(res);
		
	}
	
	public List<Resource> getAll(){
		//return resourceMapper.selectByPageKey(1,2);
		return null;
	};

}
