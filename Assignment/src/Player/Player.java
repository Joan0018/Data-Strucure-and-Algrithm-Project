/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;


/**
 *
 * @author Joan Hau
 */
public class Player implements Comparable<Player>{
    
    private String name;
    private char token;
    private double score;
    

    
    public Player() {
    }

    public Player(String name, char token) {
        this.name = name;
        this.token = token;
    }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getToken() {
        return token;
    }

    public void setToken(char token) {
        this.token = token;
    }

    public double getScore() {
        return score;
    }
    

    public void setScore(double score) {
        this.score = score;
    }

    
    @Override
    public String toString() {
        return "name=" + name + ", tokenColour=" + token + ", score=" + score ;
    }
    
    @Override
    public int compareTo(Player player){
        return (int)((this.score - player.score)*100);
    }
    
    public void clone(Player player){
        this.name = player.name;
        this.score = player.score;
        this.token = player.token;
    }
    
    
}
