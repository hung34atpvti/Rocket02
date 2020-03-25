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
public class Function {
	public void Login() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Username:");
		String username = ScannerUtil.readEmail(sc, "error");
		System.out.println("Password:");
		String password = ScannerUtil.readPassword(sc, "error");
		boolean bl = new UserController().login(username, password);
		if (bl) {
			System.out.println("Login successfully!");
		}else {
			System.out.println("Login failed!");
		}
	}

	public void createManager() {
		User u = new User();
		Manager mn = new Manager();
		u.input();
		mn.input(u);
		boolean bl = new UserController().insertUser(u);
		if (bl) {
			mn.setUser(new UserController().getUserByEmail(u.getEmail()));
			boolean bl1 = new ManagerController().insertManager(mn);
			if (bl1) {
				System.out.println("Create Successfully!");
			} else {
				System.out.println("Create Manager failed!");
			}
		} else {
			System.out.println("Create User failed! Email existed");
		}
	}

	public void createEmployee() {
		User u = new User();
		Employee empl = new Employee();
		u.input();
		empl.input(u);
		boolean bl = new UserController().insertUser(u);
		if (bl) {
			empl.setUser(new UserController().getUserByEmail(u.getEmail()));
			boolean bl1 = new EmployeeController().insertEmployee(empl);
			if (bl1) {
				System.out.println("Create Successfully!");
			} else {
				System.out.println("Create Employee failed!");
			}
		} else {
			System.out.println("Create User failed!");
		}
	}
}
