package br.com.DAO;

import br.com.DTO.CadastroDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CadastroDAO {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void deletarCadastro(CadastroDTO objDTO) {
        String sql = "DELETE from login where id_usuario = ?";

        try {
            conexao = ConexaoDAO.conector();
            pst = conexao.prepareStatement(sql);

            pst.setInt(1, objDTO.getIdUsuario());

            int add = pst.executeUpdate();

            if (add > 0) {
                JOptionPane.showMessageDialog(null, "Usuario excluído com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum Usuario encontrado com o ID especificado.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Método Deletar: " + e);
        }

    }

    public boolean inserirUsuario(CadastroDTO objDTO) {
        String sql = "INSERT into login(email, senha) VALUES (?, ?)";

        try {
            conexao = new ConexaoDAO().conector();
            pst = conexao.prepareStatement(sql);

            pst.setString(1, objDTO.getEmail());
            pst.setString(2, objDTO.getSenha());

            int add = pst.executeUpdate();

            return add > 0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir técnico: " + e);
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

    public void editarUsuario(CadastroDTO objDTO) {
        String sql = "update login set email = ?, senha = ? where id_usuario = ?";

        try {
            conexao = ConexaoDAO.conector();
            pst = conexao.prepareStatement(sql);

            pst.setString(1, objDTO.getEmail());
            pst.setString(2, objDTO.getSenha());
            pst.setInt(3, objDTO.getIdUsuario());

            int add = pst.executeUpdate();
            if (add > 0) {
                JOptionPane.showMessageDialog(null, "Usuario editado com sucesso!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Método Editar: " + e);
        }
    }
}
