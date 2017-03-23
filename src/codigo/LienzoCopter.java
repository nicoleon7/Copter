/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javafx.scene.paint.Color;
import javax.swing.Timer;



/**
 *
 * @author niko-
 */
public class LienzoCopter extends javax.swing.JFrame {
    
    boolean gameOver = false;
    
    Helicoptero miHelicoptero = new Helicoptero(30, java.awt.Color.WHITE);
    
    static int ANCHOPANTALLA = 700;
    static int ALTOPANTALLA = 400;
    static int SEPARACION_COLUMNAS = 100;
    
    Columna miColumna1 = new Columna(ANCHOPANTALLA, ALTOPANTALLA);
    Columna miColumna2 = new Columna(ANCHOPANTALLA + SEPARACION_COLUMNAS, ANCHOPANTALLA);
    Columna miColumna3 = new Columna(ANCHOPANTALLA + 2*SEPARACION_COLUMNAS, ANCHOPANTALLA);
    //Columna miColumna4 = new Columna(ANCHOPANTALLA + 3*SEPARACION_COLUMNAS, ANCHOPANTALLA);
    
        
    Suelo miSuelo1 = new Suelo(ANCHOPANTALLA, ALTOPANTALLA * 0.60);
    Suelo miSuelo2 = new Suelo(ANCHOPANTALLA, ALTOPANTALLA * 0.60);
    
    BufferedImage buffer = null;
    
    Graphics2D bufferGraphics, lienzoGraphics = null;
    
    int contador = 0;
    
     Timer temporizador = new Timer(10,new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            bucleDelJuego();
        }
    });

    /**
     * Creates new form LienzoCopter
     */
    public LienzoCopter() {
        initComponents();
        inicializaBuffers();
        temporizador.start();
    }
    
    private void inicializaBuffers(){
        lienzoGraphics = (Graphics2D) jPanel1.getGraphics();
        buffer = (BufferedImage) jPanel1.createImage(ANCHOPANTALLA, ALTOPANTALLA);
        bufferGraphics = buffer.createGraphics();
        
        bufferGraphics.setColor(java.awt.Color.BLACK);
        bufferGraphics.fillRect(0, 0, ANCHOPANTALLA, ALTOPANTALLA);
        
    }
    
    private void bucleDelJuego() {
        //limpio la pantalla
        if (miHelicoptero.chequeaColision(miColumna1)){temporizador.stop();}
        if (miHelicoptero.chequeaColision(miColumna2)){temporizador.stop();}
        if (miHelicoptero.chequeaColision(miColumna3)){temporizador.stop();}
        
        bufferGraphics.setColor(java.awt.Color.BLACK);
        bufferGraphics.fillRect(0, 0, ANCHOPANTALLA, ALTOPANTALLA);
        
        miHelicoptero.mueve(bufferGraphics); 
        miColumna1.mueve(bufferGraphics);
        miColumna2.mueve(bufferGraphics);
        miColumna3.mueve(bufferGraphics);
        
        
                
        lienzoGraphics.drawImage(buffer, 0, 0, null);
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {                                
       if (evt.getKeyCode() == KeyEvent.VK_SPACE){
           miHelicoptero.yVelocidad += 9;
       }
    }                               
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LienzoCopter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LienzoCopter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LienzoCopter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LienzoCopter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LienzoCopter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
