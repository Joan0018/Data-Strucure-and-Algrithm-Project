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

import java.util.Scanner;

public class CircularLinkedList<T> implements CircularLinkedListInterface<T> {
    
    private Node nEw;
    private Node head;
    private Node tail;
    private Node temp;
    private Node last;
    
    private int size = 0;
    
    public CircularLinkedList(){
        clear();
    }
    
    @Override
    public final void clear(){
        head = null;
        size = 0;
    }
    
    @Override 
    public boolean add(T newEntry){
      
        nEw = new Node(newEntry);

      if(isEmpty()){
          
          head = nEw;
          tail = nEw;
      }
      else{
          tail.next = nEw;
          nEw.next = head;
          tail = nEw;
      }
       
      size++;
    return true;
       
    }
    
    @Override 
    public boolean addFirst(T newEntry){
        
        nEw = new Node(newEntry);

        if(size == 0){
            head = nEw;
            tail = nEw;
        }
        else{
            nEw.data = newEntry;
            nEw.next = head;
            tail.next = nEw;
            head = nEw;
        }
    
        size++;
        return true;
    }
    
    @Override 
    public boolean addLast(T newEntry){
      	     
      nEw = new Node(newEntry);
    
      if(isEmpty()){
          
          head = nEw;
          tail = nEw;
      }
      else{
        
         tail.next = nEw;
         nEw.next = head;
         tail = nEw;
        
      }
       
      size++;
    return true;
    }
    
    @Override 
    public boolean add(int newPosition, T newEntry) { 
      
    if ((newPosition >= 0) && (newPosition <= size + 1)) {
        
        nEw = new Node(newEntry);

       if(isEmpty()){
          
          head = nEw;
          tail = nEw;
          
       } 
       else {
           
            temp = head;
            for (int i = 0; i < newPosition - 1; i++) {
                temp = temp.next;		
            }

            nEw.next = temp.next;
            temp.next = nEw;		
        }

        size++;
        } else {
        return false;
        }

        return true;
    }

    @Override 
    public boolean removeFirst(){
        
        if(isEmpty()){
            return false;
        }
        temp = head;
        
        head = head.next;
        
        tail.next = head;
        
        temp.next = null;
        
        size--;
        
        return true;
    }
    
    @Override 
    public boolean remove(int givenPosition){
      
        temp = head;
        
        if(givenPosition >= 0 && givenPosition <= size + 1) {
           
            for(int i = 0; i < givenPosition - 1; i ++){
                temp = temp.next;
            }
            
            temp.next = temp.next.next;
        }
            size--;
            return true;
        }
    
    @Override 
    public T getEntry(int givenPosition){   
        
        if (givenPosition >= 1 && givenPosition <= size) {
			
		Node temp = head;
		for (int i = 0; i < givenPosition - 1; ++i) {
			temp = temp.next;
		}
		return temp.data;
        }else{
            return null;
        }
        
    }

    @Override 
    public T getEntryByValue(T entry){
        
        temp = head;
        
        while (null != temp && temp.data != entry) {
			temp = temp.next;
		}
		if (temp.data == entry) {
			return temp.data;
		}
		return null;
    }
    
    @Override 
    public boolean contains(T anEntry){
        Node currentNode = head;
        
        if(head == null){
            return false;
        }
        else{
            do{
                if(currentNode == anEntry){
                    return true;
                }
                currentNode = currentNode.next;
            }while(currentNode != head);
            
            return true;
        }
    }
    
    

    @Override
    public boolean replace(int givenPosition, T newEntry) {
           
      if ((givenPosition >= 1) && (givenPosition <= size)) {
        
            temp = head;
            
            for (int i = 0; i < givenPosition - 1; ++i) {
                temp = temp.next;		
            }

            temp.data = newEntry;
    
        }

      return true;

    }
    
    @Override
    public String toString() {
        
        Node current = head;  
        String display = "";
        
        if(head == null) {  
            return "List is empty";  
        }  
        while(current != null) {   
            display += current.data + "\n";  
            current = current.next;  
        }
        return display;
    }
    
    @Override
    public int getLength() {
        return size;
    }
    @Override
    public boolean isEmpty(){
        
        boolean result;
        
        result = size == 0;
        
        return result;
    }
    
    @Override
    public boolean isFull(){
        return false;
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

