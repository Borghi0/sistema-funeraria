package View;

import Control.NavegadorUI;
import Model.Usuario;
import javax.swing.JOptionPane;
import Interfaces.I_JanelaRaiz;


public class JMenuUsuario extends javax.swing.JFrame implements I_JanelaRaiz{
    private NavegadorUI navegador;
    private Usuario usuario;
    
    public JMenuUsuario(NavegadorUI navegador, Usuario usuario) {
        this.navegador = navegador;
        this.usuario = usuario;
        initComponents();        
        setLocationRelativeTo(null);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rtTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        mnBar = new javax.swing.JMenuBar();
        mnOpcoes = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        miAltInfo = new javax.swing.JMenuItem();
        miSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        rtTitulo.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        rtTitulo.setText("Menu usuário");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nome", "CPF", "Data de nascimento", "Email", "Telefone", "Rua", "Número", "CEP"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        mnOpcoes.setText("Opções");
        mnOpcoes.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem1.setText("Cadastrar usuário...");
        mnOpcoes.add(jMenuItem1);

        miAltInfo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        miAltInfo.setText("Atualizar informações...");
        miAltInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAltInfoActionPerformed(evt);
            }
        });
        mnOpcoes.add(miAltInfo);

        miSair.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        miSair.setText("Fechar...");
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 917, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rtTitulo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(rtTitulo)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSairActionPerformed
        sair();
    }//GEN-LAST:event_miSairActionPerformed

    private void miAltInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAltInfoActionPerformed
        jAlterarUsuario();
    }//GEN-LAST:event_miAltInfoActionPerformed

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
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenuItem miAltInfo;
    private javax.swing.JMenuItem miSair;
    private javax.swing.JMenuBar mnBar;
    private javax.swing.JMenu mnOpcoes;
    private javax.swing.JLabel rtTitulo;
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
