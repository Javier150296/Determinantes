/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Gui.listeners.EncabezadoListener;
import Objetos.Determinante;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author JAVIER1
 */
public class Principal extends JFrame{
    private Encabezado encabezado;
    private Panel panel;
    private Determinante determinant;
    
    public Principal(String title){
        
        super(title);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(400,100);
        super.setLayout(new BorderLayout());
        
        encabezado = new Encabezado();
        panel= new Panel();
        
        encabezado.setListener(new EncabezadoListener() {
            @Override
            public void btnAceptarOnClick(String n) {
                panel.removeAll();
                Principal.this.determinant= new Determinante(Integer.valueOf(n));
                panel.drawText(determinant);
                Principal.this.setSize(400,Integer.valueOf(n)*30+100 );
                Principal.this.repaint();
                
            }

            @Override
            public void btnCalcularOnClick() {
                panel.extraerDeterminant(determinant);
                JOptionPane.showMessageDialog(Principal.this, determinant.resultado(),"Determinante Resultante", JOptionPane.PLAIN_MESSAGE);
            }
        });
        
        super.add(encabezado,BorderLayout.NORTH);
        super.add(panel,BorderLayout.CENTER);
        super.setVisible(true);
    }
}
