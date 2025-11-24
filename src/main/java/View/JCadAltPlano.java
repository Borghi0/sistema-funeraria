package View;


import Control.Calculadora;
import Control.DescontoProduto;
import Control.DescontoServico;
import Control.Plano_Ctrl;
import Control.Produto_Ctrl;
import Control.Servico_Ctrl;
import Model.Ofertavel;
import Model.Plano;
import Model.Produto;
import Model.Servico;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;


public class JCadAltPlano extends javax.swing.JFrame {
    private Plano plano;
    private final boolean modoCadastro; //false -> alterar; true -> cadastrar
    
    public JCadAltPlano(Plano plano, boolean modoCadastro) {        
        this.modoCadastro = modoCadastro;        
        this.plano = plano;
        
        initComponents();
        setLocationRelativeTo(null);        
        tbSerProIn.getColumnModel().removeColumn(tbSerProIn.getColumnModel().getColumn(3));                
        
        if(modoCadastro){
            this.plano = new Plano();
            this.plano.setListaServicos(new ArrayList<>());
            this.plano.setListaProdutos(new ArrayList<>());
            rtTitulo.setText("Cadastrar plano");
            this.setTitle("Cadastrar plano");
            atualizarInfo();
        }
        else {
            initInfo();            
            rtTitulo.setText("Alterar plano");            
            this.setTitle("Alterar plano");
        }        
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tbSerProIn = new javax.swing.JTable();
        rtServicos = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbServicos = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbProdutos = new javax.swing.JTable();
        rtServicos1 = new javax.swing.JLabel();
        rtServicos2 = new javax.swing.JLabel();
        btConfirmar = new javax.swing.JButton();
        rtNome = new javax.swing.JLabel();
        cxNome = new javax.swing.JTextField();
        rtPreco = new javax.swing.JLabel();
        rtTitulo = new javax.swing.JLabel();
        barraMenu = new javax.swing.JMenuBar();
        mbOpcoes = new javax.swing.JMenu();
        miRestaurar = new javax.swing.JMenuItem();
        miFechar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        tbSerProIn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tbSerProIn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Preço", "Classe"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbSerProIn.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tbSerProIn.setAutoscrolls(false);
        tbSerProIn.setMinimumSize(new java.awt.Dimension(380, 0));
        tbSerProIn.setPreferredSize(new java.awt.Dimension(380, 0));
        tbSerProIn.setRowHeight(30);
        tbSerProIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSerProInMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbSerProIn);
        //minhas configs
        tbSerProIn.getColumnModel().getColumn(0).setCellRenderer(
            new DefaultTableCellRenderer(){{setHorizontalAlignment(SwingConstants.CENTER);}}
        );
        tbSerProIn.getColumnModel().getColumn(1).setCellRenderer(
            new DefaultTableCellRenderer(){{setHorizontalAlignment(SwingConstants.CENTER);}}
        );
        tbSerProIn.getColumnModel().getColumn(2).setCellRenderer(
            new DefaultTableCellRenderer(){{setHorizontalAlignment(SwingConstants.CENTER);}}
        );

        TableCellRenderer centerHeaderRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(
                JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int column){
                JLabel lbl = (JLabel) tbSerProIn.getTableHeader().getDefaultRenderer().getTableCellRendererComponent(
                    table, value, isSelected, hasFocus, row, column
                );
                lbl.setHorizontalAlignment(SwingConstants.CENTER);
                return lbl;
            }
        };
        tbSerProIn.getColumnModel().getColumn(0).setHeaderRenderer(centerHeaderRenderer);
        tbSerProIn.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        //fim

        rtServicos.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtServicos.setText("Serviços e produtos inclusos:");

        tbServicos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tbServicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Preço", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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

        tbServicos.getColumnModel().getColumn(0).setHeaderRenderer(centerHeaderRenderer);
        tbServicos.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        //fim

        tbProdutos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tbProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Preço", "Perecível"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbProdutos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tbProdutos.setMinimumSize(new java.awt.Dimension(380, 0));
        tbProdutos.setPreferredSize(new java.awt.Dimension(380, 0));
        tbProdutos.setRowHeight(30);
        tbProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProdutosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbProdutos);
        //minhas configs
        tbProdutos.getColumnModel().getColumn(0).setCellRenderer(
            new DefaultTableCellRenderer(){{setHorizontalAlignment(SwingConstants.CENTER);}}
        );
        tbProdutos.getColumnModel().getColumn(1).setCellRenderer(
            new DefaultTableCellRenderer(){{setHorizontalAlignment(SwingConstants.CENTER);}}
        );
        tbProdutos.getColumnModel().getColumn(2).setCellRenderer(
            new DefaultTableCellRenderer(){{setHorizontalAlignment(SwingConstants.CENTER);}}
        );

        tbProdutos.getColumnModel().getColumn(0).setHeaderRenderer(centerHeaderRenderer);
        tbProdutos.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        //fim

        rtServicos1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtServicos1.setText("Incluir serviço");

        rtServicos2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtServicos2.setText("Incluir produto");

        btConfirmar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btConfirmar.setText("Confirmar");
        btConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmarActionPerformed(evt);
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
        rtPreco.setText("Valor: <preço>");

        rtTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        rtTitulo.setText("Texto");

        mbOpcoes.setText("Opções");
        mbOpcoes.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N

        miRestaurar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        miRestaurar.setText("Restaurar Tabelas");
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btConfirmar)
                .addGap(21, 21, 21))
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rtTitulo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rtServicos)
                                .addGap(0, 144, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rtNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cxNome)))
                        .addGap(79, 79, 79)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                                        .addComponent(jScrollPane4))
                                    .addComponent(rtServicos1)
                                    .addComponent(rtServicos2))
                                .addGap(168, 168, 168))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rtPreco)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(rtTitulo)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cxNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rtServicos)
                    .addComponent(rtServicos1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(45, 45, 45)
                        .addComponent(rtServicos2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addGap(61, 61, 61)
                .addComponent(btConfirmar)
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmarActionPerformed
        confirmar();
    }//GEN-LAST:event_btConfirmarActionPerformed

    private void cxNomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cxNomeFocusLost
        cxNome.setText(cxNome.getText().trim());
    }//GEN-LAST:event_cxNomeFocusLost

    private void cxNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cxNomeKeyPressed
        confirmar(evt);
    }//GEN-LAST:event_cxNomeKeyPressed

    private void miRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRestaurarActionPerformed
        restaurar();
    }//GEN-LAST:event_miRestaurarActionPerformed

    private void miFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miFecharActionPerformed
        dispose();
    }//GEN-LAST:event_miFecharActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        try{
            listarTabServicosProdutos();            
        }catch(Exception e){}
    }//GEN-LAST:event_formWindowActivated

    private void tbSerProInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSerProInMouseClicked
        selecTabSerProIn();
    }//GEN-LAST:event_tbSerProInMouseClicked

    private void tbServicosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbServicosMouseClicked
        selecTabServicos();
    }//GEN-LAST:event_tbServicosMouseClicked

    private void tbProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProdutosMouseClicked
        selecTabProdutos();
    }//GEN-LAST:event_tbProdutosMouseClicked

    private void restaurar(){
        try{
            listarTabServicosProdutos();            
        }catch(Exception e){
            JOptionPane.showMessageDialog(
                    null, "Erro na busca:\n" + e,
                    "Erro!", JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    private void confirmar(){
        if(modoCadastro) cadastrar();
        else alterar();
    }
    private void confirmar(java.awt.event.KeyEvent evt){
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER) confirmar();
    }
    
    private void alterar(){
        cxNome.setText(cxNome.getText().trim());
        
        Plano planoAlt = new Plano(
                plano.getListaServicos(),
                plano.getListaProdutos(),
                plano.getPreco(),
                cxNome.getText().isBlank() ? plano.getNome() : cxNome.getText(),
                plano.getId()
        );
        
        try{
            Plano_Ctrl.getInstancia().alt_Plano(planoAlt);
            
            JOptionPane.showMessageDialog(
                null,
                "Plano alterado com sucesso!",
                "Sucesso",
                JOptionPane.INFORMATION_MESSAGE
            );
            plano = planoAlt;
            initInfo();            
        }catch(Exception e){
            JOptionPane.showMessageDialog(
                    null, "Não foi possível alterar o plano\n"+e,
                    "Erro!", JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    private void cadastrar(){
        cxNome.setText(cxNome.getText().trim());
        
        plano.setNome(cxNome.getText());        
        
        try{
            Plano_Ctrl.getInstancia().cad_Plano(plano);
            
            JOptionPane.showMessageDialog(
                null,
                "Plano cadastrado com sucesso!",
                "Sucesso",
                JOptionPane.INFORMATION_MESSAGE
            );
            plano = new Plano();
            limpar();
        }catch(Exception e){
            JOptionPane.showMessageDialog(
                    null, "Não foi possível cadastrar o plano\n"+e,
                    "Erro!", JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    private void listarTabSerProIn(){        
        DefaultTableModel modelo = (DefaultTableModel) tbSerProIn.getModel();       

        int lin = 0;
        modelo.setRowCount(lin);
                
        if(plano.getListaServicos()!=null){
            for(Servico servico : plano.getListaServicos()){
                    modelo.insertRow(lin, new Object[]{                    
                        servico.getId(),
                        servico.getNome(),
                        servico.getPreco(),
                        servico
                    });
                    lin++;
            }
        }
        if(plano.getListaProdutos()!=null){
            for(Produto produto : plano.getListaProdutos()){
                    modelo.insertRow(lin, new Object[]{
                        produto.getId(),
                        produto.getNome(),
                        produto.getPreco(),
                        produto
                    });
                    lin++;
            }                
        }
    }
    
    private void listarTabServicosProdutos() throws Exception{        
        DefaultTableModel modeloSer = (DefaultTableModel) tbServicos.getModel();       

        int lin = 0;
        modeloSer.setRowCount(lin);
        
        if(plano.getListaServicos()==null){
            for(Servico servico : Servico_Ctrl.getInstancia().ler_ServicoGenerico()){                
                modeloSer.insertRow(lin, new Object[]{                    
                    servico.getId(),
                    servico.getNome(),
                    servico.getPreco(),
                    servico.getTipo()
                });
                lin++;
            }
        } else{
            for(Servico servico : Servico_Ctrl.getInstancia().ler_ServicoGenerico()){
                if(!plano.getListaServicos().contains(servico)){
                    modeloSer.insertRow(lin, new Object[]{                    
                        servico.getId(),
                        servico.getNome(),
                        servico.getPreco(),
                        servico.getTipo()
                    });
                    lin++;
                }
            }
        }
        
        DefaultTableModel modeloPro = (DefaultTableModel) tbProdutos.getModel();       

        lin = 0;
        modeloPro.setRowCount(lin);
        
        if(plano.getListaServicos()==null){
            for(Produto produto : Produto_Ctrl.getInstancia().ler_Produto()){                
                modeloPro.insertRow(lin, new Object[]{                    
                    produto.getId(),
                    produto.getNome(),
                    produto.getPreco(),
                    produto.isPerecivel()
                });
                lin++;                
            }
        } else{
            for(Produto produto : Produto_Ctrl.getInstancia().ler_Produto()){
                if(!plano.getListaProdutos().contains(produto)){
                    modeloPro.insertRow(lin, new Object[]{                    
                        produto.getId(),
                        produto.getNome(),
                        produto.getPreco(),
                        produto.isPerecivel()
                    });
                    lin++;
                }
            }
        }
    }
    
    private void selecTabSerProIn(){
        int linSelec = tbSerProIn.getSelectedRow();

        if(linSelec<0) return;
                        
        Ofertavel ofertavelSelec = (Ofertavel) tbSerProIn.getModel().getValueAt(linSelec, 3);
        
        int o = JOptionPane.showOptionDialog(                
                null,
                "Remover "+ofertavelSelec.getNome()+"?",
                "Remoção",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, 
                null,
                new Object[] {"Sim", "Não"},
                "Não"
        );
        
        if(o==0){
            if(ofertavelSelec instanceof Servico servico){
                plano.getListaServicos().remove(servico);
                
                Calculadora c = new Calculadora(new DescontoServico());                
                plano.setPreco(
                        plano.getPreco() - c.calcularValor(servico.getPreco())
                );
            }
            else if(ofertavelSelec instanceof Produto produto){
                plano.getListaProdutos().remove(produto);
                
                Calculadora c = new Calculadora(new DescontoProduto());                
                plano.setPreco(
                        plano.getPreco() - c.calcularValor(produto.getPreco())
                );
            }
            
            atualizarInfo();
            try{
                listarTabServicosProdutos();
            }
            catch(Exception e){}
        }        
    }
    
    private void selecTabServicos(){
        int linSelec = tbServicos.getSelectedRow();

        if(linSelec<0) return;
                
        int o = JOptionPane.showOptionDialog(                
                null,
                "Adicionar serviço ao plano?",
                "Adicionar",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, 
                null,
                new Object[] {"Sim", "Não"},
                "Não"
        );
        if(o!=0) return;
        
        Servico servicoSelec;
        try {
            servicoSelec = Servico_Ctrl.getInstancia().ler_Servico((Integer) tbServicos.getValueAt(linSelec, 0));
            
            if(servicoSelec!=null){
                if(!plano.getListaServicos().contains(servicoSelec)){
                    plano.getListaServicos().add(servicoSelec);
                    
                    Calculadora c = new Calculadora(new DescontoServico());                
                    plano.setPreco(
                            plano.getPreco() + c.calcularValor(servicoSelec.getPreco())
                    );
                }
                atualizarInfo();
            } else{
                JOptionPane.showMessageDialog(
                    null, "Serviço não encontrado",
                    "Erro!", JOptionPane.ERROR_MESSAGE
                );
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null, "Erro ao buscar serviço no banco:\n" + e,
                    "Erro!", JOptionPane.ERROR_MESSAGE
            );            
        }                       
    }
    
    private void selecTabProdutos(){
        int linSelec = tbProdutos.getSelectedRow();

        if(linSelec<0) return;
                
        int o = JOptionPane.showOptionDialog(                
                null,
                "Adicionar produto ao plano?",
                "Adicionar",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, 
                null,
                new Object[] {"Sim", "Não"},
                "Não"
        );
        if(o!=0) return;
        
        Produto produtoSelec;
        try {
            produtoSelec = Produto_Ctrl.getInstancia().ler_Produto((Integer) tbProdutos.getValueAt(linSelec, 0));
            
            if(produtoSelec!=null){
                if(!plano.getListaProdutos().contains(produtoSelec)){
                    plano.getListaProdutos().add(produtoSelec);
                    
                    Calculadora c = new Calculadora(new DescontoProduto());                
                    plano.setPreco(
                            plano.getPreco() + c.calcularValor(produtoSelec.getPreco())
                    );
                }
                atualizarInfo();
            } else{
                JOptionPane.showMessageDialog(
                    null, "Produto não encontrado",
                    "Erro!", JOptionPane.ERROR_MESSAGE
                );
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null, "Erro ao buscar serviço no banco:\n" + e,
                    "Erro!", JOptionPane.ERROR_MESSAGE
            );            
        }                                 
    }
    
    private void initInfo(){
        cxNome.setText(plano.getNome());        
        atualizarInfo();
    }
    
    private void atualizarInfo(){
        rtPreco.setText(String.format("R$ %.2f", plano.getPreco()));
        listarTabSerProIn();
    }
    
    private void limpar(){
        cxNome.setText("");
        rtPreco.setText(String.format("R$ %.2f", plano.getPreco()));
        
        DefaultTableModel modelo = (DefaultTableModel) tbSerProIn.getModel();        
        modelo.setRowCount(0);
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
                new JCadAltPlano(null, true).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JButton btConfirmar;
    private javax.swing.JTextField cxNome;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JMenu mbOpcoes;
    private javax.swing.JMenuItem miFechar;
    private javax.swing.JMenuItem miRestaurar;
    private javax.swing.JLabel rtNome;
    private javax.swing.JLabel rtPreco;
    private javax.swing.JLabel rtServicos;
    private javax.swing.JLabel rtServicos1;
    private javax.swing.JLabel rtServicos2;
    private javax.swing.JLabel rtTitulo;
    private javax.swing.JTable tbProdutos;
    private javax.swing.JTable tbSerProIn;
    private javax.swing.JTable tbServicos;
    // End of variables declaration//GEN-END:variables
}
