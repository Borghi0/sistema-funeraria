package View;


import Control.Usuario_Ctrl;
import Model.Usuario;
import com.github.weisj.darklaf.*;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class JCadastro extends javax.swing.JFrame {
    private static JCadastro instancia;
    
    private JCadastro() {
        initComponents();
        rtCadInfo.setVisible(false);
        setLocationRelativeTo(null);
        
        cxEmail.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                rtErroEmail.setText("");
                cxEmail.setForeground(UIManager.getColor("TextField.foreground"));
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                rtErroEmail.setText("");
                cxEmail.setForeground(UIManager.getColor("TextField.foreground"));
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        cxUser.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                rtErroUser.setText("");
                cxUser.setForeground(UIManager.getColor("TextField.foreground"));
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                rtErroUser.setText("");
                cxUser.setForeground(UIManager.getColor("TextField.foreground"));
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });        
    }

    public static JCadastro getInstancia(){
        if(instancia == null) instancia = new JCadastro();
        return instancia;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cxNome = new javax.swing.JTextField();
        rtTelefone = new javax.swing.JLabel();
        cxTelefone = new javax.swing.JTextField();
        rtCSenha = new javax.swing.JLabel();
        rtSenha = new javax.swing.JLabel();
        csSenha = new javax.swing.JPasswordField();
        csCSenha = new javax.swing.JPasswordField();
        rtEmail = new javax.swing.JLabel();
        cxEmail = new javax.swing.JTextField();
        rtUser = new javax.swing.JLabel();
        cxUser = new javax.swing.JTextField();
        rtNome = new javax.swing.JLabel();
        btVoltar = new javax.swing.JButton();
        btComf = new javax.swing.JButton();
        rtErroUser = new javax.swing.JLabel();
        rtErroEmail = new javax.swing.JLabel();
        rtCadInfo = new javax.swing.JLabel();
        rtCPF = new javax.swing.JLabel();
        cxCPF = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro");

        cxNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cxNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cxNomeFocusLost(evt);
            }
        });
        cxNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cxNomeKeyPressed(evt);
            }
        });

        rtTelefone.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtTelefone.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rtTelefone.setText("Telefone:");

        cxTelefone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cxTelefone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cxTelefoneFocusLost(evt);
            }
        });
        cxTelefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cxTelefoneKeyPressed(evt);
            }
        });

        rtCSenha.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtCSenha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rtCSenha.setText("Comfirmar senha:");

        rtSenha.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtSenha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rtSenha.setText("Senha:");

        csSenha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        csSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                csSenhaKeyPressed(evt);
            }
        });

        csCSenha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        csCSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                csCSenhaKeyPressed(evt);
            }
        });

        rtEmail.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtEmail.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rtEmail.setText("Email:");

        cxEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cxEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cxEmailFocusLost(evt);
            }
        });
        cxEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cxEmailKeyPressed(evt);
            }
        });

        rtUser.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtUser.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rtUser.setText("Nome de Usuario:");

        cxUser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cxUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cxUserFocusLost(evt);
            }
        });
        cxUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cxUserKeyPressed(evt);
            }
        });

        rtNome.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtNome.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rtNome.setText("Nome:");

        btVoltar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });
        btVoltar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btVoltarKeyPressed(evt);
            }
        });

        btComf.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btComf.setText("Comfirmar");
        btComf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btComfActionPerformed(evt);
            }
        });
        btComf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btComfKeyPressed(evt);
            }
        });

        rtErroUser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rtErroUser.setForeground(new java.awt.Color(255, 0, 0));
        rtErroUser.setMinimumSize(new java.awt.Dimension(120, 0));

        rtErroEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rtErroEmail.setForeground(new java.awt.Color(255, 0, 0));
        rtErroEmail.setMinimumSize(new java.awt.Dimension(120, 0));

        rtCadInfo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rtCadInfo.setForeground(new java.awt.Color(255, 0, 0));
        rtCadInfo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rtCadInfo.setText("Preencha todos os campos");

        rtCPF.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtCPF.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rtCPF.setText("CPF:");

        cxCPF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cxCPF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cxCPFFocusLost(evt);
            }
        });
        cxCPF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cxCPFKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(131, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(rtCSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(rtCadInfo)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(csCSenha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                                        .addComponent(csSenha, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(btComf)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(rtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rtNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rtTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rtUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cxEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                                    .addComponent(cxNome, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cxTelefone, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cxCPF, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cxUser))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rtErroEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(rtErroUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btVoltar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rtErroUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rtErroEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cxUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cxEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cxNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cxTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cxCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(csSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rtCSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(csCSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rtCadInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btComf, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        voltar();
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btComfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btComfActionPerformed
        cadastrar();        
    }//GEN-LAST:event_btComfActionPerformed

    private void btComfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btComfKeyPressed
        cadastrar(evt);
    }//GEN-LAST:event_btComfKeyPressed

    private void cxUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cxUserKeyPressed
        cadastrar(evt);
    }//GEN-LAST:event_cxUserKeyPressed

    private void cxEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cxEmailKeyPressed
        cadastrar(evt);
    }//GEN-LAST:event_cxEmailKeyPressed

    private void cxNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cxNomeKeyPressed
        cadastrar(evt);
    }//GEN-LAST:event_cxNomeKeyPressed

    private void cxTelefoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cxTelefoneKeyPressed
        cadastrar(evt);
    }//GEN-LAST:event_cxTelefoneKeyPressed

    private void csCSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_csCSenhaKeyPressed
        cadastrar(evt);
    }//GEN-LAST:event_csCSenhaKeyPressed

    private void btVoltarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btVoltarKeyPressed
        voltar(evt);
    }//GEN-LAST:event_btVoltarKeyPressed

    private void cxTelefoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cxTelefoneFocusLost
        cxTelefone.setText(cxTelefone.getText().replaceAll("[^0-9]", ""));
    }//GEN-LAST:event_cxTelefoneFocusLost

    private void cxUserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cxUserFocusLost
        cxUser.setText(cxUser.getText().replaceAll("\\s+", ""));
    }//GEN-LAST:event_cxUserFocusLost

    private void cxEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cxEmailFocusLost
        cxEmail.setText(cxEmail.getText().replaceAll("\\s+", ""));
    }//GEN-LAST:event_cxEmailFocusLost

    private void cxNomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cxNomeFocusLost
        cxNome.setText(cxNome.getText().trim());
    }//GEN-LAST:event_cxNomeFocusLost

    private void cxCPFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cxCPFFocusLost
        cxCPF.setText(cxCPF.getText().replaceAll("[^0-9]", ""));
    }//GEN-LAST:event_cxCPFFocusLost

    private void cxCPFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cxCPFKeyPressed
        cadastrar(evt);
    }//GEN-LAST:event_cxCPFKeyPressed

    private void csSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_csSenhaKeyPressed
        cadastrar(evt);
    }//GEN-LAST:event_csSenhaKeyPressed

    public void voltar(){
        dispose();
        JLogin.getInstancia().setVisible(true);
    }
    public void voltar(java.awt.event.KeyEvent evt){
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER) voltar();
    }
    
    public void cadastrar(){
                
        // ver se segue boas praticas (claramente n):
        cxUser.setText(cxUser.getText().replaceAll("\\s+", ""));
        cxEmail.setText(cxEmail.getText().replaceAll("\\s+", ""));
        cxNome.setText(cxNome.getText().trim());
        cxTelefone.setText(cxTelefone.getText().replaceAll("[^0-9]", ""));        
        cxCPF.setText(cxCPF.getText().replaceAll("[^0-9]", ""));
        
        // criar classes de verificação para usar aqui ou no metodo cad_User,
        // por exemplo: senha = confirma senha; CPF é válido...
        
        Usuario usuario = new Usuario(
            cxUser.getText(),
            String.valueOf(csSenha.getPassword()),
            cxTelefone.getText(),
            false,
            null, // acrescentar caixas de texto para endereco
            null,
            cxNome.getText(),
            cxCPF.getText(),
            null // acrescentar caixa de texto para data de natalidade
        );
        
        try {
            Usuario_Ctrl.getInstancia().cad_User(usuario);
            JOptionPane.showMessageDialog(
                null,
                "Usuário cadastrado com sucesso!",
                "Sucesso",
                JOptionPane.INFORMATION_MESSAGE
            );
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                null,
                "Erro ao cadastrar usuário:\n" + e,
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );
        }
            /*       Codigo de referencia
            
            boolean c = false;
            try{
            UsuarioControle.cadastrar(cxNome.getText(), cxCPF.getText(), cxEmail.getText(),
            String.valueOf(csSenha.getPassword()), String.valueOf(csCSenha.getPassword()),
            cxUser.getText(), false, false);
            }
            catch(IllegalArgumentException iae){
            c = true;
            rtCadInfo.setForeground(Color.red);
            rtCadInfo.setVisible(true);
            rtCadInfo.setText(iae.getMessage());
            if(iae.getMessage().equals("Email")) rtErro(1);
            else if(iae.getMessage().equals("User")) rtErro(2);
            else if(iae.getMessage().equals("UserEmail")) rtErro(3);
            }
            if(!c){
            limpar();
            rtCadInfo.setForeground(UIManager.getColor("TextField.foreground"));
            rtCadInfo.setText("Cadastrado com sucesso!");
            rtCadInfo.setVisible(true);
            }
            */        
    }
    public void cadastrar(java.awt.event.KeyEvent evt){
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER) cadastrar();
    }
    
    public void limpar(){
        cxUser.setText("");
        cxEmail.setText("");
        cxNome.setText("");
        cxCPF.setText("");
        csSenha.setText("");
        csCSenha.setText("");
        cxUser.requestFocus();
    }
    
    public void rtErro(int erro){
        switch (erro) {
            case 1 -> {
                rtCadInfo.setVisible(false);
                rtErroEmail.setText("Email já cadastrado");
                cxEmail.setForeground(Color.red);
            }
            case 2 -> {
                rtCadInfo.setVisible(false);
                rtErroUser.setText("Nome em uso");
                cxUser.setForeground(Color.red);
            }
            case 3 -> {
                rtErro(1);
                rtErro(2);
            }
        }
    }
    
    public void msgErro(String msg){
        rtCadInfo.setForeground(Color.red);
        rtCadInfo.setText(msg);
        rtCadInfo.setVisible(true);
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
        //catch (ClassNotFoundException e) {}
        //catch (InstantiationException e) {}
        //catch (IllegalAccessException e) {}        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JCadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btComf;
    private javax.swing.JButton btVoltar;
    private javax.swing.JPasswordField csCSenha;
    private javax.swing.JPasswordField csSenha;
    private javax.swing.JTextField cxCPF;
    private javax.swing.JTextField cxEmail;
    private javax.swing.JTextField cxNome;
    private javax.swing.JTextField cxTelefone;
    private javax.swing.JTextField cxUser;
    private javax.swing.JLabel rtCPF;
    private javax.swing.JLabel rtCSenha;
    private javax.swing.JLabel rtCadInfo;
    private javax.swing.JLabel rtEmail;
    private javax.swing.JLabel rtErroEmail;
    private javax.swing.JLabel rtErroUser;
    private javax.swing.JLabel rtNome;
    private javax.swing.JLabel rtSenha;
    private javax.swing.JLabel rtTelefone;
    private javax.swing.JLabel rtUser;
    // End of variables declaration//GEN-END:variables
}
