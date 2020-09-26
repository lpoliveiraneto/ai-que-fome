package br.com.aiquefome.aiquefome.api.resource;

//import java.util.ArrayList;
import java.util.Optional;

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
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import br.com.aiquefome.aiquefome.domain.services.CadastroUsuarioService;
import br.com.aiquefome.aiquefome.domain.models.Usuario;

@RequestMapping("/usuarios")
@RestController
public class UsuarioResource {

    @Autowired
    private CadastroUsuarioService cadastroUsuarioService;

    @GetMapping
    public List<Usuario> retrieveAllUsuarios(){
        return cadastroUsuarioService.listaTodos();
    }

    /*
    public UsuarioResource (final UsuarioRepository usuarioRepository){
        super();
        this.usuarioRepository = usuarioRepository;
    }
    */
    @PostMapping
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario){
        Usuario usuarioSave = cadastroUsuarioService.salvar(usuario);
        return new ResponseEntity<>(usuarioSave, HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        cadastroUsuarioService.deletar(id);
    }

    @GetMapping("/{id}")
    public Usuario retrieveUsuario(@PathVariable Long id){
       return cadastroUsuarioService.buscarOrFalhar(id);
    }

    @PutMapping("/{id}")
    public Usuario update(@PathVariable Long id, @RequestBody Usuario newUsuario){
       newUsuario.setId(id);
       return cadastroUsuarioService.atualizar(newUsuario);
    }

}
