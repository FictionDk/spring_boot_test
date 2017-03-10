package cn.fictio.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.fictio.springboot.dao.GoodDao;
import cn.fictio.springboot.pojo.Good;

@Service
public class GoodService {
	
	@Autowired
	private GoodDao goodDao;
	
	public boolean addGood(Good good){
		Good result = goodDao.save(good);
		if(result != null){
			return true;
		}
		return false;
	}

	public List<Good> getGoodList(){
		return goodDao.findAll();
	}

	public Good getGoodById(long id) {
		return goodDao.findOne(id);
	}
}
