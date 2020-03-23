/**
 * This class is Bee
 * 
 * @author hung34atp
 * @version 1.0
 * @Date Mar 23, 2020
 */
public class Bee {
	protected int floatingPointHealth;

	public Bee() {
		this.floatingPointHealth = 100;
	}

	/**
	 * This method to attack Bee, increase health.
	 * 
	 * @Description: .
	 * @author: hung34atp
	 * @create_date: Mar 23, 2020
	 * @version: 1.0
	 */
	public void damage(int dame) {
		if (dame >= 0 && dame <= 100) {
			floatingPointHealth -= dame;
			if (floatingPointHealth < 0)
				floatingPointHealth = 0;
		}
	}

	/**
	 * This method is check health of Bee.
	 * 
	 * @Description: .
	 * @author: hung34atp
	 * @create_date: Mar 23, 2020
	 * @version: 1.0
	 */
	public void checkHealthStatus() {
		System.out.println("\t\tfloatingPointHealth = " + floatingPointHealth);
	}
}
