/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

/**
 *
 * @author Joan Hau
 */
public class ArrayList<T> implements ListInterface<T> {
    
    private T[] arr;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private static int DEFAULT_ERROR_CODE = -1;
    private static int FACTOR  = 2;
    
    //Creates Empty ArrayList with Default Capacity = 10
    public ArrayList(){
      this(DEFAULT_CAPACITY);
    }
    
    //Creates Empty ArrayList with Specified initial Capacity
    public ArrayList(int capacity){
        size = 0;
        arr = (T[]) new Object[capacity];
    }
    
    @Override
    public boolean add(T newEntry){
        
      if(this.size == arr.length){
          reallocate();
      }
      
      arr[size] = newEntry;
      size++;
      
      return true;
    }
    
    //case 1 :index greater than size : return false
    //case 2: index equal to size of list(new element at end of list) follow add method;
    //case 3: index between start and end: shift the elements forward from index to end , insert element at index and update the size
    
    @Override
    public boolean add(int newPosition, T newEntry){
        
        if(newPosition >= 0 || newPosition < arr.length){
            
            if(newPosition < this.size){
                
                if(this.size == arr.length){
                    reallocate();
                }
                
                addGap(newPosition);
                
                arr[newPosition] = newEntry;
                size++;
                
            }
            
        }
        else if(newPosition == arr.length){
            add(newEntry);
        }
        else{
            return false;
        }
        return true;
    }
    
    @Override
    public T getEntry(int givenPosition){
        
     if(!isEmpty()){
          if(givenPosition < 0 || givenPosition >= size){
           throw new IndexOutOfBoundsException();
       }
       else{
           return arr[givenPosition];
       }
     }
     
     throw new IndexOutOfBoundsException();
   }
  
    @Override
    public T remove(int givenPosition){
       
        if(!isEmpty()){
             if(givenPosition < 0 || givenPosition >= size){
                    throw new IndexOutOfBoundsException();
             }
      
         T returnEntry = arr[givenPosition];
       
         removeGap(givenPosition);
       
         
         size--;
         return returnEntry;
        }
        else{
            throw new IndexOutOfBoundsException();
        }
      
      
       
   }
   
    @Override
    public int getLength(){
       return this.size;
    }
   
    @Override
    public boolean replace(int givenPosition, T newEntry){
       
        if(!isEmpty()){
            if(givenPosition < 0 || givenPosition >= size){
                return false;
            }
            else{
                arr[givenPosition] = newEntry;
                return true;
            }
        }
        return false;
       
   }
    
    @Override
    public int indexOf (T anEntry){
       
        for(int i = 0; i < this.size; i++){
            
            if(arr[i].equals(anEntry)){
                return i;
            }
        }
        
        return DEFAULT_ERROR_CODE;
    }
   
    @Override
    public String subList(int start, int end){
        
        if(isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        
        if(start < 0 || start >= size || end < 0 || end >= size || end < start){
            throw new IndexOutOfBoundsException();
        }
        String str = "";
        
        for(int i = start; i <= end; i++){
            
          str += arr[i] + "\n";
        }
        
        return str;
    }
    
    @Override
    public boolean contains(T anEntry){
  
        if(anEntry != null){
           
           for(int i = 0; i < size; i++){
               if(arr[i] == anEntry){
                   return true;
               }
           }
       }
       return false;
   }
   
    @Override
    public boolean isEmpty() {
       return this.size == 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }
    
    @Override
    public void clear(){
        this.size = 0;
    }
    
    @Override
    public String toString(){
        String str = "";
        
        for(int index = 0; index < size; ++index){
            str += arr[index] + "\n";
        }
        
        return str;
    }
    
    @Override
    public boolean isArrayFull(){
        return size == arr.length;
    }
    
    private void reallocate(){
       
       int arrLength = arr.length;
       
       T[] tempArr = (T[]) new Object [FACTOR*arrLength];
       
       for(int i = 0; i < this.size; i++){
           tempArr[i] = arr[i];
       }
       
       arr = tempArr;
    }

    private void removeGap(int givenPosition){
       
       for(int i = givenPosition + 1; i < this.size; i++){
           arr[i - 1] = arr[i];
       }
   }
    
    private void addGap(int newPosition){
         for(int i = this.size; i >= newPosition; i--){
            arr[i + 1] = arr[i];
        }
    }
    
}
