package junit;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import utils.Globals;
import utils.WebUtils;
import dao.CustomerDao;
import dao.impl.CustomerDaoImpl;
import domain.Customer;

public class CustomerDaoTest {
	
	private CustomerDao dao = new CustomerDaoImpl();
	
	@Test
	public void testAddAndUpdateCustomer(){
		Customer customer = new Customer();
		customer.setId("1");
		customer.setName("王五");
		customer.setGender("男");
		customer.setEmail("ww@sina.com");
		customer.setBirthday(new Date());
		customer.setCellphone("123456778");
		customer.setLikes(Globals.preferences[3]);
		customer.setType(Globals.type[0]);
		customer.setDescription("一个坏人");
		dao.addCustomer(customer);
		//在下面打断点调试
		customer.setGender("女");
		dao.updateCustomer(customer);
	}

	@Test
	public void testFindCustomer(){
		Customer customer= dao.findCustomer("1");
		System.out.println(customer.getName());
	}
	
	@Test
	public void testDeleteCustomer(){
		dao.deleteCustomer("1");
	}
	
	@Test 
	public void testGetAllCustomer(){
		List<Customer> list = dao.getAll();
		for(Customer c : list){
			System.out.println(c.getName());
		}
	}
}
