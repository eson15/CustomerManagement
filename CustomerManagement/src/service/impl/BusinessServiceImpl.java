package service.impl;

import java.util.List;

import dao.CustomerDao;
import dao.impl.CustomerDaoImpl;
import domain.Customer;
import exception.DaoException;

public class BusinessServiceImpl {

	CustomerDao dao = new CustomerDaoImpl();
	
	public List<Customer> getAllCustomer() throws DaoException{
		return dao.getAll();
	}
	
	public void addCustomer(Customer customer) throws DaoException {
		dao.addCustomer(customer);
	}
	
	public void updateCustomer(Customer customer) throws DaoException {
		dao.updateCustomer(customer);
	}
	
	public void deleteCustomer(String id) throws DaoException {
		dao.deleteCustomer(id);
	}
	
	public Customer findCustomer(String id) throws DaoException {
		return dao.findCustomer(id);
	}
}
