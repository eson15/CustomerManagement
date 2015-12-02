package web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exception.DaoException;
import service.BusinessService;
import service.impl.BusinessServiceImpl;

public class DeleteCustomerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String customerid = request.getParameter("customerid");
			BusinessService service = new BusinessServiceImpl();
			service.deleteCustomer(customerid);
			request.setAttribute("message", "删除成功！本页面将在3秒后跳转到客户列表<meta http-equiv='refresh' content='3;url=/CustomerManagement/servlet/ListCustomerServlet'");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		} catch (DaoException e) {
			e.printStackTrace();
			request.setAttribute("message", "对不起，删除失败！");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
