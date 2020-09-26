package br.com.aiquefome.aiquefome.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.aiquefome.aiquefome.domain.exceptions.CozinhaNotFoundException;
import br.com.aiquefome.aiquefome.domain.models.Cozinha;
import br.com.aiquefome.aiquefome.domain.repositoreis.CozinhaRepository;

@Service
public class CadastroCozinhaService {
    
    @Autowired
    private CozinhaRepository cozinhaRepository;

    public Cozinha salvar(Cozinha cozinha){
        return cozinhaRepository.save(cozinha);
    }

    public List<Cozinha> listaTodas(){
        return cozinhaRepository.findAll();
    }

    public void deletar(Long cozinhaID){
        try{
            cozinhaRepository.deleteById(cozinhaID);
        }catch(EmptyResultDataAccessException exception){
            throw new CozinhaNotFoundException(String.format("Não foi encontrado uma cozinha com o ID: %d", cozinhaID));
        }
    }

    public Cozinha atualizar(Cozinha cozinha){
        Cozinha cozinhaAtual = buscarOrFalhar(cozinha.getId());
        cozinhaAtual.setNome(cozinha.getNome());
        return salvar(cozinha);
    }

    public Cozinha buscarOrFalhar(Long cozinhaID){
        Optional<Cozinha> cozinhaOptional = cozinhaRepository.findById(cozinhaID);
        return cozinhaOptional.orElseThrow(()->
                new CozinhaNotFoundException(String.format("Não foi entrada uma cozinha com o ID: %d", cozinhaID)));
    }
}
