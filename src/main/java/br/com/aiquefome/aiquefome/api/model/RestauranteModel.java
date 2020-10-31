package br.com.aiquefome.aiquefome.api.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class RestauranteModel {

    private Long id;
    private String nome;
    private BigDecimal taxaFrete;
    private boolean ativo;
    private CozinhaModel cozinha;
}
