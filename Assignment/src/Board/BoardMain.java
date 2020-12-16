/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Board;

import GameMode.GameModeConnect4;
import GameMode.Tournament;
import Player.ArrayList;
import Player.Player;
import Player.PlayerConnectFour;
import Player.ListInterface;
import Ranking.Ranking;
import Ranking.RankingConnectFour;
import Ranking.SortedLinkedList;
import token.*;
import java.util.Scanner;

/**
 *
 * @author All members
 */
public class BoardMain {
    
    public BoardMain(){}
   
    public void displayLogo(){
        System.out.println(String.format("\n\n%5s %s", " ", "===================================================="));
        System.out.println(String.format("%5s %s", " ", "AAAA  AAAA  A  A  A  A  AAAA  AAAA AAAAA     A  A"));
        System.out.println(String.format("%5s %s", " ", "A     A  A  A  A  A  A  A     A      A       A  A"));
        System.out.println(String.format("%5s %s", " ", "A     A  A  AA A  AA A  AAAA  A      A       AAAAAA  "));
        System.out.println(String.format("%5s %s", " ", "A     A  A  A AA  A AA  A     A      A          A"));
        System.out.println(String.format("%5s %s", " ", "AAAA  AAAA  A  A  A  A  AAAA  AAAA   A          A"));
        System.out.println(String.format("%5s %s", " ", "===================================================="));
        System.out.println("\n");
        System.out.println(String.format("%20s %s", " ", "(1)  Play Game"));
        System.out.println(String.format("%20s %s", " ", "(2)  Ranking Board"));
        System.out.println(String.format("%20s %s", " ", "(3)  Exit"));
        //System.out.println("\n");
        System.out.print(String.format("\n%13s %s", " ", "Your selection (1/2/3): "));
            
    }
    
    public void Game(SortedLinkedList<Ranking> rankingList){
        
        Player playerN = new Player();
        ListInterface<Player> PlayerList = new ArrayList<>();
        ListInterface<Player> winnerList = new ArrayList<>();
        PlayerConnectFour play = new PlayerConnectFour();
        SortedLinkedList<Player> sortedPlayerList = new SortedLinkedList<>();
        CircularLinkedList<Token> CirStr = new CircularLinkedList<>();
        TokenCount token = new TokenCount();     
        BoardConnectFour mainBoard;
        Board board;

        Tournament tour=new Tournament();
        int rows = 9; 
        int cols = 8;
        int numOfPlayer;
        int round = 1;
        boolean insertSuccess;
        int checkResult; // win will get turn else 0
        int turn = 0;
        
        double startTime, timeTaken;
        double totalTime = 0; // total time for all round
        Player currentPlayer[];
        String winnerName;
        char currentToken[] = new char[2];
        LinkedList<Character> boardCol[] = new LinkedList[cols];
        
        
        GameModeConnect4 mode=new GameModeConnect4();
        int gamemode=mode.selectGameMode();
        
        play.addPlayer(playerN, PlayerList, CirStr,gamemode);
        
        numOfPlayer = PlayerList.getLength();
        
        tour.initialize(PlayerList);
        
        
        play.displayPlayerDetails(PlayerList, CirStr);
               
        if(gamemode==2)
        tour.display();
        
        
        int connectNum = promptConnectNum();
                
        do{
            if(gamemode==1)
        currentPlayer = play.retrievePlayerForEachRound(PlayerList, winnerList,round);
            else currentPlayer=tour.retrievePlayerForEachRound(numOfPlayer);
        currentToken[0] = token.retrieveToken(currentPlayer[0].getName(), CirStr);
        currentToken[1] = token.retrieveToken(currentPlayer[1].getName(), CirStr);      
        
        System.out.println(currentPlayer[0].getName() + " >> "+ currentPlayer[1].getName());
         
        mainBoard = new BoardConnectFour();
        board = new Board(currentToken, rows);
        
        mainBoard.createNewBoard(currentPlayer, currentToken,boardCol, board);
        board.setTime();
        startTime = board.getTime();
        
        do{
            mainBoard.displayBoard();
            
            if(mainBoard.isAllColFull()){
                System.out.println("\nTHERE IS NO WINNER !! This round will PLAY AGAIN !");
                insertSuccess = false;
            }else{
                do{
                    insertSuccess = mainBoard.insertToken();
                
                }while(!insertSuccess);
            
                mainBoard.assignToken();

                turn++;

                if(turn % 2 == 1){
                    token.addEachRoundToken(currentPlayer[0].getName(), CirStr);
                }
                else
                {
                    token.addEachRoundToken(currentPlayer[1].getName(), CirStr);
                }
            }
            checkResult = mainBoard.checkResult(connectNum);

            if(checkResult != 0){
                if(checkResult %2 == 0){
                     winnerName = currentPlayer[0].getName();
                     Player playerW = new Player();
                     board.setTime();
                     timeTaken = board.totalTimeTaken(startTime);
                     totalTime += timeTaken;
                    playerW.setName(currentPlayer[0].getName());
                    if(gamemode==1){
                     play.calculateAndAssignScore(timeTaken,CirStr.getEntry(1).getCount(),PlayerList,currentPlayer[0].getName());
                     winnerList.add(playerW);
                     }else tour.stepUp(playerW,numOfPlayer);
                     round++;

                }else{
                     winnerName = currentPlayer[1].getName();
                     Player playerW = new Player();
                     board.setTime();
                     timeTaken = board.totalTimeTaken(startTime);
                     totalTime += timeTaken;
                     playerW.setName(currentPlayer[1].getName());
                     if(gamemode==1){
                     play.calculateAndAssignScore(timeTaken,CirStr.getEntry(2).getCount(),PlayerList,currentPlayer[1].getName());
                     winnerList.add(playerW);
                     }
                     else tour.stepUp(playerW,numOfPlayer);
                     round++;
                }
                
                mainBoard.displayBoard();
                token.finishEachRound(CirStr);
                System.out.println("\nWinner is "+ winnerName.toUpperCase());
                
                if(gamemode==2)
                tour.display();
                
                break;
            }
            
            
        }while(insertSuccess);
        
        
        }while(round <= play.getNumberofRoundInAGame(PlayerList));
        
        for(int i = 0; i < PlayerList.getLength(); i++){
            Player temp = new Player();
            temp.clone(PlayerList.getEntry(i));
            sortedPlayerList.add(temp);
        }
        
        Ranking ranking = new Ranking(sortedPlayerList, totalTime);
        if(gamemode==1){
            ranking.displayRanking();
            rankingList.add(ranking);
        }else tour.champion();
    }

    public int promptConnectNum(){
        Scanner scan = new Scanner(System.in);
        char selectConnectNum = 2;
        boolean validSelection;
        
        do{
            System.out.println("\n Connect Number Mode   ");
            System.out.println(" ===================  ");
            System.out.println(" (1) Simple Mode - connect 3");
            System.out.println(" (2) Medium Mode - connect 4");
            System.out.println(" (3) Hard Mode - connect 5");
            System.out.print(" Pls enter the mode number (1/2/3) : ");
            String selection = scan.nextLine();

            if(selection.compareTo("") == 0){
                System.out.println("Pls enter a mode slection ...");
               validSelection = false;
               
            }else{
                selectConnectNum = selection.charAt(0);
            
                if(!Character.isDigit(selectConnectNum)){
                    System.out.println("\nNOT A NUMBER ! ");
                    validSelection = false;
                }else if( Character.getNumericValue(selectConnectNum) < 1 || Character.getNumericValue(selectConnectNum) > 3){
                    System.out.println("\nInvalid Selection ! Must 1 / 2 / 3 ... ");
                    validSelection = false;
                }else{
                    validSelection = true;
                }
            }
            
            
            
        }while( !validSelection);
        
        switch(Character.getNumericValue(selectConnectNum)){
            case 1:
                return 3;
            case 3:
                return 5;
            case 2:
            default:
                return 4;
        }
        
    }
    
    

    public void drawLine(int length, int space){
        String line = "";
        for(int i = 0; i < space; i++){
            line += " ";
        }
        for(int i = 0; i < length; i++){
            line += "=";
        }
        System.out.println(line);
    }
    
    public void drawLine2(int length, int space){
        String line = "";
        for(int i = 0; i < space; i++){
            line += " ";
        }
        for(int i = 0; i < length; i++){
            line += "-";
        }
        System.out.println(line);
    }
    
    public static void main(String args[]) {
        BoardMain boardMain = new BoardMain();
        RankingConnectFour rankingConnectFour = new RankingConnectFour();
        Scanner scan = new Scanner(System.in);
        
        SortedLinkedList<Ranking> rankingList = rankingConnectFour.prevGameRecord();

        int menuSelection = 0;
        boolean validMenuSelection = false;

        ////// 
        do{
            do{
                validMenuSelection = false;
                
                boardMain.displayLogo();
                String input = scan.nextLine();
                System.out.println(" ");
                
                 if(input.compareTo("") == 0){
                    System.out.println("Pls enter a slection ...");
                    validMenuSelection = false;
                }else{
                     if(Character.isDigit(input.charAt(0))){
                        menuSelection = Integer.parseInt(input);
                        if(menuSelection >= 1 && menuSelection <= 3){
                            validMenuSelection = true;
                        }else{
                            System.out.println(String.format("%s %s", " ", "Invalid selection! Please enter your selection between 1 - 3\n"));
                            validMenuSelection = false;
                        }    
                    }else{
                        System.out.println(String.format("%s %s", " ", "Invalid selection! Please enter digit only\n"));
                        validMenuSelection = false;
                    }
                 }

            }while(validMenuSelection == false);
            
            switch(menuSelection){
                case 1:

                    boardMain.Game(rankingList);
                    break;

                case 2:
                    //Ranking
                    rankingConnectFour.selectRankingBoard(rankingList);
                    break;
                case 3:
                    //Exit
                    System.out.println(String.format("%11s %s", " ", "Hope you have a nice day! Bye!!"));
                    break;
                default:
                    break;
            }
            
        }while(menuSelection != 3);
        
        
        
}
}
