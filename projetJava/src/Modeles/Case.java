
package Modeles;

import java.util.Observable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Case extends Observable implements Comparable{

    ImageView imgv;
    
    private int x,y ;
    
    private String ressource ;
    
    
    
    
    public Case(ImageView m_imgv,int x ,int y){
        this.imgv = m_imgv;
        this.x = x ;
        this.y = y ;
        
       
    }
    

    

    public ImageView getImgv() {
        return imgv;
        
    }
    
    public void upateImage(String ressource)
    {
        if(! ( this instanceof CaseSymbole) )
        {
        
        this.imgv.setImage(new Image (this.getClass().getResource(ressource).toExternalForm()));
            this.ressource  =ressource ;
        
        setChanged();
        notifyObservers();
        }
        
        
    }

    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int compareTo(Object o) {
        return 0 ;
    }

    public String getRessource() {
        return ressource;
    }
    
    
    
   
    
    

}
