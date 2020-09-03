package br.com.aiquefome.aiquefome.resource;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import br.com.aiquefome.aiquefome.repositoreis.UsuarioRepository;
import br.com.aiquefome.aiquefome.usuario.Usuario;

@RestController
public class UsuarioResource {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/usuarios")
    public List<Usuario> retrieveAllUsuarios(){
        return usuarioRepository.findAll();
    }

    /*
    public UsuarioResource (final UsuarioRepository usuarioRepository){
        super();
        this.usuarioRepository = usuarioRepository;
    }
    */
    @PostMapping("/usuarios")
    public ResponseEntity<Usuario> save(@RequestBody final Usuario usuario){
        Usuario usuarioSave = usuarioRepository.save(usuario);
        return new ResponseEntity<>(usuarioSave, HttpStatus.CREATED);
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> delete(@PathVariable Long id){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if(usuarioOptional.isPresent()){
            usuarioRepository.delete(usuarioOptional.get());
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    /*
    @GetMapping
    public ResponseEntity<List<Usuario>> getAll(){
        List<Usuario> usuarios = new ArrayList<>();
        usuarios = usuarioRepository.findAll();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }
    */
    
    
}
