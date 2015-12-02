package service;

import java.util.List;

import domain.Customer;
import exception.DaoException;

public interface BusinessService {

	List<Customer> getAllCustomer() throws DaoException;

	void addCustomer(Customer customer) throws DaoException;

	void updateCustomer(Customer customer) throws DaoException;

	void deleteCustomer(String id) throws DaoException;

	Customer findCustomer(String id) throws DaoException;

}