package br.com.fiap.model.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.model.dao.TabelaAssociativaDAO;
import br.com.fiap.model.vo.TabelaAssociativaVO;

public class TabelaAssociativaBO {

    private TabelaAssociativaDAO tabelaAssociativaDAO;

    public TabelaAssociativaBO() throws ClassNotFoundException, SQLException {
        this.tabelaAssociativaDAO = new TabelaAssociativaDAO();
    }

    public void cadastrarTabelaAssociativa(TabelaAssociativaVO tabelaAssociativa) throws SQLException {
        this.tabelaAssociativaDAO.TabelaAssociativa_Inserir(tabelaAssociativa);
    }

    public void atualizarTabelaAssociativa(TabelaAssociativaVO tabelaAssociativa) throws SQLException {
        this.tabelaAssociativaDAO.TabelaAssociativa_Atualizar(tabelaAssociativa);
    }

    public void deletarTabelaAssociativa(String cpfCliente, String idChatbot) throws SQLException {
        this.tabelaAssociativaDAO.TabelaAssociativa_Deletar(cpfCliente, idChatbot);
    }

    public List<TabelaAssociativaVO> listarTabelaAssociativa() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarTabelaAssociativa'");
    }
}

