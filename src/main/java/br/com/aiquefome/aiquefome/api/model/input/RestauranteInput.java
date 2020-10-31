package br.com.aiquefome.aiquefome.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class RestauranteInput {

    @NotBlank
    private String nome;

    @DecimalMin(value = "0.0")
    private BigDecimal taxaFrete;

    @NotNull
    private CozinhaInput cozinha;
}
