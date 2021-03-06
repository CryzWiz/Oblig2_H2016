package BST;
import java.util.ArrayList;

// Code copied from the textbook

public class BST<E extends Comparable<E>> extends AbstractTree<E> {
	protected TreeNode<E> root;
	protected int size = 0;
	/** Create a default binary search tree */
	public BST() {
		
	}
	
	/** Create a binary search tree from an array of objects */
	public BST(E[] objects) {
		for(int i = 0; i < objects.length; i++) {
			insert(objects[i]);
		}
	}
	
	@Override /** Return true if the element is in the tree */
	public boolean search(E e) {
		TreeNode<E> current = root; // Start from the root
		
		while(current != null) {
			if(e.compareTo(current.element) < 0) {
				current = current.left;
			}
			else if(e.compareTo(current.element) > 0) {
				current = current.right;
			}
			else // element matches current.element
				return true; // Element is found
		}
		return false;
	}
	
	@Override/** Insert element e into the binary search tree.
	 * Return true if the element is inserted successfully. */
	public boolean insert(E e) {
		if(root == null) root = createNewNode(e); // Create a new root
		else {
			// Locate the parent node
			TreeNode<E> parent = null;
			TreeNode<E> current = root;
			while(current != null) 
				if(e.compareTo(current.element) < 0){
					parent = current;
					current = current.left;
				}
				else if(e.compareTo(current.element) > 0){
					parent = current;
					current = current.right;
				}
				else 
					return false; // Duplicate node not inserted
				// Create the new node and attach it to the parent node
				if(e.compareTo(parent.element) < 0){
					parent.left = createNewNode(e);
					parent.left.parent = parent;
				}
				else {
					parent.right = createNewNode(e);
					parent.right.parent = parent;
				}
		}
		size++;
		return true; // Element inserted successfully
	}
	
	protected TreeNode<E> createNewNode(E e) {
		return new TreeNode<>(e);
	}
	
	@Override /** Inorder traversal from the root */
	public void inorder() {
		inorder(root);
	}
	
	/** Inorder traversal from a subtree */
	protected void inorder(TreeNode<E> root) {
		if (root == null) return;
		inorder(root.left);
		System.out.print(root.element + " ");
		inorder(root.right);
	}
	
	@Override /** Postorder traversal from the root */
	public void postorder() {
		postorder(root);
	}
	
	/** Postorder traversal from a subtree */
	protected void preorder(TreeNode<E> root) {
		if (root == null) return;
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.element + " ");
	}
	
	@Override /** Preorder traversal from the root */
	public void preorder() {
		preorder(root);
	}
	
	/** Preorder traversal from a subtree */
	protected void postorder(TreeNode<E> root) {
		if (root == null) return;
		System.out.print(root.element + " ");
		preorder(root.left);
		preorder(root.right);
	}
	
	
	/** This inner class is static, because it does not access
	 any instance members defined in its outer class */
	public static class TreeNode<E extends Comparable<E>> {
		public E element;
		protected TreeNode<E> left;
		protected TreeNode<E> right;
		protected TreeNode<E> parent;
		
		public TreeNode(E e) {
			element = e;
		}
	}

	
	
	// OBLIG OPPGAVER START
	 
	/** Returns the node for the specified element
	 * returns null if the element is not in the tree */
	public TreeNode<E> getNode(E element){
		TreeNode<E> current = root;
		if(search(element) != false){
			while(current != null) {
				if(element.compareTo(current.element) < 0) { // Compare element to the left
					current = current.left;					// Go left
				}
				else if(element.compareTo(current.element) > 0) {	// Compare element to the right
					current = current.right;						// Go right
				}
				else // element matches current.element
					return current; // Element is found, Returning the node
			}
		}
		return null;
	}
	
	/** Returns true if the node for the element is a leaf */
	public boolean isLeaf(E element){
		TreeNode<E> current = getNode(element);
		if(current == null) return false;					// If we can't find the node, we return false (a non-existent node is no leaf)
		if(current.right == null && current.left == null) // If we have no nodes on the sides, we have to be a leaf
		return true;
		else return false;								// If not, we are a parent
	}
	
	/** Returns the path of the elements from the specified element
	 * to the root in an array list*/
	public ArrayList<E> getPath(E e) {
		TreeNode<E> target = getNode(e); 			// Get the node we are looking for
		ArrayList<E> path = new ArrayList<>();		// Make a second list containing our path
		while(target != null) {						// while we have a node
			path.add(target.element);				// add the node
			target = target.parent;					// and set the next target to its parent
		}
		return path;								// return the path from the element back to root
	}
	
	// OBLIG OPPGAVER SLUTT

	
	@Override /** Get the number of nodes in the tree */
	public int getSize() {
		return size;
	}
	
	/** Returns the root of the tree */
	public TreeNode<E> getRoot() {
	return root;
	}
	
	/** Returns a path from the root leading to the specified element */
	public ArrayList<TreeNode<E>> path(E e) {
	ArrayList<TreeNode<E>> list = new ArrayList<>();
	TreeNode<E> current = root; // Start from the root
	while (current != null) {
	list.add(current); // Add the node to the list
		if (e.compareTo(current.element) < 0) {
			current = current.left;
		}
		else if (e.compareTo(current.element) > 0) {
			current = current.right;
		}
		else
			break;
	 	}
	
	 	return list; // Return an array list of nodes
	 }
	
	@Override /** Delete an element from the binary search tree.
	* Return true if the element is deleted successfully.
	* Return false if the element is not in the tree. */
	public boolean delete(E e) {
		// Locate the node to be deleted and also locate its parent node
		TreeNode<E> parent = null;
		TreeNode<E> current = root;
		while (current != null) {
			if (e.compareTo(current.element) < 0) {
				parent = current;
				current = current.left;
			}
			else if (e.compareTo(current.element) > 0) {
				parent = current;
				current = current.right;
			}
			else
				break; // Element is in the tree pointed at by current
		}
		if (current == null){
			return false; // Element is not in the tree
		}
		parent = current.parent;
		
		if(current.left == current.right){
			if(e.compareTo(parent.element) < 0){
				parent.left = null;
			}
			else
				parent.right = null;
		}
			// Case 1: current has no left child
		if (current.left == null) {
			// Connect the parent with the right child of the current node
			if (parent == null) {
				root = current.right;
				if(root != null){
					root.parent = null;
				}
			}
			else {
				if (e.compareTo(parent.element) < 0) {
					parent.left = current.right;
					if(parent.left != null){ // If current parents left node is not empty
					parent.left.parent = parent; // Set parents left parent to current parent
					}
				}
				else {
					parent.right = current.right;
					if(parent.right != null){ 	// If current parents right node is not empty
					parent.right.parent = parent;	// Set parents right parent to current parent
					}
				}
			}
		}
		else {
			// Case 2: The current node has a left child.
			// Locate the rightmost node in the left subtree of
			// the current node and also its parent.
			TreeNode<E> parentOfRightMost = current;
			TreeNode<E> rightMost = current.left;
			while (rightMost.right != null) {
				parentOfRightMost = rightMost;
				rightMost = rightMost.right; // Keep going to the right
			}
			// Replace the element in current by the element in rightMost
			current.element = rightMost.element;
			// Eliminate rightmost node
			if (parentOfRightMost.right == rightMost){
				parentOfRightMost.right = rightMost.left;
			}	
			else {
				// Special case: parentOfRightMost == current
				parentOfRightMost.left = rightMost.left;
				
			}
		}
	 
		size--;
		return true; // Element deleted successfully
	  } 
	
	 @Override /** I have changed this to call for preorderIterator instead */
	 public java.util.Iterator<E> iterator() {
		 return new preorderIterator();
	 }
	 
	 // Inner class InorderIterator
	 private class InorderIterator implements java.util.Iterator<E> {
		 // Store the elements in a list
		 private java.util.ArrayList<E> list = new java.util.ArrayList<>();
		 private int current = 0; // Point to the current element in list
		 
		 public InorderIterator() {
			 inorder(); // Traverse binary tree and store elements in list
		 }	  
		 
		 /** Inorder traversal from the root*/
		 private void inorder() {
			 inorder(root);
		 }	   
		 
		 /** Inorder traversal from a subtree */
		 private void inorder(TreeNode<E> root) {
			 if (root == null) return;
			 inorder(root.left);
			 list.add(root.element);
			 inorder(root.right);
		 }	 
		 
		 @Override /** More elements for traversing? */
		 public boolean hasNext() {
			 if (current < list.size())
				 return true;
			 return false;
		 }  
		 
		 @Override /** Get the current element and move to the next */
		 public E next() {
			 return list.get(current++);
		 }  
		 
		 @Override /** Remove the current element */
		 public void remove() {
			 delete(list.get(current)); // Delete the current element
			 list.clear(); // Clear the list
			 inorder(); // Rebuild the list
		 }
		 
	 }	
	 
	 /* This is literally a copy of inorder iterator with just method names changed to
	  * preorder(), methodcalls to preorder() and the method: private void preorder(TreeNode<E> root) 
	  * changed according to the textbook
	  */
	 
	 // Inner class PreOrderIterator - Our iterator
	 private class preorderIterator implements java.util.Iterator<E> {
		 
		 // Store the elements in a list
		 private java.util.ArrayList<E> list = new java.util.ArrayList<>();
		 private int current = 0; // Point to the current element in list
		 public preorderIterator() {
			preorder(); // Traverse binary tree and store elements in list
		 }
		 
		/** PreOrder traversal from the root*/
		private void preorder() {
			preorder(root);
		}
		
		/** PreOrder traversal from a subtree */
		private void preorder(TreeNode<E> root) {
			if (root == null) return;
				list.add(root.element); // This is changed according to the textbook example on page 935( + 1 2 )
				preorder(root.left);
				preorder(root.right);	
		}
		
		@Override /** More elements for traversing? */
		public boolean hasNext() {
			if (current < list.size())
				return true;
			return false;
		}
		
		@Override /** Get the current element and move to the next */
		public E next() {
			return list.get(current++);
		}
		
		@Override /** Remove the current element */
		public void remove() {
			delete(list.get(current)); // Delete the current element
			list.clear(); // Clear the list
			preorder(); // Rebuild the list
		}
		
	}
	 
	/** Remove all elements from the tree */
	public void clear() {
		root = null;
		size = 0;
	}
}
