package BSTTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import BST.BST;

public class BSTTest {
	private BST<Integer> tree;
	ArrayList GetNodeReturn = new ArrayList<>();
	@Before
	public void initialize(){
		tree = new BST<>();
		int[] numbers = {3,2,1,5,6,44,23,99,54,21,35,25};
		int[] numbersSorted = {1,3,5,6,21,23,25,35,44,54,99};
		for(int i = 0; i < numbers.length; i++){
			tree.insert(numbers[i]);
		}
	}
	/*@Test
	 * Commented out since we can't access private methods
	public void isLeafTest() {
		assertEquals(false, tree.isLeaf(6));
		assertEquals(true, tree.isLeaf(54));
		assertEquals(false, tree.isLeaf(44));
		assertEquals(false, tree.isLeaf(78));
	}*/
	
	/*@Test
	 * Commented out since we can't access private methods
	public void getNodeTest() {
		assertEquals(23, tree.getNode(23));
		
	}*/
	@Test
	public void getPathtest() {
		ArrayList path1 = new ArrayList<>(Arrays.asList(1,2,3));
		ArrayList path2 = new ArrayList<>(Arrays.asList(21,23,44,6,5,3));
		ArrayList path3 = new ArrayList<>(Arrays.asList(35,23,44,6,5,3));
		assertEquals(path1, tree.getPath(1));
		assertEquals(path2, tree.getPath(21));
		assertEquals(path3, tree.getPath(35));
	}
	@Test
	public void testOrderAfterDelete() {
		ArrayList root = new ArrayList<>(Arrays.asList(3));
		ArrayList Newroot = new ArrayList<>(Arrays.asList(2));
		assertEquals(root, tree.getPath(3));
		tree.delete(3);
		assertEquals(Newroot, tree.getPath(2));
		ArrayList completeListMinus99 = new ArrayList<>(Arrays.asList(54,44,6,5,2));
		ArrayList completeListMinus6 = new ArrayList<>(Arrays.asList(44,5,2));
		tree.delete(99);
		assertEquals(completeListMinus99, tree.getPath(54));
		tree.delete(6);
		assertEquals(completeListMinus6, tree.getPath(44));	
	
	}

}
