package br.com.aiquefome.aiquefome.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.aiquefome.aiquefome.domain.models.Restaurante;
import br.com.aiquefome.aiquefome.domain.exceptions.RestauranteNotFoundException;
import br.com.aiquefome.aiquefome.domain.models.Cozinha;
import br.com.aiquefome.aiquefome.domain.repositoreis.RestauranteRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CadastroRestauranteService {
    
    private final RestauranteRepository restauranteRepository;
    private final CadastroCozinhaService cadastroCozinhaService;

    public Restaurante salvar(Restaurante restaurante){

        Cozinha cozinha = cadastroCozinhaService.buscarOrFalhar(restaurante.getCozinha().getId());
        restaurante.setCozinha(cozinha);

        return restauranteRepository.save(restaurante);
    }

    public List<Restaurante> listaTodos(){
        
        return restauranteRepository.findAll();
    }

    public void deletar(Long restauranteID){
        
        try {
            restauranteRepository.deleteById(restauranteID);
        } catch (EmptyResultDataAccessException exception) {
            throw new RestauranteNotFoundException(String.format("Não foi encontrado um restaurante com o ID: d%", restauranteID));
        }
    }

    public Restaurante atualizar(Restaurante restaurante){

        Cozinha cozinha = cadastroCozinhaService.buscarOrFalhar(restaurante.getCozinha().getId());

        Restaurante restauranteAtual = buscarOrFalhar(restaurante.getId());
        restauranteAtual.setNome(restaurante.getNome());
        restauranteAtual.setTaxaFrete(restaurante.getTaxaFrete());
        restauranteAtual.setAtivo(restaurante.isAtivo());;
        restauranteAtual.setCozinha(cozinha);

        return salvar(restauranteAtual);
    }

    public Restaurante buscarOrFalhar(Long restauranteID){
        Optional<Restaurante> restauranteOptional = restauranteRepository.findById(restauranteID);
        return restauranteOptional.orElseThrow(() ->
                new RestauranteNotFoundException((String.format("Não foi encontrado Restaurante com o ID: %d", restauranteID))));

    }

}
