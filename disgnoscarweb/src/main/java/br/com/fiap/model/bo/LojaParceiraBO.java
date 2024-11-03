// AutomovelBO.java
package br.com.fiap.model.bo;

import br.com.fiap.model.dao.AutomovelDAO;
import br.com.fiap.model.vo.Automovel;
import java.sql.SQLException;
import java.util.List;

public class AutomovelBO {
    private AutomovelDAO automovelDAO;

    public AutomovelBO() throws ClassNotFoundException, SQLException {
        this.automovelDAO = new AutomovelDAO();
    }

    public String cadastrarAutomovel(Automovel automovel) throws SQLException {
        return automovelDAO.AutomovelDAO_Inserir(automovel);
    }

    public String atualizarAutomovel(Automovel automovel) throws SQLException {
        return automovelDAO.AutomovelDAO_Atualizar(automovel);
    }

    public String deletarAutomovel(String placa) throws SQLException {
        return automovelDAO.AutomovelDAO_Deletar(placa);
    }

    public List<Automovel> listarAutomoveis() throws SQLException {
        return automovelDAO.AutomovelDAO_Selecionar();
    }
}
