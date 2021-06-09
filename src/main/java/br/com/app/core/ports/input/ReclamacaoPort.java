package br.com.app.core.ports.input;

import br.com.app.core.model.Reclamacao;

import java.util.List;


public interface ReclamacaoPort {
    Reclamacao criar(Reclamacao entityInput, String id);

    List<Reclamacao> buscarReclamacoesPorEmpresaId(String id);
}
