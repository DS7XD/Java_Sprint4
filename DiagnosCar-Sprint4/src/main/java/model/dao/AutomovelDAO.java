package model.dao;

import connection.ConnDAO;
import model.vo.Automovel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AutomovelDAO {

    public void inserir(Automovel automovel) {
        String sql = "INSERT INTO Automovel (Placa_Automovel, Marca_Automovel, Modelo_Automovel, Ano_Automovel, Cliente_CPF_Cliente) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConnDAO.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, automovel.getPlacaAutomovel());
            pstmt.setString(2, automovel.getMarcaAutomovel());
            pstmt.setString(3, automovel.getModeloAutomovel());
            pstmt.setInt(4, automovel.getAnoAutomovel());
            pstmt.setString(5, automovel.getClienteCpfCliente());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Automovel buscarPorPlaca(String placa) {
        String sql = "SELECT * FROM Automovel WHERE Placa_Automovel = ?";
        Automovel automovel = null;

        try (Connection conn = ConnDAO.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, placa);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                automovel = new Automovel(
                    rs.getString("Placa_Automovel"),
                    rs.getString("Marca_Automovel"),
                    rs.getString("Modelo_Automovel"),
                    rs.getInt("Ano_Automovel"),
                    rs.getString("Cliente_CPF_Cliente")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return automovel;
    }

    public void atualizar(Automovel automovel) {
        String sql = "UPDATE Automovel SET Marca_Automovel = ?, Modelo_Automovel = ?, Ano_Automovel = ?, Cliente_CPF_Cliente = ? WHERE Placa_Automovel = ?";

        try (Connection conn = ConnDAO.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, automovel.getMarcaAutomovel());
            pstmt.setString(2, automovel.getModeloAutomovel());
            pstmt.setInt(3, automovel.getAnoAutomovel());
            pstmt.setString(4, automovel.getClienteCpfCliente());
            pstmt.setString(5, automovel.getPlacaAutomovel());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(String placa) {
        String sql = "DELETE FROM Automovel WHERE Placa_Automovel = ?";

        try (Connection conn = ConnDAO.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, placa);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para listar todos os automóveis
    public List<Automovel> listarTodos() {
        String sql = "SELECT * FROM Automovel";
        List<Automovel> automoveis = new ArrayList<>();

        try (Connection conn = ConnDAO.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
             
            while (rs.next()) {
                Automovel automovel = new Automovel(
                    rs.getString("Placa_Automovel"),
                    rs.getString("Marca_Automovel"),
                    rs.getString("Modelo_Automovel"),
                    rs.getInt("Ano_Automovel"),
                    rs.getString("Cliente_CPF_Cliente")
                );
                automoveis.add(automovel);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return automoveis;
    }
}
