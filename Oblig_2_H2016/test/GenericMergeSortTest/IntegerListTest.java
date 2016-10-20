package GenericMergeSortTest;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import GenericMergeSort.GenericMergeSort;

public class IntegerListTest {
	
	@Test //Test case for integers
	public void checkifIntegersinEvenListLengthGetsSortedCorrect(){
		Integer[] intArrayOneEVEN = {9,6,1,2,-6,0,-2,3};
		GenericMergeSort.mergeSort(intArrayOneEVEN);
		Integer[] intCorrectResponceOne = {-6,-2,0,1,2,3,6,9};
		assertThat(intArrayOneEVEN, is(intCorrectResponceOne));
	}
	
	@Test 
	public void checkIfIntegersInOddListLengthGetsSortedCorrect(){ 
		Integer[] intArrayOneODD = {12,9,6,1,2,-6,0,-2,3};
		GenericMergeSort.mergeSort(intArrayOneODD);
		Integer[] intCorrectResponceOne = {-6,-2,0,1,2,3,6,9,12};
		assertThat(intArrayOneODD, is(intCorrectResponceOne));
	}
	
}
