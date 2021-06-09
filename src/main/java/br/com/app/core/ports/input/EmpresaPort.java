package br.com.app.core.ports.input;

import br.com.app.core.model.Empresa;

import java.util.List;

public interface EmpresaPort {
    Empresa criar(Empresa input);

    List<Empresa> buscarTodas();

    Empresa buscarPorId(String id);

    Empresa atualizar(Empresa input, String id);
}
