//
package com.vti.FinalTest.frontend;

import java.util.Scanner;

import com.vti.FinalTest.backend.presentationlayer.EmployeeController;
import com.vti.FinalTest.backend.presentationlayer.ManagerController;
import com.vti.FinalTest.backend.presentationlayer.UserController;
import com.vti.FinalTest.entity.Employee;
import com.vti.FinalTest.entity.Manager;
import com.vti.FinalTest.entity.User;
import com.vti.FinalTest.utils.ScannerUtil;

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
public class Program {

	/**
	 * This method is .
	 * 
	 * @Description: .
	 * @author: hung34atp
	 * @create_date: Mar 25, 2020
	 * @version: 1.0
	 * @modifer: hung34atp
	 * @modifer_date: Mar 25, 2020
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choose;
		int choose1;
		while (true) {
			System.out.println("----------Welcome---------");
			System.out.println("1.	Create User.");
			System.out.println("2.	Login.");
			choose = ScannerUtil.readInt(sc, "Please input data as INTEGER! \nPlease input again: ");
			switch (choose) {
			case 1:
				System.out.println("1.Manager");
				System.out.println("2.Employee");
				choose1 = ScannerUtil.readInt(sc, "Please input data as INTEGER! \nPlease input again: ");
				if(choose1==1) {
					User user = new User();
					Manager mn = new Manager();
					System.out.println("uId: ");
					user.setUId(ScannerUtil.readInt(sc, "Please input data as Integer! \nPlease input again: "));
					System.out.println("FirstName:");
					user.setFirstName(ScannerUtil.readString(sc, "Please input data as String! \nPlease input again: "));
					System.out.println("LastName:");
					user.setLastName(ScannerUtil.readString(sc, "Please input data as String! \nPlease input again: "));
					System.out.println("Phone:");
					user.setPhone(ScannerUtil.readString(sc, "Please input data as String! \nPlease input again: "));
					System.out.println("Email:");
					user.setEmail(ScannerUtil.readString(sc, "Please input data as String! \nPlease input again: "));
					System.out.println("Password:");
					user.setPassword(ScannerUtil.readString(sc, "Please input data as String! \nPlease input again: "));
//					System.out.println("MId:");
//					mn.setmId(ScannerUtil.readInt(sc, "Please input data as INTEGER! \nPlease input again: "));
					System.out.println("ExpInt:");
					mn.setExpInYear(ScannerUtil.readInt(sc, "Please input data as INTEGER! \nPlease input again: "));
					mn.setUser(user.getUId());
					boolean blu = new UserController().insertUser(user);
					boolean bl = new ManagerController().insertManager(mn);
					if (bl) {
						System.out.println("insert successfully");
					}else {
						System.out.println("insert failed");
					}
					
				}else if(choose1==2) {
					User user = new User();
					Employee empl = new Employee();
					System.out.println("uId: ");
					user.setUId(ScannerUtil.readInt(sc, "Please input data as Integer! \nPlease input again: "));
					System.out.println("FirstName:");
					user.setFirstName(ScannerUtil.readString(sc, "Please input data as String! \nPlease input again: "));
					System.out.println("LastName:");
					user.setLastName(ScannerUtil.readString(sc, "Please input data as String! \nPlease input again: "));
					System.out.println("Phone:");
					user.setPhone(ScannerUtil.readString(sc, "Please input data as String! \nPlease input again: "));
					System.out.println("Email:");
					user.setEmail(ScannerUtil.readString(sc, "Please input data as String! \nPlease input again: "));
					System.out.println("Password:");
					user.setPassword(ScannerUtil.readString(sc, "Please input data as String! \nPlease input again: "));
//					System.out.println("EId:");
//					empl.setEId(ScannerUtil.readInt(sc, "Please input data as INTEGER! \nPlease input again: "));
					System.out.println("ProjectName:");
					empl.setProjectName(ScannerUtil.readString(sc, "Please input data as String! \nPlease input again: "));
					System.out.println("ProSkill:");
					empl.setProSkill(ScannerUtil.readString(sc, "Please input data as String! \nPlease input again: "));
					empl.setUser(user.getUId());
					boolean blu = new UserController().insertUser(user);
					boolean bl = new EmployeeController().insertEmployee(empl);
					if (bl) {
						System.out.println("insert successfully");
					}else {
						System.out.println("insert failed");
					}
					
				}else {
					System.out.println("Please choose 1 or 2");
				}
				break;
			case 2:
				String username;
				String password;
				System.out.println("Username:");
				username = ScannerUtil.readString(sc, "Please input data as String! \nPlease input again: ");
				System.out.println("Password:");
				password = ScannerUtil.readString(sc, "Please input data as String! \nPlease input again: ");
				boolean bl = new UserController().login(username, password);
				if(bl) {
					System.out.println("Login!");
				}else {
					System.out.println("Not Login!");
					
				}
				break;
			default:
				System.out.println("Please choose 1 or 2");
				break;
			}
		}

	}

}
