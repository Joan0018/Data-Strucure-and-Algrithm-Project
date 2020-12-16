/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ranking;

import Player.ArrayList;
import Player.Player;
import Board.BoardMain;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Lee Ling
 */
public class RankingConnectFour {
    BoardMain board = new BoardMain();
    Scanner scan = new Scanner(System.in);
    
    public void RankingConnectFour(){
        
    }
    
    //Display the ranking board based on the number of player
    public void displayRankingBoard(SortedLinkedList<Ranking> rankingList, int playerNum){
        System.out.print("\n\n");
        board.drawLine(20,25);
        System.out.println(String.format("%41s","Ranking Board"));
        
        if(playerNum > 4)
            System.out.println(String.format("%25s More than 5 Player )","("));
        else
            System.out.println(String.format("%30s %d Player )","(", playerNum));
            
        board.drawLine(20,25);
        
   
        board.drawLine2(52,9);
        System.out.println(String.format("%13s %16s %28s","Rank","Player Name","Score"));
        System.out.println(String.format("%14s %14s %30s","-----","----------","------"));
        
        int recordNum = 1;
        //only display for 10 or less than 10 records
        
        for(int i = rankingList.getLength() - 1; i >= 0 ; i-- ){
            if(recordNum <= 10){
                if(playerNum > 5){
                    if(rankingList.getEntry(i).getPlayerNum() > 5){
                        System.out.println(String.format("%12d %-8s %-31s %d",
                           (recordNum), 
                           " ",
                           rankingList.getEntry(i).getWinner(), 
                           (int)rankingList.getEntry(i).getHighestScore()
                        ));
                        recordNum++;
                    }  
                }else{
                    if(rankingList.getEntry(i).getPlayerNum() == playerNum){
                            System.out.println(String.format("%12d %-8s %-31s %d",
                               recordNum, 
                               " ",
                               rankingList.getEntry(i).getWinner(), 
                               (int)rankingList.getEntry(i).getHighestScore()
                            ));
                            recordNum++;
                    }
                }
            }else{
                break;
            }
        }
      
        System.out.print("\n");
        board.drawLine2(52,9);
        System.out.print("\n");

    }
    
    //Displat the ranking board menu
    public void displayRankingMenu(){
        board.drawLine(20,25);
        System.out.println(String.format("%41s","Ranking Board"));
        board.drawLine(20,25);
        
        System.out.println(String.format("\n%40s","Display for"));
        board.drawLine2(28,20);
        System.out.println(String.format("%23s %16s","(1)","2 Player Ranking Board"));
        System.out.println(String.format("%23s %16s","(2)","3 Player Ranking Board"));
        System.out.println(String.format("%23s %16s","(3)","4 Player Ranking Board"));
        System.out.println(String.format("%23s %16s","(4)","5 Player Ranking Board"));
        System.out.println(String.format("%23s %16s","(5)","More than 5 Player"));
        board.drawLine2(28,20);
  
    }
    
    //records for demo
    public SortedLinkedList<Ranking> prevGameRecord(){
        Player p1 = new Player("Lee",'a');
        Player p2 = new Player("Joan",'b');
        Player p3 = new Player("Yeu",'c');
        Player p4 = new Player("Cheong", 'd');
        Player p5 = new Player("Kang",'e');
        
        ArrayList<Player> playerList = new ArrayList<>();
        SortedLinkedList<Player> sortedPlayerList = new SortedLinkedList<>();
        SortedLinkedList<Ranking> rankingList = new SortedLinkedList<>();
        
        //for record 1
        playerList.add(p1);
        playerList.add(p2);
        playerList.add(p3);
        playerList.add(p4);
        playerList.add(p5);
        p1.setScore(200);
        p2.setScore(150);
        p3.setScore(160);
        p4.setScore(150);
        p5.setScore(100);
        
        for(int i = 0; i < playerList.getLength(); i++){
            Player temp = new Player();
            temp.clone(playerList.getEntry(i));
            sortedPlayerList.add(temp);
        }
        
        Ranking ranking = new Ranking(sortedPlayerList, 10.3);
        rankingList.add(ranking);
        sortedPlayerList.clear();
        playerList.clear();
        
         //for record 2
        playerList.add(p1);
        playerList.add(p2);
        playerList.add(p3);
        p1.setScore(110);
        p2.setScore(120);
        p3.setScore(50);
        
        for(int i = 0; i < playerList.getLength(); i++){
            Player temp = new Player();
            temp.clone(playerList.getEntry(i));
            sortedPlayerList.add(temp);
        }
        
        ranking = new Ranking(sortedPlayerList, 5.2);
        rankingList.add(ranking);
        sortedPlayerList.clear();
        playerList.clear();
        
        //for record 3
        playerList.add(p1);
        playerList.add(p2);
        playerList.add(p3);
        playerList.add(p4);
        p1.setScore(100);
        p2.setScore(110);
        p3.setScore(50);
        p4.setScore(330);
        
        for(int i = 0; i < playerList.getLength(); i++){
            Player temp = new Player();
            temp.clone(playerList.getEntry(i));
            sortedPlayerList.add(temp);
        }
        
        ranking = new Ranking(sortedPlayerList, 10.5);
        rankingList.add(ranking);
        sortedPlayerList.clear();
        playerList.clear();
        
        //for record 4
        playerList.add(p3);
        playerList.add(p5);
        p3.setScore(50);
        p4.setScore(0);
        
        for(int i = 0; i < playerList.getLength(); i++){
            Player temp = new Player();
            temp.clone(playerList.getEntry(i));
            sortedPlayerList.add(temp);
        }
        
        ranking = new Ranking(sortedPlayerList, 2.5);
        rankingList.add(ranking);
        sortedPlayerList.clear();
        playerList.clear();
        
        return rankingList;
    }
    
    //Ask user to select their option
    public void selectRankingBoard(SortedLinkedList<Ranking> rankingList) {
        
        RankingConnectFour r = new RankingConnectFour();

        int boardPlayerNum = 0;
        r.displayRankingMenu();
        
        do{
            try{
                System.out.print(String.format("%52s","Please select your option (1 - 5): "));
                boardPlayerNum = scan.nextInt();

                if(boardPlayerNum < 1 || boardPlayerNum > 5){
                    System.out.println(String.format("%45s","Invalid Input Detected!"));
                }
            }
            catch (InputMismatchException ex){
                System.out.println(String.format("%49s","Input Must be Positive Integer"));
                scan.next();
            }
        }while(boardPlayerNum < 1 || boardPlayerNum > 5);
        
        r.displayRankingBoard(rankingList, (boardPlayerNum+1));
    }
}
