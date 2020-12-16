/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Board;

import Player.Player;
import java.util.Scanner;

/**
 *
 * @author Cheong Yin Lam
 */
public class BoardConnectFour {

    Scanner scan = new Scanner(System.in);
    
    Player currentPlayer[]; 
    Board board;  
    
   
    public void createNewBoard(Player currentplayer[], char tokenChar[], LinkedList<Character> boardCol[], Board boardTime){
       
         this.currentPlayer = currentplayer;
         
         board = boardTime;
         
         for(int j = 0; j < boardCol.length; j++){
             boardCol[j] = new LinkedList();
            for(int i = 0; i < board.getRows(); i++){
                boardCol[j].add('-');
            }
        }
        board.setBoardCol(boardCol);
    }
    
    public void displayBoard(){
                
        // display column number
        System.out.print("\n");
        for(int j = 0; j < board.getBoardCol().length; j++){
            System.out.print((j+1) +" ");
        } 

        //display board
        for(int i = 0; i < board.getRows(); i++){
            System.out.print("\n");
            for(int j = 0; j < board.getBoardCol().length; j++){
                System.out.print(board.getSpecificBoardCol(j).getEntry(i)+" ");
                
            }
        }
        
    }
    
    public boolean insertToken(){
        
        if(board.getTurn() % 2 == 1){
            System.out.print("\n\n"+currentPlayer[0].getName() +"'s turn: ");
        }else{
            System.out.print("\n\n"+currentPlayer[1].getName() +"'s turn: ");
        }

        String selectCol = scan.nextLine();
        
         if(selectCol.compareTo("") == 0){
            System.out.println("Pls enter a column number ...");
            return false;
        }
        char selectedCol = selectCol.charAt(0);
        
        if(Character.isDigit(selectedCol)){
            board.setInsertTokenPosition(Character.getNumericValue(selectedCol)); 
        }else{
            System.out.println("Invalid NUMBER ! \n\nPls try again...");
            return false;
        }

        
        //check selected column for insert token
        if(board.getInsertTokenPosition() <= 0 || board.getInsertTokenPosition()> board.getBoardCol().length){
            System.out.println("Invalid column number! Pls try again...");
            return false;
        }else{
            // check if col full
            int isColFull = board.getRows();
            for(int i = 0; i < board.getRows(); i++){
                Character entry = board.getSpecificBoardCol(board.getInsertTokenPosition()-1).getEntry(board.getRows() - 1 - i);
               
                if(entry == '-'){
                    break;
                }else{
                    isColFull--;
                }
            } 
            if(isColFull == 0){
                System.out.println("Col " +board.getInsertTokenPosition()+" is full ! "
                        + "Pls proceed to another row ! ");
                return false;
            }
        }
       return true;
    }
   
    //--- save the token inserted position into linked list ----//
    public void assignToken(){
        
        boolean assignSuccess;
        int replaceRow = board.getRows(); 
        Character entry;
        int turn = board.getTurn();
        do{
            replaceRow--;
            entry = board.getSpecificBoardCol(board.getInsertTokenPosition()-1).getEntry(replaceRow);
        
        }while(entry != '-');
       
            
        if(turn % 2 == 1){
            assignSuccess = board.getSpecificBoardCol(board.getInsertTokenPosition()-1).replace( replaceRow, board.getSpecificToken(0));
                 
        }else{
            assignSuccess = board.getSpecificBoardCol(board.getInsertTokenPosition()-1).replace( replaceRow, board.getSpecificToken(1));
        }

        if(assignSuccess){
            turn++;
            board.setTurn(turn);
        }
    }

    
    //-----check win------//
    public int checkResult(int connectNum){
        Character entry;
        switch (connectNum) {
                case 3:
                    //check for horizontal win
                    for(int i = board.getRows() - 1 ; i > 0; i--){
                        for(int j = 0; j < board.getBoardCol().length - 2; j++){
                            entry = board.getSpecificBoardCol(j).getEntry(i);
                            
                            if( !(entry.equals('-')) && board.getSpecificBoardCol(j+1).getEntry(i).equals(entry) 
                                    && board.getSpecificBoardCol(j+2).getEntry(i).equals(entry)){
                                return board.getTurn();
                            }
                        }
                    }
                    
                    //check for vertical win
                    for(int j = 0; j < board.getBoardCol().length; j++){
                        for(int i = 0; i < board.getRows() - 2; i++){
                            entry = board.getSpecificBoardCol(j).getEntry(i);
                            
                            if( !(entry.equals('-')) && board.getSpecificBoardCol(j).getEntry(i+1).equals(entry) 
                                    && board.getSpecificBoardCol(j).getEntry(i+2).equals(entry)){
                                return board.getTurn();
                            }
                        }
                    }   
                   
                    //check for diagonal win (+ve slope)
                    for(int i = board.getRows() - 1 ; i > 2; i--){
                        for(int j = 0; j < board.getBoardCol().length - 2; j++){
                            entry =  board.getSpecificBoardCol(j).getEntry(i);
                            
                            if( !(entry.equals('-')) &&  board.getSpecificBoardCol(j+1).getEntry(i-1).equals(entry) 
                                    &&  board.getSpecificBoardCol(j+2).getEntry(i-2).equals(entry)){
                                return board.getTurn();
                            }
                        }
                    }
                    
                    //check for diagonal win (-ve slope)
                    for(int i = board.getRows() - 1 ; i > 0; i--){
                        for(int j = board.getBoardCol().length - 1; j > 1; j--){
                            entry = board.getSpecificBoardCol(j).getEntry(i);
                            
                            if( !(entry.equals('-')) && board.getSpecificBoardCol(j-1).getEntry(i-1).equals(entry) 
                                    && board.getSpecificBoardCol(j-2).getEntry(i-2).equals(entry)){
                                return board.getTurn();
                            }
                        }
                    } 
                    
                    break;
                case 5:
                    //check for horizontal win
                     for(int i = board.getRows() - 1 ; i > 0; i--){
                        for(int j = 0; j < board.getBoardCol().length - 4; j++){
                            entry = board.getSpecificBoardCol(j).getEntry(i);
                            
                            if( !(entry.equals('-')) && board.getSpecificBoardCol(j+1).getEntry(i).equals(entry) 
                                    && board.getSpecificBoardCol(j+2).getEntry(i).equals(entry) 
                                    && board.getSpecificBoardCol(j+3).getEntry(i).equals(entry)
                                    && board.getSpecificBoardCol(j+4).getEntry(i).equals(entry)){
                                return board.getTurn();
                            }
                        }
                    }
                    
                    //check for vertical win
                      for(int j = 0; j < board.getBoardCol().length; j++){
                        for(int i = 0; i < board.getRows() - 4; i++){
                            entry = board.getSpecificBoardCol(j).getEntry(i);
                            
                            if( !(entry.equals('-')) && board.getSpecificBoardCol(j).getEntry(i+1).equals(entry) 
                                    && board.getSpecificBoardCol(j).getEntry(i+2).equals(entry) 
                                    && board.getSpecificBoardCol(j).getEntry(i+3).equals(entry)
                                    && board.getSpecificBoardCol(j).getEntry(i+4).equals(entry)){
                                return board.getTurn();
                            }
                        }
                    }   
                      
                    //check for diagonal win (+ve slope)
                    for(int i = board.getRows() - 1 ; i > 3; i--){
                        for(int j = 0; j < board.getBoardCol().length - 4; j++){
                            entry = board.getSpecificBoardCol(j).getEntry(i);
                            
                            if( !(entry.equals('-')) && board.getSpecificBoardCol(j+1).getEntry(i-1).equals(entry) 
                                    && board.getSpecificBoardCol(j+2).getEntry(i-2).equals(entry) 
                                    && board.getSpecificBoardCol(j+3).getEntry(i-3).equals(entry)
                                    && board.getSpecificBoardCol(j+4).getEntry(i-4).equals(entry)){
                                return board.getTurn();
                            }
                        }
                    }
                      
                    //check for diagonal win (-ve slope)
                     for(int i = board.getRows() - 1 ; i > 3; i--){
                        for(int j = board.getBoardCol().length - 1; j > 3; j--){
                            entry = board.getSpecificBoardCol(j).getEntry(i);
                            
                            if( !(entry.equals('-')) && board.getSpecificBoardCol(j-1).getEntry(i-1).equals(entry) 
                                    && board.getSpecificBoardCol(j-2).getEntry(i-2).equals(entry) 
                                    && board.getSpecificBoardCol(j-3).getEntry(i-3).equals(entry)
                                    && board.getSpecificBoardCol(j-4).equals(entry)){
                                return board.getTurn();
                            }
                        }
                    } 
                    
                    break;
                default: // connect 4
                    
                    //check for horizontal win
                    for(int i = board.getRows() - 1 ; i >= 0; i--){
                        for(int j = 0; j < board.getBoardCol().length - 3; j++){
                            entry = board.getSpecificBoardCol(j).getEntry(i);
                            
                            if( !(entry.equals('-')) && board.getSpecificBoardCol(j+1).getEntry(i).equals(entry) 
                                    && board.getSpecificBoardCol(j+2).getEntry(i).equals(entry) 
                                    && board.getSpecificBoardCol(j+3).getEntry(i).equals(entry)){
                                return board.getTurn();
                            }
                        }
                    }
                    
                    //check for vertical win
                    for(int j = 0; j < board.getBoardCol().length; j++){
                        for(int i = 0; i <= board.getRows()  - 4; i++){
                            entry = board.getSpecificBoardCol(j).getEntry(i);
                            
                            if( !(entry.equals('-')) && board.getSpecificBoardCol(j).getEntry(i+1).equals(entry) 
                                    && board.getSpecificBoardCol(j).getEntry(i+2).equals(entry) 
                                    && board.getSpecificBoardCol(j).getEntry(i+3).equals(entry)){
                                return board.getTurn();
                            }
                        }
                    }  
                    
                    //check for diagonal win (+ve slope)
                    for(int i = board.getRows()  - 1 ; i > 2; i--){
                        for(int j = 0; j < board.getBoardCol().length - 3; j++){
                            entry = board.getSpecificBoardCol(j).getEntry(i);
                            
                            if( !(entry.equals('-')) && board.getSpecificBoardCol(j+1).getEntry(i-1).equals(entry) 
                                    && board.getSpecificBoardCol(j+2).getEntry(i-2).equals(entry) 
                                    && board.getSpecificBoardCol(j+3).getEntry(i-3).equals(entry)){
                                return board.getTurn();
                            }
                        }
                    }
                    //check for diagonal win (-ve slope)
                    for(int i = board.getRows() - 1 ; i > 2; i--){
                        for(int j = board.getBoardCol().length - 1; j > 2; j--){
                            entry = board.getSpecificBoardCol(j).getEntry(i);
                            
                            if( !(entry.equals('-')) && board.getSpecificBoardCol(j-1).getEntry(i-1).equals(entry) 
                                    && board.getSpecificBoardCol(j-2).getEntry(i-2).equals(entry) 
                                    && board.getSpecificBoardCol(j-3).getEntry(i-3).equals(entry)){
                                return board.getTurn();
                            }
                        }
                    } 
                    
                    break;
            }
        
            return 0;
    }
    
    
    //---- check if all col full ---//
    public boolean isAllColFull(){
        
        for(int j = 0; j < board.getBoardCol().length; j++){
            for(int i = 0; i < board.getRows(); i++){
                if( board.getSpecificBoardCol(j).getEntry(i) == '-'){
                    return false;
            } 
         }
        }
          return true;
    }
   
}
