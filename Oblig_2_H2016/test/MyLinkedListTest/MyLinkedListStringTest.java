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
	String inserted = new String("This is inserted");
	
	@Before
	public void initialize(){
		mylinkedlist = new MyLinkedList();
		for(int i = 0; i < stringArray.length; i++){
			mylinkedlist.add(new String(stringArray[i]));
		}
	}
	@Test
	public void testGet() {
		assertEquals(stringArray[2], mylinkedlist.get(2));
		assertEquals(stringArray[4], mylinkedlist.get(4));
	}
	
	@Test(expected=NullPointerException.class)
	public void testGetWithToBigIndex() {
		assertEquals("The list size is not that big", mylinkedlist.get(12));
		
	}
	
	@Test
	public void testContains(){
		assertEquals(true, mylinkedlist.contains(keyword));
		assertTrue(mylinkedlist.contains(new String("Stian")));
		assertFalse(mylinkedlist.contains(new String("Kjartan")));
	}
	
	@Test
	public void testlastIndexOf(){
		assertEquals(4, mylinkedlist.lastIndexOf(keyword));
		assertEquals(-1, mylinkedlist.lastIndexOf(""));
		assertEquals(4, mylinkedlist.lastIndexOf("Åse"));
	}
	
	@Test
	public void testSet(){
		assertEquals("Inserted", mylinkedlist.set(0,insert));
		mylinkedlist.set(5,inserted);
		assertEquals(inserted, mylinkedlist.get(5));
		assertEquals(inserted, mylinkedlist.getLast());
		
		
	}

}
