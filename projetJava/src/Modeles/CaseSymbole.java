
package Modeles;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class CaseSymbole extends Case{
    
    private final int nbSymbole;
    
    public CaseSymbole(ImageView m_imgv, int x, int y, int no) {
        super(m_imgv, x, y);
        this.nbSymbole = no;
    }
    
    public void upateImageSymbole (String ressource)
    {
        
                this.imgv.setImage(new Image (this.getClass().getResource(ressource).toExternalForm()));

    }

    public int getNbSymbole() {
        return nbSymbole;
    }
    
    
    
}
