package br.com.app.application.controller;

import br.com.app.application.input.ReclamacaoInput;
import br.com.app.application.output.ReclamacaoOutput;
import br.com.app.core.model.Reclamacao;
import br.com.app.core.ports.Mapper;
import br.com.app.core.ports.input.ReclamacaoPort;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reclamacoes")
@AllArgsConstructor
public class ReclamacaoController {

    private final ReclamacaoPort reclamacaoPort;
    private final Mapper mapper;

    @PostMapping("/empresa/{id}")
    public ReclamacaoOutput criar (@RequestBody ReclamacaoInput input, @PathVariable("id") String id){
        Reclamacao reclamacaoEntity = this.mapper.createMapper(input, Reclamacao.class);
        Reclamacao reclamacaoSalva = reclamacaoPort.criar(reclamacaoEntity, id);
        return mapper.createMapper(reclamacaoSalva, ReclamacaoOutput.class);
    }

    @GetMapping("/empresa/{id}")
    public List<ReclamacaoOutput> buscarReclamacoesPorEmpresa (@PathVariable("id") String id){
        List<Reclamacao> reclamacoes = reclamacaoPort.buscarReclamacoesPorEmpresaId(id);
        return reclamacoes.stream().map(r -> mapper.createMapper(r, ReclamacaoOutput.class)).collect(Collectors.toList());
    }
}
