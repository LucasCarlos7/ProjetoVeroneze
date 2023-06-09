package telas;

import entidade.Cargo;
import javax.swing.JOptionPane;

/**
 *
 * @author LUKAS
 */
public class telaCargo extends javax.swing.JFrame {

    Cargo cargo = new Cargo();

    /**
     * Creates new form Funcionario
     */
    public telaCargo() {
        initComponents();
        jbExcluir.setEnabled(false);
        jbSalvar.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JbVoltar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jbBuscar = new javax.swing.JButton();
        jbIncluir = new javax.swing.JButton();
        jbSalvar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbRelatorio = new javax.swing.JButton();
        jbLimpar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jlID = new javax.swing.JLabel();
        jlNome = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        jlEndereco = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 100));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("CARGO");

        JbVoltar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        JbVoltar.setText("VOLTAR");
        JbVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 681, Short.MAX_VALUE)
                .addComponent(JbVoltar)
                .addGap(75, 75, 75))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JbVoltar))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setPreferredSize(new java.awt.Dimension(150, 800));

        jbBuscar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbBuscar.setText("Buscar");
        jbBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jbIncluir.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbIncluir.setText("Incluir");
        jbIncluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbIncluir.setNextFocusableComponent(txtNome);
        jbIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbIncluirActionPerformed(evt);
            }
        });

        jbSalvar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbSalvar.setText("Salvar");
        jbSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        jbExcluir.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbExcluir.setText("Excluir");
        jbExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jbRelatorio.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbRelatorio.setText("Relatório");
        jbRelatorio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jbLimpar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbLimpar.setText("Limpar");
        jbLimpar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbExcluir)
                    .addComponent(jbRelatorio)
                    .addComponent(jbSalvar)
                    .addComponent(jbIncluir)
                    .addComponent(jbBuscar)
                    .addComponent(jbLimpar))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jbBuscar)
                .addGap(50, 50, 50)
                .addComponent(jbIncluir)
                .addGap(50, 50, 50)
                .addComponent(jbSalvar)
                .addGap(50, 50, 50)
                .addComponent(jbExcluir)
                .addGap(53, 53, 53)
                .addComponent(jbLimpar)
                .addGap(50, 50, 50)
                .addComponent(jbRelatorio)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setPreferredSize(new java.awt.Dimension(895, 800));

        jlID.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jlID.setText("ID");

        jlNome.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jlNome.setText("Nome");

        txtID.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N

        txtNome.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N

        jlEndereco.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jlEndereco.setText("Descrição");

        txtDescricao.setColumns(20);
        txtDescricao.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        txtDescricao.setRows(5);
        jScrollPane1.setViewportView(txtDescricao);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlNome, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlID, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlEndereco))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jlID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jlNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jlEndereco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(241, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 944, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JbVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbVoltarActionPerformed

        telaFuncionario telaFuncionario = new telaFuncionario();
        telaFuncionario.setVisible(true);
        dispose();
    }//GEN-LAST:event_JbVoltarActionPerformed

    private void jbIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbIncluirActionPerformed
        String strID = Integer.toString(cargo.proximoId());
        txtID.setText(strID);
        txtNome.setText("");
        txtDescricao.setText("");
        txtID.setEditable(false);
        jbIncluir.nextFocus();
        jbSalvar.setEnabled(true);
    }//GEN-LAST:event_jbIncluirActionPerformed

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        int id = 0;
        String nome = txtNome.getText().toUpperCase();
        String descricao = txtDescricao.getText().toUpperCase();
        
        try {
            id = Integer.parseInt(txtID.getText());
        } catch (NumberFormatException e) {
            
        }
        for(Cargo c : cargo.getCargoList()){
            if(id == c.getId()){
                JOptionPane.showMessageDialog(rootPane, "ID: "+ c.getId() +" já cadastrado no cargo "+ c.getNome());
                return;
            }else if(c.getNome().equals(nome)){
                JOptionPane.showMessageDialog(rootPane, "Cargo: "+ c.getNome() +" já cadastrado com ID: "+ c.getId());
                return;
            }
        }
        Cargo cargo1 = new Cargo(id, nome, descricao);
        cargo1.getCargoList().add(cargo1);
        JOptionPane.showMessageDialog(rootPane, "Cargo: "+ cargo1.getNome() +"\nID: "+ cargo1.getId() +"\nCadastrado com Sucesso!");
        jbExcluir.setEnabled(true);
        jbSalvar.setEnabled(false);
        jbBuscar.setEnabled(true);
        txtID.setEditable(true);
        
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        int id = 0;
        
        try{
            id = Integer.parseInt(txtID.getText());
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(rootPane, "Formato inválido");
            return;
        }
        
        for(Cargo c : cargo.getCargoList()){
            if(id == c.getId()){
                txtID.setEditable(false);
                txtNome.setText(c.getNome());
                txtDescricao.setText(c.getDescrição());
                jbExcluir.setEnabled(true);
                return;
            }
        }
        JOptionPane.showMessageDialog(rootPane, "Cargo com ID: " + id + " não encontrado");
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        Object[] opcao = {"OK", "CANCELAR"};
        int id = Integer.parseInt(txtID.getText());
        
        for(Cargo c : cargo.getCargoList()){
            if(c.getId() == id){
                int confirmacao = JOptionPane.showOptionDialog(null, "Deseja Excluir o Cargo? \nID: "+ c.getId() + "\nCargo:" + c.getNome() + "\nDescrição: " + c.getDescrição(), "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, 
                        null, opcao, opcao[0]);
                if(confirmacao == 0){
                    c.getCargoList().remove(c);
                    JOptionPane.showMessageDialog(rootPane, "Cargo: "+ c.getNome() +" excluído com sucesso!");
                    txtID.setText("");
                    txtDescricao.setText("");
                    txtNome.setText("");
                    return;
                }else if(confirmacao == 1){
                    JOptionPane.showMessageDialog(rootPane, "Exclusão cancelada");
                }
            }
            JOptionPane.showMessageDialog(null, "Não foi encontrado um produto com ID " + id);
            return;
        }
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparActionPerformed
        txtID.setText("");
        txtDescricao.setText("");
        txtNome.setText("");
        jbExcluir.setEnabled(false);
    }//GEN-LAST:event_jbLimparActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(telaCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaCargo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JbVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbIncluir;
    private javax.swing.JButton jbLimpar;
    private javax.swing.JButton jbRelatorio;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JLabel jlEndereco;
    private javax.swing.JLabel jlID;
    private javax.swing.JLabel jlNome;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
