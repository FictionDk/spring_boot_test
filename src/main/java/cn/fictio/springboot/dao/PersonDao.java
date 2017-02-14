package cn.fictio.springboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import cn.fictio.springboot.pojo.Person;

@Component("personDao")
public interface PersonDao extends JpaRepository<Person, Long>{
	public List<Person> findByUserId(int userId);
}
