package com.mycompany.TareaNo4;

import javax.swing.JFrame;
import Vista.ArbolBinarioGrafico;
import javax.swing.SwingUtilities;

public class TareaNo4 {

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable(){
        
            @Override
        public void run(){
            
            JFrame frame = new ArbolBinarioGrafico();
            frame.setSize(400, 400);
            frame.setVisible(true);
            
        }
    });
    }
}
