package GameMode;
import GameMode.BinaryTree;
import GameMode.GameMode;
import Player.ArrayList;
import Player.ListInterface;
import Player.Player;
import Player.PlayerConnectFour;
import java.util.Scanner;
import token.CircularLinkedList;
import token.Token;
import token.TokenCount;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tan Yong Kang (RSF2G5)
 */
public class Tournament{

    private static BinaryTree tree;
    static int size;
    
    public Tournament(){
        tree=new BinaryTree();
        size=7;
    }

        //use to create tree and node
        public  static void initialize(ListInterface<Player> player){
            int i=0;
            tree.addRoot(null);
            int length=player.getLength();

            int position=1;
            int check=0;
            if(player.getLength()==4)
                check=2;
            else if (player.getLength()==8)
                check=1;
            while(length>check){
                length=length/2;
                tree.searchNode(position);  
                tree.addChild(null, null);
                position++;
            }
            if(length<=2){
                while(i<=player.getLength()-2){
                    
                    tree.searchNode(position);
                    tree.addChild(player.getEntry(i),player.getEntry(i+1));
                    i+=2;
                    position++;
                }}
   }

        public void display(){

            int currentLayer=0;
            int times=1;
            String display;
            System.out.print(" \nTOURNAMENT TREE  \n");
            for(int i=1;i<=tree.size();i++){
                tree.searchNode(i);
                if(currentLayer!=tree.layer(tree.getRoot())){
                    currentLayer=tree.layer(tree.getRoot());
                    System.out.print("\n");
                    for(int j=0;j<times;j++){
                        if(tree.layer(tree.getRoot())==1)
                        System.out.print(String.format("%27s", "|"));
                        if(tree.layer(tree.getRoot())==2)
                        System.out.print(String.format("%18s", "|"));
                        if(tree.layer(tree.getRoot())==3)
                        System.out.print(String.format("%11s", "|"));
                        if(tree.layer(tree.getRoot())==4)
                        System.out.print(String.format("%6s", "|"));

                    }
                    times*=2;
                    System.out.print("\n");

                }

                if(tree.getRoot().getData().equals("-"))
                display="PENDING";
                else display=((Player)tree.getRoot().getData()).getName();
                
                if(tree.layer(tree.getRoot())==1)
                System.out.print(String.format("%30s", display));
                if(tree.layer(tree.getRoot())==2)
                System.out.print(String.format("%20s", display));
                if(tree.layer(tree.getRoot())==3)
                System.out.print(String.format("%12s", display));
                if(tree.layer(tree.getRoot())==4)
                System.out.print(String.format("%6s", display));
            }
            System.out.print("\n\n");
        }


        public  Player[] retrievePlayerForEachRound(int numPlayer){
            int current=size;
            if(numPlayer==4){
                current=size-4;
            }
        tree.searchNode(current);
        Player[] player = new Player[2];

            player[0] = ((Player)tree.getRoot().getLeft().getData());
            player[1] = ((Player)tree.getRoot().getRight().getData());
            size-=1;
   
        return player;
    }
        
        public  void stepUp(Player player,int numPlayer){
            int current=size;
            if(numPlayer==4){
                current=size-4;
            }
            tree.searchNode(current+1);
            if(player.getName()==((Player)tree.getRoot().getRight().getData()).getName())
                tree.replace(tree.getRoot().getRight().getData(),current+1);
            else tree.replace(tree.getRoot().getLeft().getData(),current+1); 
        }   
        
                
        public void champion(){
            tree.topRoot();
            System.out.print("Champion of the tournament : "+((Player)tree.getRoot().getData()).getName()+ "\nCongratulations !\n");
        }
}
