package br.com.app.infrastructure.db.mongo.empresa;

import br.com.app.core.model.Empresa;
import br.com.app.core.ports.adapters.EmpresaAdapterRepository;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Optional;

@Configuration
public class EmpresaAdapterRepositoryImpl implements EmpresaAdapterRepository {

    private final MongoEmpresaRepository mongoEmpresaRepository;

    public EmpresaAdapterRepositoryImpl(MongoEmpresaRepository mongoEmpresaRepository) {
        this.mongoEmpresaRepository = mongoEmpresaRepository;
    }

    @Override
    public Empresa save(Empresa empresa) {
        return mongoEmpresaRepository.save(empresa);
    }

    @Override
    public List<Empresa> findAll() {
        return mongoEmpresaRepository.findAll();
    }

    @Override
    public Optional<Empresa> findById(String id) {
        return mongoEmpresaRepository.findById(id);
    }
}
