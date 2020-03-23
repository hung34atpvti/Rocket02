/**
 * This class is Drone, this is a Bee
 * 
 * @author hung34atp
 * @version 1.0
 * @Date Mar 23, 2020
 */
public class Drone extends Bee {
	public Drone() {
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
		System.out.println("\t\t:Drone:");
		super.checkHealthStatus();
		if (floatingPointHealth < 50) {
			System.out.println("\t\tBee can't fly and die!");
		}
	}
}
