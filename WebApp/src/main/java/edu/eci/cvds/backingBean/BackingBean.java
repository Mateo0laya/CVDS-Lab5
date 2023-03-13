package edu.eci.cvds.backingBean;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "guessBean")
@ApplicationScoped

public class BackingBean {

    private int number;
    private int reward;
    private int tries;
    private String state;

    public BackingBean(){
    }

    public int getNumber(){
        return number;
    }

    public int getReward(){
        return reward;
    }

    public int getTries(){
        return tries;
    }

    public String getState(){
        return state;
    }

    public void setNumber(int number){
        this.number =  number;

    }

    public void setTries(int tries){
        this.tries = tries;
    }

    public void setState(String state){
        this.state = state;
    }

    public void setReward(int reward){
        this.reward = reward;
    } 
}
