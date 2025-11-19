package View;

import Control.Usuario_Ctrl;
import Model.Endereco;
import Model.Usuario;
import java.time.LocalDate;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import Interfaces.I_JanelaRaiz;


public class JAlterarUsuario extends javax.swing.JFrame {    
    private final I_JanelaRaiz janelaRaiz;
    private Usuario usuario;

    public JAlterarUsuario(I_JanelaRaiz janelaRaiz, Usuario usuario) {
        if(janelaRaiz==null||usuario==null) throw new IllegalArgumentException("Args não podem ser null");
        this.janelaRaiz = janelaRaiz;
        this.usuario = usuario;
        initComponents();
        setLocationRelativeTo(null);
        DefaultComboBoxModel<String> modelDia = new DefaultComboBoxModel<>();
        for(int i=1; i<=31; i++) modelDia.addElement(String.valueOf(i));
        cbDia.setModel(modelDia);
        
        DefaultComboBoxModel<String> modelMes = new DefaultComboBoxModel<>();
        for(int i=1; i<=12; i++) modelMes.addElement(String.valueOf(i));
        cbMes.setModel(modelMes);
        
        DefaultComboBoxModel<String> modelAno = new DefaultComboBoxModel<>();
        for(int i=1900; i<=2025; i++) modelAno.addElement(String.valueOf(i));
        cbAno.setModel(modelAno);
        initInfo();                
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rtTitulo = new javax.swing.JLabel();
        rtEmail = new javax.swing.JLabel();
        rtNome = new javax.swing.JLabel();
        rtTelefone = new javax.swing.JLabel();
        rtRua = new javax.swing.JLabel();
        rtNumero = new javax.swing.JLabel();
        rtCep = new javax.swing.JLabel();
        rtDataNasc = new javax.swing.JLabel();
        rtSenha = new javax.swing.JLabel();
        cxEmail = new javax.swing.JTextField();
        cxNome = new javax.swing.JTextField();
        cxTelefone = new javax.swing.JTextField();
        cxRua = new javax.swing.JTextField();
        cxNumero = new javax.swing.JTextField();
        cxCep = new javax.swing.JTextField();
        cbDia = new javax.swing.JComboBox<>();
        cbMes = new javax.swing.JComboBox<>();
        cbAno = new javax.swing.JComboBox<>();
        csSenha = new javax.swing.JPasswordField();
        btConfirmar = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        rtTitulo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        rtTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rtTitulo.setText("Atualizar Usuário");

        rtEmail.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtEmail.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rtEmail.setText("Email:");

        rtNome.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtNome.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rtNome.setText("Nome:");

        rtTelefone.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtTelefone.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rtTelefone.setText("Telefone:");

        rtRua.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtRua.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rtRua.setText("Rua:");

        rtNumero.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtNumero.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rtNumero.setText("Número:");

        rtCep.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtCep.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rtCep.setText("CEP:");

        rtDataNasc.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtDataNasc.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rtDataNasc.setText("Data de nascimento:");

        rtSenha.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtSenha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rtSenha.setText("Senha:");

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

        cxRua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cxRua.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cxRuaFocusLost(evt);
            }
        });
        cxRua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cxRuaKeyPressed(evt);
            }
        });

        cxNumero.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cxNumero.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cxNumeroFocusLost(evt);
            }
        });
        cxNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cxNumeroKeyPressed(evt);
            }
        });

        cxCep.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cxCep.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cxCepFocusLost(evt);
            }
        });
        cxCep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cxCepKeyPressed(evt);
            }
        });

        cbDia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cbMes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cbAno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        csSenha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        csSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                csSenhaKeyPressed(evt);
            }
        });

        btConfirmar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btConfirmar.setText("Atualizar");
        btConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmarActionPerformed(evt);
            }
        });
        btConfirmar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btConfirmarKeyPressed(evt);
            }
        });

        btVoltar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btVoltar.setText("Cancelar");
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

        jMenu1.setText("Opções");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N

        jMenuItem1.setText("Fechar...");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(103, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btVoltar)
                        .addGap(6, 6, 6))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rtSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(csSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btConfirmar)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(rtNumero, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rtCep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rtRua, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cxRua)
                                    .addComponent(cxNumero)
                                    .addComponent(cxCep, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(rtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rtNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rtDataNasc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cbDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35)
                                        .addComponent(cbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35)
                                        .addComponent(cbAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cxEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                                    .addComponent(cxNome)
                                    .addComponent(cxTelefone))))
                        .addContainerGap(109, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rtTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(rtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
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
                    .addComponent(cxTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rtRua, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cxRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cxNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cxCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbDia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rtDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbAno, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbMes, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(csSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cxRuaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cxRuaFocusLost
        cxRua.setText(cxRua.getText().trim());
    }//GEN-LAST:event_cxRuaFocusLost

    private void cxRuaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cxRuaKeyPressed
        atualizar(evt);
    }//GEN-LAST:event_cxRuaKeyPressed

    private void cxNumeroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cxNumeroFocusLost
        cxNumero.setText(cxNumero.getText().replaceAll("[^0-9]", ""));
    }//GEN-LAST:event_cxNumeroFocusLost

    private void cxNumeroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cxNumeroKeyPressed
        atualizar(evt);
    }//GEN-LAST:event_cxNumeroKeyPressed

    private void cxCepFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cxCepFocusLost
        cxCep.setText(cxCep.getText().replaceAll("[^0-9]", ""));
    }//GEN-LAST:event_cxCepFocusLost

    private void cxCepKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cxCepKeyPressed
        atualizar(evt);
    }//GEN-LAST:event_cxCepKeyPressed

    private void cxEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cxEmailFocusLost
        cxEmail.setText(cxEmail.getText().replaceAll("\\s+", ""));
    }//GEN-LAST:event_cxEmailFocusLost

    private void cxEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cxEmailKeyPressed
        atualizar(evt);
    }//GEN-LAST:event_cxEmailKeyPressed

    private void cxNomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cxNomeFocusLost
        cxNome.setText(cxNome.getText().trim());
    }//GEN-LAST:event_cxNomeFocusLost

    private void cxNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cxNomeKeyPressed
        atualizar(evt);
    }//GEN-LAST:event_cxNomeKeyPressed

    private void cxTelefoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cxTelefoneFocusLost
        cxTelefone.setText(cxTelefone.getText().replaceAll("[^0-9]", ""));
    }//GEN-LAST:event_cxTelefoneFocusLost

    private void cxTelefoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cxTelefoneKeyPressed
        atualizar(evt);
    }//GEN-LAST:event_cxTelefoneKeyPressed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        cancelar();
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btVoltarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btVoltarKeyPressed
        cancelar(evt);
    }//GEN-LAST:event_btVoltarKeyPressed

    private void btConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmarActionPerformed
        atualizar();
    }//GEN-LAST:event_btConfirmarActionPerformed

    private void btConfirmarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btConfirmarKeyPressed
        atualizar(evt);
    }//GEN-LAST:event_btConfirmarKeyPressed

    private void csSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_csSenhaKeyPressed
        atualizar(evt);
    }//GEN-LAST:event_csSenhaKeyPressed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        cancelar();
    }//GEN-LAST:event_formWindowClosed

    private void cancelar(){
        dispose();
        janelaRaiz.voltar(usuario);
    }
    private void cancelar(java.awt.event.KeyEvent evt){
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER) cancelar();
    }
    
    private void atualizar(){
        cxEmail.setText(cxEmail.getText().replaceAll("\\s+", ""));
        cxNome.setText(cxNome.getText().trim());
        cxTelefone.setText(cxTelefone.getText().replaceAll("[^0-9]", ""));                
        cxRua.setText(cxRua.getText().trim());
        cxNumero.setText(cxNumero.getText().replaceAll("[^0-9]", ""));
        cxCep.setText(cxCep.getText().replaceAll("[^0-9]", ""));
        
        LocalDate data_natalidade = validarData();
        if(data_natalidade == null) return;        
        
        Endereco endereco = new Endereco(
                cxNumero.getText().isBlank() ? usuario.getEndereco().getNumero() : Integer.parseInt(cxNumero.getText()),
                cxRua.getText().isBlank() ? usuario.getEndereco().getRua() : cxRua.getText(),
                cxCep.getText().isBlank() ? usuario.getEndereco().getCep() : cxCep.getText()
        );
            
        String senha = String.valueOf(csSenha.getPassword());
        Usuario usuarioAlt = new Usuario(
                cxEmail.getText().isBlank() ? usuario.getEmail() : cxEmail.getText(),
                senha.isBlank() ? usuario.getSenha() : senha,
                cxTelefone.getText().isBlank() ? usuario.getNumero_Telefone() : cxTelefone.getText(),
                usuario.isAdmin(),
                endereco,
                usuario.getPlano(),
                cxNome.getText().isBlank() ? usuario.getNome() : cxNome.getText(),
                usuario.getCpf(),
                data_natalidade
        );
        
        try{
            Usuario_Ctrl.getInstancia().alt_User(usuarioAlt);
            JOptionPane.showMessageDialog(
                null,
                "Usuário atualizado com sucesso!",
                "Sucesso",
                JOptionPane.INFORMATION_MESSAGE
            );
            usuario = usuarioAlt;
            initInfo();
        }catch(Exception e){
            JOptionPane.showMessageDialog(
                null,
                "Erro ao atualizar usuário:\n" + e,
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
    private void atualizar(java.awt.event.KeyEvent evt){
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER) atualizar();
    }
    
    private LocalDate validarData(){
        LocalDate data_natalidade;
        try{
            data_natalidade = LocalDate.of(
                    Integer.parseInt(cbAno.getSelectedItem().toString()),
                    Integer.parseInt(cbMes.getSelectedItem().toString()),
                    Integer.parseInt(cbDia.getSelectedItem().toString())
            );
        }catch(Exception e){
            JOptionPane.showMessageDialog(
                null,
                "Data inválida:\n" + e,
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );
            return null;
        }
        return data_natalidade;
    }
    
    private void initInfo(){
        cxEmail.setText(usuario.getEmail());
        cxNome.setText(usuario.getNome());
        csSenha.setText(usuario.getSenha());
        cxTelefone.setText(usuario.getNumero_Telefone());
        cxNumero.setText(String.valueOf(usuario.getEndereco().getNumero()));
        cxRua.setText(usuario.getEndereco().getRua());
        cxCep.setText(usuario.getEndereco().getCep());
        cbDia.setSelectedItem(String.valueOf(usuario.getData_natalidade().getDayOfMonth()));
        cbMes.setSelectedItem(String.valueOf(usuario.getData_natalidade().getMonthValue()));
        cbAno.setSelectedItem(String.valueOf(usuario.getData_natalidade().getYear()));
        cxEmail.requestFocus();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConfirmar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JComboBox<String> cbAno;
    private javax.swing.JComboBox<String> cbDia;
    private javax.swing.JComboBox<String> cbMes;
    private javax.swing.JPasswordField csSenha;
    private javax.swing.JTextField cxCep;
    private javax.swing.JTextField cxEmail;
    private javax.swing.JTextField cxNome;
    private javax.swing.JTextField cxNumero;
    private javax.swing.JTextField cxRua;
    private javax.swing.JTextField cxTelefone;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JLabel rtCep;
    private javax.swing.JLabel rtDataNasc;
    private javax.swing.JLabel rtEmail;
    private javax.swing.JLabel rtNome;
    private javax.swing.JLabel rtNumero;
    private javax.swing.JLabel rtRua;
    private javax.swing.JLabel rtSenha;
    private javax.swing.JLabel rtTelefone;
    private javax.swing.JLabel rtTitulo;
    // End of variables declaration//GEN-END:variables
}
