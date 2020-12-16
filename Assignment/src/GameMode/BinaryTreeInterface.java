package GameMode;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tan Yong Kang (RSF2G5)
 */
public interface BinaryTreeInterface<T> {
    public void addRoot(T newEntry);                                            //add root for the tree
    public void addChild(T newEntry1,T newEntry2);                              //add child at current node
    public void searchNode(int position);                                       //move root to given position
    public void printNode(int position);                                        //searchnode and display the value of the node at this position
    public boolean contains(T entry);                                           //search the tree is it contain of the given data
    public boolean replace(T entry,int position);                               //change the data in the node at given position
    public boolean isRoot(BinaryTree.Node node);                                // return the given node is the top root or not
    public void clear();                                                        //clear the current tree
    public boolean isEmpty();                                                   //return the tree is empty or not
    public int size();                                                          //return the total node in the tree
    public BinaryTree.Node root();                                              // return the top root of the tree
    public int layer(BinaryTree.Node node);                                     //display which is the layer of node given
    public int depth();                                                         //display the total layer in the tree
    public void displayPost();                                                  //binary search tree in postorder form
    public void displayPre();                                                   //binary search tree in preorder form
    public void displayIn();                                                    //binary search tree in inorder form
}
