package View;

import Interfaces.I_Navegador;
import Model.Usuario;
import javax.swing.JOptionPane;


public class JMenuUsuario extends javax.swing.JFrame implements I_Navegador{
    private static JMenuUsuario instancia;
    private Usuario usuario;
    
    public JMenuUsuario() {
        initComponents();        
        setLocationRelativeTo(null);
    }
    
    public static JMenuUsuario getInstancia(){
        if(instancia==null) instancia = new JMenuUsuario();
        return instancia;
    }        
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mnBar = new javax.swing.JMenuBar();
        mnOpcoes = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        mniCad = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mnOpcoes.setText("Opções");
        mnOpcoes.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem1.setText("Atualizar informações...");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mnOpcoes.add(jMenuItem1);

        mniCad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mniCad.setText("Sair...");
        mniCad.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        mniCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCadActionPerformed(evt);
            }
        });
        mnOpcoes.add(mniCad);

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

    private void mniCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCadActionPerformed
        sair();
    }//GEN-LAST:event_mniCadActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        jAlterarUsuario();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            usuario = null;
            dispose();
            JLogin.getInstancia().setVisible(true);
        }
    }        
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuBar mnBar;
    private javax.swing.JMenu mnOpcoes;
    private javax.swing.JMenuItem mniCad;
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
