
package Modeles;

import javafx.scene.image.ImageView;



public class CaseChemin extends Case {
    private int x, y; // 0 = haut, 1 = droite etc
    
    private String ressource ;
    
    private int nbChemin;

    
    public CaseChemin(int x, int y, ImageView imgv){
        super(imgv,x , y);
      
    }

    public CaseChemin() {
        super(null,-1 , -1);
        
    }
        public int getNbChemin() {
        return nbChemin;
    }
}
