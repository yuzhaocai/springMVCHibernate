package com.class8.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import com.class8.dao.IPersonDao;
import com.class8.entity.Person;

@Repository
public class PersonDaoImpl extends HibernateDaoSupport implements IPersonDao {
	
	private static final Logger logger = LoggerFactory.getLogger(PersonDaoImpl.class);

	public void createPerson(Person person) {
		this.getHibernateTemplate().save(person);
		logger.info("person created successfully,person detail " + person);
	}

	public void updatePerson(Person person) {
		this.getHibernateTemplate().update(person);
		logger.info("person updated successfully,person detail " + person);
	}

	@SuppressWarnings("unchecked")
	public List<Person> listPersons() {
		return (List<Person>) this.getHibernateTemplate().find("from Person");
	}

	public Person getPersonById(Long id) {
		logger.info("load person.");
		return this.getHibernateTemplate().get(Person.class, id);
	}

	public void deletePerson(Long id) {
		Person person = this.getPersonById(id);
		if(person != null){
			this.getHibernateTemplate().delete(person);
		}
	}
	
	@Autowired
	public void setSessionFactoryOverride(SessionFactory sessionFactory){
		this.setSessionFactory(sessionFactory);
	}
	
}
