
public class Truck extends Car {
	int weight;

	public Truck(int speed, double regularPrice, String color, int weight) {
		super(speed, regularPrice, color);
		this.weight = weight;
	}

	public Truck() {
		super();
	}


	@Override
	public double getSalePrice() {
		if (this.weight > 2000)
			return super.regularPrice * (1-0.1);
		else
			return super.regularPrice * (1-0.2);
	}

}
