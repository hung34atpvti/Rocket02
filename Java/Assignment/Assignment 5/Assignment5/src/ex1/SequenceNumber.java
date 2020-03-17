package ex1;

import java.util.Scanner;

public class SequenceNumber {
	int[] x;

	public SequenceNumber(int n) {
		this.x = new int[n];
	}

	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap phan tu cho day so: ");
		for (int i = 0; i < x.length; i++) {
			System.out.println("x[" + (i + 1) + "]: ");
			x[i] = Integer.parseInt(sc.nextLine());
		}
	}

	public void print() {
		for (int i = 0; i < x.length; i++) {
			System.out.println("x[" + (i + 1) + "] = " + x[i]);
		}

	}
}
