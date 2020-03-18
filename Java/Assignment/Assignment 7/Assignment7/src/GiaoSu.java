import java.util.Scanner;

public class GiaoSu implements ICalSalary {
	private String fullName;
	private String faculty;
	private String academicDegree;
	private double allowance;
	private double monthlyTeachingTime;
	private double salaryMultiplier;

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

	public GiaoSu() {
		super();
	}

	public GiaoSu(String fullName, String faculty, String academicDegree, double allowance, double monthlyTeachingTime,
			double salaryMultiplier) {
		super();
		this.fullName = fullName;
		this.faculty = faculty;
		this.academicDegree = academicDegree;
		this.allowance = allowance;
		this.monthlyTeachingTime = monthlyTeachingTime;
		this.salaryMultiplier = salaryMultiplier;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getAcademicDegree() {
		return academicDegree;
	}

	public void setAcademicDegree(String academicDegree) {
		this.academicDegree = academicDegree;
	}

	public double getAllowance() {
		return allowance;
	}

	public void setAllowance(double allowance) {
		this.allowance = allowance;
	}

	public double getMonthlyTeachingTime() {
		return monthlyTeachingTime;
	}

	public void setMonthlyTeachingTime(double monthlyTeachingTime) {
		this.monthlyTeachingTime = monthlyTeachingTime;
	}

	public double getSalaryMultiplier() {
		return salaryMultiplier;
	}

	public void setSalaryMultiplier(double salaryMultiplier) {
		this.salaryMultiplier = salaryMultiplier;
	}

	public void input() {
		Scanner sc = new Scanner(System.in);
		

		System.out.println("\tTen day du: ");
		this.fullName = sc.nextLine();

		System.out.println("\tNang luc: ");
		this.faculty = sc.nextLine();

		System.out.println("\tThoi gian day hang thang: ");
		this.monthlyTeachingTime = Double.parseDouble(sc.nextLine());

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
					this.academicDegree = e.name();
					this.allowance = e.value;
					break;
				} else {
					op++;
				}
			}
			if (blA==true) System.out.println("NHAP LAI!");
		} while (blA);

	}

	@Override
	public double calculateSalary() {
		double salary;
		salary = this.salaryMultiplier * 730 + this.allowance + this.monthlyTeachingTime * 45;
		return salary;
	}
	
	public void print() {
		System.out.println("\tTen day du: "+this.fullName);
		System.out.println("\tNang luc: "+this.faculty);
		System.out.println("\tBang cap: "+this.academicDegree);
		System.out.println("\tPhu cap: "+this.allowance);
		System.out.println("\tThoi gian day hang thang: "+this.monthlyTeachingTime);
		System.out.println("\tHe so luong: "+this.salaryMultiplier);
		System.out.println("----------------------------------------------");
	}

}
