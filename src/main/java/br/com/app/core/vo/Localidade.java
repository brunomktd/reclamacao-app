package br.com.app.core.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Localidade {
    private String localidade;
    private List<Double> coordinates;
    private String type = "Point";

    public Localidade(String localidade, List<Double> coordinates) {
        this.localidade = localidade;
        this.coordinates = coordinates;
    }
}
