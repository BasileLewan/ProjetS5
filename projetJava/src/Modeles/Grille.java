
package Modeles;

import java.util.Observable;
import java.util.PriorityQueue;
import java.util.Queue;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Grille extends Observable  {
    
    private Case[][] laGrille;
    

    

    

    public  Grille( Case[][] grille) {
        
        this.laGrille = grille ;

    }
    
    public void addCase(int row, int column, Case c) {
        
        this.laGrille[row][column] = c ;

    }
    
    public void createPuzzle()
    {
        
        
                CaseSymbole s1 = new CaseSymbole(this.laGrille[3][4].getImgv(),3,4,1);
                CaseSymbole s1_2 = new CaseSymbole(this.laGrille[4][0].getImgv(),4,4,2);
        
        this.laGrille[3][4] = s1 ;
        this.laGrille[4][0] = s1_2 ;
        
     
                
        
        
         
         CaseSymbole s2 = new CaseSymbole(this.laGrille[0][0].getImgv(),0,0,1);
         CaseSymbole s2_2 = new CaseSymbole(this.laGrille[4][4].getImgv(),4,4,2);
        
        this.laGrille[0][0] = s2 ;
        this.laGrille[4][4] = s2_2 ;
        
       s2.upateImageSymbole("fleur.jpg");
        
       s1.upateImageSymbole("fleur.jpg");
       
       s2_2.upateImageSymbole("fleur2.jpg");
        
       s1_2.upateImageSymbole("fleur2.jpg");
        
        
    }
    
    
    public void clean()
    {
        for (int i = 0 ; i<5 ; i++)
        {
            
            for (int j = 0 ; j<5 ; j++)
            {
                if ( !(laGrille[i][j] instanceof CaseSymbole))
                {
                Case c =new Case(laGrille[i][j].getImgv() ,i,j ) ;
                
                    this.laGrille[i][j]= c ;
                    
                    c.upateImage("caseVide.png");
                    
                }
                    
                
            }
        }
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
            
            setChanged();
         notifyObservers();
            
          
        }
     
}
