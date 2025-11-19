package View;


import Control.NavegadorUI;
import Control.Plano_Ctrl;
import Model.Plano;
import Model.Servico;
import Model.Produto;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class JRelatorioPlano extends javax.swing.JFrame {
    private NavegadorUI navegador;
    private boolean modoAdmin;
    
    public JRelatorioPlano(NavegadorUI navegador, boolean modoAdmin) {
        this.navegador = navegador;
        this.modoAdmin = modoAdmin;
        initComponents();        
        setLocationRelativeTo(null);
        setExtendedState(MAXIMIZED_BOTH);
        
        if(!modoAdmin){
            btDeletar.setVisible(false);
            btAtualizar.setVisible(false);
        }
    }        
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbPlanos = new javax.swing.JTable();
        cxCodigo = new javax.swing.JTextField();
        rtCodigo = new javax.swing.JLabel();
        btConsultar = new javax.swing.JButton();
        btDeletar = new javax.swing.JButton();
        btAtualizar = new javax.swing.JButton();
        btRestaurar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbServicos = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbProdutos = new javax.swing.JTable();
        rtServicos = new javax.swing.JLabel();
        rtProdutos = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        barraMenu = new javax.swing.JMenuBar();
        mbOpcoes = new javax.swing.JMenu();
        miRestaurar = new javax.swing.JMenuItem();
        miFechar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Planos");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        tbPlanos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tbPlanos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Preço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbPlanos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tbPlanos.setRowHeight(30);
        tbPlanos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPlanosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbPlanos);
        //minhas configs
        tbPlanos.getColumnModel().getColumn(0).setCellRenderer(
            new DefaultTableCellRenderer(){{setHorizontalAlignment(SwingConstants.CENTER);}}
        );
        tbPlanos.getColumnModel().getColumn(2).setCellRenderer(
            new DefaultTableCellRenderer(){{setHorizontalAlignment(SwingConstants.CENTER);}}
        );
        tbPlanos.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 18));
        //fim

        cxCodigo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        rtCodigo.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtCodigo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rtCodigo.setText("Código:");

        btConsultar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btConsultar.setText("Consultar...");
        btConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultarActionPerformed(evt);
            }
        });

        btDeletar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btDeletar.setText("Deletar...");
        btDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeletarActionPerformed(evt);
            }
        });

        btAtualizar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btAtualizar.setText("Atualizar...");
        btAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarActionPerformed(evt);
            }
        });

        btRestaurar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btRestaurar.setText("Restaurar Tabela");
        btRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRestaurarActionPerformed(evt);
            }
        });

        tbServicos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tbServicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Preço", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbServicos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tbServicos.setAutoscrolls(false);
        tbServicos.setMinimumSize(new java.awt.Dimension(380, 0));
        tbServicos.setPreferredSize(new java.awt.Dimension(380, 0));
        tbServicos.setRowHeight(30);
        jScrollPane2.setViewportView(tbServicos);

        tbProdutos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tbProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Preço", "Perecível"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbProdutos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tbProdutos.setMinimumSize(new java.awt.Dimension(380, 0));
        tbProdutos.setPreferredSize(new java.awt.Dimension(380, 0));
        tbProdutos.setRowHeight(30);
        jScrollPane3.setViewportView(tbProdutos);

        rtServicos.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtServicos.setText("Serviços inclusos");

        rtProdutos.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtProdutos.setText("Produtos inclusos");

        mbOpcoes.setText("Opções");
        mbOpcoes.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N

        miRestaurar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        miRestaurar.setText("Restaurar Tabela");
        miRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRestaurarActionPerformed(evt);
            }
        });
        mbOpcoes.add(miRestaurar);

        miFechar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        miFechar.setText("Fechar");
        miFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miFecharActionPerformed(evt);
            }
        });
        mbOpcoes.add(miFechar);

        barraMenu.add(mbOpcoes);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(rtCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cxCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btConsultar)
                        .addGap(18, 18, 18)
                        .addComponent(btDeletar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAtualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                        .addComponent(btRestaurar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rtServicos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filler1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(121, 121, 121)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(rtProdutos))))
                .addGap(81, 81, 81))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cxCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btConsultar)
                    .addComponent(btDeletar)
                    .addComponent(btAtualizar)
                    .addComponent(btRestaurar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rtProdutos, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(filler1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rtServicos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        try {            
            listarTabPlanos();
        } catch (Exception ex) {}
    }//GEN-LAST:event_formWindowActivated

    private void miFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miFecharActionPerformed
        dispose();
    }//GEN-LAST:event_miFecharActionPerformed

    private void tbPlanosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPlanosMouseClicked
        selecTab();
    }//GEN-LAST:event_tbPlanosMouseClicked

    private void miRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRestaurarActionPerformed
        restaurar();
    }//GEN-LAST:event_miRestaurarActionPerformed

    private void btDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeletarActionPerformed
        deletarCod();
    }//GEN-LAST:event_btDeletarActionPerformed

    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
        atualizarCod();
    }//GEN-LAST:event_btAtualizarActionPerformed

    private void btRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRestaurarActionPerformed
        restaurar();
    }//GEN-LAST:event_btRestaurarActionPerformed

    private void btConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultarActionPerformed
        listarTabCod();
    }//GEN-LAST:event_btConsultarActionPerformed

    public void restaurar(){
        ((DefaultTableModel) tbServicos.getModel()).setRowCount(0);
        ((DefaultTableModel) tbProdutos.getModel()).setRowCount(0);
        try {
            if(!listarTabPlanos())
                JOptionPane.showMessageDialog(
                        null, "Sem planos cadastrados",
                        "Atenção!", JOptionPane.WARNING_MESSAGE
                );
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null, "Erro na busca:\n" + e,
                    "Erro!", JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    public boolean listarTabPlanos() throws Exception{
        DefaultTableModel modelo = (DefaultTableModel) tbPlanos.getModel();       

        int lin = 0;
        modelo.setRowCount(lin);
                
        for(Plano plano : Plano_Ctrl.getInstancia().ler_Plano()){                
                modelo.insertRow(lin, new Object[]{
                    plano.getId(),
                    plano.getNome(),
                    plano.getPreco()
                });
                lin++;                
        }                                        
        
        return lin != 0;
    }
      
    public void listarTabCod(){
        Plano plano = consultarPlano();
        if(plano!=null){        
            DefaultTableModel modelo = (DefaultTableModel) tbPlanos.getModel();       

            int lin = 0;
            modelo.setRowCount(lin);
            
            modelo.insertRow(lin, new Object[]{
                    plano.getId(),
                    plano.getNome(),
                    plano.getPreco()
            });
            listarTabServicos(plano.getId());
            listarTabProdutos(plano.getId());
        }
    }    
    
    public void listarTabServicos(int id){
        DefaultTableModel modelo = (DefaultTableModel) tbServicos.getModel();       

        int lin = 0;
        modelo.setRowCount(lin);
        
        try {
            for(Servico servico : Plano_Ctrl.getInstancia().getServicos(id)){                
                modelo.insertRow(lin, new Object[]{
                    servico.getNome(),
                    servico.getPreco(),
                    servico.getTipo()
                });
                lin++;                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null, "Erro na busca de serviços associados:\n" + e,
                    "Erro!", JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    public void listarTabProdutos(int id){
        DefaultTableModel modelo = (DefaultTableModel) tbProdutos.getModel();       

        int lin = 0;
        modelo.setRowCount(lin);
        
        try {
            for(Produto produto : Plano_Ctrl.getInstancia().getProdutos(id)){                
                modelo.insertRow(lin, new Object[]{
                    produto.getNome(),
                    produto.getPreco(),
                    produto.isPerecivel()
                });
                lin++;                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null, "Erro na busca de produtos associados:\n" + e,
                    "Erro!", JOptionPane.ERROR_MESSAGE
            );            
        }                      
    }
    
    public void selecTab(){
        int linSelec = tbPlanos.getSelectedRow();

        if(linSelec<0) return;
                
        
        Plano planoSelec = null;
        try {
            planoSelec = Plano_Ctrl.getInstancia().ler_Plano(
                    Integer.parseInt(tbPlanos.getValueAt(linSelec, 1).toString())
            );
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null, "Erro na busca:\n" + e,
                    "Erro!", JOptionPane.ERROR_MESSAGE
            );
        }

        if(planoSelec != null){
            listarTabServicos(planoSelec.getId());
            listarTabProdutos(planoSelec.getId());
        }        
        
    }
 
    public void deletarCod(){
        Plano plano = consultarPlano();
        if(plano!=null) deletar(plano);         
    }
    
    public void atualizarCod(){
        Plano plano = consultarPlano();
        if(plano!=null) atualizar(plano);        
    }       
    
    public Plano consultarPlano(){
        int cod;
        try{
            cod = Integer.parseInt(cxCodigo.getText());        
           
            Plano plano = Plano_Ctrl.getInstancia().ler_Plano(cod);
            if(plano==null)
                JOptionPane.showMessageDialog(
                    null, "Plano não encontrado",
                    "Código: "+cxCodigo.getText(), JOptionPane.INFORMATION_MESSAGE
                );
            return plano;
            
        }catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(
                    null, "O código deve ser um inteiro!", 
                    "Atenção!", JOptionPane.WARNING_MESSAGE
                );
        }catch(Exception e){
            JOptionPane.showMessageDialog(
                    null, "Erro na busca:\n" + e,
                    "Erro!", JOptionPane.ERROR_MESSAGE
            );
        }
        
        return null;
    }
    
    private void deletar(Plano plano){
        int o = JOptionPane.showOptionDialog(
                        null, "Deseja realmente deletar o plano?", "Id do plano: "+plano.getId(),
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, 
                        null, new Object[]{"Sim...", "Não"}, "Não"
                );
        if(o==0){
            try {
                if(Plano_Ctrl.getInstancia().del_Plano(plano))
                    JOptionPane.showMessageDialog(
                            null, "Plano deletado!",
                            "Sucesso!", JOptionPane.INFORMATION_MESSAGE
                    );
                else{
                    JOptionPane.showMessageDialog(
                            null, "Plano não encontrado!",
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
    
    private void atualizar(Plano plano){
        if(plano==null) return;
        navegador.mostrarJAltPlano(plano);
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
            java.util.logging.Logger.getLogger(JRelatorioPlano.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JRelatorioPlano.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JRelatorioPlano.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JRelatorioPlano.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JRelatorioPlano(new NavegadorUI(), false).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btConsultar;
    private javax.swing.JButton btDeletar;
    private javax.swing.JButton btRestaurar;
    private javax.swing.JTextField cxCodigo;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JMenu mbOpcoes;
    private javax.swing.JMenuItem miFechar;
    private javax.swing.JMenuItem miRestaurar;
    private javax.swing.JLabel rtCodigo;
    private javax.swing.JLabel rtProdutos;
    private javax.swing.JLabel rtServicos;
    private javax.swing.JTable tbPlanos;
    private javax.swing.JTable tbProdutos;
    private javax.swing.JTable tbServicos;
    // End of variables declaration//GEN-END:variables

}