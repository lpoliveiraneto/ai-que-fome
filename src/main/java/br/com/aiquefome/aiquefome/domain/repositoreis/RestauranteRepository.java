package br.com.aiquefome.aiquefome.domain.repositoreis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aiquefome.aiquefome.domain.models.Restaurante;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
    
}
