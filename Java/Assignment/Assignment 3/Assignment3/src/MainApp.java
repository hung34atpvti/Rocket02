import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Random;

import entity.Student;

public class MainApp {

	public static String getRandom(String[] array) {
		int rnd = new Random().nextInt(array.length);
		return array[rnd];
	}

	public static void main(String[] args) {
		String[] ho = new String[7];
		String[] dem = new String[7];
		String[] ten = new String[7];

		ho[0] = "Nguyen";
		ho[1] = "Le";
		ho[2] = "Ly";
		ho[3] = "Chu";
		ho[4] = "Duong";
		ho[5] = "Tran";
		ho[6] = "Ta";

		dem[0] = "Le";
		dem[1] = "Duy";
		dem[2] = "Manh";
		dem[3] = "Thu";
		dem[4] = "Nhu Hai";
		dem[5] = "Van";
		dem[6] = "Tuong";

		ten[0] = "Minh";
		ten[1] = "Hieu";
		ten[2] = "Hung";
		ten[3] = "Huong";
		ten[4] = "Yen";
		ten[5] = "Giang";
		ten[6] = "Khue";

		String[] hvt = new String[10];
		for (int i = 0; i < hvt.length; i++) {
			hvt[i] = getRandom(ho) + " " + getRandom(dem) + " " + getRandom(ten);
		}

		String[] msv = new String[10];
		for (int i = 0; i < msv.length; i++) {
			int code = (int) Math.floor(((Math.random() * 8999999) + 1000000));
			msv[i] = "HV" + Integer.toString(code);
		}

		String[] date = new String[10];
		date[0] = "01/02/1991";
		date[1] = "02/03/1991";
		date[2] = "03/04/1991";
		date[3] = "04/05/1991";
		date[4] = "05/06/1991";
		date[5] = "06/07/1991";
		date[6] = "07/08/1991";
		date[7] = "08/09/1991";
		date[8] = "09/10/1991";
		date[9] = "10/11/1991";

		Date[] dDate = new Date[10];
		for (int i = 0; i < dDate.length; i++) {
			try {
				dDate[i] = new SimpleDateFormat("dd/MM/yyyy").parse(date[i]);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		List<Student> list = new ArrayList<>(); //create a list student
		for (int i = 0; i < 10; i++) {
			//create a student
			Student a = new Student();
			a.setFullName(hvt[i]);
			a.setId(msv[i]);
			a.setDate(dDate[i]);
			a.setRa(new Random().nextInt(11));
			a.setSd(new Random().nextInt(11));
			a.setCp(new Random().nextInt(11));
			a.setCut(new Random().nextInt(11));
			a.setFmt(new Random().nextInt(11));
			a.calAvg();
			list.add(a); //add student into a list
		}

		Collections.sort(list, new Comparator<Student>() {
			//sort desc by avg mark
			@Override
			public int compare(Student o1, Student o2) {
				if (o2.getAvg() - o1.getAvg() > 0)
					return 1;
				else if (o2.getAvg() - o1.getAvg() == 0)
					return 0;
				else
					return -1;

			}
		});

		System.out.println("Sinh vien sap xep theo diem trung binh giam dan:");
		System.out.println("--------------------------------------");
		for (Student e : list) {
			e.display();
			System.out.println("--------------------------------------");
		}

	}

}
