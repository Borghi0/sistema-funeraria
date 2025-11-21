package View;

import Control.Produto_Ctrl;
import Model.Produto;
import javax.swing.JOptionPane;

public class JAlterarProduto extends javax.swing.JFrame {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(JAlterarProduto.class.getName());
    private Produto produto; 
    
    
    public JAlterarProduto() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rtTitulo = new javax.swing.JLabel();
        rtNome = new javax.swing.JLabel();
        rtQuant = new javax.swing.JLabel();
        rtPreco = new javax.swing.JLabel();
        rtPerecivel = new javax.swing.JLabel();
        cxNome = new javax.swing.JTextField();
        cxQuant = new javax.swing.JTextField();
        cxPreco = new javax.swing.JTextField();
        cbPerecivel = new javax.swing.JComboBox<>();
        btAtualizar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        rtTitulo.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        rtTitulo.setText("Atualizar Produto");

        rtNome.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtNome.setText("Nome:");

        rtQuant.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtQuant.setText("Quantidade:");

        rtPreco.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtPreco.setText("Preço:");

        rtPerecivel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtPerecivel.setText("É perecivel:");

        cxQuant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cxQuantActionPerformed(evt);
            }
        });

        cbPerecivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sim", "Não" }));

        btAtualizar.setText("Atualizar");
        btAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarActionPerformed(evt);
            }
        });
        btAtualizar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btAtualizarKeyPressed(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        btCancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btCancelarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(rtNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rtQuant, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rtPreco, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rtPerecivel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cxQuant)
                            .addComponent(cxPreco)
                            .addComponent(cbPerecivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cxNome, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(rtTitulo))
                .addContainerGap(74, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btAtualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCancelar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(rtTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cxNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rtQuant, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cxQuant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cxPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rtPerecivel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbPerecivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar)
                    .addComponent(btAtualizar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cxQuantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cxQuantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cxQuantActionPerformed

    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
        atualizar();
    }//GEN-LAST:event_btAtualizarActionPerformed

    private void btCancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btCancelarKeyPressed
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER) dispose();
    }//GEN-LAST:event_btCancelarKeyPressed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btAtualizarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btAtualizarKeyPressed
        atualizar(evt);
    }//GEN-LAST:event_btAtualizarKeyPressed
    
    private void atualizar(){
        cxNome.setText(cxNome.getText().replaceAll("\\s+", ""));
        cxQuant.setText(cxQuant.getText().replaceAll("[^0-9]", ""));
        cxPreco.setText(cxPreco.getText().replaceAll("[^0-9]", ""));                
        
        String opPe = (String) cbPerecivel.getSelectedItem();
        boolean perecivel = opPe.equals("Sim");

        Produto produtoAlt = new Produto(
                perecivel,
                cxQuant.getText().isBlank() ? produto.getQuant_Estoque() : Integer.parseInt(cxQuant.getText()),
                cxPreco.getText().isBlank() ? produto.getPreco() : Integer.parseInt(cxPreco.getText()),
                cxNome.getText().isBlank() ? produto.getNome() : cxNome.getText(),
                produto.getId()
        );
        
        try{
            Produto_Ctrl.getInstancia().alt_Produto(produto);
            JOptionPane.showMessageDialog(
                null,
                "Produto atualizado com sucesso!",
                "Sucesso",
                JOptionPane.INFORMATION_MESSAGE
            );
            produto = produtoAlt;
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
    
    private void initInfo(){
        cxNome.setText(produto.getNome());
        cxQuant.setText(Integer.toString(produto.getQuant_Estoque()));
        cxPreco.setText(Integer.toString(produto.getPreco()));
        cbPerecivel.insertItemAt("Sim", 0);
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
        java.awt.EventQueue.invokeLater(() -> new JAlterarProduto().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JComboBox<String> cbPerecivel;
    private javax.swing.JTextField cxNome;
    private javax.swing.JTextField cxPreco;
    private javax.swing.JTextField cxQuant;
    private javax.swing.JLabel rtNome;
    private javax.swing.JLabel rtPerecivel;
    private javax.swing.JLabel rtPreco;
    private javax.swing.JLabel rtQuant;
    private javax.swing.JLabel rtTitulo;
    // End of variables declaration//GEN-END:variables
}
