package br.com.aiquefome.aiquefome.domain.services;

import java.util.List;
import java.util.Optional;

import com.fasterxml.classmate.AnnotationOverrides.StdImpl;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.aiquefome.aiquefome.domain.exceptions.CidadeNotFoundException;
import br.com.aiquefome.aiquefome.domain.models.Cidade;
import br.com.aiquefome.aiquefome.domain.models.Estado;
import br.com.aiquefome.aiquefome.domain.repositoreis.CidadeRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CadastroCidadeService {
    
    /* A injenção de dependêcia está sendo feita pelo 
    @ do lombok @RequiredArguments*/
    private final CidadeRepository cidadeRepository;
    private final CadastroEstadoService cadastroEstadoService;
    

    public Cidade salvar(Cidade cidade){

        Estado estado = cadastroEstadoService.buscarOrFalhar(cidade.getEstado().getId());
        cidade.setEstado(estado);

        return cidadeRepository.save(cidade);
    }

    public List<Cidade> listaTodos(){
        
        return cidadeRepository.findAll();
    }

    public void deletar(Long cidadeID){
        
        try {
            cidadeRepository.deleteById(cidadeID);
        } catch (EmptyResultDataAccessException exception) {
            throw new CidadeNotFoundException(String.format("Não foi encontrado cidade com o ID: %d", cidadeID));
        }
    }

    public Cidade atualizar(Cidade cidade){

        Estado estado = cadastroEstadoService.buscarOrFalhar(cidade.getEstado().getId());

        Cidade cidadeAtual = buscarOrFalhar(cidade.getId());
        cidadeAtual.setNome(cidade.getNome());
        cidadeAtual.setEstado(estado);

        return salvar(cidade);
    }

    public Cidade buscarOrFalhar(Long cidadeID){
        
        Optional<Cidade> cidadeOptional = cidadeRepository.findById(cidadeID);
        return cidadeOptional.orElseThrow(() -> 
                new CidadeNotFoundException(String.format("Não foi encontrado cidade com o ID: %d", cidadeID)));
    }


}
