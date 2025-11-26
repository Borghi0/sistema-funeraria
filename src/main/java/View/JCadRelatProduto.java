package View;

import Control.ProdutoCtrl;
import Model.Produto;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class JCadRelatProduto extends javax.swing.JFrame {

    public JCadRelatProduto() {
        initComponents();
        setLocationRelativeTo(null);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cxNome = new javax.swing.JTextField();
        rtPreco = new javax.swing.JLabel();
        cxPreco = new javax.swing.JTextField();
        rtEstoque = new javax.swing.JLabel();
        cxEstoque = new javax.swing.JTextField();
        btConfirmar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbProdutos = new javax.swing.JTable();
        rbPerecivel = new javax.swing.JRadioButton();
        rtNome = new javax.swing.JLabel();
        barraMenu = new javax.swing.JMenuBar();
        mbOpcoes1 = new javax.swing.JMenu();
        miRestaurar = new javax.swing.JMenuItem();
        miFechar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Produtos");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
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

        rtPreco.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtPreco.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rtPreco.setText("Preço:");

        cxPreco.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cxPreco.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cxPrecoFocusLost(evt);
            }
        });
        cxPreco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cxPrecoKeyPressed(evt);
            }
        });

        rtEstoque.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtEstoque.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rtEstoque.setText("Estoque:");

        cxEstoque.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cxEstoque.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cxEstoqueFocusLost(evt);
            }
        });
        cxEstoque.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cxEstoqueKeyPressed(evt);
            }
        });

        btConfirmar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btConfirmar.setText("Registrar");
        btConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmarActionPerformed(evt);
            }
        });

        tbProdutos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tbProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Produto", "Preço", "Perecível", "Estoque"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbProdutos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tbProdutos.setAutoscrolls(false);
        tbProdutos.setMinimumSize(new java.awt.Dimension(380, 0));
        tbProdutos.setPreferredSize(new java.awt.Dimension(380, 0));
        tbProdutos.setRowHeight(30);
        tbProdutos.getTableHeader().setReorderingAllowed(false);
        tbProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProdutosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbProdutos);

        rbPerecivel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rbPerecivel.setText("Perecível");

        rtNome.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtNome.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rtNome.setText("Nome:");

        mbOpcoes1.setText("Opções");
        mbOpcoes1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N

        miRestaurar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        miRestaurar.setText("Restaurar Tabela");
        miRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRestaurarActionPerformed(evt);
            }
        });
        mbOpcoes1.add(miRestaurar);

        miFechar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        miFechar.setText("Fechar");
        miFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miFecharActionPerformed(evt);
            }
        });
        mbOpcoes1.add(miFechar);

        barraMenu.add(mbOpcoes1);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(rtNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cxNome, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                        .addGap(40, 40, 40)
                        .addComponent(rtEstoque)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cxEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(rtPreco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cxPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(rbPerecivel)
                        .addGap(40, 40, 40)
                        .addComponent(btConfirmar)))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cxNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rtEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cxEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cxPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btConfirmar)
                    .addComponent(rbPerecivel))
                .addGap(76, 76, 76)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRestaurarActionPerformed
        restaurar();
    }//GEN-LAST:event_miRestaurarActionPerformed

    private void miFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miFecharActionPerformed
        dispose();
    }//GEN-LAST:event_miFecharActionPerformed

    private void cxNomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cxNomeFocusLost
        cxNome.setText(cxNome.getText().trim());
    }//GEN-LAST:event_cxNomeFocusLost

    private void cxNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cxNomeKeyPressed
        confirmar(evt);
    }//GEN-LAST:event_cxNomeKeyPressed

    private void cxPrecoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cxPrecoFocusLost
        cxPreco.setText(cxPreco.getText().replaceAll("[^0-9]", ""));
        cxPreco.setText(cxPreco.getText().replaceAll(",", "."));
    }//GEN-LAST:event_cxPrecoFocusLost

    private void cxPrecoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cxPrecoKeyPressed
        confirmar(evt);
    }//GEN-LAST:event_cxPrecoKeyPressed

    private void cxEstoqueFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cxEstoqueFocusLost
        cxEstoque.setText(cxEstoque.getText().replaceAll("[^0-9]", ""));
    }//GEN-LAST:event_cxEstoqueFocusLost

    private void cxEstoqueKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cxEstoqueKeyPressed
        confirmar(evt);
    }//GEN-LAST:event_cxEstoqueKeyPressed

    private void btConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmarActionPerformed
        confirmar();
    }//GEN-LAST:event_btConfirmarActionPerformed

    private void tbProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProdutosMouseClicked
        selecTabProdutos();
    }//GEN-LAST:event_tbProdutosMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        try{listarTabProdutos();} catch(Exception e){}
    }//GEN-LAST:event_formWindowActivated

    private void restaurar(){
        try{
            listarTabProdutos();            
        }catch(Exception e){
            JOptionPane.showMessageDialog(
                    null, "Erro na busca:\n" + e,
                    "Erro!", JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    private void confirmar(){
        cxNome.setText(cxNome.getText().trim());
        cxEstoque.setText(cxEstoque.getText().replaceAll("[^0-9]", ""));
        cxPreco.setText(cxPreco.getText().replaceAll("[^0-9]", ""));
        cxPreco.setText(cxPreco.getText().replaceAll(",", "."));
        
        Produto produto = new Produto(
                rbPerecivel.isSelected(),
                Integer.parseInt(cxEstoque.getText()),
                Double.parseDouble(cxPreco.getText()),
                cxNome.getText(),
                0
        );
        
        try{
            ProdutoCtrl.getInstancia().cadProduto(produto);
            
            JOptionPane.showMessageDialog(
                null,
                "Produto cadastrado com sucesso!",
                "Sucesso",
                JOptionPane.INFORMATION_MESSAGE
            );
            limpar();            
            restaurar();
        }catch(Exception e){
            JOptionPane.showMessageDialog(
                    null, "Erro ao cadastrar serviço:\n" + e,
                    "Erro!", JOptionPane.ERROR_MESSAGE
            );
        }
    }
    private void confirmar(java.awt.event.KeyEvent evt){
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER) confirmar();
    }
    
    private void listarTabProdutos() throws Exception{        
        DefaultTableModel modelo = (DefaultTableModel) tbProdutos.getModel();       

        int lin = 0;
        modelo.setRowCount(lin);
                
        for(Produto produto : ProdutoCtrl.getInstancia().lerProduto()){
            modelo.insertRow(lin, new Object[]{                    
                produto.getId(),
                produto.getNome(),
                String.format("R$ %.2f", produto.getPreco()),
                produto.isPerecivel() ? "Sim" : "Não",
                produto.getQuantEstoque()
            });
            lin++;
        }
    }
    
    private void selecTabProdutos(){
        int linSelec = tbProdutos.getSelectedRow();

        if(linSelec<0) return;
                
        Produto produtoSelec = new Produto(
                tbProdutos.getValueAt(linSelec, 3).toString().equals("Sim"),
                (Integer) tbProdutos.getValueAt(linSelec, 4),
                (Double) tbProdutos.getValueAt(linSelec, 2),
                (String) tbProdutos.getValueAt(linSelec, 1),
                (Integer) tbProdutos.getValueAt(linSelec, 0)
        );        
                        
        int o = JOptionPane.showOptionDialog(
                null,
                "O que gostaria de fazer?",
                "Produto: "+produtoSelec.getId(),
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"Deletar", "Atualizar estoque", "Cancelar"},
                "Cancelar"
        );
        
        if(o==0) deletar(produtoSelec);        
        else if(o==1) altEstoque(produtoSelec);
    }
    
    private void deletar(Produto produto){
        int o = JOptionPane.showOptionDialog(null, "Deseja realmente deletar o produto?", "Id do produto: "+produto.getId(),
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, 
                        null, new Object[]{"Sim...", "Não"}, "Não"
                );
        if(o==0){
            try {
                if(ProdutoCtrl.getInstancia().delProduto(produto)>0)
                    JOptionPane.showMessageDialog(
                            null, "Produto deletado!",
                            "Sucesso!", JOptionPane.INFORMATION_MESSAGE
                    );
                else{
                    JOptionPane.showMessageDialog(
                            null, "Produto não encontrado!",
                            "Erro!", JOptionPane.ERROR_MESSAGE
                    );
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(
                    null, "Erro na busca:\n" + e,
                    "Erro!", JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }
    
    private void altEstoque(Produto produto){               
        JTextField cxQuantE = new JTextField();
        Object[] msg = {
                "Nova quantidade:", cxQuantE,
        };
                
        int o = JOptionPane.showOptionDialog(
                        null, msg, "Alterar estoque",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, 
                        null, new Object[]{"Confirmar", "Cancelar"}, "Confirmar"
                );
                
        if(o==0){            
            try{
                produto.setQuantEstoque(Integer.parseInt(cxQuantE.getText()));                
                if(ProdutoCtrl.getInstancia().altProduto(produto)>0)
                    JOptionPane.showMessageDialog(
                                null, "Estoque atualizado!",
                                "Sucesso!", JOptionPane.INFORMATION_MESSAGE
                    );                
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(
                    null, "Erro no formato do número:\n" + e,
                    "Erro!", JOptionPane.ERROR_MESSAGE
                );
            }catch(ClassNotFoundException | SQLException e){
                JOptionPane.showMessageDialog(
                    null, "Erro ao atualizar estoque:\n" + e,
                    "Erro!", JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }
    
    public void limpar(){                
        cxNome.setText("");
        cxEstoque.setText("");
        cxPreco.setText("");
        if(rbPerecivel.isSelected()) rbPerecivel.doClick();
        cxNome.requestFocus();
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
            java.util.logging.Logger.getLogger(JCadRelatProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JCadRelatProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JCadRelatProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JCadRelatProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JCadRelatProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JButton btConfirmar;
    private javax.swing.JTextField cxEstoque;
    private javax.swing.JTextField cxNome;
    private javax.swing.JTextField cxPreco;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JMenu mbOpcoes1;
    private javax.swing.JMenuItem miFechar;
    private javax.swing.JMenuItem miRestaurar;
    private javax.swing.JRadioButton rbPerecivel;
    private javax.swing.JLabel rtEstoque;
    private javax.swing.JLabel rtNome;
    private javax.swing.JLabel rtPreco;
    private javax.swing.JTable tbProdutos;
    // End of variables declaration//GEN-END:variables
}
