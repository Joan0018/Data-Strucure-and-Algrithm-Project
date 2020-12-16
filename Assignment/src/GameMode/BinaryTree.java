/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameMode;
/**
 *
 * @author Tan Yong Kang (RSF2G5)
 */

public class BinaryTree <T> implements BinaryTreeInterface<T>{
        private Node currentRoot;//means the current node
        private Node left;
        private Node right;
        private Node topRoot;//the top root of the tree
        private Node parent;
        private Node error=new Node("Node not exist ");
       static int nextPosition;
        public BinaryTree(){
        clear();
        nextPosition =1;
        currentRoot=null;
        topRoot=currentRoot;
        }
    
            class Node<T>{
            private T data;
            private int position;
            private Node parent;
            private Node left;
            private Node right;


        // Constructs a new node to store the given data value.     

                private Node(T data) {
                    this.data = data;
                    this.position=nextPosition;
                    this.left = null;
                    this.right = null;
                    nextPosition++;
                }

                private Node(T data,Node parent,Node left,Node right){
                    this.data = data;
                    this.parent=parent;
                    this.left = left;
                    this.right = right;
                    this.position=nextPosition;
                    nextPosition++;
                }



                public T getData() {
                    if(data==null)
                        return (T)"-";
                    return data;
                }

                public void setData(T data) {
                    this.data = data;
                }

                public Node getParent() {
                    return parent;
                }

                public void setParent(Node parent) {
                    this.parent = parent;
                }

                public Node getLeft() {
                    return left;
                }

                public void setLeft(Node left) {
                    this.left = left;
                }

                public Node getRight() {
                    return right;
                }

                public void setRight(Node right) {
                    this.right = right;
                }

                public int getPosition() {
                    return position;
                }
            }

    public Node getError() {
        return error;
    }

    public Node getTopRoot() {
        return topRoot;
    }

    public void setTopRoot(Node topRoot) {
        this.topRoot = topRoot;
    }

    public Node getRoot() {
        if(currentRoot==null)
            return error;
        else return currentRoot;
    }

    public void setRoot(Node root) {
        this.currentRoot = root;
    }
   
      public void addRoot(T newEntry){
       if(currentRoot==null){
       currentRoot=new Node(newEntry);
       topRoot=currentRoot;
       parent=currentRoot;
       } else System.out.print("Node already exist\n");
   } 
    
    public void addChild(T newEntry1,T newEntry2){
        if(currentRoot!=null){
        
            if(currentRoot.getLeft()==null){
                left=new Node(newEntry1,currentRoot,null,null);
                currentRoot.setLeft(left);
                
            }
            else{ System.out.print("Node already exist");
            System.out.print(currentRoot.getLeft().getData());
            }
       
            if(currentRoot.getRight()==null){
                right=new Node(newEntry2,currentRoot,null,null);
                currentRoot.setRight(right);
                
            }else System.out.print("Node already exist");
        
        }else System.out.print("Please add root first");
   } 
    
    public void searchNodeRecursive(Node node,int positon){
        if(node==null){
            return;}
        
        if(positon==node.getPosition()){
            currentRoot=node;
           }
        searchNodeRecursive(node.getLeft(),positon);
        searchNodeRecursive(node.getRight(),positon);     
    }
    
    public void searchNode(int position){
        searchNodeRecursive(topRoot,position);
    }
    
    public void printNode(int positon){
        searchNodeRecursive(topRoot,positon);
        System.out.print(currentRoot.getData()+"\n"); 
    }
    
    public boolean contains(T entry){
        for(int i=0;i<nextPosition;i++){
            searchNode(i);
            if(entry==currentRoot.getData())
                return true;
        }
        return false;
    }
    
    public boolean replace(T entry,int position){
        boolean replace=false;
            
        searchNode(position);
        if(currentRoot!=null){
        currentRoot.setData(entry);
        replace=true;
        }
        
        return replace;
    }
    
    public boolean isRoot(Node node) {
        return node == getTopRoot();
    }
        
    public void clear(){
        topRoot=null;
    }
        
    public boolean isEmpty() {
        return nextPosition == 1;
    }
    
    public int size(){
        return nextPosition-1;
    }
         
    public Node root(){
        return topRoot;
    }
         
    public int layer(Node node){
             
        if (node == topRoot) 
        return 1; 
             
        return 1+layer(node.parent);
    }
    
    public int depth(){
        return depthRecursive(topRoot);
    }
        
    public int depthRecursive(Node node){
             
        if (node == null) 
        return 0; 
             
        return 1+depthRecursive(node.left);
    }
 
    public void displayPost(){
        postRecursive(topRoot);
    }
    
    public void postRecursive(Node node){
        if(node==null){
        return;
        }
           
        postRecursive(node.getLeft());
        postRecursive(node.getRight());  
        System.out.print(node.getData()+"\n");           
    }
        
    public void displayPre(){
        preRecursive(topRoot);
    }
        
    public void preRecursive(Node node){
        if(node==null){
            return;
        }
           
        System.out.print(node.getData()+"\n");  
        preRecursive(node.getLeft());
        preRecursive(node.getRight());        
    }
    
    public void displayIn(){
        inRecursive(topRoot);
    }
    
    public void inRecursive(Node node){
        if(node==null){
            return;
        }
            
        inRecursive(node.getLeft());
        System.out.print(node.getData()+"\n"); 
        inRecursive(node.getRight());        
    }
        
    //travel the current node to left side of n layer
    public Node travelLeft(int n){
            topRoot();
            for(int i=0;i<n;i++){
                nextLeft();
            }
            return currentRoot;
        }
         
    //travel the current node to right side of n layer
    public Node travelRight(int n){
            topRoot();
            for(int i=0;i<n;i++){
                nextRight();
            }
            return currentRoot;
        }
        
         //travel the current node to left side of next layer
    public Node nextLeft(){
        parent=currentRoot;
        if(getRoot().getLeft()!=null){
        currentRoot=getRoot().getLeft();
        return currentRoot;
        }
        
        return error;
    }
    
    //travel the current node to right side of next layer
    public Node nextRight(){
        parent=currentRoot;
        if(getRoot().getRight()!=null){
        currentRoot=getRoot().getRight();
        return currentRoot;
        }
        
        return error;
    }
    
    //travel the current node to right side which has same parent
    public Node beside(){
        Node current=currentRoot;
        previous();

        if(current.equals(nextRight())){
            previous();
            nextLeft();
        }
        return currentRoot;
    }
    

    //travel the current node to parent node
    public Node previous(){
        currentRoot=parent;
        return currentRoot;
    }
        
    //travel to the top node
    public Node topRoot(){
        currentRoot=topRoot;
        return currentRoot;
    }

    public Node getLeft() {
        if(currentRoot.getLeft()==null)
            return error;
        else return currentRoot.getLeft();
    }


    public Node getRight() {
        if(currentRoot.getRight()==null)
            return error;
        else return currentRoot.getRight();
    }
   
}
