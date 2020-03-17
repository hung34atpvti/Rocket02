import java.util.ArrayList;
import java.util.List;

public class MyOwnAutoShop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sedan sd1 = new Sedan(120, 500000, "red", 30);
		Ford f1 = new Ford(100, 200000, "black", 2017, 50000);
		Ford f2 = new Ford(120, 300000, "white", 2019, 50000);
		Car c1 = new Car(120, 150000, "black");

		List<Car> listC = new ArrayList<>();
		listC.add(sd1);
		listC.add(f1);
		listC.add(f2);
		listC.add(c1);

		for (Car c : listC) {
			System.out.println("This sale price: " + c.getSalePrice());
		}

	}

}
