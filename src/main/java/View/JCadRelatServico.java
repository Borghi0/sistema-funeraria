package View;

import Control.Servico_Ctrl;
import Model.Servico;
import java.awt.Component;
import java.awt.Font;
import java.sql.SQLException;
import java.time.DateTimeException;
import java.time.LocalDate;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;


public class JCadRelatServico extends javax.swing.JFrame {
    private TableColumn colPrestacao;

    public JCadRelatServico() {        
        initComponents();
        setLocationRelativeTo(null);

        colPrestacao = tbServicos.getColumnModel().getColumn(4);
        rbGenericos.doClick();        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        opcaoSelec = new javax.swing.ButtonGroup();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbServicos = new javax.swing.JTable();
        rbGenericos = new javax.swing.JRadioButton();
        rbProgramados = new javax.swing.JRadioButton();
        rtNome = new javax.swing.JLabel();
        cxNome = new javax.swing.JTextField();
        rtPreco = new javax.swing.JLabel();
        cxPreco = new javax.swing.JTextField();
        rtTipo = new javax.swing.JLabel();
        cxTipo = new javax.swing.JTextField();
        btConfirmar = new javax.swing.JButton();
        barraMenu = new javax.swing.JMenuBar();
        mbOpcoes1 = new javax.swing.JMenu();
        miRestaurar = new javax.swing.JMenuItem();
        miFechar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Serviços");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        tbServicos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tbServicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Serviço", "Preço", "Tipo", "Prestação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
        tbServicos.getTableHeader().setReorderingAllowed(false);
        tbServicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbServicosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbServicos);
        //minhas configs
        tbServicos.getColumnModel().getColumn(0).setCellRenderer(
            new DefaultTableCellRenderer(){{setHorizontalAlignment(SwingConstants.CENTER);}}
        );
        tbServicos.getColumnModel().getColumn(1).setCellRenderer(
            new DefaultTableCellRenderer(){{setHorizontalAlignment(SwingConstants.CENTER);}}
        );
        tbServicos.getColumnModel().getColumn(2).setCellRenderer(
            new DefaultTableCellRenderer(){{setHorizontalAlignment(SwingConstants.CENTER);}}
        );

        TableCellRenderer centerHeaderRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(
                JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int column){
                JLabel lbl = (JLabel) tbServicos.getTableHeader().getDefaultRenderer().getTableCellRendererComponent(
                    table, value, isSelected, hasFocus, row, column
                );
                lbl.setHorizontalAlignment(SwingConstants.CENTER);
                return lbl;
            }
        };
        tbServicos.getColumnModel().getColumn(0).setHeaderRenderer(centerHeaderRenderer);
        tbServicos.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        //fim

        opcaoSelec.add(rbGenericos);
        rbGenericos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        rbGenericos.setText("Genéricos");
        rbGenericos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbGenericosActionPerformed(evt);
            }
        });

        opcaoSelec.add(rbProgramados);
        rbProgramados.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        rbProgramados.setText("Programados");
        rbProgramados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbProgramadosActionPerformed(evt);
            }
        });

        rtNome.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtNome.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rtNome.setText("Nome:");

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

        rtTipo.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtTipo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rtTipo.setText("Tipo:");

        cxTipo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cxTipo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cxTipoFocusLost(evt);
            }
        });
        cxTipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cxTipoKeyPressed(evt);
            }
        });

        btConfirmar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btConfirmar.setText("Registrar");
        btConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmarActionPerformed(evt);
            }
        });

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
                        .addComponent(cxNome, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                        .addGap(40, 40, 40)
                        .addComponent(rtTipo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cxTipo, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                        .addGap(45, 45, 45)
                        .addComponent(rtPreco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cxPreco, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                        .addGap(51, 51, 51)
                        .addComponent(btConfirmar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rbGenericos)
                        .addGap(18, 18, 18)
                        .addComponent(rbProgramados)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cxNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cxPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btConfirmar))
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbGenericos)
                    .addComponent(rbProgramados))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

    private void tbServicosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbServicosMouseClicked
        selecTabServicos();
    }//GEN-LAST:event_tbServicosMouseClicked

    private void rbGenericosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbGenericosActionPerformed
        restaurar();
    }//GEN-LAST:event_rbGenericosActionPerformed

    private void rbProgramadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbProgramadosActionPerformed
        restaurar();
    }//GEN-LAST:event_rbProgramadosActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        try{listarTabServicos();} catch(Exception e){}
    }//GEN-LAST:event_formWindowActivated

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

    private void cxTipoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cxTipoFocusLost
        cxTipo.setText(cxTipo.getText().trim());
    }//GEN-LAST:event_cxTipoFocusLost

    private void cxTipoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cxTipoKeyPressed
        confirmar(evt);
    }//GEN-LAST:event_cxTipoKeyPressed

    private void btConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmarActionPerformed
        confirmar();
    }//GEN-LAST:event_btConfirmarActionPerformed

    private void restaurar(){
        try{
            listarTabServicos();            
        }catch(Exception e){
            JOptionPane.showMessageDialog(
                    null, "Erro na busca:\n" + e,
                    "Erro!", JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    private void confirmar(){
        cxNome.setText(cxNome.getText().trim());
        cxTipo.setText(cxTipo.getText().trim());
        cxPreco.setText(cxPreco.getText().replaceAll("[^0-9]", ""));
        cxPreco.setText(cxPreco.getText().replaceAll(",", "."));
        
        Servico servico = new Servico(
                null,
                cxTipo.getText(),
                Double.parseDouble(cxPreco.getText()),
                cxNome.getText(),
                0
        );
        
        try{
            Servico_Ctrl.getInstancia().cad_Servico(servico);
            
            JOptionPane.showMessageDialog(
                null,
                "Serviço cadastrado com sucesso!",
                "Sucesso",
                JOptionPane.INFORMATION_MESSAGE
            );
            limpar();
            rbGenericos.doClick();
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
    
    private void listarTabServicos() throws Exception{
        if(rbGenericos.isSelected()) listarTabGenericos();
        else if(rbProgramados.isSelected()) listarTabProgramados();
    }
    
    private void listarTabGenericos() throws Exception{
        tbServicos.getColumnModel().removeColumn(colPrestacao);
        
        DefaultTableModel modelo = (DefaultTableModel) tbServicos.getModel();       

        int lin = 0;
        modelo.setRowCount(lin);
                
        for(Servico servico : Servico_Ctrl.getInstancia().ler_ServicoGenerico()){
            modelo.insertRow(lin, new Object[]{                    
                servico.getId(),
                servico.getNome(),
                String.format("R$ %.2f", servico.getPreco()),
                servico.getTipo()
            });
            lin++;
        }
    }
    
    private void listarTabProgramados() throws Exception{
        if(tbServicos.getColumnModel().getColumnCount()<5) tbServicos.getColumnModel().addColumn(colPrestacao);
        
        DefaultTableModel modelo = (DefaultTableModel) tbServicos.getModel();       

        int lin = 0;
        modelo.setRowCount(lin);
                
        for(Servico servico : Servico_Ctrl.getInstancia().ler_ServicoProgramado()){
            modelo.insertRow(lin, new Object[]{                    
                servico.getId(),
                servico.getNome(),
                String.format("R$ %.2f", servico.getPreco()),
                servico.getTipo(),
                servico.getPrestacao()
            });
            lin++;
        }
    }
        
    private void selecTabServicos(){
        if(rbGenericos.isSelected()) selecTabGenericos();
        else if(rbProgramados.isSelected()) selecTabProgramados();
    }
    
    private void selecTabGenericos(){
        int linSelec = tbServicos.getSelectedRow();

        if(linSelec<0) return;
                
        
        Servico servicoSelec = new Servico(
                null,
                (String) tbServicos.getValueAt(linSelec, 3),
                (Double) tbServicos.getValueAt(linSelec, 2),
                (String) tbServicos.getValueAt(linSelec, 1),
                (Integer) tbServicos.getValueAt(linSelec, 0)
        );
        
                        
        int o = JOptionPane.showOptionDialog(
                null,
                "O que gostaria de fazer?",
                "Servico: "+servicoSelec.getId(),
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"Deletar", "Programar", "Cancelar"},
                "Cancelar"
        );
        
        if(o==0) deletar(servicoSelec);        
        else if(o==1) programar(servicoSelec);
    }
    
    private void selecTabProgramados(){
        int linSelec = tbServicos.getSelectedRow();

        if(linSelec<0) return;                
        
        Servico servicoSelec = new Servico();
        servicoSelec.setId((Integer) tbServicos.getValueAt(linSelec, 0));
        
        deletar(servicoSelec);        
    }
        
    private void deletar(Servico servico){
        int o = JOptionPane.showOptionDialog(
                        null, "Deseja realmente deletar o serviço?", "Id do serviço: "+servico.getId(),
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, 
                        null, new Object[]{"Sim...", "Não"}, "Não"
                );
        if(o==0){
            try {
                if(Servico_Ctrl.getInstancia().del_Servico(servico)>0)
                    JOptionPane.showMessageDialog(
                            null, "Serviço deletado!",
                            "Sucesso!", JOptionPane.INFORMATION_MESSAGE
                    );
                else{
                    JOptionPane.showMessageDialog(
                            null, "Serviço não encontrado!",
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
    
    private void programar(Servico servico){       
        JComboBox<Integer> cbDia = new JComboBox<>();
        for (int i = 1; i <= 31; i++) cbDia.addItem(i);        
        JComboBox<Integer> cbMes = new JComboBox<>();
        for (int i = 1; i <= 12; i++) cbMes.addItem(i);        
        JComboBox<Integer> cbAno = new JComboBox<>();
        for (int i = 2025; i <= 2050; i++) cbAno.addItem(i);
        
        Object[] msg = {
                "Dia:", cbDia,
                "Mês:", cbMes,
                "Ano:", cbAno
        };
                
        int o = JOptionPane.showOptionDialog(
                        null, msg, "Escolha a data",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, 
                        null, new Object[]{"Confirmar", "Cancelar"}, "Confirmar"
                );
                
        if(o==0){            
            try{
                servico.setPrestacao(
                    LocalDate.of(
                        (Integer) cbAno.getSelectedItem(), 
                        (Integer) cbMes.getSelectedItem(),
                        (Integer) cbDia.getSelectedItem()
                    )
                );
                Servico_Ctrl.getInstancia().cad_Servico(servico);                
                JOptionPane.showMessageDialog(
                            null, "Serviço programado!",
                            "Sucesso!", JOptionPane.INFORMATION_MESSAGE
                );                
            }catch(DateTimeException e){
                JOptionPane.showMessageDialog(
                    null, "Erro na data:\n" + e,
                    "Erro!", JOptionPane.ERROR_MESSAGE
                );
            }catch(ClassNotFoundException | SQLException e){
                JOptionPane.showMessageDialog(
                    null, "Erro ao cadastrar serviço:\n" + e,
                    "Erro!", JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }
    
    public void limpar(){                
        cxNome.setText("");
        cxTipo.setText("");
        cxPreco.setText("");
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
            java.util.logging.Logger.getLogger(JCadRelatServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JCadRelatServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JCadRelatServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JCadRelatServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JCadRelatServico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JButton btConfirmar;
    private javax.swing.JTextField cxNome;
    private javax.swing.JTextField cxPreco;
    private javax.swing.JTextField cxTipo;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JMenu mbOpcoes1;
    private javax.swing.JMenuItem miFechar;
    private javax.swing.JMenuItem miRestaurar;
    private javax.swing.ButtonGroup opcaoSelec;
    private javax.swing.JRadioButton rbGenericos;
    private javax.swing.JRadioButton rbProgramados;
    private javax.swing.JLabel rtNome;
    private javax.swing.JLabel rtPreco;
    private javax.swing.JLabel rtTipo;
    private javax.swing.JTable tbServicos;
    // End of variables declaration//GEN-END:variables
}
