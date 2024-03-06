package Vista;

import Controlador.ArbolAVL;
import Controlador.NodoArbol;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class ArbolBinarioGrafico extends javax.swing.JFrame {
    
    private JPanel ventana;
    
    ArbolAVL arbol= new ArbolAVL();
    
    public ArbolBinarioGrafico() {
        
        super("Arbol AVL Grafico");
        
  
   arbol.insertar(10);
   arbol.insertar(5); 
   arbol.insertar(13);
   arbol.insertar(1);
   arbol.insertar(6);
   arbol.insertar(17);
   arbol.insertar(16);
   
    }
    
    public int drawTree(Graphics g, NodoArbol x, int x0, int x1, int y){
        
        int m = (x0 + x1) /2;
        g.setColor(Color.red);
        g.fillOval(m, y, 50, 40);
        g.setColor(Color.CYAN);
        g.setFont(new Font("Arial", Font.BOLD,20));
        String t = String.valueOf(x.dato);
        g.drawString(t, m+20, y+30);
        if(x.hijoIzquierdo != null){
            int x2 = drawTree(g, x.hijoIzquierdo, x0, m, y+50);
            g.drawLine(m+25, y+40, x2+25, y+50);
        }
        if(x.hijoDerecho != null){
            int x2 = drawTree(g, x.hijoDerecho, m, x1, y+50);
            g.drawLine(m+25, y+40, x2+25, y+50);  
        }
        return m;
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        drawTree(g, arbol.obtenerRaiz(), 0, this.getWidth()-25,100);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
  
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ArbolBinarioGrafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ArbolBinarioGrafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ArbolBinarioGrafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ArbolBinarioGrafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ArbolBinarioGrafico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
