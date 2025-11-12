package View;


import Control.Usuario_Ctrl;
import Control.Endereco_Ctrl;
import Model.Usuario;
import Model.Endereco;
import com.github.weisj.darklaf.*;
import java.awt.Color;
import java.time.LocalDate;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class JCadastro extends javax.swing.JFrame {
    private static JCadastro instancia;    
    
    private JCadastro() {        
        initComponents();
        
        DefaultComboBoxModel<String> modelDia = new DefaultComboBoxModel<>();
        for(int i=1; i<=31; i++) modelDia.addElement(String.valueOf(i));
        cbDia.setModel(modelDia);
        
        DefaultComboBoxModel<String> modelMes = new DefaultComboBoxModel<>();
        for(int i=1; i<=12; i++) modelMes.addElement(String.valueOf(i));
        cbMes.setModel(modelMes);
        
        DefaultComboBoxModel<String> modelAno = new DefaultComboBoxModel<>();
        for(int i=1900; i<=2025; i++) modelAno.addElement(String.valueOf(i));
        cbAno.setModel(modelAno);
        
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
    }

    public static JCadastro getInstancia(){
        if(instancia == null) instancia = new JCadastro();
        return instancia;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rtEmail = new javax.swing.JLabel();
        rtNome = new javax.swing.JLabel();
        rtTelefone = new javax.swing.JLabel();
        rtCpf = new javax.swing.JLabel();
        rtSenha = new javax.swing.JLabel();
        rtCSenha = new javax.swing.JLabel();
        cxEmail = new javax.swing.JTextField();
        cxNome = new javax.swing.JTextField();
        cxTelefone = new javax.swing.JTextField();
        cxCpf = new javax.swing.JTextField();
        csSenha = new javax.swing.JPasswordField();
        csCSenha = new javax.swing.JPasswordField();
        btVoltar = new javax.swing.JButton();
        btConfirmar = new javax.swing.JButton();
        rtErroEmail = new javax.swing.JLabel();
        rtCadInfo = new javax.swing.JLabel();
        cbDia = new javax.swing.JComboBox<>();
        rtCPF1 = new javax.swing.JLabel();
        rtRua = new javax.swing.JLabel();
        rtNumero = new javax.swing.JLabel();
        rtCep = new javax.swing.JLabel();
        cxRua = new javax.swing.JTextField();
        cxNumero = new javax.swing.JTextField();
        cxCep = new javax.swing.JTextField();
        cbMes = new javax.swing.JComboBox<>();
        cbAno = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro");

        rtEmail.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtEmail.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rtEmail.setText("Email:");

        rtNome.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtNome.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rtNome.setText("Nome:");

        rtTelefone.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtTelefone.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rtTelefone.setText("Telefone:");

        rtCpf.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtCpf.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rtCpf.setText("CPF:");

        rtSenha.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtSenha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rtSenha.setText("Senha:");

        rtCSenha.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtCSenha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rtCSenha.setText("Confirmar senha:");

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

        cxCpf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cxCpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cxCpfFocusLost(evt);
            }
        });
        cxCpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cxCpfKeyPressed(evt);
            }
        });

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

        btConfirmar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btConfirmar.setText("Confirmar");
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

        rtErroEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rtErroEmail.setForeground(new java.awt.Color(255, 0, 0));
        rtErroEmail.setMinimumSize(new java.awt.Dimension(120, 0));

        rtCadInfo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rtCadInfo.setForeground(new java.awt.Color(255, 0, 0));
        rtCadInfo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rtCadInfo.setText("Preencha todos os campos");

        cbDia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        rtCPF1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtCPF1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rtCPF1.setText("Data de nascimento:");

        rtRua.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtRua.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rtRua.setText("Rua:");

        rtNumero.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtNumero.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rtNumero.setText("Número:");

        rtCep.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtCep.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rtCep.setText("CEP:");

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

        cbMes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cbAno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btVoltar)
                .addGap(6, 6, 6))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(145, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rtCSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rtSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rtCadInfo)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(csCSenha, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(csSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(rtCPF1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rtCpf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rtTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                            .addComponent(cxTelefone)
                            .addComponent(cxCpf))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rtErroEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(87, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rtErroEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cxEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(rtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cxCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(rtCPF1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbAno, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbMes, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addComponent(btConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        voltar();
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmarActionPerformed
        cadastrar();        
    }//GEN-LAST:event_btConfirmarActionPerformed

    private void btConfirmarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btConfirmarKeyPressed
        cadastrar(evt);
    }//GEN-LAST:event_btConfirmarKeyPressed

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

    private void cxEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cxEmailFocusLost
        cxEmail.setText(cxEmail.getText().replaceAll("\\s+", ""));
    }//GEN-LAST:event_cxEmailFocusLost

    private void cxNomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cxNomeFocusLost
        cxNome.setText(cxNome.getText().trim());
    }//GEN-LAST:event_cxNomeFocusLost

    private void cxCpfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cxCpfFocusLost
        cxCpf.setText(cxCpf.getText().replaceAll("[^0-9]", ""));
    }//GEN-LAST:event_cxCpfFocusLost

    private void cxCpfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cxCpfKeyPressed
        cadastrar(evt);
    }//GEN-LAST:event_cxCpfKeyPressed

    private void csSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_csSenhaKeyPressed
        cadastrar(evt);
    }//GEN-LAST:event_csSenhaKeyPressed

    private void cxRuaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cxRuaFocusLost
        cxRua.setText(cxRua.getText().trim());
    }//GEN-LAST:event_cxRuaFocusLost

    private void cxRuaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cxRuaKeyPressed
        cadastrar(evt);
    }//GEN-LAST:event_cxRuaKeyPressed

    private void cxNumeroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cxNumeroFocusLost
        cxNumero.setText(cxNumero.getText().replaceAll("[^0-9]", ""));
    }//GEN-LAST:event_cxNumeroFocusLost

    private void cxNumeroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cxNumeroKeyPressed
        cadastrar(evt);
    }//GEN-LAST:event_cxNumeroKeyPressed

    private void cxCepFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cxCepFocusLost
        cxCep.setText(cxCep.getText().replaceAll("[^0-9]", ""));
    }//GEN-LAST:event_cxCepFocusLost

    private void cxCepKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cxCepKeyPressed
        cadastrar(evt);
    }//GEN-LAST:event_cxCepKeyPressed

    public void voltar(){
        dispose();
        JLogin.getInstancia().setVisible(true);
    }
    public void voltar(java.awt.event.KeyEvent evt){
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER) voltar();
    }
    
    public void cadastrar(){

        // ver se segue boas praticas (claramente n):        
        cxEmail.setText(cxEmail.getText().replaceAll("\\s+", ""));
        cxNome.setText(cxNome.getText().trim());
        cxTelefone.setText(cxTelefone.getText().replaceAll("[^0-9]", ""));        
        cxCpf.setText(cxCpf.getText().replaceAll("[^0-9]", ""));
        cxRua.setText(cxRua.getText().trim());
        cxNumero.setText(cxNumero.getText().replaceAll("[^0-9]", ""));
        cxCep.setText(cxCep.getText().replaceAll("[^0-9]", ""));
        
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
            return;
        }
        
        // criar classes de verificação para usar aqui ou no metodo cad_User,
        // por exemplo: senha = confirma senha; CPF é válido...
        Endereco endereco = new Endereco(
                cxNumero.getText().isBlank() ? 0 : Integer.parseInt(cxNumero.getText()),
                cxRua.getText(),
                cxCep.getText()
        );        
        
        Usuario usuario = new Usuario(
                cxEmail.getText(),
                String.valueOf(csSenha.getPassword()),
                cxTelefone.getText(),
                false,
                endereco,
                null,
                cxNome.getText(),
                cxCpf.getText(),
                data_natalidade
        );
        
        try {
            Endereco_Ctrl.getInstancia().cad_Endereco(endereco);
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
        cxEmail.setText("");
        cxNome.setText("");
        cxCpf.setText("");
        csSenha.setText("");
        csCSenha.setText("");
        cxEmail.requestFocus();
    }
    
    public void rtErro(){
        rtCadInfo.setVisible(false);
        rtErroEmail.setText("Email já cadastrado");
        cxEmail.setForeground(Color.red);            
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
    private javax.swing.JButton btConfirmar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JComboBox<String> cbAno;
    private javax.swing.JComboBox<String> cbDia;
    private javax.swing.JComboBox<String> cbMes;
    private javax.swing.JPasswordField csCSenha;
    private javax.swing.JPasswordField csSenha;
    private javax.swing.JTextField cxCep;
    private javax.swing.JTextField cxCpf;
    private javax.swing.JTextField cxEmail;
    private javax.swing.JTextField cxNome;
    private javax.swing.JTextField cxNumero;
    private javax.swing.JTextField cxRua;
    private javax.swing.JTextField cxTelefone;
    private javax.swing.JLabel rtCPF1;
    private javax.swing.JLabel rtCSenha;
    private javax.swing.JLabel rtCadInfo;
    private javax.swing.JLabel rtCep;
    private javax.swing.JLabel rtCpf;
    private javax.swing.JLabel rtEmail;
    private javax.swing.JLabel rtErroEmail;
    private javax.swing.JLabel rtNome;
    private javax.swing.JLabel rtNumero;
    private javax.swing.JLabel rtRua;
    private javax.swing.JLabel rtSenha;
    private javax.swing.JLabel rtTelefone;
    // End of variables declaration//GEN-END:variables
}
