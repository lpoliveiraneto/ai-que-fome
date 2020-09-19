package br.com.aiquefome.aiquefome.domain.services;

import br.com.aiquefome.aiquefome.domain.exceptions.CozinhaNotFoundException;
import br.com.aiquefome.aiquefome.domain.models.Cozinha;
import br.com.aiquefome.aiquefome.domain.repositoreis.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CadastroCozinhaService {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    public Cozinha salvar(Cozinha cozinha) {
        return cozinhaRepository.save(cozinha);
    }

    public List<Cozinha> listaTodas() {
        return cozinhaRepository.findAll();
    }

    public void deletar(Long cozinhaId) {
        try {
            cozinhaRepository.deleteById(cozinhaId);
        } catch (EmptyResultDataAccessException exception) {
            throw new CozinhaNotFoundException(String.format("Não foi entrada uma cozinha com o ID: %d", cozinhaId));
        }
    }

    public Cozinha atualizar(Cozinha cozinha) {
        Cozinha cozinhaAtual = buscarOrFalhar(cozinha.getId());
        cozinhaAtual.setNome(cozinha.getNome());
        return salvar(cozinhaAtual);
    }

    public Cozinha buscarOrFalhar(Long cozinhaId) {
        Optional<Cozinha> cozinhaOptional = cozinhaRepository.findById(cozinhaId);
        return cozinhaOptional.orElseThrow(() ->
                new CozinhaNotFoundException(String.format("Não foi entrada uma cozinha com o ID: %d", cozinhaId)));
    }
}
