import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MainApp {
	List<NhanVien> nvs = new ArrayList<>();
	List<GiaoSu> gss = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choose;

		MainApp obj = new MainApp();

		while (true) {
			System.out.println("----------MENU---------");
			System.out.println("1.	Nhap List Nhan Vien.");
			System.out.println("2.	Nhap List Giao Su.");
			System.out.println("3.	Tim kiem Nhan Vien theo ten va phong ban.");
			System.out.println("4.	Sap xep Giao Su theo ten");
			System.out.println("5.	Exit");

			System.out.println("Vui long chon: ");
			choose = Integer.parseInt(sc.nextLine());
			switch (choose) {
			case 1:
				obj.inputListNhanVien();
				break;
			case 2:
				obj.inputListGiaoSu();
				break;
			case 3:
				obj.searchNhanVien();
				break;
			case 4:
				obj.sortByNameGiaoSu();
				break;
			case 5:
				System.exit(0);
			default:
				System.out.println("Chon tu 1-->5!");
				break;
			}
		}
	}

	public void searchNhanVien() {
		List<NhanVien> nvss = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		String s;
		System.out.println("Nhap ten hoac phong ban de tim nhan vien: ");
		s = sc.nextLine();
		int found = 0;
		for (NhanVien nv : nvs) {
			if ((nv.getFullName()) == s || (nv.getPosition()) == s) {
				found++;
				nvss.add(nv);
			}
		}
		System.out.println("\nKet qua tim kiem");
		for (NhanVien nv : nvss) {
			nv.print();
		}

		if (found == 0) {
			System.out.println("Khong co ket qua nao dc tim thay!");
		} else {
			System.out.println("Co " + found + " ket qua dc tim thay!");
		}
	}

	public void inputListNhanVien() {
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap so nhan vien can nhap:");
		n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			System.out.println("Nhan vien "+(i+1));
			NhanVien nv = new NhanVien();
			nv.input();
			nvs.add(nv);
		}
	}

	public void inputListGiaoSu() {
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap so giao su can nhap:");
		n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			System.out.println("Giao su "+(i+1));
			GiaoSu gs = new GiaoSu();
			gs.input();
			gss.add(gs);
		}
	}

	public void sortByNameGiaoSu() {

		Collections.sort(gss, new Comparator<GiaoSu>() {

			@Override
			public int compare(GiaoSu o1, GiaoSu o2) {
				// TODO Auto-generated method stub
				return o1.getFullName().compareTo(o2.getFullName());
			}

		});

		System.out.println("Danh sach cac Giao su");
		for (GiaoSu gs : gss) {
			gs.print();
		}

	}

}
