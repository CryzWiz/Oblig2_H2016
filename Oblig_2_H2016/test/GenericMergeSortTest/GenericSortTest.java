package GenericMergeSortTest;
import static org.junit.Assert.*;
import org.junit.Test;
import GenericMergeSort.GenericMergeSort;
import static org.hamcrest.CoreMatchers.*;

public class GenericSortTest{
	@Test
	public void test() {
		assertEquals("it works!", GenericMergeSort.print());
	}
	
	@Test
	public void testSortInt(){ 
		Integer[] intArrayOne = {new Integer(2), new Integer(6), new Integer(1), new Integer(3),
				new Integer(-2),new Integer(9),new Integer(0),new Integer(-6),};
		GenericMergeSort.mergeSort(intArrayOne);
		Integer[] intCorrectResponceOne = {-6,-2,0,1,2,3,6,9};
		assertThat(intArrayOne, is(intCorrectResponceOne));
	}
	@Test
	public void testSortString(){
		String[] stringArrayOne = {new String("Åse"),new String("Allan"),new String("Lotte"),
				new String("Kenneth")};
		GenericMergeSort.mergeSort(stringArrayOne);
		String[] stringCorrectResponceOne = {"Allan","Kenneth","Lotte","Åse"};
		assertThat(stringArrayOne, is(stringCorrectResponceOne));
	}

}
