package GenericMergeSortTest;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import GenericMergeSort.GenericMergeSort;

public class DoubleListTest {

	@Test
	public void testSortDouble() {
		Double[] doubleArray = {22.86,86.97,-34.23,19.54};
		GenericMergeSort.mergeSort(doubleArray);
		Double[] intCorrectResponceOne = {-34.23,19.54,22.86,86.97};
		assertThat(doubleArray, is(intCorrectResponceOne));
	}

}
