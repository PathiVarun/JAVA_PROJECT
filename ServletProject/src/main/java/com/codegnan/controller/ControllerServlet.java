package com.codegnan.controller;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.codegnan.dto.Employee;
import com.codegnan.factories.EmployeeServiceFactory;
import com.codegnan.service.EmployeeService;
@WebServlet("/.do")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		response.setContentType("text/html");
		PrintWriter out = response.getWriter();


		int eno = 0;
		String ename = "";
		float esal = 0.0f;
		String eaddr = "";
		Employee employee = null;
		EmployeeService employeeService = EmployeeServiceFactory.getEmployeeService();
		String status = "";
		RequestDispatcher requestDispatcher = null;


		String requestURI = request.getRequestURI();
		// System.out.println(requestURI);


		if (requestURI.endsWith("add.do")) {
			try {


				eno = Integer.parseInt(request.getParameter("eno"));
				ename = request.getParameter("ename");
				esal = Float.parseFloat(request.getParameter("esal"));
				eaddr = request.getParameter("eaddr");


				employee = new Employee();
				employee.setEno(eno);
				employee.setEname(ename);
				employee.setEsal(esal);
				employee.setEaddr(eaddr);


				status = employeeService.addEmployee(employee);
				if (status.equalsIgnoreCase("existed")) {
					requestDispatcher = request.getRequestDispatcher("/existed.html");
				}
				if (status.equalsIgnoreCase("success")) {
					requestDispatcher = request.getRequestDispatcher("/success.html");
				}
				if (status.equalsIgnoreCase("failure")) {
					requestDispatcher = request.getRequestDispatcher("/failure.html");
				}
				requestDispatcher.forward(request, response);


			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (requestURI.endsWith("search.do")) {
			eno = Integer.parseInt(request.getParameter("eno"));
			employee = employeeService.searchEmployee(eno);
			if (employee == null) {
				requestDispatcher = request.getRequestDispatcher("/notexisted.html");
				requestDispatcher.forward(request, response);
			} else {
				out.println("<html>");
				out.println("<body bgcolor='DDF7E3'><center>");
				out.println("<br><br><br><br>");
				out.println("<table align='center' border='1'>");
				out.println("<tr><td>Employee Number</td><td>" + employee.getEno() + "</td></tr>");
				out.println("<tr><td>Employee Name</td><td>" + employee.getEname() + "</td></tr>");
				out.println("<tr><td>Employee Salary</td><td>" + employee.getEsal() + "</td></tr>");
				out.println("<tr><td>Employee Address</td><td>" + employee.getEaddr() + "</td></tr>");
				out.println("</table>");


				out.println("</center><body></html>");
			}
		}
		if (requestURI.endsWith("editform.do")) {
			try {
				eno = Integer.parseInt(request.getParameter("eno"));
				employee = employeeService.searchEmployee(eno);
				if (employee == null) {
					requestDispatcher = request.getRequestDispatcher("notexisted.html");
					requestDispatcher.forward(request, response);
				} else {
					out.println("<html>");
					out.println("<body bgcolor='DDF7E3'><center>");
					out.println("<br><br><br><br>");
					out.println("<form method='POST' action='update.do'>");
					out.println("<table align='center'>");
					out.println("<tr><td>Employee Number</td><td>" + employee.getEno() + "</td></tr>");
					out.println("<input type='hidden' name='eno' value='" + employee.getEno() + "'/>");
					out.println("<tr><td>Employee Name</td><td><input type='text' name='ename' value='"
							+ employee.getEname() + "'></td></tr>");
					out.println("<tr><td>Employee Salary</td><td><input type='text' name='esal' value='"
							+ employee.getEsal() + "'></td></tr>");
					out.println("<tr><td>Employee Address</td><td><input type='text' name='eaddr' value='"
							+ employee.getEaddr() + "'></td></tr>");
					out.println("<tr><td><input type='submit' value='UPDATE'></td></tr>");
					out.println("</table></form>");
					out.println("</center><body></html>");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (requestURI.endsWith("update.do")) {
			try {
				eno = Integer.parseInt(request.getParameter("eno"));
				ename = request.getParameter("ename");
				esal = Float.parseFloat(request.getParameter("esal"));
				eaddr = request.getParameter("eaddr");


				employee = new Employee();
				employee.setEno(eno);
				employee.setEname(ename);
				employee.setEsal(esal);
				employee.setEaddr(eaddr);


				status = employeeService.updateEmployee(employee);
				if (status.equalsIgnoreCase("success")) {
					requestDispatcher = request.getRequestDispatcher("success.html");
				} else {
					requestDispatcher = request.getRequestDispatcher("failure.html");
				}
				requestDispatcher.forward(request, response);


			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (requestURI.endsWith("delete.do")) {
			eno = Integer.parseInt(request.getParameter("eno"));
			employee = employeeService.searchEmployee(eno);
			if (employee == null) {
				requestDispatcher = request.getRequestDispatcher("/notexisted.html");
				requestDispatcher.forward(request, response);
			} else {
				status = employeeService.deleteEmployee(eno);
				if (status.equalsIgnoreCase("success")) {
					requestDispatcher = request.getRequestDispatcher("/success.html");
					requestDispatcher.forward(request, response);
				} else {
					requestDispatcher = request.getRequestDispatcher("/failure.html");
					requestDispatcher.forward(request, response);
				}
			}


		}
	}
}
