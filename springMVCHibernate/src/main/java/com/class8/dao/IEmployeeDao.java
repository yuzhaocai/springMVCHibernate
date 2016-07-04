package com.class8.dao;

import com.class8.bean.Page;
import com.class8.bean.Pageable;
import com.class8.entity.Employee;

public interface IEmployeeDao extends IBaseDao<Employee, Long>{

	public Page<Employee> findEmployeeByName(String name, Pageable pageable);

}
