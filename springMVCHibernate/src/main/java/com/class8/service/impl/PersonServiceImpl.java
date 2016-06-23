package com.class8.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.class8.dao.IPersonDao;
import com.class8.entity.Person;
import com.class8.service.IPersonService;

@Service
@Transactional
public class PersonServiceImpl implements IPersonService {
	
	@Autowired
	private IPersonDao personDao;

	public void createPerson(Person person) {
		personDao.createPerson(person);
	}

	public void updatePerson(Person person) {
		personDao.updatePerson(person);
	}
	
	@Transactional(readOnly=true)
	public Person getPersonById(Long id) {
		return personDao.getPersonById(id);
	}
	
	@Transactional(readOnly=true)
	public List<Person> listPersons() {
		return personDao.listPersons();
	}

	public void deletePerson(Long id) {
		personDao.deletePerson(id);
	}

}
