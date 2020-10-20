package br.com.aiquefome.aiquefome.api.resource;

import java.util.List;

import javax.annotation.PostConstruct;

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

import br.com.aiquefome.aiquefome.domain.models.Cidade;
import br.com.aiquefome.aiquefome.domain.services.CadastroCidadeService;

@RequestMapping("/cidades")
@RestController
public class CidadeResource {
    
    @Autowired
    private CadastroCidadeService cadastroCidadeService;

    @GetMapping
    public List<Cidade> retrieveAllCidade(){

        return cadastroCidadeService.listaTodos();
    }

    @PostMapping
    public ResponseEntity<Cidade> save(@RequestBody Cidade cidade){

        Cidade cidadeSave = cadastroCidadeService.salvar(cidade);
        return new ResponseEntity<>(cidadeSave, HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping
    public void delete(@PathVariable Long id){
        
        cadastroCidadeService.deletar(id);
    }

    @GetMapping("/id")
    public Cidade retrieveCidade(@PathVariable Long id){

        return cadastroCidadeService.buscarOrFalhar(id);
    }

    @PutMapping("/id")
    public Cidade update(@PathVariable Long id, @RequestBody Cidade newCidade){

        newCidade.setId(id);
        return cadastroCidadeService.atualizar(newCidade);
    }


}
