package br.com.DAO;

import br.com.DTO.ManutencaoDTO;
import br.com.DTO.MaquinaDTO;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ManutencaoDAO {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public boolean inserir(ManutencaoDTO objDTO) {
        String sql = "INSERT INTO manutencoes (id_manutencao, id_maquina, data_manutencao, diagnostico, solucao, tecnico_responsavel) VALUES(?, ?, ?, ?, ?, ?)";

        try {
            conexao = new ConexaoDAO().conector();
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, objDTO.getId_manutencao());
            pst.setInt(2, objDTO.getId_maquina());
            pst.setString(3, objDTO.getDataManutencao());
            pst.setString(4, objDTO.getDiagnostico());
            pst.setString(5, objDTO.getSolucao());
            pst.setString(6, objDTO.getTecnico_responsavel());
            pst.execute();
            return true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Inserir máquina: " + e);
            e.printStackTrace(); // Para depuração
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

    public void editar(ManutencaoDTO objDTO) {
     
        String sql = "UPDATE manutencoes SET id_maquina = ?, data_manutencao = ?, diagnostico = ?, solucao = ?, tecnico_responsavel = ? WHERE id_manutencao = ?";

        try {
            conexao = ConexaoDAO.conector();
            pst = conexao.prepareStatement(sql);

            pst.setInt(1, objDTO.getId_maquina());
            pst.setString(2, objDTO.getDataManutencao());
            pst.setString(3, objDTO.getDiagnostico());
            pst.setString(4, objDTO.getSolucao());
            pst.setString(5, objDTO.getTecnico_responsavel());
            pst.setInt(6, objDTO.getId_manutencao());
           
           
       
            int add = pst.executeUpdate();

            if (add > 0) {
                JOptionPane.showMessageDialog(null, "Manutenção alterada com sucesso!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Método Editar: " + e);
            e.printStackTrace(); // Para depuração
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
    
     public void deletar(ManutencaoDTO objDTO) {
        String sql = "DELETE FROM manutencoes WHERE id_manutencao = ?";

        try {
            conexao = ConexaoDAO.conector();
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, objDTO.getId_maquina());

            int add = pst.executeUpdate();
            if (add > 0) {
                JOptionPane.showMessageDialog(null, "Manutenção cancelada com sucesso!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Método apagar: " + e);
            e.printStackTrace(); // Para depuração
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

}
