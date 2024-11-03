// OficinaBO.java
package br.com.fiap.model.bo;

import br.com.fiap.model.dao.OficinaDAO;
import br.com.fiap.model.vo.Oficina;
import java.sql.SQLException;
import java.util.List;

public class OficinaBO {
    private OficinaDAO oficinaDAO = new OficinaDAO();

    public String cadastrarOficina(Oficina oficina) throws SQLException {
        if (oficina.getCnpjOficina() == null || oficina.getCnpjOficina().trim().isEmpty()) {
            throw new IllegalArgumentException("CNPJ da oficina não pode estar vazio");
        }
        
        if (oficina.getNomeOficina() == null || oficina.getNomeOficina().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome da oficina não pode estar vazio");
        }

        if (oficina.getAvaliacaoOficina() != null && 
            (oficina.getAvaliacaoOficina() < 0 || oficina.getAvaliacaoOficina() > 5)) {
            throw new IllegalArgumentException("Avaliação deve estar entre 0 e 5");
        }

        return oficinaDAO.OficinaDAO_Inserir(oficina);
    }

    public String atualizarOficina(Oficina oficina) throws SQLException {
        if (oficina.getCnpjOficina() == null || oficina.getCnpjOficina().trim().isEmpty()) {
            throw new IllegalArgumentException("CNPJ da oficina não pode estar vazio");
        }
        return oficinaDAO.OficinaDAO_Atualizar(oficina);
    }

    public String deletarOficina(String endereco) throws SQLException {
        if (endereco == null || endereco.trim().isEmpty()) {
            throw new IllegalArgumentException("Endereço não pode estar vazio");
        }
        return oficinaDAO.OficinaDAO_Deletar(endereco);
    }

    public List<Oficina> listarOficinas() throws SQLException {
        return oficinaDAO.OficinaDAO_Selecionar();
    }
}