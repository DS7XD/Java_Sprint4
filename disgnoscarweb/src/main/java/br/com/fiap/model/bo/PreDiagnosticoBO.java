// PreDiagnosticoBO.java
package br.com.fiap.model.bo;

import br.com.fiap.model.dao.PreDiagnosticoDAO;
import br.com.fiap.model.vo.PreDiagnostico;
import java.sql.SQLException;
import java.util.List;

public class PreDiagnosticoBO {
    private PreDiagnosticoDAO preDiagnosticoDAO = new PreDiagnosticoDAO();

    public String cadastrarPreDiagnostico(PreDiagnostico preDiagnostico) throws SQLException {
        if (preDiagnostico.getIdPreDiagnostico() == null || preDiagnostico.getIdPreDiagnostico().trim().isEmpty()) {
            throw new IllegalArgumentException("ID do pré-diagnóstico não pode estar vazio");
        }
        
        if (preDiagnostico.getDiagnostico() == null || preDiagnostico.getDiagnostico().trim().isEmpty()) {
            throw new IllegalArgumentException("Diagnóstico não pode estar vazio");
        }

        return preDiagnosticoDAO.PreDiagnosticoDAO_Inserir(preDiagnostico);
    }

    public String atualizarPreDiagnostico(PreDiagnostico preDiagnostico) throws SQLException {
        if (preDiagnostico.getIdPreDiagnostico() == null || preDiagnostico.getIdPreDiagnostico().trim().isEmpty()) {
            throw new IllegalArgumentException("ID do pré-diagnóstico não pode estar vazio");
        }
        return preDiagnosticoDAO.PreDiagnosticoDAO_Atualizar(preDiagnostico);
    }

    public String deletarPreDiagnostico(String id) throws SQLException {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID não pode estar vazio");
        }
        return preDiagnosticoDAO.PreDiagnosticoDAO_Deletar(id);
    }

    public List<PreDiagnostico> listarPreDiagnosticos() throws SQLException {
        return preDiagnosticoDAO.PreDiagnosticoDAO_Selecionar();
    }
}