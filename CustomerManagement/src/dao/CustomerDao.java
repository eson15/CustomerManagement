package dao;

import java.util.List;

import domain.Customer;
import exception.DaoException;

public interface CustomerDao {

	void addCustomer(Customer customer) throws DaoException;

	//find a customer by id from database
	Customer findCustomer(String id) throws DaoException;

	//update a customer from database
	void updateCustomer(Customer customer) throws DaoException;

	//delete a customer from database
	void deleteCustomer(String id) throws DaoException;

	//get all customers from database
	List<Customer> getAll() throws DaoException;
	
	//get page data
	List<Customer> getPageData(int startIndex, int pageSize) throws DaoException;
	
	//get total record
	int getTotalRecord() throws DaoException;

}