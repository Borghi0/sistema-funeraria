package View;

import Control.Banco_Ctrl;
import com.github.weisj.darklaf.DarkLaf;
import com.github.weisj.darklaf.LafManager;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import Model.Banco;
import javax.swing.JOptionPane;


public class JConexaoBD extends javax.swing.JFrame {
    private static JConexaoBD instancia;
    
    private JConexaoBD() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public static JConexaoBD getInstancia(){
        if(instancia==null) instancia = new JConexaoBD();
        return instancia;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rtUser = new javax.swing.JLabel();
        rtSenha = new javax.swing.JLabel();
        rtURL = new javax.swing.JLabel();
        rtBd = new javax.swing.JLabel();
        cxURL = new javax.swing.JTextField();
        cxUser = new javax.swing.JTextField();
        csSenha = new javax.swing.JPasswordField();
        btConectar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Conexão");

        rtUser.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtUser.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rtUser.setText("Usuário:");

        rtSenha.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtSenha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rtSenha.setText("Senha:");

        rtURL.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtURL.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rtURL.setText("URL:");

        rtBd.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        rtBd.setText("Conecte-se ao BD");

        cxURL.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cxURL.setToolTipText("");
        cxURL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cxURLKeyPressed(evt);
            }
        });

        cxUser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cxUser.setToolTipText("");
        cxUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cxUserKeyPressed(evt);
            }
        });

        csSenha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        csSenha.setToolTipText("");
        csSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                csSenhaKeyPressed(evt);
            }
        });

        btConectar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btConectar.setText("Confirmar");
        btConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConectarActionPerformed(evt);
            }
        });
        btConectar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btConectarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btConectar)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(rtURL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rtUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cxURL, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                                .addComponent(cxUser)
                                .addComponent(csSenha))))
                    .addComponent(rtBd))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addComponent(rtBd)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rtURL, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cxURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cxUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(csSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btConectar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConectarActionPerformed
        conectar();
    }//GEN-LAST:event_btConectarActionPerformed

    private void btConectarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btConectarKeyPressed
        conectar(evt);
    }//GEN-LAST:event_btConectarKeyPressed

    private void cxURLKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cxURLKeyPressed
        conectar(evt);
    }//GEN-LAST:event_cxURLKeyPressed

    private void cxUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cxUserKeyPressed
        conectar(evt);
    }//GEN-LAST:event_cxUserKeyPressed

    private void csSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_csSenhaKeyPressed
        conectar(evt);
    }//GEN-LAST:event_csSenhaKeyPressed

    
    private void conectar(){
        Banco banco = new Banco(
                cxURL.getText(), 
                String.valueOf(csSenha.getPassword()), 
                cxUser.getText()
        );
        Banco_Ctrl.getInstancia().setBanco(banco);
        
        try {
            Banco_Ctrl.getInstancia().testarConexao();
            Banco_Ctrl.getInstancia().criarTabelas();
            JOptionPane.showMessageDialog(
                null,
                "Conexão bem-sucedida!",
                "Sucesso",
                JOptionPane.INFORMATION_MESSAGE
            );            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                null,
                "Erro ao conectar ao banco de dados:\n" + e,
                "Erro de Conexão",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        
        Banco_Ctrl.getInstancia().setInicializadorBD(Config.MySQLInicializadorBD.getInstancia());
        try {            
            Banco_Ctrl.getInstancia().criarTabelas();            
            dispose();
            JLogin.getInstancia().setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                null,
                "Erro ao criar o banco de dados:\n" + e,
                "Erro de inicialização",
                JOptionPane.ERROR_MESSAGE
            );            
        }
    }
    private void conectar(java.awt.event.KeyEvent evt){
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER) conectar();
    }
    
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        LafManager.install(new com.github.weisj.darklaf.theme.OneDarkTheme());
        try {        
            //UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatDarculaLaf());
            UIManager.setLookAndFeel(new DarkLaf());
        }
        catch (UnsupportedLookAndFeelException e) {}
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                getInstancia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConectar;
    private javax.swing.JPasswordField csSenha;
    private javax.swing.JTextField cxURL;
    private javax.swing.JTextField cxUser;
    private javax.swing.JLabel rtBd;
    private javax.swing.JLabel rtSenha;
    private javax.swing.JLabel rtURL;
    private javax.swing.JLabel rtUser;
    // End of variables declaration//GEN-END:variables
}
