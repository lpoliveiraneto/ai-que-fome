package br.com.aiquefome.aiquefome.repositoreis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aiquefome.aiquefome.models.Cozinha;

@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {
    
}
