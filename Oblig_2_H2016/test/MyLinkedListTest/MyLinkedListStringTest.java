package MyLinkedListTest;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import MylinkedList.MyLinkedList;

public class MyLinkedListStringTest {
	// Testing with Strings
	private MyLinkedList mylinkedlist;
	private String[] stringArray = {"Bjarne","Åse","Vidar","Øystein","Åse","Stian"};
	
	@Before
	public void initialize(){
		mylinkedlist = new MyLinkedList();
		for(int i = 0; i < stringArray.length; i++){
			mylinkedlist.add(new String(stringArray[i]));
		}
	}
	@Test // Checking get method
	public void checkIfGetReturnsCorrectElement() {
		assertEquals(stringArray[2], mylinkedlist.get(2));
		assertEquals(stringArray[4], mylinkedlist.get(4));
	}
	
	@Test(expected=NullPointerException.class) // Checking if asking for a non-existent index will give exception
	public void testGetWithToBigIndex() {
		assertEquals("The list size is not that big", mylinkedlist.get(99));
	}
	
	@Test // Checking contains method
	public void checkIfWeCanFindElements(){
		assertEquals(true, mylinkedlist.contains("Åse"));
		assertTrue(mylinkedlist.contains(new String("Stian")));
		
	}
	@Test // Checking contains method
	public void checkIfNonExistingElementsReturnFalse() {
		assertFalse(mylinkedlist.contains(new String("Kjartan")));
	}
	
	@Test // Checking lastIndexOf method
	public void CheckIfWeGetCorrectLastIndexOfRecuringElement(){
		assertEquals(4, mylinkedlist.lastIndexOf("Åse"));
	}
	@Test // Checking lastIndexOf method
	public void checkIfWeGetCorrectIndexForSingleElements(){
		assertEquals(3, mylinkedlist.lastIndexOf("Øystein"));
	}
	@Test // Checking lastIndexOf method
	public void checkIfWeGetCorrectValueBackForIndexOfNonExsistingElement() {
		assertEquals(-1, mylinkedlist.lastIndexOf(""));
	}
	
	@Test // Checking set method, get() and getLast()
	public void SettingNewContentAndCheckThatWeFindItAfterwards(){
		String insert = new String("Inserted");
		String inserted = new String("This is inserted");
		assertEquals("Inserted", mylinkedlist.set(0,insert));
		mylinkedlist.set(5,inserted);
		assertEquals(inserted, mylinkedlist.get(5));
		assertEquals(inserted, mylinkedlist.getLast());
		
		
	}

}
