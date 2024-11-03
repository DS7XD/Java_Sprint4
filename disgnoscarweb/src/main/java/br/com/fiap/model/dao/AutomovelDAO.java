package br.com.fiap.model.dao;

import br.com.fiap.model.vo.Automovel;
import br.com.fiap.connection.ConnDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AutomovelDAO {

    private Connection conexao;

    public AutomovelDAO() throws ClassNotFoundException, SQLException {
        this.conexao = new ConnDAO().conexao();
    }

    public String AutomovelDAO_Inserir(Automovel automovel) throws SQLException {
        String sql = "INSERT INTO Automovel (PLACA_AUTOMOVEL, MARCA_AUTOMOVEL, MODELO_AUTOMOVEL, ANO_AUTOMOVEL, CPF_CLIENTE) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, automovel.getPlacaAutomovel());
            stmt.setString(2, automovel.getMarcaAutomovel());
            stmt.setString(3, automovel.getModeloAutomovel());
            stmt.setInt(4, automovel.getAnoAutomovel());
            stmt.setString(5, automovel.getClienteCpfCliente());
            stmt.executeUpdate();
        }
        return "Automóvel cadastrado com sucesso!";
    }

    public String AutomovelDAO_Deletar(String placaAutomovel) throws SQLException {
        String sql = "DELETE FROM Automovel WHERE PLACA_AUTOMOVEL = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, placaAutomovel);
            stmt.executeUpdate();
        }
        return "Automóvel deletado com sucesso!";
    }

    public String AutomovelDAO_Atualizar(Automovel automovel) throws SQLException {
        String sql = "UPDATE Automovel SET MARCA_AUTOMOVEL = ?, MODELO_AUTOMOVEL = ?, ANO_AUTOMOVEL = ?, CPF_CLIENTE = ? WHERE PLACA_AUTOMOVEL = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, automovel.getMarcaAutomovel());
            stmt.setString(2, automovel.getModeloAutomovel());
            stmt.setInt(3, automovel.getAnoAutomovel());
            stmt.setString(4, automovel.getClienteCpfCliente());
            stmt.setString(5, automovel.getPlacaAutomovel());
            stmt.executeUpdate();
        }
        return "Automóvel atualizado com sucesso!";
    }

    public List<Automovel> AutomovelDAO_Selecionar() throws SQLException {
        List<Automovel> listaAutomovel = new ArrayList<>();
        String sql = "SELECT * FROM Automovel";
        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Automovel automovel = new Automovel(
                    rs.getString("PLACA_AUTOMOVEL"),
                    rs.getString("MARCA_AUTOMOVEL"),
                    rs.getString("MODELO_AUTOMOVEL"),
                    rs.getInt("ANO_AUTOMOVEL"),
                    rs.getString("CPF_CLIENTE")
                );
                listaAutomovel.add(automovel);
            }
        }
        return listaAutomovel;
    }

    public boolean automovelExiste(String placaAutomovel) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Automovel WHERE PLACA_AUTOMOVEL = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, placaAutomovel);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next() && rs.getInt(1) > 0;
            }
        }
    }
}
