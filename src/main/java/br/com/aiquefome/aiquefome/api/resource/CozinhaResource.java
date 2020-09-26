package br.com.aiquefome.aiquefome.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
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

import java.util.List;
import br.com.aiquefome.aiquefome.domain.models.Cozinha;
import br.com.aiquefome.aiquefome.domain.services.CadastroCozinhaService;

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
