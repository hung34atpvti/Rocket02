//
package com.vti.FinalTest.backend.datalayer;

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
public interface IUserDAO {
	boolean login(String userName, String password);
	boolean insertUser(User user);
	boolean getUserById(int id);
	User getUserByEmail(String email);
}
