package br.com.aiquefome.aiquefome.domain.repositoreis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aiquefome.aiquefome.domain.models.Cozinha;

@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {
    
}
