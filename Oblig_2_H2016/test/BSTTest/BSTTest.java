package BSTTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import BST.BST;

public class BSTTest {
	private BST<Integer> tree;
	ArrayList GetNodeReturn = new ArrayList<>();
	@Before
	public void initialize(){
		tree = new BST<>();
		int[] numbers = {1,3,5,6,44,23,99,54,21,35,25};
		int[] numbersSorted = {1,3,5,6,21,23,25,35,44,54,99};
		for(int i = 0; i < numbers.length; i++){
			tree.insert(numbers[i]);
		}
	}
	@Test
	public void isLeafTest() {
		assertEquals(false, tree.isLeaf(6));
		assertEquals(true, tree.isLeaf(54));
		assertEquals(false, tree.isLeaf(44));
	}
	
	@Test
	public void getNodeTest() {
		assertEquals(23, tree.getNode(23));
		
	}
	@Test
	public void getPathtest() {
		assertEquals(23, tree.getPath(99));
	}

}
