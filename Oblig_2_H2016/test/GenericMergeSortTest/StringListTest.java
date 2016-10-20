package GenericMergeSortTest;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import GenericMergeSort.GenericMergeSort;

public class StringListTest {

	@Test // Test case for Strings
	public void checkIfStringsEvenListLengthIsSortedCorrect(){
		String[] stringArrayOne = {"Åse","Allan","Lotte","Kenneth"};
		GenericMergeSort.mergeSort(stringArrayOne);
		String[] stringCorrectResponceOne = {"Allan","Kenneth","Lotte","Åse"};
		assertThat(stringArrayOne, is(stringCorrectResponceOne));
	}
	
	@Test
	public void checkIfStringsOddListLengthIsSortedCorrect(){
		String[] stringArrayOne = {"Eple","Melon","Banan","Pærer", "Appelsin"};
		GenericMergeSort.mergeSort(stringArrayOne);
		String[] stringCorrectResponceOne = {"Appelsin","Banan","Eple","Melon", "Pærer"};
		assertThat(stringArrayOne, is(stringCorrectResponceOne));
	}
	

}
