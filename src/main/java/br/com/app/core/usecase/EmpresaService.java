package br.com.app.core.usecase;

import br.com.app.core.model.Empresa;
import br.com.app.core.ports.Mapper;
import br.com.app.core.ports.adapters.EmpresaAdapterRepository;
import br.com.app.core.ports.input.EmpresaPort;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmpresaService implements EmpresaPort {

    private final EmpresaAdapterRepository empresaAdapterRepository;
    private final Mapper mapper;

    @Override
    public Empresa criar(Empresa empresa) {
        return empresaAdapterRepository.save(empresa);
    }

    @Override
    public List<Empresa> buscarTodas() {
        return empresaAdapterRepository.findAll();
    }

    @Override
    public Empresa buscarPorId(String id) {
        Optional<Empresa> empresaOptional = empresaAdapterRepository.findById(id);
        if (empresaOptional.isPresent()){
            return empresaOptional.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Empresa não existe");
        }
    }

    @Override
    public Empresa atualizar(Empresa empresa, String id) {
        Optional<Empresa> empresaOptional = empresaAdapterRepository.findById(id);
        if (empresaOptional.isPresent()){
            Empresa entity = empresaOptional.get();
            entity.setNome(empresa.getNome());
            return empresaAdapterRepository.save(entity);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Empresa não existe");
        }
    }
}
