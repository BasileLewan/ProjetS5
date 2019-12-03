
package Modeles;

import java.util.Observable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Case extends Observable implements Comparable{

    private ImageView imgv;
    
    private int x,y ;
    
    
    
    
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
        
        this.imgv.setImage(new Image (this.getClass().getResource(ressource).toExternalForm()));
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
    
    
    
   
    
    

}
