package View;

import Control.NavegadorUI;
import Control.Usuario_Ctrl;
import Model.Usuario;
import com.github.weisj.darklaf.LafManager;
import javax.swing.JOptionPane;
import javax.swing.UIManager;


public final class JLogin extends javax.swing.JFrame {
    private NavegadorUI navegador;
    
    
    public JLogin(NavegadorUI navegador) {
        this.navegador = navegador;
        initComponents();
        rtErro.setVisible(false);
        placeholder(true);
        setLocationRelativeTo(null);
    }   

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rtEmail = new javax.swing.JLabel();
        rtSenha = new javax.swing.JLabel();
        rtErro = new javax.swing.JLabel();
        cxEmail = new javax.swing.JTextField();
        csSenha = new javax.swing.JPasswordField();
        btCad = new javax.swing.JButton();
        btEnt = new javax.swing.JButton();
        mnBar = new javax.swing.JMenuBar();
        mnOpcoes = new javax.swing.JMenu();
        mniCad = new javax.swing.JMenuItem();
        mniCon = new javax.swing.JMenuItem();
        mniSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu login");

        rtEmail.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtEmail.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rtEmail.setText("Email:");

        rtSenha.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtSenha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rtSenha.setText("Senha:");

        rtErro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rtErro.setForeground(new java.awt.Color(255, 0, 0));
        rtErro.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rtErro.setText("Email ou senha incorretos");

        cxEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cxEmail.setToolTipText("");
        cxEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cxEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cxEmailFocusLost(evt);
            }
        });
        cxEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cxEmailKeyPressed(evt);
            }
        });

        csSenha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        csSenha.setToolTipText("");
        csSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                csSenhaKeyPressed(evt);
            }
        });

        btCad.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btCad.setText("Cadastrar-se");
        btCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadActionPerformed(evt);
            }
        });
        btCad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btCadKeyPressed(evt);
            }
        });

        btEnt.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btEnt.setText("Entrar");
        btEnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEntActionPerformed(evt);
            }
        });
        btEnt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btEntKeyPressed(evt);
            }
        });

        mnOpcoes.setText("Opções");
        mnOpcoes.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N

        mniCad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mniCad.setText("Cadastrar-se...");
        mniCad.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        mniCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCadActionPerformed(evt);
            }
        });
        mnOpcoes.add(mniCad);

        mniCon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mniCon.setText("Conectar-se...");
        mniCon.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        mniCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniConActionPerformed(evt);
            }
        });
        mnOpcoes.add(mniCon);

        mniSair.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mniSair.setText("Fechar aplicação");
        mniSair.setAlignmentX(0.6F);
        mniSair.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        mniSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniSairActionPerformed(evt);
            }
        });
        mnOpcoes.add(mniSair);

        mnBar.add(mnOpcoes);

        setJMenuBar(mnBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(225, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rtErro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(csSenha)
                            .addComponent(cxEmail)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btCad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btEnt, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(225, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(150, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cxEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(csSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rtErro, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btEnt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(150, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadActionPerformed
        jCad();
    }//GEN-LAST:event_btCadActionPerformed

    private void btEntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEntActionPerformed
        entrar();
    }//GEN-LAST:event_btEntActionPerformed

    private void mniCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCadActionPerformed
        jCad();
    }//GEN-LAST:event_mniCadActionPerformed

    private void cxEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cxEmailFocusGained
        placeholder(false);
    }//GEN-LAST:event_cxEmailFocusGained

    private void cxEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cxEmailFocusLost
        placeholder(true);
    }//GEN-LAST:event_cxEmailFocusLost

    private void mniSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mniSairActionPerformed

    private void cxEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cxEmailKeyPressed
        entrar(evt);
    }//GEN-LAST:event_cxEmailKeyPressed

    private void csSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_csSenhaKeyPressed
        entrar(evt);
    }//GEN-LAST:event_csSenhaKeyPressed

    private void btEntKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btEntKeyPressed
        entrar(evt);
    }//GEN-LAST:event_btEntKeyPressed

    private void btCadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btCadKeyPressed
        jCad(evt);
    }//GEN-LAST:event_btCadKeyPressed

    private void mniConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniConActionPerformed
        jCon();
    }//GEN-LAST:event_mniConActionPerformed

    public void entrar(){
        cxEmail.setText(cxEmail.getText().replaceAll("\\s+", ""));
        try {
            Usuario usuario = Usuario_Ctrl.getInstancia().ler_User_Login(cxEmail.getText());            
            
            if(usuario!=null && usuario.getSenha().equals(String.valueOf(csSenha.getPassword()))){
                dispose();
                navegador.logar(usuario);
                csSenha.setText("");
                rtErro.setVisible(false);
            }
            else{
                rtErro.setVisible(true);
            }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                null,
                ex,
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
    public void entrar(java.awt.event.KeyEvent evt){
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER) entrar();
    }
    
    public void jCad(){
        setVisible(false);
        rtErro.setVisible(false);
        navegador.mostrarJCadastro();
    }
    public void jCad(java.awt.event.KeyEvent evt){
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER) jCad();
    }
    
    public void jCon(){
        setVisible(false);
        navegador.mostrarJConexaoBD();        
    }
    
    public void placeholder(boolean add){
        if(cxEmail.getText().isBlank() && add){
            cxEmail.setText("email");
            cxEmail.setForeground(UIManager.getColor("Label.disabledForeground"));
        }
        else if(cxEmail.getForeground().equals(UIManager.getColor("Label.disabledForeground")) && !add){
            cxEmail.setText("");
            cxEmail.setForeground(UIManager.getColor("TextField.foreground"));
        }
    }
    
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        LafManager.install(new com.github.weisj.darklaf.theme.OneDarkTheme());
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JLogin(new NavegadorUI());
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCad;
    private javax.swing.JButton btEnt;
    private javax.swing.JPasswordField csSenha;
    private javax.swing.JTextField cxEmail;
    private javax.swing.JMenuBar mnBar;
    private javax.swing.JMenu mnOpcoes;
    private javax.swing.JMenuItem mniCad;
    private javax.swing.JMenuItem mniCon;
    private javax.swing.JMenuItem mniSair;
    private javax.swing.JLabel rtEmail;
    private javax.swing.JLabel rtErro;
    private javax.swing.JLabel rtSenha;
    // End of variables declaration//GEN-END:variables

    
}
