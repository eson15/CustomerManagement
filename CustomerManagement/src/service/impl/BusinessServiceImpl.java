package service.impl;

import java.util.List;

import service.BusinessService;
import dao.CustomerDao;
import dao.impl.CustomerDaoImpl;
import domain.Customer;
import exception.DaoException;

public class BusinessServiceImpl implements BusinessService {

	CustomerDao dao = new CustomerDaoImpl();
	
	@Override
	public List<Customer> getAllCustomer() throws DaoException{
		return dao.getAll();
	}
	
	@Override
	public void addCustomer(Customer customer) throws DaoException {
		dao.addCustomer(customer);
	}
	
	@Override
	public void updateCustomer(Customer customer) throws DaoException {
		dao.updateCustomer(customer);
	}
	
	@Override
	public void deleteCustomer(String id) throws DaoException {
		dao.deleteCustomer(id);
	}
	
	@Override
	public Customer findCustomer(String id) throws DaoException {
		return dao.findCustomer(id);
	}
}
