package BST;

public class TestBST {
	public static void main(String[] args) {
		// Create a BST
		BST<String> tree = new BST<>();
		tree.insert("George");
		tree.insert("Michael");
		tree.insert("Tom");
		tree.insert("Adam");
		tree.insert("Jones");
		tree.insert("Peter");
		tree.insert("Daniel");

		// Traverse tree
		System.out.print("Inorder (sorted): ");
		tree.inorder();
		System.out.print("\nPostorder: ");
		tree.postorder();
		System.out.print("\nPreorder: ");
		tree.preorder();
		System.out.print("\nThe number of nodes is " + tree.getSize());

		// Search for an element
		System.out.print("\nIs Peter in the tree? " +
				tree.search("Peter"));

		// Get a path from the root to Peter
		System.out.print("\nA path from the root to Peter is: ");
		java.util.ArrayList<BST.TreeNode<String>> path = tree.path("Peter");
		for (int i = 0; path != null && i < path.size(); i++)
			System.out.println(path.get(i).element + " ");
		System.out.println("Node to Peter: " + tree.getNode("Peter"));
		Object test = tree.getNode("Peter").element;
		System.out.println("Content of Node: " + test);
		System.out.println("isLeaf: " + tree.isLeaf("Peter"));
		System.out.println("GetPath: " + tree.getPath("Peter"));
		
		Integer[] numbers = {2, 4, 3, 1, 8, 5, 6, 7};
		BST<Integer> intTree = new BST<>(numbers);
		System.out.print("\nInorder (sorted): ");
		intTree.inorder();
	}
}
