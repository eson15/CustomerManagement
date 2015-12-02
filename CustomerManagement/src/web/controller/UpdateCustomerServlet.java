package web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Customer;
import exception.DaoException;
import service.BusinessService;
import service.impl.BusinessServiceImpl;
import utils.WebUtils;

public class UpdateCustomerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		try {
			Customer customer = WebUtils.requestToBean(request, Customer.class);
			BusinessService service = new BusinessServiceImpl();
			service.updateCustomer(customer);
			request.setAttribute("message", "更新成功！本页面将在3秒后跳转到客户列表<meta http-equiv='refresh' content='3;url=/CustomerManagement/servlet/ListCustomerServlet'");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		} catch (DaoException e) {
			e.printStackTrace();
			request.setAttribute("message", "对不起，系统繁忙，操作失败！");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
