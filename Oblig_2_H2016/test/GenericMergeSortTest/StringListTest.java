package GenericMergeSortTest;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import GenericMergeSort.GenericMergeSort;

public class StringListTest {

	@Test // Test case for Strings
	public void testSortStringEVEN(){
		String[] stringArrayOne = {"�se","Allan","Lotte","Kenneth"};
		GenericMergeSort.mergeSort(stringArrayOne);
		String[] stringCorrectResponceOne = {"Allan","Kenneth","Lotte","�se"};
		assertThat(stringArrayOne, is(stringCorrectResponceOne));
	}
	
	@Test
	public void testSortStringODD(){
		String[] stringArrayOne = {"Eple","Melon","Banan","P�rer", "Appelsin"};
		GenericMergeSort.mergeSort(stringArrayOne);
		String[] stringCorrectResponceOne = {"Appelsin","Banan","Eple","Melon", "P�rer"};
		assertThat(stringArrayOne, is(stringCorrectResponceOne));
	}
	

}
