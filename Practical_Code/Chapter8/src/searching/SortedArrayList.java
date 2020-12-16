package searching;

/**
 * SortedArrayList - A class that implements the ADT sorted array by using an
 expandable array and includes the binarySearch method which implements the
 recursive binary search algorithm
 */
public class SortedArrayList<T extends Comparable<? super T>> implements SortedListInterface<T> {

  private T[] array;			 	
  private int length;  			 
  private static final int DEFAULT_CAPACITY = 25; 	

  public SortedArrayList() {
    this(DEFAULT_CAPACITY);
  } 

  public SortedArrayList(int initialCapacity) {
    length = 0;
    array = (T[]) new Comparable[initialCapacity];
  } 

  // method contains invokes method binarySearch
  public boolean contains(T anEntry) {
    return binarySearch(0, length - 1, anEntry);
  } 

  // recursive binary search
  private boolean binarySearch(int first, int last, T desiredItem) {
    boolean found;
    int mid = (first + last) / 2;

    if (first > last) {
      found = false;
    } else if (desiredItem.equals(array[mid])) {
      found = true;
    } else if (desiredItem.compareTo(array[mid]) < 0) {
      found = binarySearch(first, mid - 1, desiredItem);
    } else {
      found = binarySearch(mid + 1, last, desiredItem);
    }

    return found;
  } // end binarySearch

  /*
   // ----------------------------------------------------------
   // recursive sequential search
   public boolean contains(T anEntry) {
   search(0, length - 1, anEntry);
   } // end contains
	
   private boolean search(int first, int last, T desiredItem) {
   boolean found;
	  
   if (first > last)
   found = false; // no elements to search
   else if (desiredItem.equals(array[first]))
   found = true;
   else
   found = search(first + 1, last, desiredItem);
  
   return found;
   } // end search
   */
  public boolean add(T newEntry) {
    if (isArrayFull()) {
      doubleArray();
    }

    int toIndex, fromIndex;

    for (fromIndex = length - 1, toIndex = fromIndex + 1; (fromIndex >= 0)
            && (newEntry.compareTo(array[fromIndex]) < 0);
            toIndex--, fromIndex--) {
      array[toIndex] = array[fromIndex];
    } 

    array[toIndex] = newEntry;
    length++;
    return true;
  }
  
  @Override
  public boolean remove(T anEntry) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  public void clear() {
    for (int index = 0; index < length; index++) {
      array[index] = null;
    }

    length = 0; 
  } 

  public int getLength() {
    return length;
  } 

  public boolean isEmpty() {
    return length == 0;
  }

  public boolean isFull() {
    return false;
  } 

  @Override
  public String toString() {
    String str = "";
    for (int i = 0; i < length; i++) {
      str += array[i] + "\n";
    }
    return str;
  }

  private boolean isArrayFull() {
    return length == array.length;
  }  //end isArrayFull

  private void doubleArray() {
    T[] oldList = array; 
    int oldSize = oldList.length;     

    array = (T[]) new Comparable[2 * oldSize];    
    for (int index = 0; index < oldSize; index++) {
      array[index] = oldList[index];
    }
  } 

  private void removeGap(int givenPosition) {
    int removedIndex = givenPosition - 1;
    int lastIndex = length - 1;

    for (int index = removedIndex; index < lastIndex; index++) {
      array[index] = array[index + 1];
    }
  }  

} 
