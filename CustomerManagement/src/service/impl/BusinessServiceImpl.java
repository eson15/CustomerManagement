package service.impl;

import java.util.List;

import service.BusinessService;
import dao.CustomerDao;
import dao.impl.CustomerDaoImpl;
import domain.Customer;
import domain.Page;
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
	
	@Override
	public Page getPageData(String pageNum, String url) throws DaoException{
		int totalRecord = dao.getTotalRecord();
		if(pageNum == null){//表示用户第一次查看
			Page page = new Page(totalRecord, 1);
			List<Customer> list = dao.getPageData(page.getStartIndex(), page.getPageSize());
			page.setList(list);
			page.setUrl(url);
			return page;
		} else {
			Page page = new Page(totalRecord, Integer.parseInt(pageNum));
			List<Customer> list = dao.getPageData(page.getStartIndex(), page.getPageSize());
			page.setList(list);
			page.setUrl(url);
			return page;
		}
	}
}
