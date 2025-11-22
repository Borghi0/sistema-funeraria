package View;

import Control.NavegadorUI;
import Control.Usuario_Ctrl;
import Model.Endereco;
import Model.Usuario;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JRelatorioUsuario extends javax.swing.JFrame {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(JRelatorioUsuario.class.getName());
    private NavegadorUI navegador;
    
    public JRelatorioUsuario(NavegadorUI navegador) {
        this.navegador = navegador;
        initComponents();       
        tbUsers.getColumnModel().removeColumn(tbUsers.getColumnModel().getColumn(8));
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbUsers = new javax.swing.JTable();
        barraMenu = new javax.swing.JMenuBar();
        mbOpcoes1 = new javax.swing.JMenu();
        miRestaurar1 = new javax.swing.JMenuItem();
        miFechar1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        tbUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nome", "CPF", "email", "Telefone", "Admin", "Logradouro", "Numero", "Plano", "Endereco"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbUsersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbUsers);

        mbOpcoes1.setText("Opções");
        mbOpcoes1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N

        miRestaurar1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        miRestaurar1.setText("Restaurar Tabela");
        miRestaurar1.addActionListener(this::miRestaurar1ActionPerformed);
        mbOpcoes1.add(miRestaurar1);

        miFechar1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        miFechar1.setText("Fechar");
        miFechar1.addActionListener(this::miFechar1ActionPerformed);
        mbOpcoes1.add(miFechar1);

        barraMenu.add(mbOpcoes1);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1045, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        listar_tabela();
    }//GEN-LAST:event_formWindowActivated

    private void miRestaurar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRestaurar1ActionPerformed
        listar_tabela();
    }//GEN-LAST:event_miRestaurar1ActionPerformed

    private void miFechar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miFechar1ActionPerformed
        dispose();
    }//GEN-LAST:event_miFechar1ActionPerformed

    private void tbUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbUsersMouseClicked
        selecTab();
    }//GEN-LAST:event_tbUsersMouseClicked
        
    private void listar_tabela(){
        int linha = 0;
        DefaultTableModel modelo = (DefaultTableModel) tbUsers.getModel();
        
        tbUsers.setDefaultEditor(Object.class, null);
        
        try{
            for(Usuario u : Usuario_Ctrl.getInstancia().ler_User()){
                modelo.insertRow(linha, new Object[]{
                    u.getNome(), u.getCpf(), u.getEmail(), u.getNumeroTelefone(),
                    (u.isAdmin() ? "Sim" : "Não"), u.getEndereco().getRua(),
                    u.getEndereco().getNumero(), u.getPlano().getId(), u.getEndereco()
                });

                linha++;
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar usuários",
                    "Erro", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }
    
    private void selecTab(){
        int linSelec = tbUsers.getSelectedRow();

        if(linSelec<0) return;
                
        
        Usuario userSelec = new Usuario();
        
        userSelec.setAdmin(tbUsers.getValueAt(linSelec, 4).toString().equals("Sim"));
        userSelec.setCpf((String) tbUsers.getValueAt(linSelec, 1));                
        userSelec.setEndereco((Endereco) tbUsers.getValueAt(linSelec, 8));
                        
        int o = JOptionPane.showOptionDialog(
                null,
                "O que gostaria de fazer?",
                "CPF: "+userSelec.getCpf(),
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"Deletar", "Tornar admin", "Cancelar"},
                "Cancelar"
        );
        
        if(o==0) deletar(userSelec);        
        else if(o==1) tornarAdmin(userSelec);
    }
    
    private void deletar(Usuario user){
        int o = JOptionPane.showOptionDialog(
                        null, "Deseja realmente deletar o usuário?", "CPF do usuário: "+user.getCpf(),
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, 
                        null, new Object[]{"Sim...", "Não"}, "Não"
                );
        if(o==0){
            try {
                if(Usuario_Ctrl.getInstancia().del_User(user)>0)
                    JOptionPane.showMessageDialog(
                            null, "Usuário deletado!",
                            "Sucesso!", JOptionPane.INFORMATION_MESSAGE
                    );
                else{
                    JOptionPane.showMessageDialog(
                            null, "Usuário não encontrado!",
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
    
    private void tornarAdmin(Usuario user){
        if(user.isAdmin()) return;
        
        int o = JOptionPane.showOptionDialog(
                        null, "Deseja realmente tonar o usuário um administrador?", "CPF do usuário: "+user.getCpf(),
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, 
                        null, new Object[]{"Sim...", "Não"}, "Não"
                );
        if(o==0){
            try {
                user.setAdmin(true);
                if(Usuario_Ctrl.getInstancia().del_User(user)>0)
                    JOptionPane.showMessageDialog(
                            null, "Usuário atualizado!",
                            "Sucesso!", JOptionPane.INFORMATION_MESSAGE
                    );
                else{
                    JOptionPane.showMessageDialog(
                            null, "Usuário não encontrado!",
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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new JRelatorioUsuario(new NavegadorUI()).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu mbOpcoes1;
    private javax.swing.JMenuItem miFechar1;
    private javax.swing.JMenuItem miRestaurar1;
    private javax.swing.JTable tbUsers;
    // End of variables declaration//GEN-END:variables
}
