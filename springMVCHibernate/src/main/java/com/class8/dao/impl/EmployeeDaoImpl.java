package com.class8.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.class8.bean.Page;
import com.class8.bean.Pageable;
import com.class8.dao.IEmployeeDao;
import com.class8.entity.Employee;

@Repository
public class EmployeeDaoImpl extends BaseDao<Employee, Long> implements IEmployeeDao {

	@Override
	public Page<Employee> findEmployeeByName(String name, Pageable pageable) {
		final String hql = " from Employee where name  = ? ";
		final String countHql = " select count(*) from Employee where name = ? ";
		List<Employee> result = this.find(pageable, hql, name);
		long total = this.count(countHql, name);
		Page<Employee> page = new Page<Employee>(result,pageable,total);
		return page;
	}

}
