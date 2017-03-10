package cn.fictio.springboot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.fictio.springboot.dao.UserDao;
import cn.fictio.springboot.pojo.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	public User reg(User u) {
		User user = userDao.findUserByUserName(u.getUserName());
		if(user == null){
			user = userDao.save(u);
			logger.info(user.toString());
			return user;
		}
		return null;
	}

	public User login(User u) {
		User user = userDao.findUserByUserName(u.getUserName());
		if(user == null){
			return null;
		}
		if(user.getPwd().equals(u.getPwd())){
			return user;
		}else{
			return null;
		}
		
		
	}
}
