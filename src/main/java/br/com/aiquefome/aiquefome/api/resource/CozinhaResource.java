package br.com.aiquefome.aiquefome.api.resource;

import br.com.aiquefome.aiquefome.domain.services.CadastroCozinhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import br.com.aiquefome.aiquefome.domain.models.Cozinha;

@RequestMapping("/cozinhas")
@RestController
public class CozinhaResource {

    @Autowired
    private CadastroCozinhaService cadastroCozinhaService;

    @GetMapping
    public List<Cozinha> retrieveAllCozinha(){
        return cadastroCozinhaService.listaTodas();
    }

    @PostMapping
    public ResponseEntity<Cozinha> save(@RequestBody Cozinha cozinha){
        Cozinha cozinhaSave = cadastroCozinhaService.salvar(cozinha);
        return new ResponseEntity<>(cozinhaSave, HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        cadastroCozinhaService.deletar(id);
    }

    @GetMapping("/{id}")
    public Cozinha retrieveCozinha(@PathVariable Long id){
        return cadastroCozinhaService.buscarOrFalhar(id);
    }

    @PutMapping("/{id}")
    public Cozinha update(@PathVariable Long id, @RequestBody Cozinha newCozinha){
        newCozinha.setId(id);
        return cadastroCozinhaService.atualizar(newCozinha);
    }
}
