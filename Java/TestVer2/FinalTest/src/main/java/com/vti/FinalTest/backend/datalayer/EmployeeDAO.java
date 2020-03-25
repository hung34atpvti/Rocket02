//
package com.vti.FinalTest.backend.datalayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.vti.FinalTest.entity.Employee;
import com.vti.FinalTest.DBConnect;

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
public class EmployeeDAO implements IEmployeeDAO {

	

	

	/* 
	* @see com.vti.FinalTest.backend.datalayer.IEmployeeDAO#insertEmployee(com.vti.FinalTest.entity.Employee)
	*/
	public boolean insertEmployee(Employee empl) {
		Connection con;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = DBConnect.openConnection();
		try {
			pstmt = con.prepareStatement(
					"insert into Employee (uId,projectName,proSkill) values (?,?,?)");
			pstmt.setInt(1, empl.getUser().getUId());
			pstmt.setString(2, empl.getProjectName());
			pstmt.setString(3, empl.getProSkill());
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
