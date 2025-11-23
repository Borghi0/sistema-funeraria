package View;

import Control.NavegadorUI;
import Control.Defunto_Ctrl;
import Model.Defunto;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JRelatorioDefunto extends javax.swing.JFrame{
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(JRelatorioDefunto.class.getName());
    private NavegadorUI navegador;
    
    public JRelatorioDefunto(NavegadorUI navegador){
        this.navegador = navegador;
        initComponents();        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbDef = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cxId = new javax.swing.JTextField();
        btAtualizar = new javax.swing.JButton();
        btDeletar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mniFechar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        tbDef.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tbDef.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código Defunto", "Nome do Defunto", "Cemiterio", "Data Nascimento", "Data Obito", "Tipo Obito"
            }
        ));
        tbDef.setEnabled(false);
        tbDef.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDefMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbDef);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("ID:");

        btAtualizar.setText("Atualizar");
        btAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarActionPerformed(evt);
            }
        });

        btDeletar.setText("Deletar");
        btDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeletarActionPerformed(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        jMenu1.setText("Opções");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        mniFechar.setText("Fechar...");
        mniFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniFecharActionPerformed(evt);
            }
        });
        jMenu1.add(mniFechar);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 856, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cxId, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btAtualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btDeletar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btCancelar)
                        .addGap(8, 8, 8)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cxId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAtualizar)
                    .addComponent(btDeletar))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(btCancelar)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbDefMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDefMouseClicked

    }//GEN-LAST:event_tbDefMouseClicked

    private void mniFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniFecharActionPerformed
        sair();
    }//GEN-LAST:event_mniFecharActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        listarTabela();
    }//GEN-LAST:event_formWindowActivated

    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
        atualizar();
    }//GEN-LAST:event_btAtualizarActionPerformed

    private void btDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeletarActionPerformed
        deletar();
    }//GEN-LAST:event_btDeletarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        sair();
    }//GEN-LAST:event_btCancelarActionPerformed
    
    private void atualizar(){
        String codigo = cxId.getText().trim();
        if (codigo.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Insira um ID para atualizar.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        try {
            int id = Integer.parseInt(codigo);
            Defunto altDef = Defunto_Ctrl.getInstancia().ler_Defunto(id); 

            if (altDef != null) {
                //navegador.mostrarJAlterarDefunto();
                //Ligar JRelatorioDefunto ao JAlterarDefunto ao clicar "atualizar".
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "ID não encontrado no banco de dados.",
                        "Erro de Busca",
                        JOptionPane.ERROR_MESSAGE
                );
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    this,
                    "O ID deve ser um número inteiro válido.",
                    "Erro de Entrada",
                    JOptionPane.ERROR_MESSAGE
            );
        } catch (Exception ex) {
            logger.log(java.util.logging.Level.SEVERE, "Erro ao buscar defunto para alteração", ex);
            JOptionPane.showMessageDialog(
                    this,
                    "Erro ao buscar defunto: " + ex.getMessage(),
                    "Erro no BD",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    private void deletar(){
        String codigo = cxId.getText().trim();
        if (codigo.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Insira um ID para deletar.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        try {
            int id = Integer.parseInt(codigo);
            Defunto delDef = new Defunto();
            delDef.setId(id);

            int confirmacao = JOptionPane.showConfirmDialog(
                    this,
                    "Tem certeza que deseja deletar o defunto com ID: " + id + "?", 
                    "Confirmar Exclusão",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirmacao == JOptionPane.YES_OPTION) {
                int linhasAfetadas = Defunto_Ctrl.getInstancia().del_Defunto(delDef);

                if (linhasAfetadas > 0) {
                    JOptionPane.showMessageDialog(
                            this,
                            "Defunto excluído com sucesso!"
                    );
                    listarTabela();
                    cxId.setText("");
                } else {
                    JOptionPane.showMessageDialog(
                            this,
                            "ID não encontrado ou nenhuma linha excluída.",
                            "Erro de Exclusão",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    this,
                    "O ID deve ser um número inteiro válido.",
                    "Erro de Entrada",
                    JOptionPane.ERROR_MESSAGE
            );
        } catch (Exception ex) {
            logger.log(java.util.logging.Level.SEVERE, "Erro ao deletar defunto", ex);
            JOptionPane.showMessageDialog(
                    this,
                    "Erro ao deletar defunto: " + ex.getMessage(),
                    "Erro no BD",
                    JOptionPane.ERROR_MESSAGE
            );
        }
        
    }
    
    private void listarTabela(){
        int linha = 0;
        DefaultTableModel modelo = (DefaultTableModel) tbDef.getModel();
        tbDef.setDefaultEditor(Object.class, null);
        
        try{
            for(Defunto d : Defunto_Ctrl.getInstancia().ler_Defunto()){
                modelo.insertRow(linha, new Object[]{
                    d.getId(), d.getNome(), d.getCemiterio(), d.getDataNatalidade(), d.getDataObito(), d.getTipoObito()
                });

                linha++;
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(
                    null,
                    "Não foi possível encontrar defuntos",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
            //navegador.fecharJRelatorioDefunto();
            dispose();
        }
    }
    
    public void sair(){
        int resp = JOptionPane.showConfirmDialog(
                null,
                "Deseja realmente sair?",
                "SAIDA",
                JOptionPane.YES_NO_OPTION
        );
        if (resp == 0) {
            dispose();
        }
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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new JRelatorioDefunto(new NavegadorUI()).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btDeletar;
    private javax.swing.JTextField cxId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem mniFechar;
    private javax.swing.JTable tbDef;
    // End of variables declaration//GEN-END:variables
}
