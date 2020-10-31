package br.com.aiquefome.aiquefome.api.assembler;

import br.com.aiquefome.aiquefome.api.model.CozinhaModel;
import br.com.aiquefome.aiquefome.api.model.RestauranteModel;
import br.com.aiquefome.aiquefome.domain.models.Restaurante;
import org.springframework.stereotype.Component;

@Component
public class RestauranteModelAssembler {

    public RestauranteModel toModel(Restaurante restaurante) {
        RestauranteModel restauranteModel = new RestauranteModel();
        restauranteModel.setId(restaurante.getId());
        restauranteModel.setNome(restaurante.getNome());
        restauranteModel.setAtivo(restaurante.isAtivo());

        CozinhaModel cozinhaModel  = new CozinhaModel();
        cozinhaModel.setId(restaurante.getCozinha().getId());
        cozinhaModel.setNome(restaurante.getCozinha().getNome());

        restauranteModel.setCozinha(cozinhaModel);
        restauranteModel.setTaxaFrete(restaurante.getTaxaFrete());

        return restauranteModel;
    }
}
