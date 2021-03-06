package MylinkedList;

public class MyLinkedList<E> extends MyAbstractList<E> {
	  private Node<E> head, tail;

	  /** Create a default list */
	  public MyLinkedList() {
	  }

	  /** Create a list from an array of objects */
	  public MyLinkedList(E[] objects) {
	    super(objects);
	  }

	  /** Return the head element in the list */
	  public E getFirst() {
	    if (size == 0) {
	      return null;
	    }
	    else {
	      return head.element;
	    }
	  }

	  /** Return the last element in the list */
	  public E getLast() {
	    if (size == 0) {
	      return null;
	    }
	    else {
	      return tail.element;
	    }
	  }

	  /** Add an element to the beginning of the list */
	  public void addFirst(E e) {
	    Node<E> newNode = new Node<E>(e); // Create a new node
	    newNode.next = head; // link the new node with the head
	    head = newNode; // head points to the new node
	    size++; // Increase list size

	    if (tail == null) // the new node is the only node in list
	      tail = head;
	  }

	  /** Add an element to the end of the list */
	  public void addLast(E e) {
	    Node<E> newNode = new Node<E>(e); // Create a new for element e

	    if (tail == null) {
	      head = tail = newNode; // The new node is the only node in list
	    }
	    else {
	      tail.next = newNode; // Link the new with the last node
	      tail = tail.next; // tail now points to the last node
	    }

	    size++; // Increase size
	  }


	  @Override /** Add a new element at the specified index 
	   * in this list. The index of the head element is 0 */
	  public void add(int index, E e) {
	    if (index == 0) {
	      addFirst(e);
	    }
	    else if (index >= size) {
	      addLast(e);
	    }
	    else {
	      Node<E> current = head;
	      for (int i = 1; i < index; i++) {
	        current = current.next;
	      }
	      Node<E> temp = current.next;
	      current.next = new Node<E>(e);
	      (current.next).next = temp;
	      size++;
	    }
	  }

	  /** Remove the head node and
	   *  return the object that is contained in the removed node. */
	  public E removeFirst() {
	    if (size == 0) {
	      return null;
	    }
	    else {
	      Node<E> temp = head;
	      head = head.next;
	      size--;
	      if (head == null) {
	        tail = null;
	      }
	      return temp.element;
	    }
	  }

	  /** Remove the last node and
	   * return the object that is contained in the removed node. */
	  public E removeLast() {
	    if (size == 0) {
	      return null;
	    }
	    else if (size == 1) {
	      Node<E> temp = head;
	      head = tail = null;
	      size = 0;
	      return temp.element;
	    }
	    else {
	      Node<E> current = head;

	      for (int i = 0; i < size - 2; i++) {
	        current = current.next;
	      }

	      Node<E> temp = tail;
	      tail = current;
	      tail.next = null;
	      size--;
	      return temp.element;
	    }
	  }

	  @Override /** Remove the element at the specified position in this 
	   *  list. Return the element that was removed from the list. */
	  public E remove(int index) {   
	    if (index < 0 || index >= size) {
	      return null;
	    }
	    else if (index == 0) {
	      return removeFirst();
	    }
	    else if (index == size - 1) {
	      return removeLast();
	    }
	    else {
	      Node<E> previous = head;

	      for (int i = 1; i < index; i++) {
	        previous = previous.next;
	      }

	      Node<E> current = previous.next;
	      previous.next = current.next;
	      size--;
	      return current.element;
	    }
	  }

	  @Override /** Override toString() to return elements in the list */
	  public String toString() {
	    StringBuilder result = new StringBuilder("[");

	    Node<E> current = head;
	    for (int i = 0; i < size; i++) {
	      result.append(current.element);
	      current = current.next;
	      if (current != null) {
	        result.append(", "); // Separate two elements with a comma
	      }
	      else {
	        result.append("]"); // Insert the closing ] in the string
	      }
	    }

	    return result.toString();
	  }

	  @Override /** Clear the list */
	  public void clear() {
	    size = 0;
	    head = tail = null;
	  }
	  // OBLIG OPPGAVE
	  @Override /** Return true if this list contains the element e */
	  public boolean contains(E e) {
		return indexOf(e) != -1; // We already look for equals. We just check if we have any, if not return false.
	  }
	  // OBLIG OPPGAVE
	  @Override /** Return the element at the specified index */
	  public E get(int index) {
	    Node<E> target = head;
	    if(index > size) throw new NullPointerException("The list size is not that big"); // If index is bigger than the actual size
	    for (int i = 0; i < index; i++) { // Search the list to the index before, and set target to the next object
	    	target = target.next;
	    }
	    if(target.element != null) return target.element; // Return the object found
	    else return null; //else return null, but this should never happen..
	  }
	  // OBLIG OPPGAVE
	  @Override /** Return the index of the head matching element in 
	   *  this list. Return -1 if no match. */
	  public int indexOf(E e) {
	    int index = 0;
	    Node target = head;	// Start with the target set to head
	    while(target != null){	// While we have something in target
	    	if(e.equals(target.element)){	// Check if it equals e
	    		return index;				// If it does, return the index
	    	}
	    	index++;						// If this was not it, add one to index
	    	target = target.next;			// Set target to the nest element and repeat
	    }
	    return -1;							// No luck? We return -1
	  }
	  
	  // OBLIG OPPGAVE
	  @Override /** Return the index of the last matching element in 
	   *  this list. Return -1 if no match. */
	  public int lastIndexOf(E e) {
	    if(indexOf(e) == -1) return -1;	// Do a quick check to see if the element is in the list at all, if not return -1
	    Node<E> target = head;			// Set target to head
	    int index = 0;					// index
	    int i= 0;						// i
	    while(i < size){				// While i is smaller than the size of the list
	    	if(e.equals(target.element)){ // Check if e equals the content of the target
	    		index = i;				// If it does, set the index to the value of i
	    	}
	    	i++;						// Increase i	
	    	target = target.next;		// set target to next object, rinse and repeat
	    }
	    return index;					// Return the final value of index
	  }
	  // OBLIG OPPGAVE
	  @Override /** Replace the element at the specified position 
	   *  in this list with the specified element. */
	  public E set(int index, E e) {
		Node<E> newNode = new Node<E>(e);		// Set target to head
		Node<E> temp;							// Make Node temp
		Node<E> returnElement;					// Make Node to hold return element
		if(index - 1 <= 0){						// If index is 0 we handle the head
			Node<E> target = head;				// Target head
			temp = target.next;					// Set temp to next object
			Node<E> newHead = newNode;        // Set a new Node to hold the new object first
		    newHead.next = temp; 				// Set target next in to newhead
		    head = newHead;						// Set head to new head
		    returnElement = head;				// Set the return element to hold head
		}
		else if(index == size - 1){				// If the index is size - 1 we handle the tail
			Node<E> target = head;				// Set target to head
			for(int i = 1; i < index; i++){		// Search through until we hit the next to last object
				target = target.next;			// Set target to the next object on the list
			}
			temp = target.next;					// Set the last target to temp
			target.next = newNode;				// Set the next node to be the new node
			tail = newNode;						// Set tail to hold the new last element
			returnElement = tail;				// Set returnelement to hold the new tail
		}
		else{
			Node<E> target = head;				// Target head
			for(int i = 1; i < index - 1; i++){ // If we want to handle anything but the first and last element
		    	target = target.next;			// Set target to next object until we reach the object we are looking for
		    }
		    temp = target.next;					// Set temp to hold the next object
		    target.next = new Node<E>(e);		// Set targets next object to hold the new object
		    (target.next).next = temp;			// Set our target next next's object to hold temp
		    returnElement = target.next;		// Set return element to hold target next's object
		}
		return returnElement.element;			// Return the element we put in. ( Don't know what we are supposed to return here..)
	  }											// But we are storing all the old values, so we can change this in a heartbeat.

	  @Override /** Override iterator() defined in Iterable */
	  public java.util.Iterator<E> iterator() {
	    return new LinkedListIterator();
	  }

	  private void checkIndex(int index) {
	    if (index < 0 || index >= size)
	      throw new IndexOutOfBoundsException
	        ("Index: " + index + ", Size: " + size);
	  }
	  
	  private class LinkedListIterator 
	      implements java.util.Iterator<E> {
	    private Node<E> current = head; // Current index 
	    
	    @Override
	    public boolean hasNext() {
	      return (current != null);
	    }

	    @Override
	    public E next() {
	      E e = current.element;
	      current = current.next;
	      return e;
	    }

	    @Override
	    public void remove() {
	      System.out.println("Implementation left as an exercise");
	    }
	  }
	  
	  private static class Node<E> {
	    E element;
	    Node<E> next;

	    public Node(E element) {
	      this.element = element;
	    }
	  }
	}

