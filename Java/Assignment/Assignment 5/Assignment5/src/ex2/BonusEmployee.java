package ex2;

abstract class Employee {
	private String name;
	private String address;
	protected int basicSalary;

	public abstract int getMonthlySalary();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(int basicSalary) {
		this.basicSalary = basicSalary;
	}
}

class NormalEmployee extends Employee {

	@Override
	public int getMonthlySalary() {
		// TODO Auto-generated method stub
		return basicSalary / 12;
	}

}

public class BonusEmployee extends Employee{

	@Override
	public int getMonthlySalary() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
