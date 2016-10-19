package BSTTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import BST.BST;

public class BSTPreOrderIteratorTest {
	// Using names from the book to make it easy for myself
	private BST<String> tree;
	private java.util.Iterator<String> IteratorTree;
	private String[] names = {"George", "Michael", "Tom", "Adam", "Jones", "Peter", "Daniel"};
	
	@Before 
	public void initialize(){
		tree = new BST<>();
		for(int i = 0; i < names.length; i++){
			tree.insert(names[i]);
		}
		IteratorTree = tree.iterator();
	}
	@Test 
	public void CheckIfOurPreOrderSortsJustLikeTheExample(){
		ArrayList<String> expected = new ArrayList<>(Arrays.asList("George" ,"Adam" ,"Daniel" ,"Michael","Jones","Tom","Peter"));
		int i = 0;
		while(i < expected.size()){
			assertEquals(IteratorTree.next(), expected.get(i));
			i++;
		}	
	}
	
}
