package GenericMergeSort;

public class GenericMergeSort {
	public static <E extends Comparable<E>> void mergeSort(E[] list){
		if(list.length > 1){
			E[] firsthalf = (E[]) new  Comparable[list.length / 2];
			System.arraycopy(list, 0, firsthalf, 0, list.length / 2);
			mergeSort(firsthalf);
			
			E[] secondhalf = (E[]) new  Comparable[list.length / 2];
			System.arraycopy(list, list.length / 2, secondhalf, 0, (list.length - (list.length / 2 )));
			mergeSort(secondhalf);
			
			merge(firsthalf, secondhalf, list);
		}
		
	}
	
	public static <E> void merge(E[] firsthalf, E[] secondhalf, E[] temp){
		
	}
	
	
	
	
	// Just a test case to see if we imported the right packages
	public static String print(){
		return "it works!";
	}
}
