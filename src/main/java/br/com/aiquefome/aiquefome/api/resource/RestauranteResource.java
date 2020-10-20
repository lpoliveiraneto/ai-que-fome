package br.com.aiquefome.aiquefome.api.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.aiquefome.aiquefome.domain.models.Restaurante;
import br.com.aiquefome.aiquefome.domain.services.CadastroRestauranteService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/restaurantes")
@RestController
public class RestauranteResource {

    private final CadastroRestauranteService cadastroRestauranteService;
    
    @GetMapping
    public List<Restaurante> retrieveAllCozinha(){
    
        return cadastroRestauranteService.listaTodos();
    }

    @PostMapping
    public ResponseEntity<Restaurante> save(@RequestBody Restaurante restaurante){

        Restaurante restauranteSave = cadastroRestauranteService.salvar(restaurante);
        return new ResponseEntity<>(restauranteSave, HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){

        cadastroRestauranteService.deletar(id);
    }

    @GetMapping("/{id}")
    public Restaurante retrieveRestaurante(@PathVariable Long id){

        return cadastroRestauranteService.buscarOrFalhar(id);
    }

    @PutMapping("/{id}")
    public Restaurante update(@PathVariable Long id, @RequestBody Restaurante newRestaurante){
        newRestaurante.setId(id);
        return cadastroRestauranteService.atualizar(newRestaurante);
    }

}
