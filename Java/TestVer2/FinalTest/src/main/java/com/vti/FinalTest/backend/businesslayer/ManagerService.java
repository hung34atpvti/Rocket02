//
package com.vti.FinalTest.backend.businesslayer;

import com.vti.FinalTest.backend.datalayer.IManagerDAO;

import com.vti.FinalTest.backend.datalayer.ManagerDAO;

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
public class ManagerService implements IManagerService {
private IManagerDAO dao;

	
	
	public ManagerService() {
		
		dao=new ManagerDAO();
	}

	/* 
	* @see com.vti.FinalTest.backend.businesslayer.IManagerService#insertManager(com.vti.FinalTest.entity.Manager)
	*/
	public boolean insertManager(Manager mn) {
		// TODO Auto-generated method stub
		return dao.insertManager(mn);
	}

}
