package dao;

import java.util.List;

import domain.Customer;

public interface CustomerDao {

	void addCustomer(Customer customer);

	//find a customer by id from database
	Customer findCustomer(String id);

	//update a customer from database
	void updateCustomer(Customer customer);

	//delete a customer from database
	void deleteCustomer(String id);

	//get all customers from database
	List<Customer> getAll();

}