//
package com.vti.FinalTest.backend.presentationlayer;

import com.vti.FinalTest.backend.businesslayer.IManagerService;

import com.vti.FinalTest.backend.businesslayer.ManagerService;

import com.vti.FinalTest.entity.Manager;


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
public class ManagerController {
	private IManagerService service;

	public ManagerController() {
		service = new ManagerService();
	}

	

	public boolean insertManager(Manager mn) {
		// TODO Auto-generated method stub
		return service.insertManager(mn);
	}
}
