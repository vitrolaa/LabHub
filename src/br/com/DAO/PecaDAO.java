package br.com.DAO;

import br.com.DTO.PecasDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class PecaDAO {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public PecaDAO() {
        conexao = ConexaoDAO.conector();
    }

    // Método para adicionar uma nova peça
    public boolean adicionar(PecasDTO objDTO) {
        String sql = "INSERT INTO pecas (nome_peca, quantidade_estoque, descricao) VALUES (?, ?, ?)";
        try {
            conexao = ConexaoDAO.conector();
            pst = conexao.prepareStatement(sql);

            pst.setString(1, objDTO.getNomePecas());
            pst.setString(2, objDTO.getQuantidadePecas());
            pst.setString(3, objDTO.getDescricaoPecas());
            pst.execute();
            return true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Inserir máquina: " + e);
            return false;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + e);
            }
        }
    }

    // Método para editar os dados de uma peça
    public void editarPeca(PecasDTO objDTO) {
        String sql = "UPDATE pecas SET nome_peca = ?, quantidade_estoque = ?, descricao = ? WHERE id_peca = ?";
        try {
            conexao = ConexaoDAO.conector();
            pst = conexao.prepareStatement(sql);

            pst.setString(1, objDTO.getNomePecas());
            pst.setString(2, objDTO.getQuantidadePecas());
            pst.setString(3, objDTO.getDescricaoPecas());
            pst.setInt(4, objDTO.getId_peca());

            int update = pst.executeUpdate();
            if (update > 0) {
                JOptionPane.showMessageDialog(null, "Peça atualizada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro: Nenhum dado foi atualizado.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar dados: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }

}
