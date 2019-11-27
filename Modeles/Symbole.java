
package Modeles;

import Modeles.Case;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;

/**
 *
 * @author quent
 */
public class Symbole  {
    
    private int height ;
    
    private int width ;
    
    private String path ;
    
    private boolean motif ;
    
    private Case laCase ;
    
    public Symbole(int h, int w, String p, boolean m)
    {
        super();
        this.height = h ;
        this.path = p ;
        this.width = w ;
        this.motif = m ;
       
    }
    public Symbole(int h, int w, String p)
    {
        super();
        this.height = h ;
        this.path = p ;
        this.width = w ;
        
       
    }
    
    
    public ImageView getImageView(){
        
        System.out.print(getClass().getResource(this.path));
        System.out.print(this.path);
        Image img = new Image((this.getClass().getResource(this.path).toExternalForm()));
        ImageView imgv  = new ImageView(img);
         
        imgv.setFitWidth(this.width);
        imgv.setFitHeight(this.height);
            
            
            
            return imgv ;
        
    }
    
    
    
    
    
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
    
    
}

