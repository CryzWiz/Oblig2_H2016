package GenericMergeSort;

import java.util.ArrayList;





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
		int current1 = 0;
		int current2 = 0;
		int current3 = 0;
		
		while(current1 < firsthalf.length && current2 < secondhalf.length){
			if(((Comparable) firsthalf[current1]).compareTo(secondhalf[current2]) < 0){
				temp[current3++] = firsthalf[current1++];
			}
			else {
				temp[current3++] = secondhalf[current2++];
			}
		}
		while(current1 < firsthalf.length){
			temp[current3++] = firsthalf[current1++];
		}
		while(current2 < secondhalf.length){
			temp[current3++] = secondhalf[current2++];
		}
	}
	
	
	
	
	// Just a test case to see if we imported the right packages
	public static String print(){
		return "it works!";
	}
	/** A test method 
	 * @param <E>*/
	public static <E> void main(String[] args) {
		Integer[] intArray = {
				new Integer(2), 
				new Integer(6), 
				new Integer(1), 
				new Integer(3),
				new Integer(-2),
				new Integer(9),
				new Integer(0),
				new Integer(-6),};
		mergeSort(intArray);
		for (int i = 0; i < intArray.length; i++)
			System.out.print(intArray[i] + " ");
	}
}
