package br.com.app.core.ports.adapters;

import br.com.app.core.model.Empresa;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmpresaAdapterRepository {
    Empresa save(Empresa empresa);

    List<Empresa> findAll();

    Optional<Empresa> findById(String id);
}
