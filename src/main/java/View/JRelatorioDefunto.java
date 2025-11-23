package View;

import Control.Defunto_Ctrl;
import Model.Defunto;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class JRelatorioDefunto extends javax.swing.JFrame {
    
    public JRelatorioDefunto() {
        initComponents();
        setLocationRelativeTo(null);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        tbDefuntos = new javax.swing.JTable();
        barraMenu = new javax.swing.JMenuBar();
        mbOpcoes1 = new javax.swing.JMenu();
        miRestaurar = new javax.swing.JMenuItem();
        miFechar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Relatório de defuntos");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        tbDefuntos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tbDefuntos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Nascimento", "Data de óbito", "Tipo de óbito", "Cemitério"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbDefuntos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tbDefuntos.setAutoscrolls(false);
        tbDefuntos.setMinimumSize(new java.awt.Dimension(380, 0));
        tbDefuntos.setPreferredSize(new java.awt.Dimension(380, 0));
        tbDefuntos.setRowHeight(30);
        tbDefuntos.getTableHeader().setReorderingAllowed(false);
        tbDefuntos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDefuntosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbDefuntos);

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
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1083, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRestaurarActionPerformed
        listar_tabela();
    }//GEN-LAST:event_miRestaurarActionPerformed

    private void miFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miFecharActionPerformed
        dispose();
    }//GEN-LAST:event_miFecharActionPerformed

    private void tbDefuntosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDefuntosMouseClicked
        selecTab();
    }//GEN-LAST:event_tbDefuntosMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        listar_tabela();
    }//GEN-LAST:event_formWindowActivated

    private void listar_tabela(){
        int linha = 0;
        DefaultTableModel modelo = (DefaultTableModel) tbDefuntos.getModel();
        
        tbDefuntos.setDefaultEditor(Object.class, null);
        
        try{
            for(Defunto d : Defunto_Ctrl.getInstancia().ler_Defunto()){
                modelo.insertRow(linha, new Object[]{
                    d.getId(), d.getNome(), d.getDataNatalidade(), d.getDataObito(),
                    d.getTipoObito(), d.getCemiterio()                    
                });

                linha++;
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar defuntos",
                    "Erro", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }
    
    private void selecTab(){
        int linSelec = tbDefuntos.getSelectedRow();

        if(linSelec<0) return;
                
        
        Defunto defSelec = new Defunto();       
        defSelec.setId((Integer) tbDefuntos.getValueAt(linSelec, 0));                                                
        
        deletar(defSelec);   
        
    }
    
    private void deletar(Defunto def){
        int o = JOptionPane.showOptionDialog(null, "Deseja deletar o defunto?", "Id do defunto: "+def.getId(),
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, 
                        null, new Object[]{"Sim...", "Não"}, "Não"
                );
        if(o==0){
            try {
                if(Defunto_Ctrl.getInstancia().del_Defunto(def)>0)
                    JOptionPane.showMessageDialog(
                            null, "Defunto deletado!",
                            "Sucesso!", JOptionPane.INFORMATION_MESSAGE
                    );
                else{
                    JOptionPane.showMessageDialog(
                            null, "Defunto não encontrado!",
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
            java.util.logging.Logger.getLogger(JRelatorioDefunto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JRelatorioDefunto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JRelatorioDefunto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JRelatorioDefunto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JRelatorioDefunto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JMenu mbOpcoes1;
    private javax.swing.JMenuItem miFechar;
    private javax.swing.JMenuItem miRestaurar;
    private javax.swing.JTable tbDefuntos;
    // End of variables declaration//GEN-END:variables
}
