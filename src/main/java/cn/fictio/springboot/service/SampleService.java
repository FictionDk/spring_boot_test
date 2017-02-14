package cn.fictio.springboot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.fictio.springboot.dao.SampleDao;
import cn.fictio.springboot.pojo.Person;

@Service
public class SampleService {
	
	@Autowired
	private SampleDao sampleDao;
	private static Logger log = LoggerFactory.getLogger(SampleService.class);
	
	public boolean reg(Person p){
		p = sampleDao.findByName(p.getName());
		if(p == null){
			return true;
		}
		return false;
	}
	
	public boolean login(Person p){
		p = sampleDao.findByName(p.getName());
		return false;
	}
	
}
