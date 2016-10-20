package BST;

public class TestBSTWithIterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST<String> tree = new BST<>();
		tree.insert("George");
		tree.insert("Michael");
		tree.insert("Tom");
		tree.insert("Adam");
		tree.insert("Jones");
		tree.insert("Peter");
		tree.insert("Daniel");
		
		java.util.Iterator<String> IteratorTree = tree.iterator();
		
		while(IteratorTree.hasNext()){
			System.out.print(IteratorTree.next().toUpperCase() + " ");
		}
			
	}

}
