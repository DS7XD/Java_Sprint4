package sprint4.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import sprint4.conection.ConnDAO;
import sprint4.model.vo.Peca;

public class PecaDAO {

	public void inserirPeca(Peca peca) {
	    String sql = "INSERT INTO Peca (Id_Peca, Tipo_Peca, Nome_Peca, Endereco_Peca) VALUES (?, ?, ?, ?)";
	    
	    try (Connection conn = ConnDAO.conectar();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        
	        stmt.setInt(1, peca.getIdPeca());
	        stmt.setString(2, peca.getTipoPeca());
	        stmt.setString(3, peca.getNomePeca());
	        stmt.setString(4, peca.getEndereco_Peca()); 
	        
	        int rowsInserted = stmt.executeUpdate();
	        if (rowsInserted > 0) {
	            System.out.println("A peça foi inserida com sucesso!");
	        }
	        
	    } catch (SQLException e) {
	        System.out.println("Erro ao inserir a peça: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
}




