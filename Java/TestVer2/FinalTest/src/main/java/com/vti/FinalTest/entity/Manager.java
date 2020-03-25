//
package com.vti.FinalTest.entity;

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
public class Manager {
	private User uId;
	private int mId;
	private int expInYear;

	public Manager() {
		super();
	}

	public Manager(int mId, int expInYear) {
		super();
		this.mId = mId;
		this.expInYear = expInYear;
	}

	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;

	}

	public int getExpInYear() {
		return expInYear;
	}

	public void setExpInYear(int expInYear) {
		this.expInYear = expInYear;

	}

	public User getUser() {
		return uId;
	}

	public void setUser(User user) {
		this.uId = user;

	}

	public void input(User uId) {
		Scanner sc = new Scanner(System.in);
		this.uId = uId;
		System.out.println("ExpInt:");
		expInYear = ScannerUtil.readInt(sc, "Please input data as INTEGER! \nPlease input again: ");
	}

}
