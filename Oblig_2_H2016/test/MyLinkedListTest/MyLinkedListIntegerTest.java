package MyLinkedListTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import MylinkedList.MyLinkedList;

public class MyLinkedListIntegerTest {
	 // Testing with Integers
	 // Stopped this one since we only needed to test with one data type. String test is continued.
	private MyLinkedList mylinkedlist;
	private Integer[] intArray = {9,6,1,2,-6,0,-2,3};
	Object keyword = 2;
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
	
	@Test
	public void testGet() {
		assertEquals(intArray[4], mylinkedlist.get(4));

	}
	
	@Test(expected=NullPointerException.class)
	public void testGetWithToBigIndex() {
		assertEquals("The list size is not that big", mylinkedlist.get(12));
		
	}
	
	@Test
	public void testContains(){
		//assertTrue(mylinkedlist.contains(keyword));
		assertEquals(true, mylinkedlist.contains(keyword));
	}
	
	@Test
	public void testlastIndexOf(){
		//assertTrue(mylinkedlist.contains(keyword));
		assertEquals(3, mylinkedlist.lastIndexOf(keyword));
	}

}
