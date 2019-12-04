/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modeles;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author quent
 */
public class CaseSymbole extends Case{
    
    
    
    public CaseSymbole(ImageView m_imgv, int x, int y) {
        super(m_imgv, x, y);
    }
    
    public void upateImageSymbole (String ressource)
    {
        
                this.imgv.setImage(new Image (this.getClass().getResource(ressource).toExternalForm()));

    }
    
}
