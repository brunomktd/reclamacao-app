package br.com.app.core.ports.adapters;

import br.com.app.core.model.Reclamacao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReclamacaoAdapterRepository {

    Reclamacao save(Reclamacao reclamacaoEntity);

    List<Reclamacao> findAllByEmpresaId(String id);
}
