package View;

import Control.DefuntoCtrl;
import Model.Defunto;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class JCadastroDefunto extends javax.swing.JFrame {        

    public JCadastroDefunto() {
        initComponents();              
        setLocationRelativeTo(null);              
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        rtNomeDefunto = new javax.swing.JLabel();
        rtDataNascimento = new javax.swing.JLabel();
        rtDataObito = new javax.swing.JLabel();
        rtCemiterio = new javax.swing.JLabel();
        rtCadastroDefunto = new javax.swing.JLabel();
        rtTipoObito = new javax.swing.JLabel();
        cxNomeDefunto = new javax.swing.JTextField();
        cxCemiterio = new javax.swing.JTextField();
        cbTipoObito = new javax.swing.JComboBox<>();
        cbDiaNasc = new javax.swing.JComboBox<>();
        cbMesNasc = new javax.swing.JComboBox<>();
        cbAnoNasc = new javax.swing.JComboBox<>();
        cbDiaObito = new javax.swing.JComboBox<>();
        cbMesObito = new javax.swing.JComboBox<>();
        cbAnoObito = new javax.swing.JComboBox<>();
        btCadastrar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de defunto");

        rtNomeDefunto.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtNomeDefunto.setText("Nome do defunto:");

        rtDataNascimento.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtDataNascimento.setText("Data de nascimento:");

        rtDataObito.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtDataObito.setText("Data de obito:");

        rtCemiterio.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtCemiterio.setText("Cemitério:");

        rtCadastroDefunto.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        rtCadastroDefunto.setText("Cadastro de defunto");

        rtTipoObito.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rtTipoObito.setText("Tipo de obito:");

        cbTipoObito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Natural", "Violenta", "Indeterminado", "Pendente" }));

        cbDiaNasc.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cbDiaNasc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dia", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        cbMesNasc.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cbMesNasc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mês", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        cbAnoNasc.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cbAnoNasc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ano", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025" }));

        cbDiaObito.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cbDiaObito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dia", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        cbMesObito.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cbMesObito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mês", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        cbAnoObito.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cbAnoObito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ano", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025" }));

        btCadastrar.setText("Cadastrar");
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btLimpar.setText("Limpar");
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rtCadastroDefunto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(rtCemiterio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rtDataObito, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rtDataNascimento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rtNomeDefunto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rtTipoObito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btCadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cxNomeDefunto, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addComponent(cbTipoObito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cxCemiterio, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 158, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(rtCadastroDefunto)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rtNomeDefunto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cxNomeDefunto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addGap(42, 42, 42))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rtTipoObito, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbTipoObito, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCadastrar)
                    .addComponent(btCancelar)
                    .addComponent(btLimpar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        cadastrar();
    }//GEN-LAST:event_btCadastrarActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        limpar();
    }//GEN-LAST:event_btLimparActionPerformed
    
    private void limpar(){
        cxNomeDefunto.setText("");
        cxCemiterio.setText("");        
    }
    
    private void cadastrar(){
        cxNomeDefunto.setText(cxNomeDefunto.getText().replaceAll("\\s+", ""));
        cxCemiterio.setText(cxCemiterio.getText().replaceAll("\\s+", ""));
                
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
            return;
        }
        
        LocalDate data_Obito;
        try{
            data_Obito = LocalDate.of(
                    Integer.parseInt((String) cbAnoObito.getSelectedItem()),
                    Integer.parseInt((String) cbMesObito.getSelectedItem()),
                    Integer.parseInt((String) cbDiaObito.getSelectedItem())
            );
        }catch(Exception e){
            JOptionPane.showMessageDialog(
                null,
                "Data inválida:\n" + e,
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        
        Defunto defunto = new Defunto(
                data_Obito,
                (String) cbTipoObito.getSelectedItem(),
                cxCemiterio.getText(),                
                cxNomeDefunto.getText(),
                data_natalidade,
                0
        );
        
        try {
            DefuntoCtrl.getInstancia().cadDefunto(defunto);
            JOptionPane.showMessageDialog(
                null,
                "Defunto cadastrado com sucesso!",
                "Sucesso",
                JOptionPane.INFORMATION_MESSAGE
            );
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                null,
                "Erro ao cadastrar defunto:\n" + e,
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );
        }        
    }               
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new JCadastroDefunto().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btLimpar;
    private javax.swing.JComboBox<String> cbAnoNasc;
    private javax.swing.JComboBox<String> cbAnoObito;
    private javax.swing.JComboBox<String> cbDiaNasc;
    private javax.swing.JComboBox<String> cbDiaObito;
    private javax.swing.JComboBox<String> cbMesNasc;
    private javax.swing.JComboBox<String> cbMesObito;
    private javax.swing.JComboBox<String> cbTipoObito;
    private javax.swing.JTextField cxCemiterio;
    private javax.swing.JTextField cxNomeDefunto;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel rtCadastroDefunto;
    private javax.swing.JLabel rtCemiterio;
    private javax.swing.JLabel rtDataNascimento;
    private javax.swing.JLabel rtDataObito;
    private javax.swing.JLabel rtNomeDefunto;
    private javax.swing.JLabel rtTipoObito;
    // End of variables declaration//GEN-END:variables
}
