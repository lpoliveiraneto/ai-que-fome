package br.com.aiquefome.aiquefome.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import br.com.aiquefome.aiquefome.domain.exceptions.EstadoNotFoundException;
import br.com.aiquefome.aiquefome.domain.models.Estado;
import br.com.aiquefome.aiquefome.domain.repositoreis.EstadoRepository;

@Service
public class CadastroEstadoService {
    
    @Autowired
    private EstadoRepository estadoRepository;

    public Estado salvar(Estado estado){
        return estadoRepository.save(estado);
    }

    public List<Estado> listaTodas(){
        return estadoRepository.findAll();
    }

    public void deletar(Long estadoID){
        try{
            estadoRepository.deleteById(estadoID);
        }catch(EmptyResultDataAccessException exception){
            throw new EstadoNotFoundException(String.format("Não foi encontrado o Estado com o ID: %d", estadoID));
        }
    }

    public Estado atualizar(Estado estado){
        Estado estadoAtual = buscarOrFalhar(estado.getId());
        estadoAtual.setNome(estado.getNome());
        return salvar(estadoAtual);
    }

    public Estado buscarOrFalhar(Long estadoID){
        Optional<Estado> estadoOptional = estadoRepository.findById(estadoID);
        return estadoOptional.orElseThrow(() -> 
                new EstadoNotFoundException(String.format("Não foi encontrado o Estado com o ID: %d", estadoID)));
    }

}
