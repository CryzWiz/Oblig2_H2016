package MyLinkedListTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import MylinkedList.MyLinkedList;

public class MyLinkedListStringTest {
	// Testing with Strings
	private MyLinkedList mylinkedlist;
	private String[] stringArray = {"Åse","Bjarne","Vidar","Øystein"};
	
	@Before
	public void initialize(){
		mylinkedlist = new MyLinkedList();
		for(int i = 0; i < stringArray.length; i++){
			mylinkedlist.add(stringArray[i]);
		}
	}
	@Test
	public void test() {
		assertEquals(stringArray[0], mylinkedlist.getFirst());
	}
	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void testGet() {
		assertEquals(stringArray[4], mylinkedlist.get(4));
		assertEquals("The list size is not that big", mylinkedlist.get(12));
	}

}
