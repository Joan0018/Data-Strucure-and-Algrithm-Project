/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ranking;;
import Player.*;
import Board.BoardMain;

/**
 *
 * @author Lee Ling
 */
public class Ranking implements Comparable<Ranking> {
    private double highestScore;
    private String winner;
    private SortedLinkedList<Player> sortedPlayerList;
    private int playerNum;
    private double totalTime;

    public Ranking(SortedLinkedList<Player> sortedPlayerList, double totalTime) {
        this.sortedPlayerList = sortedPlayerList;
        this.playerNum = sortedPlayerList.getLength();
        //Descending the list
        sortedPlayerList.desc();
        this.highestScore = sortedPlayerList.getEntry(0).getScore();
        this.winner = sortedPlayerList.getEntry(0).getName();
        this.totalTime = totalTime;
        
    }

    public SortedLinkedList<Player> getSortedPlayerList() {
        return sortedPlayerList;
    }

    public void setSortedPlayerList(SortedLinkedList<Player> sortedPlayerList) {
        this.sortedPlayerList = sortedPlayerList;
    }
    

    public double getHighestScore() {
        return highestScore;
    }

    public void setHighestScore(double highestScore) {
        this.highestScore = highestScore;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
   

    public int getPlayerNum() {
        return playerNum;
    }

    public void setPlayerNum(int playerNum) {
        this.playerNum = playerNum;
    }

    public double getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(double totalTime) {
        this.totalTime = totalTime;
    }
    
    //To override the compareTo method in order to sort the list based on the score
    @Override
    public int compareTo(Ranking ranking){
        return (int)(this.highestScore - ranking.highestScore);
    }
    
    //diplay the ranking board that inside the classic mode
    public void displayRanking(){
        BoardMain board = new BoardMain();
        //title
        board.drawLine(12,28);
        System.out.println(String.format("%37s","Ranking"));
        board.drawLine(12,28);
        
        board.drawLine(52,9);     
        System.out.println(String.format("%28s %d","Total player     : ", this.playerNum));
        System.out.println(String.format("%28s %.2f minutes","Total time spent : ", this.totalTime));
        board.drawLine2(52,9);
        System.out.println(String.format("%13s %14s %30s","Rank","Winner","Score"));
        System.out.println(String.format("%14s %14s %30s","-----","-------","------"));
        
        for(int i = 0; i < this.sortedPlayerList.getLength(); i++ ){
            System.out.println(String.format("%12d %-8s %-31s %d",
                    (i+1), 
                    " ",
                    this.sortedPlayerList.getEntry(i).getName(), 
                    (int)this.sortedPlayerList.getEntry(i).getScore()));
        }
        
        System.out.print("\n");
        board.drawLine2(52,9);
        
        System.out.println(String.format("%40s %d !","The highest score is ",(int)this.highestScore));
        System.out.println(String.format("%20s %s %s !"," ", "Congratulations ",this.winner));
        
        System.out.print("\n");
        board.drawLine(52,9);
    }
  
   //To clone all the details from one ranking to another ranking
   public void clone(Ranking ranking){
        this.winner = ranking.winner;
        this.sortedPlayerList = ranking.sortedPlayerList;
        this.playerNum = ranking.playerNum;
        this.totalTime = ranking.totalTime;
    }
    
}