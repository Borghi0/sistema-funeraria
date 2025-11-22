package View;

import Control.NavegadorUI;
import Model.Usuario;
import javax.swing.JOptionPane;
import Interfaces.I_JanelaRaiz;
import Model.Plano;
import Model.Produto;
import Model.Servico;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;


public class JMenuUsuario extends javax.swing.JFrame implements I_JanelaRaiz{
    private NavegadorUI navegador;
    private Usuario usuario;
    
    public JMenuUsuario(NavegadorUI navegador, Usuario usuario) {
        this.navegador = navegador;
        this.usuario = usuario;
        initComponents();        
        setLocationRelativeTo(null);
        
        if(usuario.getPlano()==null){
            rtPlano.setText("Você ainda não tem um plano :(");
            btPlano.setVisible(true);
        }else{
            rtPlano.setText("Seu plano: "+usuario.getPlano().getNome());
            btPlano.setVisible(false);
        }        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rtTitulo = new javax.swing.JLabel();
        rtProdutos = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jScrollPane2 = new javax.swing.JScrollPane();
        tbServicos = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbProdutos = new javax.swing.JTable();
        rtServicos = new javax.swing.JLabel();
        rtPlano = new javax.swing.JLabel();
        btPlano = new javax.swing.JButton();
        mnBar = new javax.swing.JMenuBar();
        mnOpcoes = new javax.swing.JMenu();
        miAdqPlano = new javax.swing.JMenuItem();
        miAltInfo = new javax.swing.JMenuItem();
        miAltInfo1 = new javax.swing.JMenuItem();
        miSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu de usuário");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        rtTitulo.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        rtTitulo.setText("Bem vindo(a), <nome>");
        rtTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        rtProdutos.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtProdutos.setText("Produtos inclusos");

        tbServicos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tbServicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
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
        jScrollPane2.setViewportView(tbServicos);
        //minhas configs
        tbServicos.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        //fim

        tbProdutos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tbProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Perecível"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbProdutos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tbProdutos.setMinimumSize(new java.awt.Dimension(380, 0));
        tbProdutos.setPreferredSize(new java.awt.Dimension(380, 0));
        tbProdutos.setRowHeight(30);
        tbProdutos.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tbProdutos);
        //minhas configs
        tbServicos.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        //fim

        rtServicos.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtServicos.setText("Serviços inclusos");

        rtPlano.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        rtPlano.setText("Seu plano: <plano>");

        btPlano.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btPlano.setText("Adquirir plano");
        btPlano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPlanoActionPerformed(evt);
            }
        });

        mnOpcoes.setText("Opções");
        mnOpcoes.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N

        miAdqPlano.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        miAdqPlano.setText("Adquirir plano...");
        miAdqPlano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAdqPlanoActionPerformed(evt);
            }
        });
        mnOpcoes.add(miAdqPlano);

        miAltInfo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        miAltInfo.setText("Atualizar informações...");
        miAltInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAltInfoActionPerformed(evt);
            }
        });
        mnOpcoes.add(miAltInfo);

        miAltInfo1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        miAltInfo1.setText("Restaurar tebelas");
        miAltInfo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAltInfo1ActionPerformed(evt);
            }
        });
        mnOpcoes.add(miAltInfo1);

        miSair.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        miSair.setText("Sair...");
        miSair.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        miSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSairActionPerformed(evt);
            }
        });
        mnOpcoes.add(miSair);

        mnBar.add(mnOpcoes);

        setJMenuBar(mnBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rtPlano)
                        .addGap(51, 51, 51)
                        .addComponent(btPlano)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rtServicos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filler1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                            .addComponent(rtProdutos))
                        .addGap(30, 30, 30))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rtTitulo)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(rtTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btPlano, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rtPlano, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rtProdutos, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(filler1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rtServicos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSairActionPerformed
        sair();
    }//GEN-LAST:event_miSairActionPerformed

    private void miAltInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAltInfoActionPerformed
        jAlterarUsuario();
    }//GEN-LAST:event_miAltInfoActionPerformed

    private void miAdqPlanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAdqPlanoActionPerformed
        navegador.mostrarJRelatorioPlano(usuario);
    }//GEN-LAST:event_miAdqPlanoActionPerformed

    private void btPlanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPlanoActionPerformed
        navegador.mostrarJRelatorioPlano(usuario);
    }//GEN-LAST:event_btPlanoActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        listarTab();
    }//GEN-LAST:event_formWindowActivated

    private void miAltInfo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAltInfo1ActionPerformed
        listarTab();
    }//GEN-LAST:event_miAltInfo1ActionPerformed

    private void jAlterarUsuario(){        
        setVisible(false);
        new JAlterarUsuario(this, usuario).setVisible(true);
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
    
    private void listarTab(){
        Plano plano = usuario.getPlano();
        if(plano==null){
            rtPlano.setText("Você ainda não tem um plano :(");
            btPlano.setVisible(true);
            return;
        }
        rtPlano.setText("Seu plano: "+plano.getNome());
        btPlano.setVisible(false);
        
        DefaultTableModel modeloSer = (DefaultTableModel) tbServicos.getModel();       

        int lin = 0;
        modeloSer.setRowCount(lin);        
        
        for(Servico servico : plano.getLista_Servico()){                
            modeloSer.insertRow(lin, new Object[]{
                servico.getNome(),                
                servico.getTipo()
            });
            lin++;                
        }
        
        
        DefaultTableModel modeloPro = (DefaultTableModel) tbProdutos.getModel();       

        lin = 0;
        modeloPro.setRowCount(lin);
        
        for(Produto produto : plano.getLista_Produto()){                
            modeloPro.insertRow(lin, new Object[]{
                produto.getNome(),                
                produto.isPerecivel()
            });
            lin++;                
        }        
    }        
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btPlano;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JMenuItem miAdqPlano;
    private javax.swing.JMenuItem miAltInfo;
    private javax.swing.JMenuItem miAltInfo1;
    private javax.swing.JMenuItem miSair;
    private javax.swing.JMenuBar mnBar;
    private javax.swing.JMenu mnOpcoes;
    private javax.swing.JLabel rtPlano;
    private javax.swing.JLabel rtProdutos;
    private javax.swing.JLabel rtServicos;
    private javax.swing.JLabel rtTitulo;
    private javax.swing.JTable tbProdutos;
    private javax.swing.JTable tbServicos;
    // End of variables declaration//GEN-END:variables
        
    public Usuario getUsuario(){
        return usuario;
    }
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }

    @Override
    public void voltar() {}
    @Override
    public void voltar(Object objeto) {
        usuario = (Usuario) objeto;
        this.setVisible(true);        
    }
}
