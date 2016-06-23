import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.class8.entity.Person;
import com.class8.service.IPersonService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:applicationContext-core.xml")
public class TestService {
	
	@Autowired
	private IPersonService personService;
	
	@Test
	public void hbm2Ddl(){
		
	}
	
	@Test
	public void testCreatePerson(){
		Person person = new Person();
		person.setFirstName("yu");
		person.setSecondName("zhaocai");
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 1990);
		calendar.set(Calendar.MONTH, 11);
		calendar.set(Calendar.DATE, 20);
		person.setBirthday(calendar.getTime());
		person.setCreateTime(new Date());
		person.setEmail("870646595@qq.com");
		person.setAge(26);
		person.setLastmodified(new Date());
		
		personService.createPerson(person);
		
	}
}
