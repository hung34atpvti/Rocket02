package entity;

import java.text.DateFormat;
import java.util.Date;

public class Student {
	//Basic info
	private String fullName;
	private String id;
	private Date date;
	//Mark
	private int ra;
	private int sd;
	private int cp;
	private int cut;
	private int fmt;
	private double avg;
	
	

	public Student() {
	}

	public Student(String fullName, String id, Date date, int ra, int sd, int cp, int cut, int fmt,double avg) {
		this.fullName = fullName;
		this.id = id;
		this.date = date;
		this.ra = ra;
		this.sd = sd;
		this.cp = cp;
		this.cut = cut;
		this.fmt = fmt;
		this.avg = avg;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getRa() {
		return ra;
	}

	public void setRa(int ra) {
		this.ra = ra;
	}

	public int getSd() {
		return sd;
	}

	public void setSd(int sd) {
		this.sd = sd;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public int getCut() {
		return cut;
	}

	public void setCut(int cut) {
		this.cut = cut;
	}

	public int getFmt() {
		return fmt;
	}

	public void setFmt(int fmt) {
		this.fmt = fmt;
	}
	
	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}
	
	public void calAvg() {
		this.avg=(double)(this.cp+this.cut+this.fmt+this.ra+this.sd)/5;
		
	}
	
	public void display() {
		System.out.println("\tFull Name: "+getFullName());
		System.out.println("\tID: "+getId());
		DateFormat df = DateFormat.getDateInstance();
		System.out.println("\tDate: "+df.format(getDate()));
		System.out.println("\tRA mark: "+getRa());
		System.out.println("\tSD mark: "+getSd());
		System.out.println("\tCP mark: "+getCp());
		System.out.println("\tCUT mark: "+getCut());
		System.out.println("\tFMT mark: "+getFmt());
		System.out.println("AVG: "+getAvg());
	}
	
}
