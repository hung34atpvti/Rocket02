
public class Ford extends Car {
	int year;
	int manufacturerDiscount;

	public Ford() {
		super();
	}

	public Ford(int speed, double regularPrice, String color, int year, int manufacturerDiscount) {
		super(speed, regularPrice, color);
		this.year = year;
		this.manufacturerDiscount = manufacturerDiscount;
	}


	@Override
	public double getSalePrice() {
		// TODO Auto-generated method stub
		return super.getSalePrice() - this.manufacturerDiscount;
	}

}
