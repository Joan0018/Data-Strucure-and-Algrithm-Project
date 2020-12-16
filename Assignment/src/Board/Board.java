
package Board;

/**
 *
 * @author Cheong Yin Lam
 */


import java.util.Scanner;

public class Board {
    Scanner scan = new Scanner(System.in);
    
    double time; 
    int rows;
    
    LinkedList<Character> boardCol[]; 
    
    int insertTokenPosition = 0;
    int turn = 1;
    
    char currentToken[]; 
    
    public Board(){
        
    }
    
    public Board(char tokenChar[], int row) {
        this.currentToken = tokenChar;
        this.rows = row;
    }

    public double getTime() {
        return time;
    }

    public void setTime() {
        this.time = System.currentTimeMillis();
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public LinkedList<Character>[] getBoardCol() {
        return boardCol;
    }

    public void setBoardCol(LinkedList<Character>[] boardCol) {
        this.boardCol = boardCol;
    }

    public int getInsertTokenPosition() {
        return insertTokenPosition;
    }

    public void setInsertTokenPosition(int insertTokenPosition) {
        this.insertTokenPosition = insertTokenPosition;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public char[] getCurrentToken() {
        return currentToken;
    }

    public void setCurrentToken(char[] currentToken) {
        this.currentToken = currentToken;
    }
    
    public LinkedList<Character> getSpecificBoardCol(int colPos){
        return boardCol[colPos];
    }
    
    public char getSpecificToken(int num){
        return currentToken[num];
    }
    
    //----- cal total time----//
    public double totalTimeTaken(double anotherTime){  //return min
      double timeTaken; 
      
      if(time > anotherTime){
           timeTaken = time - anotherTime;
      }else{
          timeTaken = anotherTime - time;
      }
      return (timeTaken / 60000 );  // (/1000/60)
      
     }
   

}
