/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Board;

/**
 * @author Cheong Yin Lam
 */
public interface ListInterface<T> {
    
  public boolean add(T newEntry); 

  public boolean add(int newPosition, T newEntry);

  public T remove(int givenPosition); 

  public void clear();

  public boolean replace(int givenPosition, T newEntry); 

  public T getEntry(int givenPosition); 

  public boolean contains(T anEntry);
  
  public boolean equals(T anEntry, T nodeData);

  public int getLength(); 

  public boolean isEmpty();

  public boolean isFull();
}
