/**
 * This class is Queen, this is a Bee
 * 
 * @author hung34atp
 * @version 1.0
 * @Date Mar 23, 2020
 */
public class Queen extends Bee {
	public Queen() {
		super();
	}

	/**
	 * This method to check health of Bee.
	 * 
	 * @Description: .
	 * @author: hung34atp
	 * @create_date: Mar 23, 2020
	 * @version: 1.0
	 */
	@Override
	public void checkHealthStatus() {
		System.out.println("\t\t:Queen:");
		super.checkHealthStatus();
		if (floatingPointHealth < 20) {
			System.out.println("\t\tBee can't fly and die!");
		}
	}
}
