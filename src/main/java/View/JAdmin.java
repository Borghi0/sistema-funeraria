package View;


import Interfaces.I_JanelaRaiz;
import Model.Usuario;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class JAdmin extends javax.swing.JFrame implements I_JanelaRaiz{
    private static JAdmin instancia;
    private Usuario usuario;
    
        
    private JAdmin() {
        initComponents();        
        setLocationRelativeTo(null);
        setExtendedState(MAXIMIZED_BOTH);
    }
    
    public static JAdmin getInstancia(){
        if(instancia==null) instancia = new JAdmin();        
        return instancia;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        miRelatVelorios = new javax.swing.JMenuItem();
        miRelatSalas = new javax.swing.JMenuItem();
        mnCadastrar = new javax.swing.JMenu();
        mnCadOfertavel = new javax.swing.JMenu();
        miCadPlano = new javax.swing.JMenuItem();
        miCadServico = new javax.swing.JMenuItem();
        miCadProduto = new javax.swing.JMenuItem();
        miCadVelorio = new javax.swing.JMenuItem();
        miCadSala = new javax.swing.JMenuItem();
        miAltInfo = new javax.swing.JMenuItem();
        miSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório");

        mnOpcoes.setText("Opções");
        mnOpcoes.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N

        mnRelatorios.setText("Relatórios");
        mnRelatorios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        mnRelatPessoa.setText("Pessoas");
        mnRelatPessoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        miRelatUsuarios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        miRelatUsuarios.setText("Usuários...");
        mnRelatPessoa.add(miRelatUsuarios);

        miRelatDefuntos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        miRelatDefuntos.setText("Defuntos...");
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
        mnRelatOfertaveis.add(miRelatServicos);

        miRelatProdutos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        miRelatProdutos.setText("Produtos...");
        mnRelatOfertaveis.add(miRelatProdutos);

        mnRelatorios.add(mnRelatOfertaveis);

        miRelatVelorios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        miRelatVelorios.setText("Velórios...");
        miRelatVelorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRelatVeloriosActionPerformed(evt);
            }
        });
        mnRelatorios.add(miRelatVelorios);

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

        mnCadOfertavel.setText("Ofertavel");
        mnCadOfertavel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        miCadPlano.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        miCadPlano.setText("Plano...");
        mnCadOfertavel.add(miCadPlano);

        miCadServico.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        miCadServico.setText("Serviço...");
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
            .addGap(0, 1216, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 666, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSairActionPerformed
        sair();
    }//GEN-LAST:event_miSairActionPerformed

    private void miAltInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAltInfoActionPerformed
        jAlterarUsuario();
    }//GEN-LAST:event_miAltInfoActionPerformed

    private void miRelatVeloriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRelatVeloriosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miRelatVeloriosActionPerformed

    private void miRelatSalasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRelatSalasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miRelatSalasActionPerformed

    private void miCadVelorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCadVelorioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miCadVelorioActionPerformed

    private void miCadSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCadSalaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miCadSalaActionPerformed

    private void miRelatPlanosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRelatPlanosActionPerformed
        JRelatorioPlano.getInstancia().setVisible(true);
    }//GEN-LAST:event_miRelatPlanosActionPerformed
    
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
            usuario = null;
            fecharJanelasAssociadas();
            dispose();
            JLogin.getInstancia().setVisible(true);
        }
    }
    
    private void fecharJanelasAssociadas(){
        JRelatorioPlano.getInstancia().dispose();
        //...
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
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
    private javax.swing.JMenuItem miRelatVelorios;
    private javax.swing.JMenuItem miSair;
    private javax.swing.JMenu mnCadOfertavel;
    private javax.swing.JMenu mnCadastrar;
    private javax.swing.JMenu mnOpcoes;
    private javax.swing.JMenu mnRelatOfertaveis;
    private javax.swing.JMenu mnRelatPessoa;
    private javax.swing.JMenu mnRelatorios;
    // End of variables declaration//GEN-END:variables

    
    public Usuario getUsuario(){
        return usuario;
    }
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
    
    @Override
    public void voltar() {
        this.setVisible(true);
    }
    @Override
    public void voltar(Object objeto) {
        usuario = (Usuario) objeto;
        this.setVisible(true);   
    }

}