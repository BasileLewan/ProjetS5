package Modeles;

import java.util.Observable;


public class Modele extends Observable {
    
    int lastC, lastR;
    
    public void startDD(int c, int r) {
        // TODO
        System.out.println("startDD : " + c + "-" + r);
        setChanged();
        notifyObservers();
    }
    
    public void stopDD(int c, int r) {
        // TODO
        
        // mémoriser le dernier objet renvoyé par parcoursDD pour connaitre la case de relachement
        
        System.out.println("stopDD : " + c + "-" + r + " -> " + lastC + "-" + lastR);
        setChanged();
        notifyObservers();
    }
    
    public void parcoursDD(int c, int r) {
        // TODO
        lastC = c;
        lastR = r;
        System.out.println("parcoursDD : " + c + "-" + r);
        setChanged();
        notifyObservers();
    }
   

}