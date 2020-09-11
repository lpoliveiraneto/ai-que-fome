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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import br.com.aiquefome.aiquefome.repositoreis.UsuarioRepository;
import br.com.aiquefome.aiquefome.models.Usuario;
import br.com.aiquefome.aiquefome.models.UsuarioNotFoundException;

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
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario){
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

    @GetMapping("usuarios/{id}")
    public Usuario retrieveUsuario(@PathVariable Long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
            if(!usuario.isPresent()){
                throw new UsuarioNotFoundException("id - "+id+" Usuário não existe");
            }
            return usuario.get();
    }

    @PutMapping("usuarios/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario newUsuario){
       /* 
        Esse trecho de código funciona mas optei pelo que está fora por ser um código mais limpo
       return usuarioRepository.findById(id)
                .map(usuario -> {
                    usuario.setNome(newUsuario.getNome());
                    usuario.setEmail(newUsuario.getEmail());
                    usuario.setSenha(newUsuario.getSenha());
                    Usuario usuarioUpdate = usuarioRepository.save(usuario);
                    return ResponseEntity.ok().body(usuarioUpdate);
                }).orElse(ResponseEntity.notFound().build());
        */
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        if(!usuarioOptional.isPresent())
            return ResponseEntity.notFound().build();
        
        newUsuario.setId(id);
        usuarioRepository.save(newUsuario);
        return ResponseEntity.noContent().build();
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
