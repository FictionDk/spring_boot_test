package cn.fictio.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import cn.fictio.springboot.pojo.User;

@Component("userDao")
public interface UserDao extends JpaRepository<User, Long>{
	public User findUserByUserName(String userName);
}
