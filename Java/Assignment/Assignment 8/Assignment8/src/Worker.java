/**
 * This class is Worker, this is a Bee
 * 
 * @author hung34atp
 * @version 1.0
 * @Date Mar 23, 2020
 */
public class Worker extends Bee {

	public Worker() {
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
		System.out.println("\t\t:Worker:");
		super.checkHealthStatus();
		if (floatingPointHealth < 70) {
			System.out.println("\t\tBee can't fly and die!");
		}
	}

}
