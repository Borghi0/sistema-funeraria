package com.mycompany.utfuneral;

import Control.NavegadorUI;
import com.github.weisj.darklaf.DarkLaf;
import com.github.weisj.darklaf.LafManager;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class UTFuneral {

    public static void main(String[] args) {
        
        LafManager.install(new com.github.weisj.darklaf.theme.OneDarkTheme());
        try {        
            //UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatDarculaLaf());
            UIManager.setLookAndFeel(new DarkLaf());
        }
        catch (UnsupportedLookAndFeelException e) {}
        
        
        NavegadorUI navegador = new NavegadorUI();        
        navegador.mostrarJConexaoBD();
    }
}
