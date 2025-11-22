package View;


import Control.NavegadorUI;
import Control.Velorio_Ctrl;
import Model.Defunto;
import Model.Sala;
import Model.Usuario;
import Model.Velorio;
import java.awt.Component;
import java.awt.Font;
import java.time.LocalDateTime;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import Interfaces.JanelaRaiz;


public class JAdmin extends javax.swing.JFrame implements JanelaRaiz{    
    private NavegadorUI navegador;
    private Usuario usuario;
    
        
    public JAdmin(NavegadorUI navegador, Usuario usuario) {
        this.navegador = navegador;
        this.usuario = usuario;
        initComponents();        
        setLocationRelativeTo(null);        
        tbVelorio.getColumnModel().removeColumn(tbVelorio.getColumnModel().getColumn(4));
    }        
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbVelorio = new javax.swing.JTable();
        barraMenu = new javax.swing.JMenuBar();
        mnOpcoes = new javax.swing.JMenu();
        mnRelatorios = new javax.swing.JMenu();
        mnRelatPessoa = new javax.swing.JMenu();
        miRelatUsuarios = new javax.swing.JMenuItem();
        miRelatDefuntos = new javax.swing.JMenuItem();
        mnRelatOfertaveis = new javax.swing.JMenu();
        miRelatPlanos = new javax.swing.JMenuItem();
        miRelatServicos = new javax.swing.JMenuItem();
        miRelatProdutos = new javax.swing.JMenuItem();
        miRelatSalas = new javax.swing.JMenuItem();
        mnCadastrar = new javax.swing.JMenu();
        mnCadOfertavel = new javax.swing.JMenu();
        miCadPlano = new javax.swing.JMenuItem();
        miCadServico = new javax.swing.JMenuItem();
        miCadProduto = new javax.swing.JMenuItem();
        miCadVelorio = new javax.swing.JMenuItem();
        miCadSala = new javax.swing.JMenuItem();
        miRestaurar1 = new javax.swing.JMenuItem();
        miAltInfo = new javax.swing.JMenuItem();
        miSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Admin");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        tbVelorio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tbVelorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Sala", "Lotação", "Falecido", "Id do falecido"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbVelorio.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tbVelorio.setRowHeight(30);
        tbVelorio.getTableHeader().setReorderingAllowed(false);
        tbVelorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbVelorioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbVelorio);
        //minhas configs
        tbVelorio.getColumnModel().getColumn(0).setCellRenderer(
            new DefaultTableCellRenderer(){{setHorizontalAlignment(SwingConstants.CENTER);}}
        );
        tbVelorio.getColumnModel().getColumn(1).setCellRenderer(
            new DefaultTableCellRenderer(){{setHorizontalAlignment(SwingConstants.CENTER);}}
        );
        tbVelorio.getColumnModel().getColumn(2).setCellRenderer(
            new DefaultTableCellRenderer(){{setHorizontalAlignment(SwingConstants.CENTER);}}
        );

        TableCellRenderer centerHeaderRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(
                JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int column){
                JLabel lbl = (JLabel) tbVelorio.getTableHeader().getDefaultRenderer().getTableCellRendererComponent(
                    table, value, isSelected, hasFocus, row, column
                );
                lbl.setHorizontalAlignment(SwingConstants.CENTER);
                return lbl;
            }
        };
        tbVelorio.getColumnModel().getColumn(0).setHeaderRenderer(centerHeaderRenderer);
        tbVelorio.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        //fim

        mnOpcoes.setText("Opções");
        mnOpcoes.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N

        mnRelatorios.setText("Relatórios");
        mnRelatorios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        mnRelatPessoa.setText("Pessoas");
        mnRelatPessoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        miRelatUsuarios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        miRelatUsuarios.setText("Usuários...");
        miRelatUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRelatUsuariosActionPerformed(evt);
            }
        });
        mnRelatPessoa.add(miRelatUsuarios);

        miRelatDefuntos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        miRelatDefuntos.setText("Defuntos...");
        miRelatDefuntos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRelatDefuntosActionPerformed(evt);
            }
        });
        mnRelatPessoa.add(miRelatDefuntos);

        mnRelatorios.add(mnRelatPessoa);

        mnRelatOfertaveis.setText("Ofertáveis");
        mnRelatOfertaveis.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        miRelatPlanos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        miRelatPlanos.setText("Planos...");
        miRelatPlanos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRelatPlanosActionPerformed(evt);
            }
        });
        mnRelatOfertaveis.add(miRelatPlanos);

        miRelatServicos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        miRelatServicos.setText("Serviços...");
        miRelatServicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRelatServicosActionPerformed(evt);
            }
        });
        mnRelatOfertaveis.add(miRelatServicos);

        miRelatProdutos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        miRelatProdutos.setText("Produtos...");
        miRelatProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRelatProdutosActionPerformed(evt);
            }
        });
        mnRelatOfertaveis.add(miRelatProdutos);

        mnRelatorios.add(mnRelatOfertaveis);

        miRelatSalas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        miRelatSalas.setText("Salas...");
        miRelatSalas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRelatSalasActionPerformed(evt);
            }
        });
        mnRelatorios.add(miRelatSalas);

        mnOpcoes.add(mnRelatorios);

        mnCadastrar.setText("Cadastrar");
        mnCadastrar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        mnCadOfertavel.setText("Ofertável");
        mnCadOfertavel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        miCadPlano.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        miCadPlano.setText("Plano...");
        miCadPlano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCadPlanoActionPerformed(evt);
            }
        });
        mnCadOfertavel.add(miCadPlano);

        miCadServico.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        miCadServico.setText("Serviço...");
        miCadServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCadServicoActionPerformed(evt);
            }
        });
        mnCadOfertavel.add(miCadServico);

        miCadProduto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        miCadProduto.setText("Produto...");
        mnCadOfertavel.add(miCadProduto);

        mnCadastrar.add(mnCadOfertavel);

        miCadVelorio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        miCadVelorio.setText("Velório...");
        miCadVelorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCadVelorioActionPerformed(evt);
            }
        });
        mnCadastrar.add(miCadVelorio);

        miCadSala.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        miCadSala.setText("Sala...");
        miCadSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCadSalaActionPerformed(evt);
            }
        });
        mnCadastrar.add(miCadSala);

        mnOpcoes.add(mnCadastrar);

        miRestaurar1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        miRestaurar1.setText("Restaurar Tabela");
        miRestaurar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRestaurar1ActionPerformed(evt);
            }
        });
        mnOpcoes.add(miRestaurar1);

        miAltInfo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        miAltInfo.setText("Alterar informações...");
        miAltInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAltInfoActionPerformed(evt);
            }
        });
        mnOpcoes.add(miAltInfo);

        miSair.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        miSair.setText("Sair...");
        miSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSairActionPerformed(evt);
            }
        });
        mnOpcoes.add(miSair);

        barraMenu.add(mnOpcoes);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1043, Short.MAX_VALUE)
                .addGap(80, 80, 80))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSairActionPerformed
        sair();
    }//GEN-LAST:event_miSairActionPerformed

    private void miAltInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAltInfoActionPerformed
        jAlterarUsuario();
    }//GEN-LAST:event_miAltInfoActionPerformed

    private void miRelatSalasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRelatSalasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miRelatSalasActionPerformed

    private void miCadVelorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCadVelorioActionPerformed
        navegador.mostrarJCadAltVelorio(null, true);
    }//GEN-LAST:event_miCadVelorioActionPerformed

    private void miCadSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCadSalaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miCadSalaActionPerformed

    private void miRelatPlanosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRelatPlanosActionPerformed
        navegador.mostrarJRelatorioPlano(usuario);
    }//GEN-LAST:event_miRelatPlanosActionPerformed

    private void miCadPlanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCadPlanoActionPerformed
        navegador.mostrarJCadAltPlano(null, true);
    }//GEN-LAST:event_miCadPlanoActionPerformed

    private void miCadServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCadServicoActionPerformed
        navegador.mostrarJCadRelatServico();
    }//GEN-LAST:event_miCadServicoActionPerformed

    private void miRelatServicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRelatServicosActionPerformed
        navegador.mostrarJCadRelatServico();
    }//GEN-LAST:event_miRelatServicosActionPerformed

    private void tbVelorioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbVelorioMouseClicked
        selecTabVelorio();
    }//GEN-LAST:event_tbVelorioMouseClicked

    private void miRestaurar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRestaurar1ActionPerformed
        restaurar();
    }//GEN-LAST:event_miRestaurar1ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        try{listarTabVelorio();}catch(Exception ex){}
    }//GEN-LAST:event_formWindowActivated

    private void miRelatDefuntosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRelatDefuntosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miRelatDefuntosActionPerformed

    private void miRelatUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRelatUsuariosActionPerformed
        navegador.mostrarJRelatorioUsuario();
    }//GEN-LAST:event_miRelatUsuariosActionPerformed

    private void miRelatProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRelatProdutosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miRelatProdutosActionPerformed
    
    private void jAlterarUsuario(){        
        setVisible(false);
        navegador.mostrarJAlterarUsuario(this, usuario);
    }
    
    private void sair(){
        int o = JOptionPane.showOptionDialog(                
                null,
                "Realmente deseja sair?",
                "Sair",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, 
                null,
                new Object[] {"Sim", "Não"},
                "Não"
        );
        if(o==0){            
            navegador.deslogar();
        }
    }
    
    private void restaurar(){
        try{
            listarTabVelorio();            
        }catch(Exception e){
            JOptionPane.showMessageDialog(
                    null, "Erro na busca:\n" + e,
                    "Erro!", JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    private void listarTabVelorio() throws Exception{                
        DefaultTableModel modelo = (DefaultTableModel) tbVelorio.getModel();       

        int lin = 0;
        modelo.setRowCount(lin);
                
        for(Velorio velorio : Velorio_Ctrl.getInstancia().ler_Velorio()){
            modelo.insertRow(lin, new Object[]{                    
                velorio.getData(),
                velorio.getSala().getNumero(),
                velorio.getSala().getCapacidade(),
                velorio.getDefunto().getNome(),
                velorio.getDefunto().getId()
            });
            lin++;
        }
    }
    
    private void selecTabVelorio(){
        int linSelec = tbVelorio.getSelectedRow();
        
        if(linSelec<0) return;   
        
        Velorio velorio = new Velorio(
                new Sala(0, (Integer) tbVelorio.getValueAt(linSelec, 1)),
                (LocalDateTime) tbVelorio.getValueAt(linSelec, 0),
                new Defunto(null, null, null, null, null, (Integer) tbVelorio.getModel().getValueAt(linSelec, 4))
        );
        
        int o = JOptionPane.showOptionDialog(
                null,
                "O que gostaria de fazer?",
                "Velório de: "+(String) velorio.getDefunto().getNome(),
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"Deletar", "Alterar", "Cancelar"},
                "Cancelar"
        );
        
        if(o==0) deletar(velorio);
        else if(o==1) navegador.mostrarJCadAltVelorio(velorio, false);
 
        
    }
    
    private void deletar(Velorio velorio){
        int o = JOptionPane.showOptionDialog(
                        null, "Deseja realmente deletar o velorio?", "Deletar",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, 
                        null, new Object[]{"Sim...", "Não"}, "Não"
                );
        if(o==0){
            try {
                if(Velorio_Ctrl.getInstancia().del_Velorio(velorio) > 0)
                    JOptionPane.showMessageDialog(
                            null, "Velorio deletado!",
                            "Sucesso!", JOptionPane.INFORMATION_MESSAGE
                    );
                else{
                    JOptionPane.showMessageDialog(
                            null, "Velorio não encontrado!",
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
            java.util.logging.Logger.getLogger(JCadAltPlano.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JCadAltPlano.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JCadAltPlano.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JCadAltPlano.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JAdmin(new NavegadorUI(), null).setVisible(true);
            }
        });
    }    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem miAltInfo;
    private javax.swing.JMenuItem miCadPlano;
    private javax.swing.JMenuItem miCadProduto;
    private javax.swing.JMenuItem miCadSala;
    private javax.swing.JMenuItem miCadServico;
    private javax.swing.JMenuItem miCadVelorio;
    private javax.swing.JMenuItem miRelatDefuntos;
    private javax.swing.JMenuItem miRelatPlanos;
    private javax.swing.JMenuItem miRelatProdutos;
    private javax.swing.JMenuItem miRelatSalas;
    private javax.swing.JMenuItem miRelatServicos;
    private javax.swing.JMenuItem miRelatUsuarios;
    private javax.swing.JMenuItem miRestaurar1;
    private javax.swing.JMenuItem miSair;
    private javax.swing.JMenu mnCadOfertavel;
    private javax.swing.JMenu mnCadastrar;
    private javax.swing.JMenu mnOpcoes;
    private javax.swing.JMenu mnRelatOfertaveis;
    private javax.swing.JMenu mnRelatPessoa;
    private javax.swing.JMenu mnRelatorios;
    private javax.swing.JTable tbVelorio;
    // End of variables declaration//GEN-END:variables

    
    public Usuario getUsuario(){
        return usuario;
    }
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
        
    @Override
    public void voltar(Object objeto) {
        usuario = (Usuario) objeto;
        this.setVisible(true);   
    }

}