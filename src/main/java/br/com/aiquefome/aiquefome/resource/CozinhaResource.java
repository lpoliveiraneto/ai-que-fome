package br.com.aiquefome.aiquefome.resource;

import br.com.aiquefome.aiquefome.domain.services.CadastroCozinhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import br.com.aiquefome.aiquefome.domain.models.Cozinha;
import br.com.aiquefome.aiquefome.domain.exceptions.CozinhaNotFoundException;
import br.com.aiquefome.aiquefome.domain.repositoreis.CozinhaRepository;

@RestController
public class CozinhaResource {

    @Autowired
    private CadastroCozinhaService cadastroCozinhaService;

    @GetMapping("/cozinhas")
    public List<Cozinha> retrieveAllCozinha(){
        return cadastroCozinhaService.listaTodas();
    }

    @PostMapping("/cozinhas")
    public ResponseEntity<Cozinha> save(@RequestBody Cozinha cozinha){
        Cozinha cozinhaSave = cadastroCozinhaService.salvar(cozinha);
        return new ResponseEntity<>(cozinhaSave, HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/cozinhas/{id}")
    public void delete(@PathVariable Long id){
        cadastroCozinhaService.deletar(id);
    }

    @GetMapping("/cozinhas/{id}")
    public Cozinha retrieveCozinha(@PathVariable Long id){
        return cadastroCozinhaService.buscarOrFalhar(id);
    }

    @PutMapping("/cozinhas/{id}")
    public Cozinha update(@PathVariable Long id, @RequestBody Cozinha newCozinha){
        newCozinha.setId(id);
        return cadastroCozinhaService.atualizar(newCozinha);
    }
}
