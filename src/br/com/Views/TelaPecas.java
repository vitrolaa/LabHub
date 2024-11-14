
package br.com.Views;

import br.com.DAO.ConexaoDAO;
import br.com.DAO.PecaDAO;
import br.com.DTO.PecasDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class TelaPecas extends javax.swing.JFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public TelaPecas() {
        initComponents();
        conexao = ConexaoDAO.conector();
    }

    public void pesquisarPecas() {
    String sql = "SELECT p.id_pecas, p.nomePecas AS Nome_da_Peça, "
            + "p.quantidadePecas, p.tipoPecas "
            + "FROM pecas p "
            + "WHERE p.id_pecas = ?";
    try {
        pst = conexao.prepareStatement(sql);
        pst.setString(1, txtIdPeca.getText());
        rs = pst.executeQuery();

        if (rs.next()) {
            txtNomePeca.setText(rs.getString(2));
            txtQtdPeca.setText(rs.getString(3));
            txtDescricao.setText(rs.getString(4));
        } else {
            JOptionPane.showMessageDialog(null, "Peça não existe!");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Metodo pesquisar " + e);
    }
}


    public void pesquisarPecasTabela() {
    // Alteração na consulta SQL para refletir a nova estrutura da tabela "pecas"
    String sql = "SELECT id_peca, nome_peca AS Nome_da_Peça, quantidade_estoque, descricao "
                + "FROM pecas "
                + "WHERE id_peca = ?"; // Filtrando pelo id_peca

    try {
        pst = conexao.prepareStatement(sql);
        pst.setString(1, txtPesquisarPecaTabela.getText()); // Obtendo o texto da caixa de pesquisa
        rs = pst.executeQuery();

        // Preenchendo a tabela com os dados da pesquisa
        tbPeca.setModel(DbUtils.resultSetToTableModel(rs));
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao pesquisar peças: " + e.getMessage());
    }
}


    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLimpar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtPesquisarPecaTabela = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPeca = new javax.swing.JTable();
        btnVoltar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtIdPeca = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNomePeca = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtQtdPeca = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        btnEditar = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        jLabel6.setText("Digite o ID da peça que voce quer pesquisar na tabela");

        txtPesquisarPecaTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisarPecaTabelaActionPerformed(evt);
            }
        });
        txtPesquisarPecaTabela.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisarPecaTabelaKeyReleased(evt);
            }
        });

        tbPeca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID da peça", "Nome", "Manutenção", "Quantidade", "Tipo"
            }
        ));
        jScrollPane1.setViewportView(tbPeca);

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        jLabel1.setText("ID Peça");

        txtIdPeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdPecaActionPerformed(evt);
            }
        });

        jLabel3.setText("Nome da Peça");

        jLabel4.setText("Quantidade de Peça");

        jLabel5.setText("Descrição de Pecas");

        txtDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescricaoActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtIdPeca, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtNomePeca))
                        .addGap(83, 83, 83)
                        .addComponent(btnVoltar)
                        .addGap(52, 52, 52))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtQtdPeca)
                                .addGap(196, 196, 196))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(btnEditar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnAdicionar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnLimpar))
                                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtPesquisarPecaTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(41, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdPeca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnVoltar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomePeca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtQtdPeca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(btnAdicionar)
                    .addComponent(btnLimpar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPesquisarPecaTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        txtIdPeca.setText(null);
        txtNomePeca.setText(null);
        txtQtdPeca.setText(null);
        txtDescricao.setText(null);
    }//GEN-LAST:event_btnLimparActionPerformed

    private void txtPesquisarPecaTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisarPecaTabelaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisarPecaTabelaActionPerformed

    private void txtPesquisarPecaTabelaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarPecaTabelaKeyReleased
        pesquisarPecasTabela();
    }//GEN-LAST:event_txtPesquisarPecaTabelaKeyReleased

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        TelaPrincipal tPrincipal = new TelaPrincipal();
        tPrincipal.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void txtIdPecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdPecaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdPecaActionPerformed

    private void txtDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescricaoActionPerformed
      
    }//GEN-LAST:event_txtDescricaoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        String id_peca = txtIdPeca.getText();
        String nomePecas = txtNomePeca.getText();
        String quantidadePecas = txtQtdPeca.getText();
        String descricaoPecas = txtDescricao.getText();

        PecasDTO objDTO = new PecasDTO();
        objDTO.setId_peca(Integer.parseInt(id_peca));
        objDTO.setNomePecas(nomePecas);
        objDTO.setQuantidadePecas(quantidadePecas);
        objDTO.setDescricaoPecas(descricaoPecas);

        PecaDAO objPecaDAO = new PecaDAO();
        objPecaDAO.editarPeca(objDTO);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
          String nomePeca = txtNomePeca.getText();
        String qntdPeca = txtQtdPeca.getText();
        String descricao = txtDescricao.getText();
        
        PecasDTO objDTO = new PecasDTO();
        objDTO.setNomePecas(nomePeca);
        objDTO.setQuantidadePecas(qntdPeca);
        objDTO.setDescricaoPecas(descricao);
        
        PecaDAO objPecaDAO = new PecaDAO();
        boolean inserir = objPecaDAO.adicionar(objDTO);
        if (inserir) {
            JOptionPane.showMessageDialog(null, "O Equipamento foi inserido com sucesso ");
            
        } else {
            JOptionPane.showMessageDialog(null, "O Equipamento não foi inserido");
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPecas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPecas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPecas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPecas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPecas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbPeca;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtIdPeca;
    private javax.swing.JTextField txtNomePeca;
    private javax.swing.JTextField txtPesquisarPecaTabela;
    private javax.swing.JTextField txtQtdPeca;
    // End of variables declaration//GEN-END:variables
}
