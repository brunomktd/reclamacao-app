package br.com.app.infrastructure.db.mongo.reclamacao;

import br.com.app.core.model.Reclamacao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MongoReclamacaoRepository extends MongoRepository<Reclamacao, String> {
    List<Reclamacao> findAllByEmpresaId(String id);
}
