package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utils.JdbcUtils;
import dao.CustomerDao;
import domain.Customer;
import exception.DaoException;

//add a customer to database
public class CustomerDaoImpl implements CustomerDao {
	
	private Connection conn = null;
	private PreparedStatement st = null;
	private ResultSet rs = null;
	
	@Override
	public void addCustomer(Customer customer) throws DaoException{
		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into customer(id,name,gender,birthday,cellphone,email,preference,type,description) values(?,?,?,?,?,?,?,?,?)";
			st = conn.prepareStatement(sql);
			st.setString(1, customer.getId());
			st.setString(2, customer.getName());
			st.setString(3, customer.getGender());
			st.setDate(4, new java.sql.Date(customer.getBirthday().getTime()));
			st.setString(5, customer.getCellphone());
			st.setString(6, customer.getEmail());
			st.setString(7, customer.getLikes());
			st.setString(8, customer.getType());
			st.setString(9, customer.getDescription());
			st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}

	//find a customer by id from database
	@Override
	public Customer findCustomer(String id) throws DaoException{
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from customer where id=?";
			st = conn.prepareStatement(sql);
			st.setString(1, id);
			rs = st.executeQuery();
			while(rs.next()){
				Customer customer = new Customer();
				customer.setId(id);
				customer.setName(rs.getString("name"));
				customer.setGender(rs.getString("gender"));
				customer.setBirthday(rs.getDate("birthday"));
				customer.setEmail(rs.getString("email"));
				customer.setCellphone(rs.getString("cellphone"));
				customer.setType(rs.getString("type"));
				customer.setLikes(rs.getString("preference"));
				customer.setDescription(rs.getString("description"));
				return customer;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e);
		} finally{
			JdbcUtils.release(conn, st, rs);
		}
	}
	
	//update a customer from database
	@Override
	public void updateCustomer(Customer customer) throws DaoException{
		try {
			conn = JdbcUtils.getConnection();
			String sql = "update customer set name=?,gender=?,birthday=?,cellphone=?,email=?,preference=?,type=?,description=? where id=?";
			st = conn.prepareStatement(sql);
			st.setString(1, customer.getName());
			st.setString(2, customer.getGender());
			st.setDate(3, new java.sql.Date(customer.getBirthday().getTime()));
			st.setString(4, customer.getCellphone());
			st.setString(5, customer.getEmail());
			st.setString(6, customer.getLikes());
			st.setString(7, customer.getType());
			st.setString(8, customer.getDescription());
			st.setString(9, customer.getId());
			st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}

	//delete a customer from database
	@Override
	public void deleteCustomer(String id) throws DaoException{
		try {
			conn = JdbcUtils.getConnection();
			String sql = "delete from customer where id=?";
			st = conn.prepareStatement(sql);
			st.setString(1, id);
			st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e);
		} finally{
			JdbcUtils.release(conn, st, rs);
		}
	}
	
	//get all customers from database
	@Override
	public List<Customer> getAll() throws DaoException{
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from customer";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			List<Customer> list = new ArrayList<Customer>();
			while(rs.next()){
				Customer customer = new Customer();
				customer.setId(rs.getString("id"));
				customer.setName(rs.getString("name"));
				customer.setGender(rs.getString("gender"));
				customer.setBirthday(rs.getDate("birthday"));
				customer.setEmail(rs.getString("email"));
				customer.setCellphone(rs.getString("cellphone"));
				customer.setType(rs.getString("type"));
				customer.setLikes(rs.getString("preference"));
				customer.setDescription(rs.getString("description"));
				list.add(customer);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}
}
