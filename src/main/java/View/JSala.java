package View;

import Control.SalaCtrl;
import Interfaces.Relatorio;
import Interfaces.RelatorioIndividual;
import Model.Sala;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import Interfaces.JanelaRaiz;


public class JSala extends javax.swing.JFrame implements Relatorio, RelatorioIndividual{
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(JSala.class.getName());

    
    public JSala() {
        initComponents();
        setLocationRelativeTo(null);
        tbInfoSala.setComponentPopupMenu(pmOpcoesTabela);        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbSalas = new javax.swing.JTable();
        jProgressBar1 = new javax.swing.JProgressBar();
        pmOpcoesTabela = new javax.swing.JPopupMenu();
        pmiEditar = new javax.swing.JMenuItem();
        pmiDeletar = new javax.swing.JMenuItem();
        spInfoSala = new javax.swing.JScrollPane();
        tbInfoSala = new javax.swing.JTable();
        rtCodigo = new javax.swing.JLabel();
        cxCod = new javax.swing.JTextField();
        btConfirmar = new javax.swing.JButton();
        btConsultar = new javax.swing.JButton();
        mnBar = new javax.swing.JMenuBar();
        mnSala = new javax.swing.JMenu();
        mni_voltar = new javax.swing.JMenuItem();

        tbSalas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbSalas);

        pmiEditar.setText("Editar");
        pmiEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pmiEditarActionPerformed(evt);
            }
        });
        pmOpcoesTabela.add(pmiEditar);

        pmiDeletar.setText("Deletar");
        pmiDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pmiDeletarActionPerformed(evt);
            }
        });
        pmOpcoesTabela.add(pmiDeletar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Salas");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        tbInfoSala.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Sala", "Capacidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbInfoSala.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbInfoSalaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbInfoSalaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbInfoSalaMouseReleased(evt);
            }
        });
        spInfoSala.setViewportView(tbInfoSala);

        rtCodigo.setText("Código: ");

        cxCod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cxCodKeyPressed(evt);
            }
        });

        btConfirmar.setText("Cadastrar");
        btConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmarActionPerformed(evt);
            }
        });

        btConsultar.setText("Consultar");
        btConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultarActionPerformed(evt);
            }
        });

        mnSala.setText("Opções");
        mnSala.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        mni_voltar.setText("Voltar");
        mni_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mni_voltarActionPerformed(evt);
            }
        });
        mnSala.add(mni_voltar);

        mnBar.add(mnSala);

        setJMenuBar(mnBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spInfoSala, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rtCodigo)
                        .addGap(18, 18, 18)
                        .addComponent(cxCod, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btConsultar)
                .addGap(18, 18, 18)
                .addComponent(btConfirmar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rtCodigo)
                    .addComponent(cxCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btConfirmar)
                    .addComponent(btConsultar))
                .addGap(18, 18, 18)
                .addComponent(spInfoSala, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mni_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mni_voltarActionPerformed
        dispose();
    }//GEN-LAST:event_mni_voltarActionPerformed

    private void btConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmarActionPerformed
        cadSala();
        listarTabela();
    }//GEN-LAST:event_btConfirmarActionPerformed

    private void btConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultarActionPerformed
        relatIndividual();
        cxCod.setText("");
        cxCod.requestFocus();
    }//GEN-LAST:event_btConsultarActionPerformed

    private void tbInfoSalaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbInfoSalaMouseClicked
        if(evt.getButton() == java.awt.event.MouseEvent.BUTTON3){
            int linha = tbInfoSala.rowAtPoint(evt.getPoint());
            
            if(linha >= 0 && linha < tbInfoSala.getRowCount()) tbInfoSala.setRowSelectionInterval(linha, linha);
            else tbInfoSala.clearSelection();
        }
    }//GEN-LAST:event_tbInfoSalaMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        listarTabela();
    }//GEN-LAST:event_formWindowActivated

    private void pmiEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pmiEditarActionPerformed
        editarLinha();
        listarTabela();
    }//GEN-LAST:event_pmiEditarActionPerformed

    private void pmiDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pmiDeletarActionPerformed
        deletarLinha();
        listarTabela();
    }//GEN-LAST:event_pmiDeletarActionPerformed

    private void cxCodKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cxCodKeyPressed
       if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER){
           relatIndividual();
           cxCod.setText("");
           cxCod.requestFocus();
       }
    }//GEN-LAST:event_cxCodKeyPressed

    private void tbInfoSalaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbInfoSalaMousePressed
        if(evt.getButton() == java.awt.event.MouseEvent.BUTTON3){
            int linha = tbInfoSala.rowAtPoint(evt.getPoint());
            
            if(linha >= 0 && linha < tbInfoSala.getRowCount()) tbInfoSala.setRowSelectionInterval(linha, linha);
            else tbInfoSala.clearSelection();
        }
    }//GEN-LAST:event_tbInfoSalaMousePressed

    private void tbInfoSalaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbInfoSalaMouseReleased
        if(evt.getButton() == java.awt.event.MouseEvent.BUTTON3){
            int linha = tbInfoSala.rowAtPoint(evt.getPoint());
            
            if(linha >= 0 && linha < tbInfoSala.getRowCount()) tbInfoSala.setRowSelectionInterval(linha, linha);
            else tbInfoSala.clearSelection();
        }
    }//GEN-LAST:event_tbInfoSalaMouseReleased
    
    @Override
    public void listarTabela(){
        int lin = 0;
        DefaultTableModel modelo = (DefaultTableModel) tbInfoSala.getModel();
        
        modelo.setRowCount(0);
        
        try{
            for(Sala s : SalaCtrl.getInstancia().lerSala()){
                modelo.insertRow(lin, new Object[]{
                    s.getNumero(), s.getCapacidade()
                });

                lin++;
            }
        } catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + sqle.toString(),
                    "Erro na busca", JOptionPane.ERROR_MESSAGE);
            dispose();
        } catch(ClassNotFoundException cnfe){
            JOptionPane.showMessageDialog(null, "Erro de Conexão: " + cnfe.toString(),
                    "Banco não encontrado", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }
    
    public void editarLinha(){
        try{
            int linha = tbInfoSala.getSelectedRow(),
                num = 0;
            String opt = "";
            Sala s = new Sala();

            if(linha < 0 || linha > tbInfoSala.getRowCount()) return;
            
            num = (int) tbInfoSala.getValueAt(linha, 0);
            opt = JOptionPane.showInputDialog("Nova capacidade: ");
            if(opt != null){
                s.setNumero(num);
                s.setCapacidade(Integer.parseInt(opt));
            }

            SalaCtrl.getInstancia().altSala(s);
        } catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "Capacidade nova deve ser numérica",
                    "Erro de atualização", JOptionPane.ERROR_MESSAGE);
        } catch(SQLException | ClassNotFoundException sql_cnf_e){
            JOptionPane.showMessageDialog(null, "Erro: " + sql_cnf_e.toString(),
                    "Erro de SQL", JOptionPane.ERROR_MESSAGE);
        } catch(NullPointerException | ClassCastException np_cc_e){
            JOptionPane.showMessageDialog(null, "Erro: " + np_cc_e.toString(),
                    "Erro desconhecido", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void deletarLinha(){
        try{
            int linha = tbInfoSala.getSelectedRow(),
                num = 0,
                opt = 0;

            if(linha < 0 || linha > tbInfoSala.getRowCount()) return;
            
            num = (int) tbInfoSala.getValueAt(linha, 0);
            opt = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir esta linha?",
                    "Confirmação de exclusão", JOptionPane.YES_NO_OPTION);
            
            if(opt == JOptionPane.YES_OPTION){
                opt = SalaCtrl.getInstancia().delSala(num);
                
                if(opt > 0)
                    JOptionPane.showMessageDialog(null, "Sala excluída",
                            "Confirmação de exclusão", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "Capacidade nova deve ser numérica",
                    "Erro de atualização", JOptionPane.ERROR_MESSAGE);
        } catch(SQLException | ClassNotFoundException sql_cnf_e){
            JOptionPane.showMessageDialog(null, "Erro: " + sql_cnf_e.toString(),
                    "Erro de SQL", JOptionPane.ERROR_MESSAGE);
        } catch(NullPointerException | ClassCastException np_cc_e){
            JOptionPane.showMessageDialog(null, "Erro: " + np_cc_e.toString(),
                    "Erro desconhecido", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void cadSala(){
        int num = 0;
        Object mensagem = null;
        String capacidade = "";
        Sala s = new Sala();
        JLabel rtNum = new JLabel("Numero: "),
               rtCapacidade = new JLabel("Capacidade");
        JTextField cxNum = new JTextField(),
                   cxCapacidade = new JTextField();
        
        try{
            num = SalaCtrl.getInstancia().lerSala().size();
            cxNum.setText(Integer.toString(num + 1));
            cxNum.setEditable(false);
            mensagem = new Object[]{rtNum, cxNum,
                        rtCapacidade, cxCapacidade};
            JOptionPane.showMessageDialog(null, mensagem, "Cadastro de sala",
                    JOptionPane.QUESTION_MESSAGE);
            
            s.setNumero(num + 1);
            s.setCapacidade(Integer.parseInt(cxCapacidade.getText()));
            
            num = SalaCtrl.getInstancia().cadSala(s);
            
            if(num > 0)
                JOptionPane.showMessageDialog(null, "Cadastro realizado",
                        "Sucesso de operação", JOptionPane.INFORMATION_MESSAGE);
        } catch(SQLException | ClassNotFoundException sql_cnf_e){
            JOptionPane.showMessageDialog(null, "Erro: " + sql_cnf_e.toString(),
                    "Erro na operação", JOptionPane.ERROR_MESSAGE);
        } catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "Capacidade deve ser inteiro",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
    
    @Override
    public void relatIndividual(){
        int num = 0,
            capacidade = 0;
        Sala s = new Sala();
        Object mensagem = null;
        JLabel rtNum = new JLabel("Numero: "),
               rtCapacidade = new JLabel("Capacidade");
        JTextField cxNum = new JTextField(),
                   cxCapacidade = new JTextField();
        
        try{
            s = SalaCtrl.getInstancia().lerSala(Integer.parseInt(cxCod.getText()));
            
            cxNum.setText(Integer.toString(s.getNumero()));
            cxCapacidade.setText(Integer.toString(s.getCapacidade()));
            cxNum.setEditable(false);
            cxCapacidade.setEditable(false);
            
            mensagem = new Object[]{rtNum, cxNum, rtCapacidade, cxCapacidade};
            
            JOptionPane.showMessageDialog(null, mensagem, "Relatório de consulta",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "Código deve ser inteiro",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        } catch(SQLException | ClassNotFoundException sql_cnf_e){
            JOptionPane.showMessageDialog(null, "Erro: " + sql_cnf_e.toString(),
                    "Erro na operação", JOptionPane.ERROR_MESSAGE);
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
        java.awt.EventQueue.invokeLater(() -> new JSala().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConfirmar;
    private javax.swing.JButton btConsultar;
    private javax.swing.JTextField cxCod;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuBar mnBar;
    private javax.swing.JMenu mnSala;
    private javax.swing.JMenuItem mni_voltar;
    private javax.swing.JPopupMenu pmOpcoesTabela;
    private javax.swing.JMenuItem pmiDeletar;
    private javax.swing.JMenuItem pmiEditar;
    private javax.swing.JLabel rtCodigo;
    private javax.swing.JScrollPane spInfoSala;
    private javax.swing.JTable tbInfoSala;
    private javax.swing.JTable tbSalas;
    // End of variables declaration//GEN-END:variables
}
