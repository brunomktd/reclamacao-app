package br.com.app.application.controller;

import br.com.app.application.input.EmpresaInput;
import br.com.app.application.output.EmpresaOutput;
import br.com.app.core.model.Empresa;
import br.com.app.core.ports.Mapper;
import br.com.app.core.ports.input.EmpresaPort;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/empresas")
@AllArgsConstructor
public class EmpresaController {

    private final EmpresaPort empresaPort;
    private final Mapper mapper;

    @PostMapping
    public EmpresaOutput criar(@RequestBody EmpresaInput input){
        Empresa empresa = mapper.createMapper(input, Empresa.class);
        Empresa empresaSalva = empresaPort.criar(empresa);
        return mapper.createMapper(empresaSalva, EmpresaOutput.class);
    }

    @GetMapping
    public List<EmpresaOutput> buscarTodas(){
        List<Empresa> empresas = empresaPort.buscarTodas();
        return empresas.stream().map(e -> mapper.createMapper(e, EmpresaOutput.class)).collect(Collectors.toList());
    }

    @GetMapping("/empresa/{id}")
    public EmpresaOutput buscarPorId(@PathVariable("id") String id){
        Empresa empresa = empresaPort.buscarPorId(id);
        return mapper.createMapper(empresa, EmpresaOutput.class);
    }

    @PutMapping("/empresa/{id}")
    public EmpresaOutput atualizar(@RequestBody EmpresaInput input, @PathVariable("id") String id){
        Empresa empresa = this.mapper.createMapper(input, Empresa.class);
        Empresa empresaAtualizada = empresaPort.atualizar(empresa, id);
        return mapper.createMapper(empresaAtualizada, EmpresaOutput.class);
    }

}
