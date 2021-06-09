package br.com.app.application.output;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReclamacaoOutput {
    private String titulo;
    private String descricao;
    private String localidade;
    private EmpresaOutput empresa;
}
