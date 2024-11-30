package com.codegnan.factories;
 
import com.codegnan.dao.EmployeeDao;
import com.codegnan.dao.EmployeeDaoImpl;
 
public class EmployeeDaoFactory {
  	private static EmployeeDao employeeDao = null;
  	static {
        	employeeDao = new EmployeeDaoImpl();
  	}
 
  	public static EmployeeDao getEmployeeDao() {
        	return employeeDao;
  	}
}
