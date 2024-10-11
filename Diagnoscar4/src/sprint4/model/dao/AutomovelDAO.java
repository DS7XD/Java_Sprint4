package sprint4.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sprint4.conection.ConnDAO;
import sprint4.model.vo.Automovel;

public class AutomovelDAO {

    public boolean inserirAutomovel(Automovel automovel) {
        String sql = "INSERT INTO Automovel (Placa_Automovel, Marca_Automovel, Modelo_Automovel, Cor_Automovel, Ano_Automovel, Cliente_CPF_Cliente) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnDAO.conectar(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, automovel.getPlacaAutomovel());
            ps.setString(2, automovel.getMarcaAutomovel());
            ps.setString(3, automovel.getModeloAutomovel());
            ps.setString(4, automovel.getCorAutomovel());
            ps.setInt(5, automovel.getAnoAutomovel());
            ps.setString(6, automovel.getClienteCpfCliente());

            int rowsInserted = ps.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Automóvel cadastrado com sucesso!");
                return true;
            } else {
                System.out.println("Nenhum automóvel foi inserido.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir automóvel: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean removerAutomovelPorPlaca(String placaAutomovel) {
        String sql = "DELETE FROM Automovel WHERE Placa_Automovel = ?";

        try (Connection conn = ConnDAO.conectar(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, placaAutomovel);

            int rowsDeleted = ps.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Automóvel removido com sucesso!");
                return true;
            } else {
                System.out.println("Nenhum automóvel encontrado com a placa informada.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao remover automóvel: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public List<Automovel> selecionarAutomoveisPorCpf(String cpfCliente) {
        String sql = "SELECT * FROM Automovel WHERE Cliente_CPF_Cliente = ?";
        List<Automovel> automoveis = new ArrayList<>();

        try (Connection conn = ConnDAO.conectar(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, cpfCliente);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Automovel automovel = new Automovel();
                automovel.setPlacaAutomovel(rs.getString("Placa_Automovel"));
                automovel.setMarcaAutomovel(rs.getString("Marca_Automovel"));
                automovel.setModeloAutomovel(rs.getString("Modelo_Automovel"));
                automovel.setCorAutomovel(rs.getString("Cor_Automovel"));
                automovel.setAnoAutomovel(rs.getInt("Ano_Automovel"));
                automovel.setClienteCpfCliente(rs.getString("Cliente_CPF_Cliente"));
                
                automoveis.add(automovel);
            }
            
            if (automoveis.isEmpty()) {
                System.out.println("Nenhum automóvel encontrado para o CPF informado.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao selecionar automóveis: " + e.getMessage());
            e.printStackTrace();
        }

        return automoveis;
    }
}
