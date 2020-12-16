/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameMode;
/**
 *
 * @author User
 */
public class GameMode {
    private int ID;
    private String name;
    private String rule;
 

    public GameMode(int ID, String name,String rule) {
        this.ID = ID;
        this.name = name;
        this.rule=rule;
    }
    
       public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }
    
}
