//
package com.vti.FinalTest.frontend;

import java.util.Scanner;


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
		Function f = new Function();
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
				boolean bl = true;
				while (bl) {
					System.out.println("1.Manager");
					System.out.println("2.Employee");
					System.out.println("3.Back");
					choose1 = ScannerUtil.readInt(sc, "Please input data as INTEGER! \nPlease input again: ");
					if (choose1 == 1) {
						f.createManager();

					} else if (choose1 == 2) {
						f.createEmployee();

					} else if (choose1 == 3) {
						bl = false;

					} else {
						System.out.println("Please choose 1 or 2 or 3");
					}
					break;
				}
				break;

			case 2:
				f.Login();
				break;
			default:
				System.out.println("Please choose 1 or 2");
				break;
			}
		}

	}

}
