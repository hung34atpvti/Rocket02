import java.util.Scanner;

public class NhanVien implements ICalSalary {
	private String fullName;
	private String department;
	private double workingTime;
	private double salaryMultiplier;
	private int allowance;
	private String position;

	enum eAllowanceByPosition {
		DepartmentHead(2000), ViceHead(1000), Staff(500);

		private int value;

		eAllowanceByPosition(int i) {
			this.value = i;
		}

		public static eAllowanceByPosition getAllowanceByIndex(int value) {
			for (eAllowanceByPosition d : eAllowanceByPosition.values()) {
				if (d.value == value) {
					return d;
				}
			}
			return null;
		}

		public static eAllowanceByPosition getAllowanceByValue(int value) {
			for (eAllowanceByPosition d : eAllowanceByPosition.values()) {
				if (d.value == value) {
					return d;
				}
			}
			return null;
		}
	}

	enum eAllowance {
		Bachelor(300), Master(500), Doctor(1000);

		private int value;

		eAllowance(int i) {
			this.value = i;
		}

		public static eAllowance getAllowanceByIndex(int value) {
			for (eAllowance d : eAllowance.values()) {
				if (d.value == value) {
					return d;
				}
			}
			return null;
		}

		public static eAllowance getAllowanceByValue(int value) {
			for (eAllowance d : eAllowance.values()) {
				if (d.value == value) {
					return d;
				}
			}
			return null;
		}
	}

	public NhanVien() {
		super();
	}

	public NhanVien(String fullName, String department, double workingTime, double salaryMultiplier, int allowance,
			String position) {
		super();
		this.fullName = fullName;
		this.department = department;
		this.workingTime = workingTime;
		this.salaryMultiplier = salaryMultiplier;
		this.allowance = allowance;
		this.position = position;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getWorkingTime() {
		return workingTime;
	}

	public void setWorkingTime(double workingTime) {
		this.workingTime = workingTime;
	}

	public double getSalaryMultiplier() {
		return salaryMultiplier;
	}

	public void setSalaryMultiplier(double salaryMultiplier) {
		this.salaryMultiplier = salaryMultiplier;
	}

	public double getAllowance() {
		return allowance;
	}

	public void setAllowance(int allowance) {
		this.allowance = allowance;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public void input() {
		Scanner sc = new Scanner(System.in);
		

		System.out.println("\tTen day du: ");
		this.fullName = sc.nextLine();

		System.out.println("\tPhong ban: ");
		this.department = sc.nextLine();

		System.out.println("\tSo ngay lam viec: ");
		this.workingTime = Double.parseDouble(sc.nextLine());

		System.out.println("\tHe so luong: ");
		this.salaryMultiplier = Double.parseDouble(sc.nextLine());

		int option;
		boolean blA = true;
		do {
			System.out.println("\tHoc vi:");
			int dem = 1;
			int op = 1;
			for (eAllowance e : eAllowance.values()) {

				System.out.println("\t\t" + dem + ". " + e);
				dem++;
			}
			option = Integer.parseInt(sc.nextLine());
			for (eAllowance e : eAllowance.values()) {
				if (op == option) {
					blA = false;
					this.allowance = e.value;
					break;
				} else {
					op++;
				}
			}
			if (blA==true) System.out.println("NHAP LAI!");
		} while (blA);

		int option1;
		boolean blP = true;
		do {
			System.out.println("\tVi tri:");
			int dem = 1;
			int op = 1;
			for (eAllowanceByPosition e : eAllowanceByPosition.values()) {

				System.out.println("\t\t" + dem + ". " + e);
				dem++;
			}
			option1 = Integer.parseInt(sc.nextLine());
			for (eAllowanceByPosition e : eAllowanceByPosition.values()) {
				if (op == option1) {
					blP = false;
					this.position = e.name();
					this.allowance += e.value;
					break;
				} else {
					op++;
				}
			}
			if (blP==true) System.out.println("NHAP LAI!");
		} while (blP);
	}

	@Override
	public double calculateSalary() {
		double salary;
		salary = this.salaryMultiplier * 730 + this.allowance + this.workingTime * 30;
		return salary;
	}

	public void print() {
		System.out.println("\tTen day du: "+this.fullName);
		System.out.println("\tPhong ban: "+this.department);
		System.out.println("\tSo ngay lam viec: "+this.workingTime);
		System.out.println("\tHe so luong: "+this.salaryMultiplier);
		System.out.println("\tPhu cap: "+this.allowance);
		System.out.println("\tVi tri: "+this.position);
		System.out.println("----------------------------------------------");
	}
}
