//
package com.vti.FinalTest.backend.datalayer;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vti.FinalTest.DBConnect;
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
public class ManagerDAO implements IManagerDAO {



	

	/* 
	* @see com.vti.FinalTest.backend.datalayer.IManagerDAO#insertEmployee(com.vti.FinalTest.entity.Manager)
	*/
	public boolean insertManager(Manager mn) {
		Connection con;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = DBConnect.openConnection();
		try {
			pstmt = con.prepareStatement(
					"insert into Manager (uid,expInYear) values (?,?)");
			pstmt.setInt(1, mn.getUser());
			pstmt.setInt(2, mn.getExpInYear());
			
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
