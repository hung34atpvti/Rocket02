//
package com.vti.FinalTest.backend.businesslayer;

import com.vti.FinalTest.backend.datalayer.IUserDAO;
import com.vti.FinalTest.backend.datalayer.UserDAO;
import com.vti.FinalTest.entity.User;

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
public class UserService implements IUserService {
	private IUserDAO dao;

	
	
	public UserService() {	
		dao=new UserDAO();;
	}

	/* 
	* @see com.vti.FinalTest.backend.businesslayer.IUserService#login(java.lang.String, java.lang.String)
	*/
	public boolean login(String userName, String password) {
		// TODO Auto-generated method stub
		return dao.login(userName, password);
	}

	/* 
	* @see com.vti.FinalTest.backend.businesslayer.IUserService#insertUser(com.vti.FinalTest.entity.User)
	*/
	public boolean insertUser(User user) {
		// TODO Auto-generated method stub
		return dao.insertUser(user);
	}

	/* 
	* @see com.vti.FinalTest.backend.businesslayer.IUserService#getUserById(int)
	*/
	public boolean getUserById(int id) {
		// TODO Auto-generated method stub
		return dao.getUserById(id);
	}

	/* 
	* @see com.vti.FinalTest.backend.businesslayer.IUserService#getUserByEmail(java.lang.String)
	*/
	public boolean getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return dao.getUserByEmail(email);
	}

}
