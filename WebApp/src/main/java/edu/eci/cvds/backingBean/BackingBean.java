package edu.eci.cvds.backingBean;

import java.util.concurrent.locks.ReadWriteLock;

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

    public void guess(int attempt){
        if (attempt == number){
            setState("Win: " + reward);
        }else{
            setReward(reward - 10000);
            setState("You still do not win");
        }
    }

    public void reset(){
        int randomNumber = (int)(Math.random()*10 + 1);
        setNumber(randomNumber);
        setReward(100000);
        setState("You still do not win");
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
