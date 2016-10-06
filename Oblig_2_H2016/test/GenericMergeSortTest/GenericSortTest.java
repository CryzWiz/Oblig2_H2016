package GenericMergeSortTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import GenericMergeSort.GenericMergeSort;


public class GenericSortTest{
	@Test
	public void test() {
		assertEquals("it works!", GenericMergeSort.print());
	}
	
	@Test
	public void testSort(){ 
		Integer[] intArray = {
				new Integer(2), 
				new Integer(6), 
				new Integer(1), 
				new Integer(3),
				new Integer(-2),
				new Integer(9),
				new Integer(0),
				new Integer(-6),};
		Integer[] intCorrectResponceOne = {-6,-2,0,1,2,3,6,9};
	}
	

	
	

}
