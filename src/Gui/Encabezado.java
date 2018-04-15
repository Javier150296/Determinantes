/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Gui.listeners.EncabezadoListener;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author JAVIER1
 */
public class Encabezado extends JPanel{
    private JButton btnAceptar;
    private JTextField txtTamano;
    private JLabel lblTamano;
    private JButton btnCalcular;
    private EncabezadoListener listener;
    
    public Encabezado(){
        super();
        
        
        btnAceptar = new JButton("Aceptar");
        txtTamano = new JTextField("0");
        lblTamano = new JLabel("Tamaño: ");
        btnCalcular = new JButton("Calcular");
        
        txtTamano.setPreferredSize(new Dimension(60,30));
        txtTamano.setFont(new Font("Courier new", Font.BOLD, 24));
        txtTamano.setHorizontalAlignment(SwingConstants.CENTER);
        
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.btnAceptarOnClick(txtTamano.getText());
            }
        });
        
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.btnCalcularOnClick();
            }
        });
        super.add(lblTamano);
        super.add(txtTamano);
        super.add(btnAceptar);
        super.add(btnCalcular);
        
    }
    
    public void setListener(EncabezadoListener listener){
        this.listener=listener;
    }
}
