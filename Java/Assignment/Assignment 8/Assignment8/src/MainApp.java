import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MainApp {
	static List<Bee> bees;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int choose;

		MainApp obj = new MainApp();
		while (true) {
			System.out.println("----------MENU---------");
			System.out.println("1.	Create random Bee list.");
			System.out.println("2.	Attack Bee.");
			System.out.println("3.	Exit.");
			System.out.println("Please choose: ");
			choose = ScannerUtil.readInt(sc, "Please input data as INTEGER! \nPlease input again: ");

			switch (choose) {
			case 1:
				obj.createBeeList();
				break;
			case 2:
				if (bees == null) {
					System.out.println("PLEASE CREATE LIST BEE FIRST!");
					break;
				} else {
					obj.attackBee();
					obj.showStatus();
					break;
				}
			case 3:
				System.exit(0);
			default:
				System.out.println("PLEASE CHOOSE FROM 1 --> 3!");
				break;
			}

		}

	}

	private void showStatus() {
		int i = 1;
		for (Bee bee : bees) {
			System.out.println("\tBee " + i);
			i++;
			bee.checkHealthStatus();
			System.out.println("-----------------------------------------");
		}
	}

	private void attackBee() {
		for (Bee bee : bees) {
			bee.damage(new Random().nextInt(81));
		}
		System.out.println("ATTACK SUCCESSFULLY!");
		System.out.println("-----------------------------------------");
		System.out.println();
	}

	private void createBeeList() {
		bees = new ArrayList<>();
		int rnd = new Random().nextInt(11);
		int rnd1 = new Random().nextInt(11 - rnd);
		int rnd2 = 10 - (rnd1 + rnd);
		for (int i = 0; i < rnd; i++) {
			Worker bee = new Worker();
			bees.add(bee);
		}
		for (int i = 0; i < rnd1; i++) {
			Drone bee = new Drone();
			bees.add(bee);
		}
		for (int i = 0; i < rnd2; i++) {
			Queen bee = new Queen();
			bees.add(bee);
		}
		 Collections.shuffle(bees);
		System.out.println("CREATE SUCCESSFULLY!");
	}
}
