
package Modeles;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Case{

    private ImageView imgv;
    
    Image img = new Image((getClass().getResource("caseVide.png").toExternalForm()));
    
    public Case(ImageView m_imgv){
        this.imgv = m_imgv;
    }
    

    }

    public ImageView getImgv() {
        return imgv;
        
    }
    
    

}
