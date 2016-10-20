package BSTTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import BST.BST;

public class BSTPreOrderIteratorTest {
	// Using names from the book to help myself understand
	private BST<String> tree; 
	private java.util.Iterator<String> IteratorTree;
	private String[] names = {"George", "Michael", "Tom", "Adam", "Jones", "Peter", "Daniel"};
	
	@Before // Make our tree and fill it with names
	public void initialize(){
		tree = new BST<>(); 
		for(int i = 0; i < names.length; i++){
			tree.insert(names[i]);
		}
		IteratorTree = tree.iterator();	// Here we make our Iterator tree with our BST tree 
	}
	@Test // Check if the Iterator we made sorts like the example in the book
	public void CheckIfOurPreOrderSortsJustLikeTheExample(){
		ArrayList<String> expected = new ArrayList<>(Arrays.asList("George" ,"Adam" ,"Daniel" ,"Michael","Jones","Tom","Peter"));
		int i = 0;
		while(i < expected.size()){ // for every name
			assertEquals(IteratorTree.next(), expected.get(i)); // Check if the next name in our iterator tree is as expected
			i++;
		}	
	}
	
	@Test // Just to make sure that we are in fact in our iterator and can access iterator methods
	public void testRemoveMethodAndCheckSorting() {
		ArrayList<String> newexpected = new ArrayList<>(Arrays.asList("George" ,"Adam" ,"Daniel" ,"Jones","Tom","Peter"));
		int i = 0;
		while(i < newexpected.size()){ // for every name
			if(i == 3){ IteratorTree.remove();} // If i is 3, we delete it - That would be Michael
			assertEquals(IteratorTree.next(), newexpected.get(i)); // Check if the next name in our iterator tree is as expected
			i++;
		}
		
	}
}
