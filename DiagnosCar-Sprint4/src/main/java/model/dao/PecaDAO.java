package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.vo.Peca;
import conection.ConnDAO;

public class PecaDAO {

	public void inserirPeca(Peca peca) {
	    String sql = "INSERT INTO Peca (Id_Peca, Tipo_Peca, Nome_Peca, Endereco_Peca) VALUES (?, ?, ?, ?)";
	    
	    try (Connection conn = ConnDAO.conectar();
	         PreparedStatement ps = conn.prepareStatement(sql)) {
	        
	        ps.setInt(1, peca.getIdPeca());
	        ps.setString(2, peca.getTipoPeca());
	        ps.setString(3, peca.getNomePeca());
	        ps.setString(4, peca.getEndereco_Peca()); 
	        
	        int rowsInserted = ps.executeUpdate();
	        if (rowsInserted > 0) {
	            System.out.println("A peça foi inserida com sucesso!");
	        }
	        
	    } catch (SQLException e) {
	        System.out.println("Erro ao inserir a peça: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
}




