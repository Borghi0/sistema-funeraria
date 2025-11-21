package View;

import Control.Velorio_Ctrl;
import Model.Defunto;
import Model.Sala;
import Model.Velorio;
import java.time.LocalDateTime;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;


public class JCadAltVelorio extends javax.swing.JFrame {
    private Velorio velorio;
    private boolean modoCadastro;
    
    
    public JCadAltVelorio(Velorio velorio, Boolean modoCadastro) {
        this.velorio = velorio;
        this.modoCadastro = modoCadastro;
        
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
        
        DefaultComboBoxModel<String> modelHora = new DefaultComboBoxModel<>();
        for(int i=0; i<=23; i++) modelHora.addElement(String.valueOf(i));
        cbHora.setModel(modelHora);
        
        DefaultComboBoxModel<String> modelMin = new DefaultComboBoxModel<>();
        for(int i=0; i<=55; i+=5) modelMin.addElement(String.valueOf(i));
        cbMin.setModel(modelMin);
        
        if(modoCadastro){
            this.velorio = new Velorio();            
            rtTitulo.setText("Cadastrar velório");
            this.setTitle("Cadastrar velório");
        }
        else {
            initInfo();            
            rtTitulo.setText("Alterar velório");            
            this.setTitle("Alterar velório");
            cxIdDefunto.setEnabled(false);
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbDia = new javax.swing.JComboBox<>();
        rtData = new javax.swing.JLabel();
        rtNumeroSala = new javax.swing.JLabel();
        rtIdDefunto = new javax.swing.JLabel();
        cxNumeroSala = new javax.swing.JTextField();
        cxIdDefunto = new javax.swing.JTextField();
        cbMes = new javax.swing.JComboBox<>();
        cbAno = new javax.swing.JComboBox<>();
        btConfirmar = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();
        cbHora = new javax.swing.JComboBox<>();
        cbMin = new javax.swing.JComboBox<>();
        rtTitulo = new javax.swing.JLabel();
        rtHorario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar velório");

        cbDia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        rtData.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtData.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rtData.setText("Data:");

        rtNumeroSala.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtNumeroSala.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rtNumeroSala.setText("Número da sala:");

        rtIdDefunto.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtIdDefunto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rtIdDefunto.setText("Id do falecido:");

        cxNumeroSala.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cxNumeroSala.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cxNumeroSalaFocusLost(evt);
            }
        });
        cxNumeroSala.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cxNumeroSalaKeyPressed(evt);
            }
        });

        cxIdDefunto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cxIdDefunto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cxIdDefuntoFocusLost(evt);
            }
        });
        cxIdDefunto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cxIdDefuntoKeyPressed(evt);
            }
        });

        cbMes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cbAno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

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

        cbHora.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cbMin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        rtTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        rtTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rtTitulo.setText("Texto");

        rtHorario.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtHorario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rtHorario.setText("Horário:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btVoltar)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rtNumeroSala)
                    .addComponent(rtData, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rtHorario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(cbDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(cbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(cbAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(cxNumeroSala, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30)
                            .addComponent(rtIdDefunto)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cxIdDefunto, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btConfirmar)))
                .addContainerGap(152, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(rtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rtIdDefunto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cxIdDefunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rtNumeroSala, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cxNumeroSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rtData, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbDia, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbMes, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbAno, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbHora, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbMin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rtHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cxNumeroSalaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cxNumeroSalaFocusLost
        cxNumeroSala.setText(cxNumeroSala.getText().replaceAll("[^0-9]", ""));
    }//GEN-LAST:event_cxNumeroSalaFocusLost

    private void cxNumeroSalaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cxNumeroSalaKeyPressed
        confirmar(evt);
    }//GEN-LAST:event_cxNumeroSalaKeyPressed

    private void cxIdDefuntoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cxIdDefuntoFocusLost
        cxIdDefunto.setText(cxIdDefunto.getText().replaceAll("[^0-9]", ""));
    }//GEN-LAST:event_cxIdDefuntoFocusLost

    private void cxIdDefuntoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cxIdDefuntoKeyPressed
        confirmar(evt);
    }//GEN-LAST:event_cxIdDefuntoKeyPressed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btVoltarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btVoltarKeyPressed
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER) dispose();
    }//GEN-LAST:event_btVoltarKeyPressed

    private void btConfirmarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btConfirmarKeyPressed
        confirmar(evt);
    }//GEN-LAST:event_btConfirmarKeyPressed

    private void btConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmarActionPerformed
        confirmar();
    }//GEN-LAST:event_btConfirmarActionPerformed

    private void confirmar(){
        if(modoCadastro) cadastrar();
        else alterar();
    }
    private void confirmar(java.awt.event.KeyEvent evt){
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER) confirmar();
    }    
    
    private void cadastrar(){        
        cxNumeroSala.setText(cxNumeroSala.getText().replaceAll("[^0-9]", ""));
        cxIdDefunto.setText(cxIdDefunto.getText().replaceAll("[^0-9]", ""));
        
        LocalDateTime data = validarData();
        if(data == null) return;
                     
        
        Velorio v = new Velorio(
                new Sala(0, Integer.parseInt(cxNumeroSala.getText())),
                data,
                new Defunto(null, null, null, null, null, Integer.parseInt(cxIdDefunto.getText()))
        );
        
        try {            
            Velorio_Ctrl.getInstancia().cad_Velorio(v);
            JOptionPane.showMessageDialog(
                null,
                "Velório cadastrado com sucesso!",
                "Sucesso",
                JOptionPane.INFORMATION_MESSAGE
            );
            limpar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                null,
                "Erro ao cadastrar velório:\n" + e,
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }    
    
    private void alterar(){
        cxNumeroSala.setText(cxNumeroSala.getText().replaceAll("[^0-9]", ""));
        cxIdDefunto.setText(cxIdDefunto.getText().replaceAll("[^0-9]", ""));
        
        LocalDateTime data = validarData();
        if(data == null) return;
                     
        
        Velorio velorioAlt = new Velorio(
                new Sala(0, Integer.parseInt(cxNumeroSala.getText())),
                data,
                new Defunto(null, null, null, null, null, Integer.parseInt(cxIdDefunto.getText()))
        );
        
        try {            
            Velorio_Ctrl.getInstancia().alt_Velorio(velorioAlt);
            JOptionPane.showMessageDialog(
                null,
                "Velório alterado com sucesso!",
                "Sucesso",
                JOptionPane.INFORMATION_MESSAGE
            );
            velorio = velorioAlt;
            initInfo();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                null,
                "Erro ao alterar velório:\n" + e,
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    private LocalDateTime validarData(){
        LocalDateTime data;
        try{
            data = LocalDateTime.of(
                    Integer.parseInt(cbAno.getSelectedItem().toString()),
                    Integer.parseInt(cbMes.getSelectedItem().toString()),
                    Integer.parseInt(cbDia.getSelectedItem().toString()),
                    Integer.parseInt(cbHora.getSelectedItem().toString()),
                    Integer.parseInt(cbMin.getSelectedItem().toString())
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
        return data;
    }
             
    private void initInfo(){
        cxNumeroSala.setText(String.valueOf(velorio.getSala().getNumero()));
        cxIdDefunto.setText(String.valueOf(velorio.getDefunto().getId()));
        cbDia.setSelectedItem(String.valueOf(velorio.getData().getDayOfMonth()));
        cbMes.setSelectedItem(String.valueOf(velorio.getData().getMonthValue()));
        cbAno.setSelectedItem(String.valueOf(velorio.getData().getYear()));
        cbHora.setSelectedItem(String.valueOf(velorio.getData().getHour()));
        cbMin.setSelectedItem(String.valueOf(velorio.getData().getMinute()));
    }
    
    private void limpar(){        
        cxNumeroSala.setText("");
        cxIdDefunto.setText("");
        cbDia.setSelectedIndex(0);
        cbMes.setSelectedIndex(0);
        cbAno.setSelectedIndex(0);
        cbHora.setSelectedIndex(0);
        cbMin.setSelectedIndex(0);
        cxNumeroSala.requestFocus();
    }
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JCadAltVelorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JCadAltVelorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JCadAltVelorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            //java.util.logging.Logger.getLogger(JCadVelorio.class.getName())cbHoraava.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JCadAltVelorio(null, true).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConfirmar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JComboBox<String> cbAno;
    private javax.swing.JComboBox<String> cbDia;
    private javax.swing.JComboBox<String> cbHora;
    private javax.swing.JComboBox<String> cbMes;
    private javax.swing.JComboBox<String> cbMin;
    private javax.swing.JTextField cxIdDefunto;
    private javax.swing.JTextField cxNumeroSala;
    private javax.swing.JLabel rtData;
    private javax.swing.JLabel rtHorario;
    private javax.swing.JLabel rtIdDefunto;
    private javax.swing.JLabel rtNumeroSala;
    private javax.swing.JLabel rtTitulo;
    // End of variables declaration//GEN-END:variables
}
