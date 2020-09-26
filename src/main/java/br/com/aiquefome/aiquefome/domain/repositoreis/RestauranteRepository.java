package br.com.aiquefome.aiquefome.domain.repositoreis;

import br.com.aiquefome.aiquefome.domain.models.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
}
