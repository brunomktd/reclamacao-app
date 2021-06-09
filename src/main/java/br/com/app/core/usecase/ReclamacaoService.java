package br.com.app.core.usecase;

import br.com.app.core.model.Empresa;
import br.com.app.core.model.Reclamacao;
import br.com.app.core.ports.Mapper;
import br.com.app.core.ports.adapters.EmpresaAdapterRepository;
import br.com.app.core.ports.adapters.GoogleCoordinates;
import br.com.app.core.ports.adapters.ReclamacaoAdapterRepository;
import br.com.app.core.ports.input.ReclamacaoPort;
import com.google.maps.errors.ApiException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReclamacaoService implements ReclamacaoPort {

    private final ReclamacaoAdapterRepository reclamacaoAdapterRepository;
    private final EmpresaAdapterRepository empresaAdapterRepository;
    private final GoogleCoordinates googleCoordinates;

    @Override
    public Reclamacao criar(Reclamacao entityInput, String id) {

        Optional<Empresa> empresaOptional = empresaAdapterRepository.findById(id);

        if (empresaOptional.isPresent()){
            Empresa empresa = empresaOptional.get();

            try {
                List<Double> coordinates = googleCoordinates.getCoordinates(entityInput.getLocalidade().getLocalidade());
                entityInput.getLocalidade().setCoordinates(coordinates);
            } catch (Exception e) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
            }

            entityInput.setEmpresa(empresa);
            return reclamacaoAdapterRepository.save(entityInput);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Empresa não existe");
        }
    }

    @Override
    public List<Reclamacao> buscarReclamacoesPorEmpresaId(String id) {
        return reclamacaoAdapterRepository.findAllByEmpresaId(id);
    }
}
