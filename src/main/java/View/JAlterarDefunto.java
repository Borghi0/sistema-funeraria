package View;

import Control.Defunto_Ctrl;
import Control.NavegadorUI;
import Model.Defunto;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class JAlterarDefunto extends javax.swing.JFrame {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(JAlterarDefunto.class.getName());
    private NavegadorUI navegador;
    private Defunto defunto;

    public JAlterarDefunto(NavegadorUI navegador) {
        this.navegador = navegador;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rtTitulo = new javax.swing.JLabel();
        rtNomeDefunto = new javax.swing.JLabel();
        rtDataNascimento = new javax.swing.JLabel();
        rtDataObito = new javax.swing.JLabel();
        rtCemiterio = new javax.swing.JLabel();
        rtTipoObito = new javax.swing.JLabel();
        rtErroNome = new javax.swing.JLabel();
        cxNomeDefunto = new javax.swing.JTextField();
        cxCemiterio = new javax.swing.JTextField();
        cbDiaNasc = new javax.swing.JComboBox<>();
        cbMesNasc = new javax.swing.JComboBox<>();
        cbAnoNasc = new javax.swing.JComboBox<>();
        cbDiaObito = new javax.swing.JComboBox<>();
        cbMesObito = new javax.swing.JComboBox<>();
        cbAnoObito = new javax.swing.JComboBox<>();
        cbTipoObito = new javax.swing.JComboBox<>();
        btAtualizar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        rtTitulo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        rtTitulo.setText("Atualizar Defunto");

        rtNomeDefunto.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtNomeDefunto.setText("Nome do defunto:");

        rtDataNascimento.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtDataNascimento.setText("Data de nascimento:");

        rtDataObito.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtDataObito.setText("Data de obito:");

        rtCemiterio.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtCemiterio.setText("Cemitério:");

        rtTipoObito.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtTipoObito.setText("Tipo de obito:");

        rtErroNome.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

        cxNomeDefunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cxNomeDefuntoActionPerformed(evt);
            }
        });

        cbDiaNasc.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cbDiaNasc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dia", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        cbMesNasc.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cbMesNasc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mês", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cbMesNasc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMesNascActionPerformed(evt);
            }
        });

        cbAnoNasc.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cbAnoNasc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ano", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025" }));

        cbDiaObito.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cbDiaObito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dia", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        cbMesObito.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cbMesObito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mês", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        cbAnoObito.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cbAnoObito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ano", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025" }));

        cbTipoObito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Natural", "Violenta", "Indeterminado", "Pendente" }));
        cbTipoObito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoObitoActionPerformed(evt);
            }
        });

        btAtualizar.setText("Atualizar");
        btAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarActionPerformed(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(107, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(rtCemiterio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rtDataObito, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rtDataNascimento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rtNomeDefunto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rtTipoObito, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cxNomeDefunto, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rtErroNome, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbDiaNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbMesNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbAnoNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbDiaObito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbMesObito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbAnoObito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(cbTipoObito, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cxCemiterio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 104, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btAtualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancelar)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rtTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(rtTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(rtNomeDefunto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbDiaNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbMesNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbAnoNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rtDataObito, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbDiaObito, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbMesObito, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbAnoObito, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rtCemiterio, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cxCemiterio, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rtTipoObito, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbTipoObito, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cxNomeDefunto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rtErroNome, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar)
                    .addComponent(btAtualizar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbMesNascActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMesNascActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbMesNascActionPerformed

    private void cxNomeDefuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cxNomeDefuntoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cxNomeDefuntoActionPerformed

    private void cbTipoObitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoObitoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTipoObitoActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        sair();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
        atualizar();
    }//GEN-LAST:event_btAtualizarActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void atualizar(){
        cxNomeDefunto.setText(cxNomeDefunto.getText().replaceAll("\\s+", ""));
        cxCemiterio.setText(cxCemiterio.getText().replaceAll("\\s+", ""));
        
        LocalDate data_natalidade = validarDataNasc();
        if(data_natalidade == null) return;
        LocalDate data_Obito = validarDataObito();
        if(data_Obito == null) return;
        String opOb = (String) cbTipoObito.getSelectedItem();
        
        try {
            if (data_natalidade.equals(data_Obito)) {
                throw new IllegalArgumentException("A data de nascimento não pode ser igual à data de óbito.");
            }
            if (data_Obito.isBefore(data_natalidade)) {
                 throw new IllegalArgumentException("A data de óbito não pode ser anterior à data de nascimento.");
            }
        } catch (IllegalArgumentException e) {
             JOptionPane.showMessageDialog(
                null,
                "Erro de Validação:\n" + e.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        
        Defunto defuntoAlt = new Defunto(
                data_Obito,
                opOb,
                cxCemiterio.getText().isBlank() ? defunto.getCemiterio() : cxCemiterio.getText(),
                cxNomeDefunto.getText().isBlank() ? defunto.getNome() : cxNomeDefunto.getText(),
                data_natalidade,
                defunto.getId()
        );
        
        try{
            Defunto_Ctrl.getInstancia().alt_Defunto(defunto);
            JOptionPane.showMessageDialog(
                null,
                "Defunto atualizado com sucesso!",
                "Sucesso",
                JOptionPane.INFORMATION_MESSAGE
            );
            defunto = defuntoAlt;
            initInfo();
        }catch(Exception e){
            JOptionPane.showMessageDialog(
                null,
                "Erro ao atualizar defunto:\n" + e,
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    private LocalDate validarDataNasc(){
        LocalDate data_natalidade;
        try{
            data_natalidade = LocalDate.of(
                    Integer.parseInt(cbAnoNasc.getSelectedItem().toString()),
                    Integer.parseInt(cbMesNasc.getSelectedItem().toString()),
                    Integer.parseInt(cbDiaNasc.getSelectedItem().toString())
            );
        }catch(Exception e){
            JOptionPane.showMessageDialog(
                null,
                "Data inválida:\n" + e,
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );
            return null;
        }
        return data_natalidade;
    }
    
    private LocalDate validarDataObito(){
        LocalDate data_Obito;
        try{
            data_Obito = LocalDate.of(
                    Integer.parseInt(cbAnoObito.getSelectedItem().toString()),
                    Integer.parseInt(cbMesObito.getSelectedItem().toString()),
                    Integer.parseInt(cbDiaObito.getSelectedItem().toString())
            );
        }catch(Exception e){
            JOptionPane.showMessageDialog(
                null,
                "Data inválida:\n" + e,
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );
            return null;
        }
        return data_Obito;
    }
    
    private void carregarData(LocalDate data, javax.swing.JComboBox<String> cbDia, javax.swing.JComboBox<String> cbMes, javax.swing.JComboBox<String> cbAno) {
        if (data != null) {
            cbDia.setSelectedItem(String.valueOf(data.getDayOfMonth()));
            cbMes.setSelectedItem(String.valueOf(data.getMonthValue()));
            cbAno.setSelectedItem(String.valueOf(data.getYear()));
        }
    }

    public void carregarDefunto(Defunto defunto) {
        if (defunto == null) {
            JOptionPane.showMessageDialog(
                    null,
                    "Alteração de defunto não encontrada.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        this.defunto = defunto;

        cxNomeDefunto.setText(defunto.getNome());
        cxCemiterio.setText(defunto.getCemiterio());
        carregarData(defunto.getDataNatalidade(), cbDiaNasc, cbMesNasc, cbAnoNasc);
        carregarData(defunto.getDataObito(), cbDiaObito, cbMesObito, cbAnoObito);
        cbTipoObito.setSelectedItem(defunto.getTipoObito());
    }
    
    private void initInfo(){
        cxNomeDefunto.setText(defunto.getNome());
        cbDiaNasc.setSelectedItem(defunto.getDataNatalidade());
        cbMesNasc.setSelectedItem(defunto.getDataNatalidade());
        cbAnoNasc.setSelectedItem(defunto.getDataNatalidade());
        cbDiaObito.setSelectedItem(defunto.getDataObito());
        cbMesObito.setSelectedItem(defunto.getDataObito());
        cbAnoObito.setSelectedItem(defunto.getDataObito());
        cxCemiterio.setText(defunto.getCemiterio());
        cbTipoObito.insertItemAt("Natural", 0);
    }
    
    public void sair(){
        int resp = JOptionPane.showConfirmDialog(
                null,
                "Deseja realmente sair?",
                "SAIDA",
                JOptionPane.YES_NO_OPTION
        );
        if (resp == 0) {
            dispose();
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
        java.awt.EventQueue.invokeLater(() -> new JAlterarDefunto(new NavegadorUI()).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JComboBox<String> cbAnoNasc;
    private javax.swing.JComboBox<String> cbAnoObito;
    private javax.swing.JComboBox<String> cbDiaNasc;
    private javax.swing.JComboBox<String> cbDiaObito;
    private javax.swing.JComboBox<String> cbMesNasc;
    private javax.swing.JComboBox<String> cbMesObito;
    private javax.swing.JComboBox<String> cbTipoObito;
    private javax.swing.JTextField cxCemiterio;
    private javax.swing.JTextField cxNomeDefunto;
    private javax.swing.JLabel rtCemiterio;
    private javax.swing.JLabel rtDataNascimento;
    private javax.swing.JLabel rtDataObito;
    private javax.swing.JLabel rtErroNome;
    private javax.swing.JLabel rtNomeDefunto;
    private javax.swing.JLabel rtTipoObito;
    private javax.swing.JLabel rtTitulo;
    // End of variables declaration//GEN-END:variables
}
