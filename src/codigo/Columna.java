/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author niko-
 */
public class Columna {
    Rectangle2D barra;
    int altura_columna = 120;
    int ancho_columna = 60;
    private int ancho_pantalla;
    Image palo;
   

 public Columna (int _ancho, int _anchoPantalla){
    Random aleatorio = new Random();
    int desplazamiento = aleatorio.nextInt(400 - 250);
    barra = new Rectangle2D.Double(_ancho, 
                                        -desplazamiento - ancho_columna/2, 
                                        ancho_columna, 
                                        altura_columna);
   
     
    }


 private void precargaImagenes(){
         
        palo = (new ImageIcon(new ImageIcon(
                getClass().getResource("C:\\Users\\niko-\\Desktop\\DAM\\Programación\\NetBeans\\Sin título.jpg"))
                .getImage().getScaledInstance(79, 500, Image.SCALE_DEFAULT)))
                .getImage();
    }
 
  public void mueve(Graphics2D g2){
        mueveColumna();     
        
        g2.drawImage(palo, (int)barra.getX(), (int)barra.getY()+ancho_columna/2, null);
        g2.setColor(Color.BLUE);
        g2.fill(barra);
        
    }
    
    private void mueveColumna(){
        if (barra.getX() + ancho_columna < 0){
            Random aleatorio = new Random();
            int desplazamiento = aleatorio.nextInt(300);
            barra.setFrame(ancho_pantalla, 
                            -desplazamiento - ancho_columna/2,
                            barra.getWidth(), 
                            barra.getHeight());
        }
        
        else{           
            barra.setFrame(barra.getX()-1, barra.getY(),barra.getWidth(), barra.getHeight());          
        }
    }
}

