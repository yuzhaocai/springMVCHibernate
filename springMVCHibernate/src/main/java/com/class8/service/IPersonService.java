package com.class8.service;

import java.util.List;
import com.class8.entity.Person;

public interface IPersonService {
	
	public void createPerson(Person person);
	
	public void updatePerson(Person person);
	
	public Person getPersonById(Long id);
	
	public List<Person> listPersons();
	
	public void deletePerson(Long id);
}
