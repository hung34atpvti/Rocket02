
public class Sedan extends Car {
	int lenght;

	public Sedan(int speed, double regularPrice, String color, int lenght) {
		super(speed, regularPrice, color);
		this.lenght = lenght;
	}

	public Sedan() {
		super();
	}


	@Override
	public double getSalePrice() {
		if (this.lenght > 20)
			return super.regularPrice * (1 - 0.05);
		else
			return super.regularPrice * (1 - 0.1);
	}

}
