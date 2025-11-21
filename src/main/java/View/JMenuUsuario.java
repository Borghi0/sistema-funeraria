package View;

import Control.NavegadorUI;
import Model.Usuario;
import javax.swing.JOptionPane;
import Interfaces.I_JanelaRaiz;


public class JMenuUsuario extends javax.swing.JFrame implements I_JanelaRaiz{
    private NavegadorUI navegador;
    private Usuario usuario;
    
    public JMenuUsuario(NavegadorUI navegador, Usuario usuario) {
        this.navegador = navegador;
        this.usuario = usuario;
        initComponents();        
        setLocationRelativeTo(null);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mnBar = new javax.swing.JMenuBar();
        mnOpcoes = new javax.swing.JMenu();
        miAdqPlano = new javax.swing.JMenuItem();
        miAltInfo = new javax.swing.JMenuItem();
        miSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mnOpcoes.setText("Opções");
        mnOpcoes.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N

        miAdqPlano.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        miAdqPlano.setText("Adquirir plano...");
        miAdqPlano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAdqPlanoActionPerformed(evt);
            }
        });
        mnOpcoes.add(miAdqPlano);

        miAltInfo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        miAltInfo.setText("Atualizar informações...");
        miAltInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAltInfoActionPerformed(evt);
            }
        });
        mnOpcoes.add(miAltInfo);

        miSair.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        miSair.setText("Sair...");
        miSair.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        miSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSairActionPerformed(evt);
            }
        });
        mnOpcoes.add(miSair);

        mnBar.add(mnOpcoes);

        setJMenuBar(mnBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 860, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 539, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSairActionPerformed
        sair();
    }//GEN-LAST:event_miSairActionPerformed

    private void miAltInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAltInfoActionPerformed
        jAlterarUsuario();
    }//GEN-LAST:event_miAltInfoActionPerformed

    private void miAdqPlanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAdqPlanoActionPerformed
        navegador.mostrarJRelatorioPlano(usuario);
    }//GEN-LAST:event_miAdqPlanoActionPerformed

    private void jAlterarUsuario(){        
        setVisible(false);
        new JAlterarUsuario(this, usuario).setVisible(true);
    }
    
    private void sair(){
        int o = JOptionPane.showOptionDialog(                
                null,
                "Realmente deseja sair?",
                "Sair",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, 
                null,
                new Object[] {"Sim", "Não"},
                "Não"
        );
        if(o==0){            
            navegador.deslogar();
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem miAdqPlano;
    private javax.swing.JMenuItem miAltInfo;
    private javax.swing.JMenuItem miSair;
    private javax.swing.JMenuBar mnBar;
    private javax.swing.JMenu mnOpcoes;
    // End of variables declaration//GEN-END:variables
        
    public Usuario getUsuario(){
        return usuario;
    }
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }

    @Override
    public void voltar() {}
    @Override
    public void voltar(Object objeto) {
        usuario = (Usuario) objeto;
        this.setVisible(true);        
    }
}
