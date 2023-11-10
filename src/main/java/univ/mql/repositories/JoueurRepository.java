package univ.mql.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import univ.mql.entities.Joueur;
import univ.mql.entities.Equipe;

public interface JoueurRepository extends JpaRepository<Joueur, Long> {
    List<Joueur> findByEquipe(Equipe equipe);

    List<Joueur> findByPoste(String poste);
    
    List<Joueur> findByPosteAndEquipe(String poste, Equipe equipe);
}