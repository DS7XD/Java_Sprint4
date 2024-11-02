package br.com.fiap.model.dao;

import br.com.fiap.model.vo.Loja_Parceira;
import br.com.fiap.connection.ConnDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LojaParceiraDAO {

    private Connection conexao;

    public LojaParceiraDAO() throws ClassNotFoundException, SQLException {
        this.conexao = new ConnDAO().conexao();
    }

    // Inserir
    public String LojaParceiraDAO_Inserir(Loja_Parceira loja) throws SQLException {
        String sql = "INSERT INTO LOJA_PARCHEIRA (ENDERECO_LOJA, CNPJ_LOJA, NOME_LOJA, AVALIACAO_LOJA, ESPECIALIZACAO_LOJA) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, loja.getEnderecoLoja());
            stmt.setString(2, loja.getCnpjLoja());
            stmt.setString(3, loja.getNomeLoja());
            stmt.setDouble(4, loja.getAvaliacaoLoja());
            stmt.setString(5, loja.getEspecializacaoLoja());
            stmt.executeUpdate();
        }
        return "Loja parceira cadastrada com sucesso!";
    }

    // Deletar
    public String LojaParceiraDAO_Deletar(String cnpjLoja) throws SQLException {
        String sql = "DELETE FROM LOJA_PARCHEIRA WHERE CNPJ_LOJA = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cnpjLoja);
            stmt.executeUpdate();
        }
        return "Loja parceira deletada com sucesso!";
    }

    // Atualizar
    public String LojaParceiraDAO_Atualizar(Loja_Parceira loja) throws SQLException {
        String sql = "UPDATE LOJA_PARCHEIRA SET ENDERECO_LOJA = ?, NOME_LOJA = ?, AVALIACAO_LOJA = ?, ESPECIALIZACAO_LOJA = ? WHERE CNPJ_LOJA = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, loja.getEnderecoLoja());
            stmt.setString(2, loja.getNomeLoja());
            stmt.setDouble(3, loja.getAvaliacaoLoja());
            stmt.setString(4, loja.getEspecializacaoLoja());
            stmt.setString(5, loja.getCnpjLoja());
            stmt.executeUpdate();
        }
        return "Loja parceira atualizada com sucesso!";
    }

    // Selecionar
    public List<Loja_Parceira> LojaParceiraDAO_Selecionar() throws SQLException {
        List<Loja_Parceira> listaLojas = new ArrayList<>();
        String sql = "SELECT * FROM LOJA_PARCHEIRA";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
             
            while (rs.next()) {
                Loja_Parceira loja = new Loja_Parceira(
                    rs.getString("ENDERECO_LOJA"),
                    rs.getString("CNPJ_LOJA"),
                    rs.getString("NOME_LOJA"),
                    rs.getDouble("AVALIACAO_LOJA"),
                    rs.getString("ESPECIALIZACAO_LOJA")
                );
                listaLojas.add(loja);
            }
        }
        return listaLojas;
    }
}
