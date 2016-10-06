package GenericMergeSort;
public class GenericMergeSort {
	public static <E extends Comparable<E>> void mergeSort(E[] list){
		if(list.length > 1){
			E[] firsthalf = (E[]) new  Comparable[list.length / 2];
			System.arraycopy(list, 0, firsthalf, 0, list.length / 2);
			mergeSort(firsthalf);
			
			E[] secondhalf = (E[]) new  Comparable[list.length / 2];
			System.arraycopy(list, list.length - (list.length / 2 ), secondhalf, 0, (list.length - (list.length / 2 )));
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
}
