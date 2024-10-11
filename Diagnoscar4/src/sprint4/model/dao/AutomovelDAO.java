package sprint4.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	            System.out.println("Automóvel inserido com sucesso!");
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

}
