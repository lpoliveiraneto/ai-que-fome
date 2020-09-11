package br.com.aiquefome.aiquefome.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import br.com.aiquefome.aiquefome.models.Cozinha;
import br.com.aiquefome.aiquefome.models.CozinhaNotFoundException;
import br.com.aiquefome.aiquefome.repositoreis.CozinhaRepository;

@RestController
public class CozinhaResource {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @GetMapping("/cozinhas")
    public List<Cozinha> retrieveAllCozinha(){
        return cozinhaRepository.findAll();
    }

    @PostMapping("/cozinhas")
    public ResponseEntity<Cozinha> save(@RequestBody Cozinha cozinha){
        Cozinha cozinhaSave = cozinhaRepository.save(cozinha);
        return new ResponseEntity<>(cozinhaSave, HttpStatus.CREATED);
    }

    @DeleteMapping("/cozinhas/{id}")
    public ResponseEntity<Cozinha> delete(@PathVariable Long id){
        Optional<Cozinha> cozinhaOptional = cozinhaRepository.findById(id);
        if(cozinhaOptional.isPresent()){
            cozinhaRepository.delete(cozinhaOptional.get());
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/cozinhas/{id}")
    public Cozinha retrieveCozinha(@PathVariable Long id){
        Optional<Cozinha> cozinhaOptional = cozinhaRepository.findById(id);
        if(!cozinhaOptional.isPresent()){
            throw new CozinhaNotFoundException("id - " +id+" Cozinha não existe");
        }else{
            return cozinhaOptional.get();
        }
    }

    @PutMapping("/cozinhas/{id}")
    public ResponseEntity<Cozinha> update(@PathVariable Long id, @RequestBody Cozinha newCozinha){
        Optional<Cozinha> cozinhaOptional = cozinhaRepository.findById(id);

        if(!cozinhaOptional.isPresent())
            return ResponseEntity.notFound().build();

        newCozinha.setId(id);
        cozinhaRepository.save(newCozinha);
        return ResponseEntity.noContent().build();
    }
}
