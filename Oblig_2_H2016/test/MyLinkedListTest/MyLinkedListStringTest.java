package MyLinkedListTest;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import MylinkedList.MyLinkedList;

public class MyLinkedListStringTest {
	// Testing with Strings
	private MyLinkedList mylinkedlist;
	private String[] stringArray = {"Bjarne","Åse","Vidar","Øystein","Åse","Stian"};
	String keyword = new String("Åse");
	String insert = new String("Inserted");
	
	@Before
	public void initialize(){
		mylinkedlist = new MyLinkedList();
		for(int i = 0; i < stringArray.length; i++){
			mylinkedlist.add(new String(stringArray[i]));
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
		assertEquals("Inserted", mylinkedlist.set(2,insert));
		
	}

}
