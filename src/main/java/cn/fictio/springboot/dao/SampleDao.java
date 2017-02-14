package cn.fictio.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import cn.fictio.springboot.pojo.Person;

@Component("sampleDao")
public interface SampleDao extends JpaRepository<Person, Long> {
	public Person findByName(String name);
}
