//
package com.vti.FinalTest.entity;



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
public class Employee {
	private int uId;
	private int eId;
	private String projectName;
	private String proSkill;

	enum eProjectName {
		TestingSystem(1), CRM(2), TimeSheet(3);

		private int value;

		eProjectName(int i) {
			this.value = i;
		}

		public static eProjectName getEByIndex(int value) {
			for (eProjectName d : eProjectName.values()) {
				if (d.value == value) {
					return d;
				}
			}
			return null;
		}

		public static eProjectName getEByValue(int value) {
			for (eProjectName d : eProjectName.values()) {
				if (d.value == value) {
					return d;
				}
			}
			return null;
		}
	}

	public Employee() {
		super();
	}

	public Employee(int eId,String projectName, String proSkill) {
		super();
		this.eId=eId;
		this.projectName = projectName;
		this.proSkill = proSkill;
	}
	
	

	public int getEId() {
		return eId;
	}

	public void setEId(int eId) {
		this.eId = eId;
	
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	
	}

	public String getProSkill() {
		return proSkill;
	}

	public void setProSkill(String proSkill) {
		this.proSkill = proSkill;
	
	}

	public int getUser() {
		return uId;
	}

	public void setUser(int user) {
		this.uId = user;
	
	}
	
	
}
