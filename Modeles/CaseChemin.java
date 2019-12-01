/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modeles;

/**
 *
 * @author Basile
 */
public class CaseChemin extends Case {
    int entree, sortie; // 0 = haut, 1 = droite etc
    
    public CaseChemin(int x, int y, int in, int out){
        entree = in;
        sortie = out;
    }
}
