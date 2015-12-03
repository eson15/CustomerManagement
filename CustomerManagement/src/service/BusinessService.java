package service;

import java.util.List;

import domain.Customer;
import domain.Page;
import exception.DaoException;

public interface BusinessService {

	List<Customer> getAllCustomer() throws DaoException;

	void addCustomer(Customer customer) throws DaoException;

	void updateCustomer(Customer customer) throws DaoException;

	void deleteCustomer(String id) throws DaoException;

	Customer findCustomer(String id) throws DaoException;
	
	Page getPageData(String pageNum, String url) throws DaoException;

}