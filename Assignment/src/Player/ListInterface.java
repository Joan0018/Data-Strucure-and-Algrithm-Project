/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

/**
 *
 * @author User
 */
public interface ListInterface<T> {
    
  /**
  * Task: Adds a new entry to the end of the list. Entries currently in the
  * list are unaffected. The list's size is increased by 1.
  *
  * @param newEntry the object to be added as a new entry
  * @return true if the addition is successful, or false if the list is full
  */
  public boolean add(T newEntry);

  /**
   * Task: Adds a new entry at a specified position within the list. Entries
   * originally at and above the specified position are at the next higher
   * position within the list. The list's size is increased by 1.
   *
   * @param newPosition an integer that specifies the desired position of the
   * new entry
   * @param newEntry the object to be added as a new entry
   * @return true if the addition is successful, or false if either the list is
   * full, newPosition < 0, or
   *          newPosition > getLength()
   */
  public boolean add(int newPosition, T newEntry);

  /**
   * Task: Removes the entry at a given position from the list. Entries
   * originally at positions higher than the given position are at the next
   * lower position within the list, and the list's size is decreased by 1.
   *
   * @param givenPosition an integer that indicates the position of the entry to
   * be removed
   * @return a reference to the removed entry or null, if either the list was
   * empty, givenPosition < 0, or
   *          givenPosition > getLength()
   */
  public T remove(int givenPosition);

  /**
   * Task: Removes all entries from the list.
   */
  public void clear();

  /**
   * Task: Replaces the entry at a given position in the list.
   *
   * @param givenPosition an integer that indicates the position of the entry to
   * be replaced
   * @param newEntry the object that will replace the entry at the position
   * givenPosition
   * @return true if the replacement occurs, or false if either the list is
   * empty, givenPosition < 1, or givenPosition > getLength()
   */
  public boolean replace(int givenPosition, T newEntry);

  /**
   * Task: Retrieves the entry at a given position in the list.
   *
   * @param givenPosition an integer that indicates the position of the desired
   * entry
   * @return a reference to the indicated entry or null, if either the list is
   * empty, givenPosition < 1, or givenPosition > getLength()
   */
  public T getEntry(int givenPosition);

  /**
   * Task: Retrieves the entry between a given position in the list.
   *
   * @param start an integer that represent the first data want to retrieves
   * @param end an integer that represent the last data want to retrieves
   * @return a data of the list in given position
   */
  public String subList(int start, int end);
  
  /**
   * Task: Sees whether the list contains a given entry.
   *
   * @param anEntry the object that is the desired entry
   * @return true if the list contains anEntry, or false if not
   */
  public boolean contains(T anEntry);

  /**
   * Task: Gets the number of entries in the list.
   *
   * @return the integer number of entries currently in the list
   */
  public int getLength();

  /**
   * Task: Sees whether the list is empty.
   *
   * @return true if the list is empty, or false if not
   */
  public boolean isEmpty();

  /**
   * Task: Sees whether the list is full.
   *
   * @return true if the list is full, or false if not
   */
  public boolean isFull();
  
  /**
  * Task: To get the position of the current entry
  * @param anEntry the object that is the desired entry
  * @return the position of anEntry
  */
  public int indexOf(T anEntry);
  
  /**
  * Task: Sees whether the list meet the size assigned
  * @return true is the size = array length, else false
  */
  public boolean isArrayFull();
  
}

