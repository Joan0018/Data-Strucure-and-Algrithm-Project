/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package token;

/**
 *
 * @author Yeu
 */
public interface CircularLinkedListInterface<T> {
    
  public boolean add(T newEntry); 

  public boolean add(int newPosition, T newEntry);
  
   public boolean addFirst(T newEntry);
    
  public boolean addLast(T newEntry);
    
  public boolean remove(int givenPosition);

  public boolean removeFirst();

  public void clear();

  public boolean replace(int givenPosition, T newEntry);
    
  public T getEntry(int givenPosition);

  public T getEntryByValue(T entry);
  
  public boolean contains(T anEntry);

  public int getLength();

  public boolean isEmpty();
  
  public boolean isFull();
  
}

