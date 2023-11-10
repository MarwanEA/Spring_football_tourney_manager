package univ.mql.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import univ.mql.entities.Equipe;

public interface EquipeRepository extends JpaRepository<Equipe, Long> {

    List<Equipe> findByPays(String pays);

    Equipe findByNomEquipe(String nomEquipe);
}
