package lj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lj.dao.UserMapper;
import lj.model.User;
import lj.service.UserServiceI;
@Service("userService")
public class UserServiceImpl implements UserServiceI {

	private UserMapper userMapper;
	public UserMapper getUserMapper() {
		return userMapper;
	}
	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	@Override
	public User getUserById(String idf) {
		// TODO Auto-generated method stub
		
		return userMapper.selectByPrimaryKey(idf);
	}

}
