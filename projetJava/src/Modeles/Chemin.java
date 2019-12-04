/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modeles;

import static java.lang.Math.abs;
import java.util.LinkedList;
import java.util.Observable;

import java.util.Queue;
import javafx.scene.image.ImageView;

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
   
   private boolean[] chContinu = {false, false, false};

   
   
   public Chemin(Case[][]g)
   {
       
       grille = g;
       lastChemin = new LinkedList<Case>();
       
   }
   
   public void check(int c , int r)
   {
      /* if( lastChemin.size() > 0)
       {
       int checkX = lastChemin.peek().getX() - r ;
       int checkY = lastChemin.peek().getY() - c ; 
       
       if ( abs(checkX) > 1 || abs(checkY) > 1 )
       {
           this.lastChemin.clear();
       }
       
       }

*/
       
       lastChemin.clear() ;
   }
    
     public void startDD(int c, int r) {
         if (!(grille[c][r] instanceof CaseSymbole)){
            continu = false;
        }else{
            startSymbol = ((CaseSymbole) grille[c][r]).getNbSymbole();
        }
        
        this.stopped = false ;
        System.out.println("startDD : " + c + "-" + r);
        this.started = true ;
        
        check(c,r);
        setChanged();
        notifyObservers();
        
        
    }
    
    public void stopDD(int c, int r) {

        // mémoriser le dernier objet renvoyé par parcoursDD pour connaitre la case de relachement

        if (grille[c][r] instanceof CaseSymbole){
            if (startSymbol != ((CaseSymbole) grille[lastC][lastR]).getNbSymbole()){
                continu = false;}          
        }else{
            continu = false;
        }
        chContinu[startSymbol] = continu;

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
                if (isOver()){System.out.println("gagné");}
        }

    public void parcoursDD(int c, int r) {
        lastC = c;
        lastR = r;
        this.started = false ;
        
        if (grille[r][c] instanceof CaseChemin){
            chContinu[((CaseChemin) grille[r][c]).getNbChemin()] = false;
        }
                
        if (! (grille[r][c] instanceof CaseChemin ) && ! (grille[r][c] instanceof CaseSymbole )  )
        {
            ImageView imgv = grille[r][c].getImgv() ;
        grille[r][c] = new CaseChemin(r,c,imgv) ;
        lastChemin.add(grille[r][c]) ;
        

        
        if(lastChemin.size() > 3)
        {
            
            lastChemin.remove() ;
            System.out.println(lastChemin);
        }
        }
        else
        {
            
            this.lastChemin.clear();
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
    
    private boolean isOver(){
        for (var val : chContinu){
        System.out.println(val);}
         for (var l : grille){
             for(var cel : l){
                 if (!((cel instanceof CaseChemin) || (cel instanceof CaseSymbole))){
                     return false;
                 }
             }
         }
         return (chContinu[1] && chContinu[2] && !chContinu[0]);
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
