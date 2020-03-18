package ex1;

public class Test {

	public static void main(String[] args) {
		SequenceNumber sn = new SelectionSort(5);
		sn.input();
		((SelectionSort) sn).sort();
		sn.print();
		
		SequenceNumber sn1 = new QuickSort(5);
		sn1.input();
		((QuickSort) sn1).sort();
		sn1.print();
		
		SequenceNumber sn2 = new InsertSort(5);
		sn2.input();
		((InsertSort) sn2).sort();
		sn2.print();
		
	}

}
