/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

import java.util.InputMismatchException;
import java.util.Scanner;
import token.CircularLinkedList;
import token.Token;
import token.TokenCount;

/**
 *
 * @author User
 */
public class PlayerConnectFour {
    

    
    public void addPlayer(Player player, ListInterface<Player> PlayerList, CircularLinkedList<Token> CirStr,int gamemode){
        
        int numOfPlayer = 0;
        int check = 0;
        String playerName = "";
        
        Scanner scan = new Scanner(System.in);
        System.out.printf("         ==========================\n");
        System.out.printf("             Player Registration\n");
        System.out.printf("         ==========================\n");
        

        if(gamemode==1){
        do{
            
            System.out.printf("Please Enter The Number Of Player For This Round:   ");
           
           try{
               numOfPlayer = scan.nextInt();
               
               if(numOfPlayer < 2){
                   System.out.println("Invalid Input Detected!");
               }
           }
           catch (InputMismatchException ex){
               System.out.println("Input Must be Positive Integer");
               scan.next();
           }

        }while(numOfPlayer < 2);
            
        }
        else {
            
            do{
            
            System.out.printf("Please Enter The Number Of Player For Tournament （Only 4/8 player allowed) :   ");
            
              try{
               numOfPlayer = scan.nextInt();
               
               if(numOfPlayer != 4 && numOfPlayer != 8){
                   System.out.println("Input Must be 4 or 8");
               }
              }
              catch (InputMismatchException ex){
               System.out.println("Invalid Input Detected!");
               scan.next();
           }

           
            }while(numOfPlayer != 4 && numOfPlayer != 8);
        }
     
        do{
            System.out.printf("\nPlease Enter The Player Name:    \n");
           
            scan.nextLine();
        
            for(int i = 0; i < numOfPlayer; i++){
           
                System.out.printf("\nPlayer%2d Name:    ", i+1);
            
                playerName = scan.nextLine();
       
                if(validateName(playerName,PlayerList)){
                
            
                    player = new Player(playerName);
          
                    PlayerList.add(player);
                
                    TokenCount tok = new TokenCount();
                    tok.addToken(playerName, CirStr);   
                
                    for(int j = 0; j < PlayerList.getLength(); j++){
                   
                        if(PlayerList.getEntry(j).equals(player)){
                            PlayerList.getEntry(j).setToken(CirStr.getEntry(j + 1).getToken());
                        }
                    }
                    
                }
                else if (-1 == check || !validateName(playerName,PlayerList)){
                    i--;
                    System.out.println("\nError Detected! Please Enter Again");
                }
            
                
            }  
        }while("".equals(playerName));  
        
    }
    
    public Player[] retrievePlayerForEachRound(ListInterface<Player> PlayerList,ListInterface<Player> winnerList,int round){
        
        Player[] player = new Player[2];
        int length = winnerList.getLength();
        
      
       
      
        if(length == 0 && round == 1){
            
            player[0] = PlayerList.getEntry(0);
            player[1] = PlayerList.getEntry(1);
            
        }
        else if (length > 0 && round > 1){
           
            player[0] = winnerList.getEntry(length - 1);
            player[1] = PlayerList.getEntry(length + 1);
 
        }
        
        return player;
    }
    
    public int getNumberofRoundInAGame(ListInterface<Player> PlayerList){
        
        int round = PlayerList.getLength() - 1;

        return round;
    }
    
    public void calculateAndAssignScore(double min, int tokenCount,ListInterface<Player> PlayerList, String playerName){
        
        int length = PlayerList.getLength();
        double playerScore;
        
        for(int i = 0; i < length; i++){
            
            if(PlayerList.getEntry(i).getName().equals(playerName)){
                playerScore = PlayerList.getEntry(i).getScore();
                double score = (double) ((tokenCount/min)*100);
                
                 if(playerScore == 0){
                        PlayerList.getEntry(i).setScore(score);
                 }else{
                        score += PlayerList.getEntry(i).getScore();
                        PlayerList.getEntry(i).setScore(score);
                 }
            }
        }
    
    }
    
    public void displayPlayerDetails(ListInterface<Player> PlayerList, CircularLinkedList<Token> CirStr){
        
        System.out.printf("\t\t\t============================\n");
        System.out.printf("\t\t\t     Player Details\n");
        System.out.printf("\t\t\t============================\n");
        
        System.out.printf("=========================================================================\n");
        System.out.printf("||\t Player\t\t\tPlayer Name\t\t\tToken\t||\n");
        for(int i = 0; i < PlayerList.getLength(); i++){
           
             System.out.println(String.format("||%12d %-18s %-31s %c\t||",
                    (i+1), 
                    " ",
                    PlayerList.getEntry(i).getName(), 
                    PlayerList.getEntry(i).getToken()));
        }
        System.out.printf("=========================================================================\n");
    }
    
    public  boolean validateName(String name, ListInterface<Player> PlayerList) {
        
       
        
        String currentName = name ;
        String regexName = "^[aA-zZ]\\w{0,29}$";
        int check = 0;
        
        for(int i = 0; i < PlayerList.getLength(); i++){
            if(PlayerList.getEntry(i).getName().equals(name)){
                check = -1;
            }
        }
        return !(name.length() < 0 || !currentName.matches(regexName) || (check == -1)) ;
    }
    
    
}
