
package Modeles;

import javafx.scene.canvas.*;


public class Case extends Canvas {
    private int posX, posY;
    
    public Case(int m_posX, int m_posY){
        super(50.0, 50.0);
        posX = m_posX;
        posY = m_posY;
    }
    
    @Override
    public String toString(){
        return " "  + posX + " - " + posY;
    }
}
