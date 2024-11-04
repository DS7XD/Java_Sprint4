package br.com.fiap.model.bo;

import br.com.fiap.model.dao.OficinaDAO;
import br.com.fiap.model.vo.OficinaVO;
import java.sql.SQLException;
import java.util.List;

public class OficinaBO {
    private OficinaDAO oficinaDAO;

    public String cadastrarOficina(OficinaVO oficina) throws SQLException {
        if (oficina.getCnpjOficina() == null || oficina.getCnpjOficina().trim().isEmpty()) {
            throw new IllegalArgumentException("CNPJ da oficina não pode estar vazio");
        }
        
        if (oficina.getNomeOficina() == null || oficina.getNomeOficina().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome da oficina não pode estar vazio");
        }

        if (oficina.getAvaliacaoOficina() != null && 
            (oficina.getAvaliacaoOficina() < 0 || oficina.getAvaliacaoOficina() > 10)) {
            throw new IllegalArgumentException("Avaliação deve estar entre 0 e 10");
        }

        return oficinaDAO.OficinaDAO_Inserir(oficina);
    }

    public String atualizarOficina(OficinaVO oficina) throws SQLException {
        if (oficina.getCnpjOficina() == null || oficina.getCnpjOficina().trim().isEmpty()) {
            throw new IllegalArgumentException("CNPJ da oficina não pode estar vazio");
        }
        return oficinaDAO.OficinaDAO_Atualizar(oficina);
    }

    public String deletarOficina(String endereco) throws SQLException {
        if (endereco == null || endereco.trim().isEmpty()) {
            throw new IllegalArgumentException("Endereço não pode estar vazio");
        }
        return oficinaDAO.OficinaDAO_deletar(endereco);
    }

    public List<OficinaVO> listarOficinas() throws SQLException {
        return oficinaDAO.OficinaDAO_Selecionar();
    }
}