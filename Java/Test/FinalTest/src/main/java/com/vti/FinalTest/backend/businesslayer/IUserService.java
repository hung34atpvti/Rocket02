//
package com.vti.FinalTest.backend.businesslayer;

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
public interface IUserService {
	boolean login(String userName, String password);
	boolean insertUser(User user);
	boolean getUserById(int id);
	boolean getUserByEmail(String email);
}
