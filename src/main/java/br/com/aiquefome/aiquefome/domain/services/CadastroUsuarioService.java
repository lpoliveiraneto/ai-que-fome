package br.com.aiquefome.aiquefome.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.aiquefome.aiquefome.domain.exceptions.UsuarioNotFoundException;
import br.com.aiquefome.aiquefome.domain.models.Usuario;
import br.com.aiquefome.aiquefome.domain.repositoreis.UsuarioRepository;

@Service
public class CadastroUsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listaTodos(){
        return usuarioRepository.findAll();
    }

    public void deletar(Long usuarioID){
        try{
            usuarioRepository.deleteById(usuarioID);
        }catch(EmptyResultDataAccessException exception){
            throw new UsuarioNotFoundException(String.format("Não foi encontrado um usuário com o ID: d%", usuarioID));
        }
    }

    public Usuario atualizar(Usuario usuario){
        Usuario usuarioAtual = buscarOrFalhar(usuario.getId());
        usuarioAtual.setNome(usuario.getNome());
        usuarioAtual.setEmail(usuario.getEmail());
        usuarioAtual.setSenha(usuario.getSenha());
        return salvar(usuarioAtual);
    }

    public Usuario buscarOrFalhar(Long usuarioID){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuarioID);
        return usuarioOptional.orElseThrow(()-> 
                new UsuarioNotFoundException(String.format("Não foi encontrado usuário com o ID: %d", usuarioID)));
    }
}
