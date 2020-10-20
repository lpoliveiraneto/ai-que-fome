package br.com.aiquefome.aiquefome.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.aiquefome.aiquefome.domain.models.Estado;
import br.com.aiquefome.aiquefome.domain.services.CadastroEstadoService;

@RequestMapping("/estados")
@RestController
public class EstadoResource {
    
    @Autowired
    private CadastroEstadoService cadastroEstadoService;

    @GetMapping
    public List<Estado> retrieveAllEstado(){
        return cadastroEstadoService.listaTodas();
    }

    @PostMapping
    public ResponseEntity<Estado> save(@RequestBody Estado estado){

        Estado estadoSave = cadastroEstadoService.salvar(estado);
        return new ResponseEntity<>(estadoSave, HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/id")
    public void delete(@PathVariable Long id){
        cadastroEstadoService.deletar(id);
    }

    @GetMapping("/id")
    public Estado retrieveEstado(@PathVariable Long id){
        return cadastroEstadoService.buscarOrFalhar(id);
    }

    public Estado update(@PathVariable Long id, @RequestBody Estado newEstado){
        newEstado.setId(id);
        return cadastroEstadoService.atualizar(newEstado);

    }
    
}
