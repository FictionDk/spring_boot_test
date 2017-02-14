package cn.fictio.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.fictio.springboot.dao.PersonDao;
import cn.fictio.springboot.pojo.Person;

@Service
public class PersonService {
	
	private PersonDao personDao;
	
	public List<Person> showUserPerson(int userId){
		
		return null;
		
	}

}
