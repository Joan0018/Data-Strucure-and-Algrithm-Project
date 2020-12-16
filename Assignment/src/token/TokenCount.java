/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package token;

import java.util.Scanner;
/**
 *
 * @author Yeu
 */
public class TokenCount {
    
    public void addToken(String nam, CircularLinkedList<Token> cirStr){
        char symbol;
        int zero = 0;
        
        Scanner scan = new Scanner(System.in);
        
        System.out.printf("\n" + nam + ", please enter token of your symbol(alphabet) : ");
        
        do{          
            symbol = scan.next().charAt(0);
            
        }while(!validate(symbol, cirStr));
        
        Token tokName = new Token(nam, symbol, zero);

        cirStr.add(tokName);
    }
    
    public boolean validate(char symbol, CircularLinkedList<Token> cirStr){     
        if((symbol >= 'a' && symbol <= 'z') || (symbol >= 'A' && symbol <= 'Z')){
            for(int i = 1; i < cirStr.getLength() + 1; i++){ 
                if(cirStr.getEntry(i).getToken() == symbol){
                    System.out.println("\n\nError Detected! Please Enter Symbol that have not choose before\n");
                    System.out.printf("\nPlease enter symbol (alphabet) : ");    
                    return false;
                }
            }
            return true;
        }
        System.out.println("\n\nError Detected! Please Enter Alphabet\n");
        System.out.printf("\nPlease reenter symbol (alphabet) : ");
        return false;
    }
       
    public void addEachRoundToken(String nam, CircularLinkedList<Token> cirStr){    
       for(int i = 1; i < cirStr.getLength() + 1; i++){          
           if(cirStr.getEntry(i).getName().equals(nam)){  
               cirStr.getEntry(i).setCount(cirStr.getEntry(i).getCount() + 1);          
           }
       }
    }
    
    public void finishEachRound(CircularLinkedList<Token> cirStr){
        System.out.printf("\n\n==============================================\n");
        System.out.printf("||            Total Token Used              ||\n");
        System.out.printf("==============================================\n");
        
        for(int i = 1; i < cirStr.getLength() + 1; i++){          
           if(cirStr.getEntry(i).getCount() != 0){  
               System.out.printf("|| %s : %d token\n", cirStr.getEntry(i).getName(), cirStr.getEntry(i).getCount());
           }
       }
       System.out.printf("==============================================\n");
    }
      
    public char retrieveToken(String nam, CircularLinkedList<Token> cirStr){
        char a = '0';
        for(int i = 1; i < cirStr.getLength() + 1; i++){  
            if(cirStr.getEntry(i).getName().equals(nam)){                
                return cirStr.getEntry(i).getToken();
            }
        } 
        return a;
    }
}
