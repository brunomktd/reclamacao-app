package br.com.app.application.input;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReclamacaoInput {
    private String titulo;
    private String descricao;
    private String localidade;
}
