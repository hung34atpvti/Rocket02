//
package com.vti.FinalTest.backend.businesslayer;

import com.vti.FinalTest.backend.datalayer.EmployeeDAO;
import com.vti.FinalTest.backend.datalayer.IEmployeeDAO;
import com.vti.FinalTest.entity.Employee;

/**
 * This class is . 
 * 
 * @Description: .
 * @author: hung34atp
 * @create_date: Mar 25, 2020
 * @version: 1.0
 * @modifer: hung34atp
 * @modifer_date: Mar 25, 2020
 */
public class EmployeeService implements IEmployeeService {
	
private IEmployeeDAO dao;

	
	
	public EmployeeService() {
		
		dao=new EmployeeDAO();
	}

	/* 
	* @see com.vti.FinalTest.backend.businesslayer.IEmployeeService#insertEmployee(com.vti.FinalTest.entity.Employee)
	*/
	public boolean insertEmployee(Employee empl) {
		// TODO Auto-generated method stub
		return dao.insertEmployee(empl);
	}

}
