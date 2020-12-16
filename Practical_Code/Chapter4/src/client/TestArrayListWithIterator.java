package client;

import adt.ArrayListWithIterator;
import adt.ListWithIteratorInterface;
import entity.Runner;
import java.util.Iterator;



public class TestArrayListWithIterator {
  private ListWithIteratorInterface<Runner> runnerList;
  
  public <T> void displayList(ListWithIteratorInterface<T> aList) {
    Iterator<T> iterator = aList.getIterator();
    while (iterator.hasNext()) {
      System.out.print(iterator.next());
    }
  }

  public TestArrayListWithIterator() {
    runnerList = new ArrayListWithIterator<>();
    initializeList();
    displayList(runnerList);
  }
  
  private void initializeList() {
    // Hardcoded data for testing purposes only
    runnerList.add(new Runner("Eric Liddel"));
    runnerList.add(new Runner("Usain Bolt"));
    runnerList.add(new Runner("Jesse Owens"));
    runnerList.add(new Runner("Edwin Moses"));
    runnerList.add(new Runner("Carl Lewis"));
    runnerList.add(new Runner("Marina Chin"));
  }
  
  public static void main(String[] args) {
    new TestArrayListWithIterator();
  }
  
}
