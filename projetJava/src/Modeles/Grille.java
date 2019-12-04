/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modeles;

import java.util.PriorityQueue;
import java.util.Queue;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Basile
 */
public class Grille {
    
    private Case[][] laGrille;

    

    

    public  Grille( Case[][] grille) {
        
        this.laGrille = grille ;

    }
    
    public void addCase(int row, int column, Case c) {
        
        this.laGrille[row][column] = c ;

    }
    
    public void buildChemin(Chemin leChemin)
    {
        
                    
                    
                    
                   
              
            
        }
        
       public void getSymbole2Cases( Case case1 , Case case2)
       {
            Case[] arrayQ = new Case[3];
            
            arrayQ[0] = case2 ;
            arrayQ[1] = case1 ;
            
           
                if(arrayQ[0].getX()==arrayQ[1].getX()-1 ||arrayQ[0].getX()==arrayQ[1].getX()+1 )
                {
                    
                      
                    this.laGrille[arrayQ[0].getX()][arrayQ[0].getY()].upateImage("vertical.png");
                    this.laGrille[arrayQ[1].getX()][arrayQ[1].getY()].upateImage("vertical.png");
                }
                else
                {
                    if(arrayQ[0].getY()==arrayQ[1].getY()+1 || arrayQ[0].getY()==arrayQ[1].getY()-1)
                    {
                         this.laGrille[arrayQ[0].getX()][arrayQ[0].getY()].upateImage("horizontal.png");
                         this.laGrille[arrayQ[1].getX()][arrayQ[1].getY()].upateImage("horizontal.png");
                         
                    }
                }
                
            } 
            
            
           
       
        
    
    
     public void getSymbole( Chemin c)
        {
            
            
            String ressource  = "yyy" ;
            Case[][] g = c.getGrille();
            
            Queue<Case> Q = c.getLastChemin() ;
           Case[] arrayQ = new Case[3];
           Q.toArray(arrayQ);
           if(Q.size() > 2)
           {
           
           }
           
           
           
           
           
           
            if( Q.size() > 1 && Q.size()< 3 )
            {
               this.getSymbole2Cases(arrayQ[1], arrayQ[0]);
                
            } 
            else if( Q.size() == 3)
            {
                
                if(arrayQ[2].getY() == arrayQ[0].getY() + 2 ||arrayQ[2].getY() == arrayQ[0].getY() -2 )
                {
                    this.getSymbole2Cases(arrayQ[2], arrayQ[1]);
                }
                else if (arrayQ[2].getX() == arrayQ[0].getX() + 2 ||arrayQ[2].getX() == arrayQ[0].getX() -2 )
                {
                    this.getSymbole2Cases(arrayQ[2], arrayQ[1]);
                    
                }
                else if((arrayQ[2].getY() == arrayQ[0].getY() + 1 && arrayQ[2].getX() == arrayQ[0].getX() + 1 ) || (arrayQ[2].getY() == arrayQ[0].getY() -1  && arrayQ[2].getX() == arrayQ[0].getX() -1 )   )
                {
                    System.out.println("basGauche ou hauDroit");
                   if( (arrayQ[0].getY() > arrayQ[1].getY()) ||(arrayQ[0].getX() < arrayQ[1].getX()) )
                   {
                       this.getSymbole2Cases(arrayQ[2], arrayQ[1]);
                       this.laGrille[arrayQ[1].getX()][arrayQ[1].getY()].upateImage("hautDroit.png");
                       
                   }
                   else
                   {
                       this.getSymbole2Cases(arrayQ[2], arrayQ[1]);
                       this.laGrille[arrayQ[1].getX()][arrayQ[1].getY()].upateImage("basGauche.png");
                   }
                    
                    
                }
                else{
                    System.out.println("hautGauche ou basDroit");
                    
                    if( (arrayQ[0].getY() > arrayQ[1].getY()) ||(arrayQ[0].getX() > arrayQ[1].getX()) )
                   {
                       this.getSymbole2Cases(arrayQ[2], arrayQ[1]);
                      this.laGrille[arrayQ[1].getX()][arrayQ[1].getY()].upateImage("basDroit.png");
                       
                   }
                   else
                   {
                       this.getSymbole2Cases(arrayQ[2], arrayQ[1]);
                      
                       this.laGrille[arrayQ[1].getX()][arrayQ[1].getY()].upateImage("hautGauche.png");
                   }
                    
                    
                    
                }
                
                
            }
              
            
            
          
        }
         public boolean isOver(){
         for (var l : laGrille){
             for(var cel : l){
                 if (!((cel instanceof CaseChemin) || (cel instanceof Symbole))){
                     return false;
                 }
             }
         }
         return (chContinu[1] && chContinu[2] && !chContinu[0]);
     }
    
}
