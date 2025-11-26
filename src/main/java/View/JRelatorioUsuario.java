package View;

import Control.NavegadorUI;
import Control.UsuarioCtrl;
import Interfaces.Relatorio;
import Model.Endereco;
import Model.Usuario;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JRelatorioUsuario extends javax.swing.JFrame implements Relatorio{
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(JRelatorioUsuario.class.getName());
    private NavegadorUI navegador;
    private Usuario usuario;
    
    public JRelatorioUsuario(){
        initComponents();
    }
    
    public JRelatorioUsuario(NavegadorUI navegador, Usuario usuario) {
        this.navegador = navegador;
        this.usuario = usuario;
        initComponents();       
        tbUsers.getColumnModel().removeColumn(tbUsers.getColumnModel().getColumn(7));
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbUsers = new javax.swing.JTable();
        barraMenu = new javax.swing.JMenuBar();
        mbOpcoes1 = new javax.swing.JMenu();
        miFechar = new javax.swing.JMenuItem();

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
                "Nome", "CPF", "email", "Telefone", "Admin", "CEP", "Logradouro", "Numero", "Plano"
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

        miFechar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        miFechar.setText("Fechar");
        miFechar.addActionListener(this::miFecharActionPerformed);
        mbOpcoes1.add(miFechar);

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
        listarTabela();
    }//GEN-LAST:event_formWindowActivated

    private void tbUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbUsersMouseClicked
        if(evt.getButton() == java.awt.event.MouseEvent.BUTTON1){
            int linha = tbUsers.rowAtPoint(evt.getPoint());
            
            if(linha >= 0 && linha < tbUsers.getRowCount()) tbUsers.setRowSelectionInterval(linha, linha);
            else tbUsers.clearSelection();
        }
        selecTab();
    }//GEN-LAST:event_tbUsersMouseClicked

    /**
     * @param args the command line arguments
     */
    
    @Override
    public void listarTabela(){
        int linha = 0;
        DefaultTableModel modelo = (DefaultTableModel) tbUsers.getModel();
        
        tbUsers.setDefaultEditor(Object.class, null);
        
        try{
            for(Usuario u : UsuarioCtrl.getInstancia().lerUser()){
                modelo.insertRow(linha, new Object[]{
                    u.getNome(), u.getCpf(), u.getEmail(), u.getNumeroTelefone(),
                    (u.isAdmin() ? "Sim" : "Não"), u.getEndereco().getCep(),
                    u.getEndereco().getRua(), u.getEndereco().getNumero(), 
                    u.getPlano().getId()
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
        userSelec.setEndereco(new Endereco(
                (int) tbUsers.getValueAt(linSelec, 7),
                (String) tbUsers.getValueAt(linSelec, 6),
                (String) tbUsers.getValueAt(linSelec, 5)));
                        
        int o = JOptionPane.showOptionDialog(
                null,
                "O que gostaria de fazer?",
                "CPF: "+userSelec.getCpf(),
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"Deletar", "Mudar permissão", "Cancelar"},
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
                if(UsuarioCtrl.getInstancia().delUser(user)>0)
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
    
    void tornarAdmin(Usuario user){
        try{
            UsuarioCtrl.getInstancia().altUserSetAdmin(user);
        } catch(SQLException | ClassNotFoundException sql_cnf_e){
            JOptionPane.showMessageDialog(null, "Erro: " + sql_cnf_e.toString(),
                    "Erro de operação", JOptionPane.ERROR_MESSAGE);
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
        java.awt.EventQueue.invokeLater(() -> new JRelatorioUsuario().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu mbOpcoes1;
    private javax.swing.JMenuItem miFechar;
    private javax.swing.JTable tbUsers;
    // End of variables declaration//GEN-END:variables

    private void miFecharActionPerformed(ActionEvent e) {
        dispose();
    }
}
