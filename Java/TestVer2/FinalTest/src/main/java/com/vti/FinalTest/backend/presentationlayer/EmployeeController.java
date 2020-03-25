//
package com.vti.FinalTest.backend.presentationlayer;

import com.vti.FinalTest.backend.businesslayer.EmployeeService;
import com.vti.FinalTest.backend.businesslayer.IEmployeeService;


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
public class EmployeeController {
	private IEmployeeService service;

	public EmployeeController() {
		service = new EmployeeService();
	}

	

	public boolean insertEmployee(Employee empl) {
		// TODO Auto-generated method stub
		return service.insertEmployee(empl);
	}

}
