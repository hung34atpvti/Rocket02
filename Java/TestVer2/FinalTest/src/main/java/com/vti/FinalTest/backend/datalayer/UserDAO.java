//
package com.vti.FinalTest.backend.datalayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vti.FinalTest.DBConnect;
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
public class UserDAO implements IUserDAO {

	/* 
	* @see com.vti.FinalTest.backend.datalayer.IUserDAO#login(java.lang.String, java.lang.String)
	*/
	public boolean login(String userName, String password) {
		Connection con;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = DBConnect.openConnection();
		int dem = 0;
		try {
			pstmt = con.prepareStatement("select 1 from User where email=? and password=?");
			pstmt.setString(1, userName);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dem++;
			}
			if (dem == 1) {
				return true;
			}else {
				return false;
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnect.closeAll(con, pstmt, rs);
		}
		return false;
	}

	/* 
	* @see com.vti.FinalTest.backend.datalayer.IUserDAO#getUserById(int)
	*/
	public boolean getUserById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	/* 
	* @see com.vti.FinalTest.backend.datalayer.IUserDAO#getUserByEmail(java.lang.String)
	*/
	public User getUserByEmail(String email) {
		Connection con;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = DBConnect.openConnection();
		User u = new User();
		boolean bl = false;
		try {
			pstmt = con.prepareStatement("select * from User where email=?");
			pstmt.setString(1, email);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				bl=true;
				u.setUId(rs.getInt("uId"));
				u.setFirstName(rs.getString("firstName"));
				u.setLastName(rs.getString("lastName"));
				u.setPhone(rs.getString("phone"));
				u.setEmail(rs.getString("email"));
				u.setPassword("");
			}
			if(bl) {
				return u;	
			}else {
				return null;
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnect.closeAll(con, pstmt, rs);
		}
		
		return null;
	}

	/* 
	* @see com.vti.FinalTest.backend.datalayer.IUserDAO#insertUser(com.vti.FinalTest.entity.User)
	*/
	public boolean insertUser(User user) {
		Connection con;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = DBConnect.openConnection();
		try {
			pstmt = con.prepareStatement(
					"insert into User (firstName,lastName,phone,email,password) values (?,?,?,?,?)");
			
			pstmt.setString(1, user.getFirstName());
			pstmt.setString(2, user.getLastName());
			pstmt.setString(3, user.getPhone());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getPassword());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnect.closeAll(con, pstmt, rs);
		}
		return false;
	}

}
