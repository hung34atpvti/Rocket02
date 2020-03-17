package ex1;

public class SelectionSort extends SequenceNumber implements Sort {

	public SelectionSort(int n) {
		super(n);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sort() {
		for (int i = 0; i < x.length - 1; i++)  
        {  
            int index = i;  
            for (int j = i + 1; j < x.length; j++){  
                if (x[j] < x[index]){  
                    index = j;//searching for lowest index  
                }  
            }  
            int smallerNumber = x[index];   
            x[index] = x[i];  
            x[i] = smallerNumber;  
        }  
		
	}
	
	
	
	

}
