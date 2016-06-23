package com.class8.dao;

import java.util.List;
import com.class8.entity.Person;

public interface IPersonDao {
	
	public void createPerson(Person person);
	
	public void updatePerson(Person person);
	
	public List<Person> listPersons();
	
	public Person getPersonById(Long id);
	
	public void deletePerson(Long id);
}
