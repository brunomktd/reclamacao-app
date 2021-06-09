package br.com.app.infrastructure.db.mongo.empresa;

import br.com.app.core.model.Empresa;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoEmpresaRepository extends MongoRepository<Empresa, String> {
}
