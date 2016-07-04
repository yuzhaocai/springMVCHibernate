import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.class8.bean.Page;
import com.class8.bean.Pageable;
import com.class8.entity.Employee;
import com.class8.service.IEmployeeService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value={"classpath:applicationContext-core.xml"})
public class TestEmployeeService {
	
	@Autowired
	private IEmployeeService employeeService;
	
	@Test
	public void testSaveEmployee(){
		Employee employee = new Employee();
		employee.setName("gaoyuanyuan");
		employee.setRole("boss");
		employeeService.saveEmployee(employee);
	}
	
	@Test
	public void testSaveOrUpdateEmployee(){
		Employee employee = new Employee();
		//employee.setId(2L);
		employee.setName("handing");
		employee.setRole("meinv");
		employeeService.saveOrUpdateEmployee(employee);
	}
	
	/**
	 * 注意：删除的时候，根据id来删除，需要先根据id查询出对应的实体类，然后进行删除操作
	 * 如果自己构建实体类，要保证非空字段的值不能为空
	 */
	@Test
	public void testDeleteEmployee(){
		Employee employee = new Employee();
		employee.setId(2L);
		employeeService.deleteEmployee(employee);
	}
	
	@Test
	public void testFindEmployeeByNameHqlPage(){
		String name = "handing";
		Pageable pageable = new Pageable(1, 2);
		Page<Employee> page = employeeService.findEmployeeByName(name, pageable);
		System.out.println(page);
	}
	
	@Test
	public void testFindEmployeeByNameSqlPage(){
		String name= "handing";
		Pageable pageable = new Pageable(1, 2);
		Page<Employee> page = employeeService.findEmployeeByName(name, pageable);
		System.out.println(page);
	}
}
