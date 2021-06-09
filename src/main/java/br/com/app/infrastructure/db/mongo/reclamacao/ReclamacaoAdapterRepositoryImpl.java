package br.com.app.infrastructure.db.mongo.reclamacao;

import br.com.app.core.model.Reclamacao;
import br.com.app.core.ports.adapters.ReclamacaoAdapterRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@AllArgsConstructor
public class ReclamacaoAdapterRepositoryImpl implements ReclamacaoAdapterRepository {

    private final MongoReclamacaoRepository mongoReclamacaoRepository;

    @Override
    public Reclamacao save(Reclamacao entity) {
        return mongoReclamacaoRepository.save(entity);
    }

    @Override
    public List<Reclamacao> findAllByEmpresaId(String id) {
        return mongoReclamacaoRepository.findAllByEmpresaId(id);
    }
}
