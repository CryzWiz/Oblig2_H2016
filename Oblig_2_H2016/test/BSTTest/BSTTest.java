package BSTTest;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import BST.BST;

public class BSTTest {
	private BST<Integer> tree;
	private int[] numbers = {3,2,1,5,6,44,23,99,54,21,35,25};
	private int[] realNodes = {3,2,1,5,6,44,23,99,54,21,35,25};
	private int[] falseNodes = {4,7,8,12,17,24,49,98,82,101,-26};
	private int[] isLeafs = {1,21,25,54};
	private int[] isNOTLeafs = {3,2};
	
	@Before
	public void initialize(){
		tree = new BST<>();
		for(int i = 0; i < numbers.length; i++){
			tree.insert(numbers[i]);
		}
	}
	@Test
	public void isLeafsTest() {
		for(int i=0;i<isLeafs.length;i++){
			assertTrue(tree.isLeaf(isLeafs[i]));
		}	
	}
	@Test
	public void isNOTLeafsTest() {
		for(int i=0;i<isNOTLeafs.length;i++){
			assertEquals(false, tree.isLeaf(isNOTLeafs[i]));
		}	
	}
	
	@Test
	public void getNodeTestForRealNodes() {
		for(int i=0;i<realNodes.length;i++){
			assertTrue(tree.getNode(realNodes[i]) != null);
		}
	}
	@Test
	public void getNodeTestForUnrealNodes() {
		for(int i=0;i<falseNodes.length;i++){
			assertFalse(tree.getNode(falseNodes[i]) != null);
		}
	}
	@Test
	public void getPathTestForCorrectPathReturn() {
		ArrayList<Integer> Correctpath1 = new ArrayList<>(Arrays.asList(1,2,3));
		ArrayList<Integer> Correctpath2 = new ArrayList<>(Arrays.asList(21,23,44,6,5,3));
		ArrayList<Integer> Correctpath3 = new ArrayList<>(Arrays.asList(35,23,44,6,5,3));
		assertEquals(Correctpath1, tree.getPath(1));
		assertEquals(Correctpath2, tree.getPath(21));
		assertEquals(Correctpath3, tree.getPath(35));
	}
	@Test
	public void testOrderAfterDelete() {
		ArrayList<Integer> root = new ArrayList<>(Arrays.asList(3));
		ArrayList<Integer> Newroot = new ArrayList<>(Arrays.asList(2));
		assertEquals(root, tree.getPath(3));
		tree.delete(3);
		assertEquals(Newroot, tree.getPath(2));
		ArrayList<Integer> completeListMinus99 = new ArrayList<>(Arrays.asList(54,44,6,5,2));
		ArrayList<Integer> completeListMinus6 = new ArrayList<>(Arrays.asList(44,5,2));
		tree.delete(99);
		assertEquals(completeListMinus99, tree.getPath(54));
		tree.delete(6);
		assertEquals(completeListMinus6, tree.getPath(44));
	}
	
}
