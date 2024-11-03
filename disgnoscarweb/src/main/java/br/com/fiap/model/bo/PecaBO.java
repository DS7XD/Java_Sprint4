package br.com.fiap.model.bo;

import br.com.fiap.model.dao.PecaDAO;
import br.com.fiap.model.vo.Peca;
import java.sql.SQLException;
import java.util.List;

public class PecaBO {
    private PecaDAO pecaDAO = new PecaDAO();

    public String cadastrarPeca(Peca peca) throws SQLException {
        if (peca.getIdPeca() == null || peca.getIdPeca().trim().isEmpty()) {
            throw new IllegalArgumentException("ID da peça não pode estar vazio");
        }
        
        if (peca.getNomePeca() == null || peca.getNomePeca().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome da peça não pode estar vazio");
        }

        return pecaDAO.PecaDAO_Inserir(peca);
    }

    public String atualizarPeca(Peca peca) throws SQLException {
        if (peca.getIdPeca() == null || peca.getIdPeca().trim().isEmpty()) {
            throw new IllegalArgumentException("ID da peça não pode estar vazio");
        }
        return pecaDAO.PecaDAO_Atualizar(peca);
    }

    public String deletarPeca(String id) throws SQLException {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID não pode estar vazio");
        }
        return pecaDAO.PecaDAO_Deletar(id);
    }

    public List<Peca> listarPecas() throws SQLException {
        return pecaDAO.PecaDAO_Selecionar();
    }
}