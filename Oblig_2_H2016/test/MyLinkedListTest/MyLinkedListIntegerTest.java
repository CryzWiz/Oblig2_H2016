package MyLinkedListTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import MylinkedList.MyLinkedList;

public class MyLinkedListIntegerTest {
	// Testing with Integers
	private MyLinkedList mylinkedlist;
	private Integer[] intArray = {9,6,1,2,-6,0,-2,3};
	@Before
	public void initialize(){
		mylinkedlist = new MyLinkedList();
		for(int i = 0; i < intArray.length; i++){
			mylinkedlist.add(intArray[i]);
		}
	}
	@Test
	public void test() {
		assertEquals(intArray[0], mylinkedlist.getFirst());
	}
	
	@Test(expected=NullPointerException.class)
	public void testGet() {
		assertEquals(intArray[4], mylinkedlist.get(4));
		assertEquals("The list size is not that big", mylinkedlist.get(12));
	}

}
