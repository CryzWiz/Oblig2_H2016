package BSTTest;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import BST.BST;

public class BSTTest {
	private BST<Integer> tree;
	private int[] ourList = {3,2,1,5,6,44,23,99,54,21,35,25};
	
	@Before // make our BST tree and fill it with some numbers
	public void initialize(){
		tree = new BST<>();
		for(int i = 0; i < ourList.length; i++){
			tree.insert(ourList[i]);
		}
	}
	@Test // Check if a leaf returns true
	public void isLeafsTest() {
		int[] isLeafs = {1,21,25,54}; // Are leafs
		for(int i=0;i<isLeafs.length;i++){	// For every leaf
			assertTrue(tree.isLeaf(isLeafs[i]));	// Confirm it is a leaf
		}	
	}
	@Test // Check if a parent returns false
	public void isNOTLeafsTest() {
		int[] isNOTLeafs = {3,2,5,6,44,23,99,35};	// Are parents
		for(int i=0;i<isNOTLeafs.length;i++){		// For every parent
			assertEquals(false, tree.isLeaf(isNOTLeafs[i]));	// Confirm its not a leaf
		}	
	}
	
	@Test // Check if we handle existing nodes correctly
	public void getNodeTestForRealNodes() {
		int[] realNodes = {3,2,1,5,6,44,23,99,54,21,35,25}; // Only existing nodes
		for(int i=0;i<realNodes.length;i++){				// For every existing node
			assertTrue(tree.getNode(realNodes[i]) != null);	// Confirm we get a node with content in return (We don't check the actual content here)
		}
	}
	@Test // Check if we handle non-existent node correctly
	public void getNodeTestForUnrealNodes() {
		int[] falseNodes = {4,7,8,12,17,24,49,98,82,101,-26}; // Only false nodes
		for(int i=0;i<falseNodes.length;i++){				// For every false node
			assertTrue(tree.getNode(falseNodes[i]) == null);	// Confirm we can't find it and get null in return
		}
	}
	@Test // Check if getPath returns correct path to nodes
	public void checkIfGetPathReturnsCorrectPath() {
		ArrayList<Integer> CorrectPath1 = new ArrayList<>(Arrays.asList(1,2,3)); // Correct path to 1
		ArrayList<Integer> CorrectPath2 = new ArrayList<>(Arrays.asList(21,23,44,6,5,3)); // Correct path to 21
		ArrayList<Integer> CorrectPath3 = new ArrayList<>(Arrays.asList(35,23,44,6,5,3)); // Correct path to 35
		assertEquals(CorrectPath1, tree.getPath(1));	// Check path to 1
		assertEquals(CorrectPath2, tree.getPath(21));   // Check path to 21
		assertEquals(CorrectPath3, tree.getPath(35));   // Check path to 35
	}
	@Test // Test if order is still correct after we delete some nodes. To check if parent updates correctly
	public void testOrderAfterDelete() {
		ArrayList<Integer> root = new ArrayList<>(Arrays.asList(3));
		ArrayList<Integer> Newroot = new ArrayList<>(Arrays.asList(2));
		assertEquals(root, tree.getPath(3)); // Verify that 3 is root
		tree.delete(3);	// Delete root
		assertEquals(Newroot, tree.getPath(2)); //Check if 2 is new root
		ArrayList<Integer> completeListMinus99 = new ArrayList<>(Arrays.asList(54,44,6,5,2)); // Correct path to 54 after 99 is deleted
		tree.delete(99);	// Delete 99
		assertEquals(completeListMinus99, tree.getPath(54)); // Check if path to 54 is correct
		ArrayList<Integer> completeListMinus6 = new ArrayList<>(Arrays.asList(44,5,2));	// Correct path to 44 after 6 is deleted
		tree.delete(6);	// Delete 6
		assertEquals(completeListMinus6, tree.getPath(44));	// Check if path to 44 is correct
	}
	
}
