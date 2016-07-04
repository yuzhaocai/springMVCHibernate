package com.class8.service;

import com.class8.bean.Page;
import com.class8.bean.Pageable;
import com.class8.entity.Employee;

public interface IEmployeeService {
	/**
	 * 保存雇员
	 * @param employee
	 * @return
	 */
	public Long saveEmployee(Employee employee); 
	
	/**
	 * 保存或更新雇员
	 * @param employee
	 * @return
	 */
	public void saveOrUpdateEmployee(Employee employee);
	
	/**
	 * 删除雇员
	 * @param employee
	 * @return
	 */
	public void deleteEmployee(Employee employee);
	
	/**
	 * 通过name分页查找Employee
	 * @param name
	 * @param pagebale
	 * @return
	 */
	public Page<Employee> findEmployeeByName(String name,Pageable pagebale);
}
