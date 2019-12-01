package Modeles;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;


public class Modele extends Observable {
    
    int lastC, lastR;
    Grille grille;
    ArrayList<int[]> chemin;
    
    public void startDD(int c, int r) {
        // TODO
        chemin = new ArrayList<int[]>();
        System.out.println("startDD : " + c + "-" + r);
        setChanged();
        notifyObservers();
    }
    
    public void stopDD(int c, int r) {
        grid.stopChemin();
        
        // mémoriser le dernier objet renvoyé par parcoursDD pour connaitre la case de relachement
        
        System.out.println("stopDD : " + c + "-" + r + " -> " + lastC + "-" + lastR);
        setChanged();
        notifyObservers();
    }
    
    public void parcoursDD(int c, int r) {
        chemin.add({c, r});
        lastC = c;
        lastR = r;
        System.out.println("parcoursDD : " + c + "-" + r);
        setChanged();
        notifyObservers();
    }

    public void addCase(int column, int row, Case c) {
        grille.addCase(column, row, c);
    }
   

}