package MyLinkedListTest;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import MylinkedList.MyLinkedList;

public class MyLinkedListStringTest {
	// Testing with Strings
	private MyLinkedList mylinkedlist;
	private String[] stringArray = {"Bjarne","�se","Vidar","�ystein","�se","Stian"};
	Object keyword = "�se";
	Object insert = "Inserted";
	
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
	
	@Test
	public void testGet() {
		assertEquals(stringArray[2], mylinkedlist.get(2));
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
		assertEquals(4, mylinkedlist.lastIndexOf(keyword));
	}
	
	@Test
	public void testSet(){
		assertEquals(mylinkedlist.get(2), mylinkedlist.set(2,insert));
		
	}

}
