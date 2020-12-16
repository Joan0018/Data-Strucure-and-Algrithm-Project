package sorting;

public class SortArray {

  public static <T extends Comparable<T>> void bubbleSort(T[] a, int n) {
    boolean sorted = false;
    for (int pass = 1; pass < n && !sorted; pass++) {
      sorted = true;
      for (int index = 0; index < n - pass; index++) {
        // swap adjacent elements if first is greater than second
        if (a[index].compareTo(a[index + 1]) > 0) {
          swap(a, index, index + 1); // swap adjacent elements 
          sorted = false;  // array not sorted because a swap was performed
        }
      }
    }
  }

  private static <T> void swap(T[] a, int i, int j) {
    T temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  } // end swap

  public static <T extends Comparable<T>> void quickSort(T[] a, int n) {
    quickSort(a, 0, n - 1);
  }

  // recursive private overloaded method quickSort() 
  private static <T extends Comparable<T>> void quickSort(T[] a, int first, int last) {
    System.out.printf("\n*** TRACE: quickSort(a, %d, %d):\n", first, last);
    if (first < last) {
      System.out.printf("\npartition(a, %d, %d):\n", first, last);
      int pivotIndex = partition(a, first, last);
      System.out.print("\n*** TRACE: array contents after partition:  ");
      printArray(a);
      quickSort(a, first, pivotIndex - 1);
      quickSort(a, pivotIndex + 1, last);
    }
  }

  // private method partition() - to partition the array based on the pivot value
  private static <T extends Comparable<T>> int partition(T[] a, int first, int last) {
    int pivotIndex = last;
    T pivot = a[last];
    int indexFromLeft = first;
    int indexFromRight = last - 1;
    boolean done = false;

    while (!done) {
      while (indexFromLeft < last && a[indexFromLeft].compareTo(pivot) < 0) {
        indexFromLeft++;
      }

      while (indexFromRight > first && a[indexFromRight].compareTo(pivot) > 0) {
        indexFromRight--;
      }

      if (indexFromLeft < indexFromRight) {
        swap(a, indexFromLeft, indexFromRight);
        indexFromLeft++;
        indexFromRight--;
      } else {
        done = true;
      }
    }
    swap(a, pivotIndex, indexFromLeft);
    pivotIndex = indexFromLeft;
    return pivotIndex;
  }

  public static <T> void printArray(T[] a) {
    for (int i = 0; i < a.length; ++i) {
      System.out.print(a[i] + "  ");
    }
    System.out.println("\n");
  }

  public static void main(String[] args) {
    // to test bubblesort
    String[] nameArray = {"Dan", "Ann", "Zoe", "Jet", "Ben"};

    System.out.print("Before bubblesort: ");
    printArray(nameArray);
    bubbleSort(nameArray, nameArray.length);
    System.out.print("After bubblesort : ");
    printArray(nameArray);
    
    Integer[] numArray = {90, 40, 10, 30, 20, 50};

    System.out.print("\nBefore bubblesort: ");
    printArray(numArray);
    bubbleSort(numArray, numArray.length);
    System.out.print("After bubblesort : ");
    printArray(numArray);

    // To test quicksort
    Integer[] numArray2 = {3, 5, 0, 4, 6, 1, 2, 4};
    System.out.print("\n\nBefore quicksort:");
    printArray(numArray2);
    quickSort(numArray2, numArray2.length);
    System.out.print("\nAfter quicksort : ");
    printArray(numArray2);

  }

}
