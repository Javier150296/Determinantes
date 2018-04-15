/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author JAVIER1
 */
public class Determinante {
    private int determinant[][];
    private Integer tamaño;
    
            
    public Determinante(){
         
    }
    public Determinante(Integer n){
        this.tamaño=n;
        this.determinant= new int[n][n];
    }

    public Integer getTamaño() {
        return tamaño;
    }

    public void setTamaño(Integer tamaño) {
        this.tamaño = tamaño;
    }
    
    public void setElementoMatriz(Integer posx, Integer posy, int elemento){
        this.determinant[posy][posx]=elemento;
    }
    
    public String resultado(){
        return String.format("Determinante = %d", this.determinante(determinant, tamaño));
    }
    
    private Integer determinante(int[][] det, Integer size) {
        Integer resultado= 0;

        if (size == 1) {
            return det[0][0];
        } else {
            int signo = 1;
            for (int i = 0; i < size; i++) {
                resultado += signo * (det[0][i] * determinante(submatriz(det, 0, i, size), size - 1));
                signo *= -1;
            }
        }
        return resultado;
    }

    private int[][] submatriz(int[][] matriz, Integer fila, Integer columna, Integer size) {
        int subM[][] = new int[size - 1][size - 1];
        Integer x = 0;
        Integer y = 0;
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i != fila && j != columna) {
                    subM[x][y] = matriz[i][j];
                    y++;
                }
            }
            if (i != fila) {
                x++;
                y = 0;
            }
        }
        return subM;
    }
}
