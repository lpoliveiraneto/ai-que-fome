package br.com.aiquefome.aiquefome.domain.services;

import br.com.aiquefome.aiquefome.domain.models.Cozinha;
import br.com.aiquefome.aiquefome.domain.models.Restaurante;
import br.com.aiquefome.aiquefome.domain.repositoreis.RestauranteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CadastroRestauranteService {

    private final RestauranteRepository restauranteRepository;
    private final CadastroCozinhaService cadastroCozinhaService;

    public Restaurante salvar(Restaurante restaurante) {
        Cozinha cozinha = cadastroCozinhaService.buscarOrFalhar(restaurante.getCozinha().getId());
        restaurante.setCozinha(cozinha);

        return restauranteRepository.save(restaurante);
    }
}
