package br.com.app.core.model;

import br.com.app.core.vo.Localidade;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document
public class Reclamacao {
    @Id
    private String id;
    private String titulo;
    private String descricao;
    @DBRef(lazy = true)
    private Localidade localidade;
    @DBRef(lazy = true)
    private Empresa empresa;
}
