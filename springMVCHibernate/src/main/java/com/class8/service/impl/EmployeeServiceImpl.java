package com.class8.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.class8.bean.Page;
import com.class8.bean.Pageable;
import com.class8.dao.IEmployeeDao;
import com.class8.entity.Employee;
import com.class8.service.IEmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	private IEmployeeDao employeeDao;

	@Override
	public Long saveEmployee(Employee employee) {
		return employeeDao.save(employee);
	}

	@Override
	public void saveOrUpdateEmployee(Employee employee) {
		employeeDao.saveOrUpdate(employee);
	}

	@Override
	public void deleteEmployee(Employee employee) {
		employeeDao.delete(employee);
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Employee> findEmployeeByName(String name, Pageable pageable) {
		return employeeDao.findEmployeeByName(name,pageable);
	}

}
