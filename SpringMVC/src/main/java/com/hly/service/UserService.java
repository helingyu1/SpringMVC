package com.hly.service;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hly.dao.UserMapper;
import com.hly.entity.User;

@Service
public class UserService {
	@Autowired
	UserMapper userDao;
	
	Logger logger = Logger.getLogger(UserService.class);
	
	public User findUser(int id){
		logger.info("Ω¯¿¥service≤„¡À");
		return userDao.selectByPrimaryKey(id);
	}
	
}
