/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Objetos.Determinante;
import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author JAVIER1
 */
public class Panel extends JPanel{
    
    public Panel(){
        super();
        super.setBackground(Color.WHITE);
        super.setLayout(null);
    }
    
    public void drawText(Determinante determinant){
        for(int i=0; i<determinant.getTamaño(); i++){
            for(int j=0; j<determinant.getTamaño(); j++){
                Texto campo = new Texto(j,i);
                campo.setBounds(i*31, j*31, 30, 30);
                super.add(campo);
            }
        }
    }
    
    public void extraerDeterminant(Determinante determinant){
        for(int i=0; i<determinant.getTamaño(); i++){
            for(int j=0; j<determinant.getTamaño(); j++){
                extraer((Texto) this.getComponentAt(i*31, j*31),determinant);
            }
        }
    }
    
    private void extraer(Texto elemento, Determinante determinant){
        determinant.setElementoMatriz(elemento.getxM(), elemento.getyM(), Integer.valueOf(elemento.getText()));
    }
}
