package adt;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LListWithIterator<T> implements ListWithIteratorInterface<T> {

  private Node firstNode;
  private int length;

  public LListWithIterator() {
    clear();
  }

  @Override
  public final void clear() {
    firstNode = null;
    length = 0;
  }

  @Override
  public boolean add(T newEntry) {
    Node newNode = new Node(newEntry);

    if (isEmpty()) {
      firstNode = newNode;
    } else {                        // add to end of nonempty list
      Node currentNode = firstNode;					// traverse linked list with p pointing to the current node
      while (currentNode.next != null) {		// while have not reached the last node
        currentNode = currentNode.next;
      }
      currentNode.next = newNode; // make last node reference new node
    }

    length++;
    return true;
  }

  @Override
  public boolean add(int newPosition, T newEntry) {
    boolean isSuccessful = true;

    if ((newPosition >= 1) && (newPosition <= length + 1)) {
      Node newNode = new Node(newEntry);

      if (isEmpty() || (newPosition == 1)) { // case 1: add to beginning of list
        newNode.next = firstNode;
        firstNode = newNode;
      } else {							// case 2: list is not empty and newPosition > 1
        Node nodeBefore = firstNode;
        for (int i = 1; i < newPosition - 1; ++i) {
          nodeBefore = nodeBefore.next;		// advance nodeBefore to its next node
        }

        newNode.next = nodeBefore.next;	// make new node point to current node at newPosition
        nodeBefore.next = newNode;		// make the node before point to the new node
      }

      length++;
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
  }

  @Override
  public boolean replace(int givenPosition, T newEntry) {
    boolean isSuccessful = true;

    if ((givenPosition >= 1) && (givenPosition <= length)) {
      Node currentNode = firstNode;
      for (int i = 0; i < givenPosition - 1; ++i) {
        currentNode = currentNode.next;		// advance currentNode to next node
      }
      currentNode.data = newEntry;	// currentNode is pointing to the node at givenPosition
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
  }

  @Override
  public boolean contains(T anEntry) {
    boolean found = false;
    Node currentNode = firstNode;

    while (!found && (currentNode != null)) {
      if (anEntry.equals(currentNode.data)) {
        found = true;
      } else {
        currentNode = currentNode.next;
      }
    }

    return found;
  }

  @Override
  public T remove(int givenPosition) {
    T result = null;

    if ((givenPosition >= 1) && (givenPosition <= length)) {
      if (givenPosition == 1) {      // case 1: remove first entry
        result = firstNode.data;
        firstNode = firstNode.next;
      } else {                         // case 2: givenPosition > 1
        Node nodeBefore = firstNode;
        for (int i = 1; i < givenPosition - 1; ++i) {
          nodeBefore = nodeBefore.next;		// advance nodeBefore to its next node
        }
        result = nodeBefore.next.data;
        nodeBefore.next = nodeBefore.next.next;	// make node before point to node after the
      } 																// one to be deleted (to disconnect node from chain)

      length--;
    }

    return result;
  }

  @Override
  public T getEntry(int givenPosition) {
    T result = null;

    if ((givenPosition >= 1) && (givenPosition <= length)) {
      Node currentNode = firstNode;
      for (int i = 0; i < givenPosition - 1; ++i) {
        currentNode = currentNode.next;		// advance currentNode to next node
      }
      result = currentNode.data;	// currentNode is pointing to the node at givenPosition
    }

    return result;
  }

  @Override
  public int getLength() {
    return length;
  }

  @Override
  public boolean isEmpty() {
    boolean result;

    if (length == 0) {
      result = true;
    } else {
      result = false;
    }

    return result;
  }

  @Override
  public boolean isFull() {
    return false;
  }

  @Override
  public String toString() {
    String outputStr = "";
    Node currentNode = firstNode;
    while (currentNode != null) {
      outputStr += currentNode.data + "\n";
      currentNode = currentNode.next;
    }
    return outputStr;
  }

  @Override
  public Iterator<T> getIterator() {
    return new LinkedListIterator();
  }

  private class LinkedListIterator implements Iterator<T> {

    private Node currentNode;

    public LinkedListIterator() {
      currentNode = firstNode;
    }

    @Override
    public boolean hasNext() {
      return currentNode != null;
    }

    @Override
    public T next() {
      if (hasNext()) {
        T returnData = currentNode.data;
        currentNode = currentNode.next;
        return returnData;
      } else {
        throw new NoSuchElementException("Illegal call to next(); iterator is after end of list.");
      }
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException("Not supported yet.");
    }
  }

  private class Node {

    private T data;
    private Node next;

    private Node(T data) {
      this.data = data;
      this.next = null;
    }

    private Node(T data, Node next) {
      this.data = data;
      this.next = next;
    }
  }
}
