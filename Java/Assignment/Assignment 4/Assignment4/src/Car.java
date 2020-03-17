
public class Car {
	int speed;
	double regularPrice;
	String color;
	
	
	public Car() {
		super();
	}


	public Car(int speed, double regularPrice, String color) {
		super();
		this.speed = speed;
		this.regularPrice = regularPrice;
		this.color = color;
	}


	public double getSalePrice() {
		return regularPrice;
	};
}
