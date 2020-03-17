package ex1;

public class Test {

	public static void main(String[] args) {
		SequenceNumber sn = new SelectionSort(5);
		sn.input();
		((SelectionSort) sn).sort();
		sn.print();
	}

}
