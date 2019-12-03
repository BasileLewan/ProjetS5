/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modeles;

import javafx.scene.image.ImageView;

/**
 *
 * @author Basile
 */
public class CaseChemin extends Case {
    private int x, y; // 0 = haut, 1 = droite etc
    
    private String ressource ;
    
    public CaseChemin(int x, int y, ImageView imgv){
        super(imgv,x , y);
      
    }

    public CaseChemin() {
        super(null,-1 , -1);
        
    }
}
