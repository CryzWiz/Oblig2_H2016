package GenericMergeSort;
// Exercise 23.2
public class GenericMergeSort {
	public static <E extends Comparable<E>> void mergeSort(E[] list){
		// Debugging purposes
		//System.out.println("list: " + list.length);
		//System.out.println("firsthalf: " + list.length / 2);
		//System.out.println("secondhalf: " + (list.length - (list.length/ 2)));
		//
		if(list.length > 1){
			// Merge first half
			E[] firsthalf = (E[]) new  Comparable[list.length / 2]; // Set new list for first half
			System.arraycopy(list, 0, firsthalf, 0, list.length / 2); // Copy the first half of the list
			mergeSort(firsthalf); // Call mergeSort again with the first half list
			// Merge second half
			E[] secondhalf = (E[]) new  Comparable[list.length - (list.length / 2)]; // set new list for second half
			System.arraycopy(list, list.length/2, secondhalf, 0, (list.length - (list.length / 2 )));	// copy second half of the list
			mergeSort(secondhalf); // Call mergeSort again with the second half
			
			merge(firsthalf, secondhalf, list); // Merge the two half's
			
		}
	}	
	public static <E> void merge(E[] firsthalf, E[] secondhalf, E[] temp){
		int current1 = 0; // Set current1 to 0
		int current2 = 0; // Set current2 to 0
		int current3 = 0; // Set current3 to 0
		while(current1 < firsthalf.length && current2 < secondhalf.length){ // While current 1 is smaller than first half length and current2 is smaller than second half length
			if(((Comparable) firsthalf[current1]).compareTo(secondhalf[current2]) < 0){ // If first half element is bigger than second half element
				temp[current3++] = firsthalf[current1++]; // set list current element to first half current element and increase both current with one
			}
			else {
				temp[current3++] = secondhalf[current2++]; //else set list current element to second half current element and increase both current with one
			}
		}
		while(current1 < firsthalf.length){ // while current 1 is smaller than first half's length
			temp[current3++] = firsthalf[current1++];	// set list current element to second half's current element and increase both with one
		}
		while(current2 < secondhalf.length){ // while current 2 is smaller than second half's length
			temp[current3++] = secondhalf[current2++];	// set list current element to second half's current element and increase both with one
		}
	}
}
