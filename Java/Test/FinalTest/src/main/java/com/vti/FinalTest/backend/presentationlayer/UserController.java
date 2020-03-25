//
package com.vti.FinalTest.backend.presentationlayer;

import com.vti.FinalTest.backend.businesslayer.IUserService;
import com.vti.FinalTest.backend.businesslayer.UserService;
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
public class UserController {
private IUserService service;

public UserController() {
	service = new UserService();
}

public boolean login(String userName, String password) {
	return service.login(userName, password);
}

public boolean insertUser(User user) {
	// TODO Auto-generated method stub
	return service.insertUser(user);
}
}
