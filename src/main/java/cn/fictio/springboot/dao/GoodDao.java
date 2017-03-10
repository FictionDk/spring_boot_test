package cn.fictio.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import cn.fictio.springboot.pojo.Good;

@Component("goodDao")
public interface GoodDao extends JpaRepository<Good, Long>{
	public Good findUserByGoodName(String goodName);
}
