/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author niko-
 */
    
    public class Helicoptero extends Ellipse2D.Double{
    Color colorHelicoptero;
    int yVelocidad = -2;
    
    public Helicoptero(int _radio, Color _color){
        super(100, 100, _radio, _radio);
        colorHelicoptero = _color;
    }
   
    
    public void mueve(Graphics2D g2){
        this.y = this.y - yVelocidad;
        //pongo un tope para que no se salga por el techo
        if (this.y < 0) {
            this.y = 0;
            yVelocidad = -2;
        }
        g2.setColor(colorHelicoptero);
        g2.fill(this);
        yVelocidad -= 1;
        if (yVelocidad < -3){
            yVelocidad = -2;
            
            }
        }
    
    

      public boolean chequeaColision(Columna c){
       
        Area areaHelicoptero = new Area(this);
        Area areaColumna = new Area(this);
        
        boolean choca = true, choca2 = true;
        
        //chequeo el choque con el segundo pajaro
        areaHelicoptero.intersect(areaColumna);
       
        if (areaHelicoptero.isEmpty()){
            choca = false;
        }
        
        //chequeo el choque con el segundo pajaro
        areaHelicoptero = new Area(this);
        areaHelicoptero.intersect(areaColumna);
        if (areaHelicoptero.isEmpty()){
            choca2 = false;
        }
        
        return (this.intersects(c.barra) || 
                choca || choca2
                );
        }
    }


