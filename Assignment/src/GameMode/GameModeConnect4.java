/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameMode;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class GameModeConnect4 {

    public GameModeConnect4() {
        GameMode[] gamemode=initializeGameMode();
        displayGameMode(gamemode);
    }
    
    public GameMode[] initializeGameMode(){
        GameMode[] gamemode={
        new GameMode(1,"Classic Mode","Must More Than 2 Players"),
        new GameMode(2,"Tournament Mode","Must 4 / 8 Players")
        };
        
        return gamemode;
    }
    
    public void displayGameMode(GameMode[] gamemode){
        System.out.println("\n Please select your Game Mode   ");
        System.out.println(" ===============================  ");
        for(int i=0;i<gamemode.length;i++){
                System.out.println("("+gamemode[i].getID() +") "+gamemode[i].getName()+"   (Player Allow :" + gamemode[i].getRule()+")");
                
            }
    }
    
    public int selectGameMode(){
        Scanner scan = new Scanner(System.in);
         boolean validSelection;
        char select = 2;
        do{
            System.out.print(" Pls enter the mode number (1/2) : ");
            String selection = scan.nextLine();

            if(selection.compareTo("") == 0){
                System.out.println("Pls enter a mode selection ...");
               validSelection = false;
               
            }else{
                select = selection.charAt(0);
            
                if(!Character.isDigit(select)){
                    System.out.println("\nNOT A NUMBER ! ");
                    validSelection = false;
                }else if( Character.getNumericValue(select) < 1 || Character.getNumericValue(select) > 2){
                    System.out.println("\nInvalid Selection ! Must 1 / 2  ... ");
                    validSelection = false;
                }else{
                    validSelection = true;
                }
            }
            
        }while( !validSelection);
            
            if(Character.getNumericValue(select)==1)
                return 1;
            else
                return 2;

        }
}
