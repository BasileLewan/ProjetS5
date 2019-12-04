/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modeles;

import java.util.LinkedList;
import java.util.Observable;

import java.util.Queue;

/**
 *
 * @author quent
 */
public class Chemin extends Observable {
    
   private int lastC, lastR;
   
   private Case[][] grille ;
   
   private boolean stopped  = false ;
   
   private boolean started = false ;
   
   private Queue<Case> lastChemin ;
   
   private boolean continu = true ;
   
   private int startSymbol = 0;
   
   
   public Chemin()
   {
       
       grille = new Case[5][5];
       lastChemin = new LinkedList<Case>();
       
   }
    
     public void startDD(int c, int r) {
        if (!(grille[c][r] instanceof Symbole)){
            continu = false;
        }else{
            startSymbol = Symbole(grille[c][r]).getNbSymbole();
        }
        
        
        this.stopped = false ;
        System.out.println("startDD : " + c + "-" + r);
        this.started = true ;
        setChanged();
        notifyObservers();
        
        
    }
    
    public void stopDD(int c, int r) {
        // TODO
        
        // mémoriser le dernier objet renvoyé par parcoursDD pour connaitre la case de relachement
        
        System.out.println("stopDD : " + c + "-" + r + " -> " + lastC + "-" + lastR);
        this.stopped = true ;
        
        //grille[r][c] = 1 ;
        
                for ( int i = 0; i< 5 ; i++)
        {
            
             for ( int j = 0; j< 5 ; j++)
             {
                 System.out.print(this.grille[i][j] +"  ");
                 
             }
            
             System.out.println("");
        }
        
        
        
        setChanged();
        notifyObservers();
    }
    
        public void stopDD(int c, int r) {
        
        // mémoriser le dernier objet renvoyé par parcoursDD pour connaitre la case de relachement
        
        if (grille[c][r] instanceof Symbole){
            if (startSymbol != grille[lastC][lastR].getNbSymbole()){
                continu = false;            
        }else{
            continu = false;
        }
        grille.setContinu(startSymbol, continu);
         
        System.out.println("stopDD : " + c + "-" + r + " -> " + lastC + "-" + lastR);
        this.stopped = true ;
        
        //grille[r][c] = 1 ;
        
                for ( int i = 0; i< 5 ; i++)
        {
            
             for ( int j = 0; j< 5 ; j++)
             {
                 System.out.print(this.grille[i][j] +"  ");
                 
             }
            
             System.out.println("");
        }
        
        
        
        setChanged();
        notifyObservers();
    }
    
    public void parcoursDD(int c, int r) {
        // TODO
        lastC = c;
        lastR = r;
        this.started = false ;
        
        if (grille[r][c] instanceof CaseChemin){
            grille.setContinu(grille[r][c].getNbChemin, false);
        }
        
        grille[r][c] = new CaseChemin(r,c,null, startSymbol) ;
        lastChemin.add(grille[r][c]) ;
        
        if(lastChemin.size() > 3)
        {
            System.out.println(lastChemin);
            lastChemin.remove() ;
        }
        System.out.println("parcoursDD : c " + c + "- r " + r);
         setChanged();
         notifyObservers();
    }

    public boolean isStopped() {
        return stopped;
    }
    
    
    public void clean()
    {
        
        this.stopped = false ;
        
        for ( int i = 0; i< 5 ; i++)
        {
            
             for ( int j = 0; j< 5 ; j++)
             {
                 this.grille[i][j] = null ;
                 
             }
            
            
        }
    }

    public Case[][] getGrille() {
        return grille;
    }

    void clean(int i, int j) {
        
        this.grille[i][j] = null ;
    }

    public boolean isStarted() {
        return started;
    }

    public int getLastC() {
        return lastC;
    }

    public int getLastR() {
        return lastR;
    }

    public Queue<Case> getLastChemin() {
        return lastChemin;
    }
    
    
    
    
}
