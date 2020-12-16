/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Board;

/**
 * @author Cheong Yin Lam
 * @param <T>
 */
public class LinkedList<T> implements ListInterface<T> {

    private Node node; // based on col
    private int length; // represent row
 
    public LinkedList() {
        clear();
    }
    
    @Override
    public boolean add(T newEntry) {
        Node newNode = new Node(newEntry);	

       if (isEmpty()) {
         node = newNode;
       } else { 
           Node tempNode = node;
           for(int i = 0 ; i < length; i++ ){
              if(tempNode.next != null){ 
                  tempNode = tempNode.next;
              }
           }
           tempNode.next = newNode;
           
       }
       length++;
       return true;
    }

    @Override
    public boolean add(int newPosition, T newEntry) {
        
        if ((newPosition >= 0) && (newPosition < length)) {
          Node newNode = new Node(newEntry);

          if (isEmpty() || (newPosition == 1)) { 
            newNode.next = node;
            node = newNode;
          } else {								
            Node tempNode = node;
            for (int i = 1; i < newPosition - 1; i++) {
              tempNode = tempNode.next;		
            }

            newNode.next = tempNode.next;	
            tempNode.next = newNode;		
          }

          length++;
          
        } else {
          return false;
        }

        return true;
    }

    
    @Override
    public T remove(int givenPosition) {
        T removeValue;                

        if ((givenPosition >= 0) && (givenPosition < length)) {
          
          if (givenPosition == 1) {      
            removeValue = (T) node.data;     
            node = node.next;
          } else {   
              
            Node tempNode = node;
            for (int i = 1; i < givenPosition - 1; i++) {
              tempNode = tempNode.next;		
            }
            
            removeValue = (T) tempNode.next.data;  
            tempNode.next = tempNode.next.next;
          } 	
          length--;
          
        }else{
            return null;
        }

        return removeValue; 
    }


    @Override
    public final void clear() {   
        node = null;
        length = 0;
    }

    
    @Override
    public boolean replace(int givenPosition, T newEntry) {
       
        if ((givenPosition >= 0) && (givenPosition < length)) {
          Node currentNode = node;
          for (int i = 0; i < givenPosition ; i++) {
            currentNode = currentNode.next;		
          }
          currentNode.data = newEntry;	
        } else {
          return false;
        }

        return true;
    }

    
    @Override
    public T getEntry(int givenPosition) {
       
        if ((givenPosition >= 0) && (givenPosition < length)) {
          Node currentNode = node;
          for (int i = 0; i < givenPosition; i++) {
            currentNode = currentNode.next;		
          }
          return (T) currentNode.data;	
        }

        return null; 
    }

    
    @Override
    public boolean contains(T anEntry) {
       
        Node tempNode = node;

        while (tempNode != null) {
            if (equals(anEntry, (T)tempNode.data)){
                return true;
            }else{
                tempNode = tempNode.next;
            }
        }
           
            return false;
   }
    
    @Override
    public boolean equals(T anEntry, T nodeData) {
        return anEntry.equals(nodeData);
    }

    
    @Override
    public int getLength() {
        return length;
    }

    
    @Override
    public boolean isEmpty() { 
        return length == 0;
    }
    
    @Override
    public boolean isFull() {  
      return false;
    }
    
    
    //---------- Node ----------//
     public class Node<T> {

        private T data; 
        private Node next; 

        private Node(T data) {
          this.data = data;
          next = null;
        }
        
        private Node(T data, Node next) {
          this.data = data;
          this.next = next;
        }
        
    }
}
