package web.UI;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BusinessService;
import service.impl.BusinessServiceImpl;
import utils.Globals;
import domain.Customer;
import exception.DaoException;

public class UpdateCustomerUIServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		try {
			String customerid = request.getParameter("customerid");
			BusinessService service = new BusinessServiceImpl();
			Customer customer = service.findCustomer(customerid);
			request.setAttribute("customer", customer);
			request.setAttribute("preferences", Globals.preferences);
			request.setAttribute("types", Globals.types);
			request.getRequestDispatcher("/WEB-INF/jsp/updateCustomer.jsp").forward(request, response);
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
