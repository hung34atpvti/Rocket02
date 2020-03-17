package ex1;

public class InsertSort extends SequenceNumber implements Sort {

	public InsertSort(int n) {
		super(n);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sort() {
		int n = x.length;  
        for (int j = 1; j < n; j++) {  
            int key = x[j];  
            int i = j-1;  
            while ( (i > -1) && ( x [i] > key ) ) {  
                x [i+1] = x [i];  
                i--;  
            }  
            x[i+1] = key;  
        }  
		
	}

}
