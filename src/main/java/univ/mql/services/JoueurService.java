package univ.mql.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import univ.mql.entities.Arbitre;
import univ.mql.entities.Equipe;
import univ.mql.entities.Joueur;
import univ.mql.repositories.EquipeRepository;
import univ.mql.repositories.JoueurRepository;

import java.util.List;

@Service
public class JoueurService {

  @Autowired
  private JoueurRepository joueurRepository;
  @Autowired
  private EquipeRepository equipeRepository;

  public List<Joueur> findAll() {
    return joueurRepository.findAll();
  }

  public Joueur findById(Long id) {
    return joueurRepository.findById(id).orElse(null);
  }

  public Joueur save(Joueur joueur) {
    return joueurRepository.save(joueur);
  }

  public Joueur update(Long id, Joueur joueur) {
    Joueur tmp = joueurRepository.findById(id).orElse(null);
    if (tmp != null) {
      joueur.setIdJoueur(id);
      return joueurRepository.save(joueur);
    }
    return null;
  }

  public Boolean deleteById(Long id) {
    Joueur tmp = joueurRepository.findById(id).orElse(null);
    if (tmp != null) {
      joueurRepository.deleteById(id);
      return true;
    }
    return false;
  }

  /************/

  public List<Joueur> findByEquipeName(String nomEquipe) {
    Equipe tmp = equipeRepository.findByNomEquipe(nomEquipe);
    if (tmp != null) {
      return joueurRepository.findByEquipe(tmp);
    }
    return null;
  }

  public List<Joueur> findByPosteAndEquipeName(String poste, String nomEquipe) {
//    Equipe tmp = equipeRepository.findByNomEquipe(nomEquipe);
//    if (tmp != null) {
//      return joueurRepository.findByPosteAndEquipe(poste, tmp);
//    }
	  
	  
	  if (poste != null && !poste.isEmpty() && nomEquipe != null && !nomEquipe.isEmpty()) {
	        Equipe equipe = equipeRepository.findByNomEquipe(nomEquipe);
	        return (equipe != null) ? joueurRepository.findByPosteAndEquipe(poste, equipe) : null;
	    }

	    if (poste != null && !poste.isEmpty()) {
	        return joueurRepository.findByPoste(poste);
	    }

	    if (nomEquipe != null && !nomEquipe.isEmpty()) {
	        Equipe equipe = equipeRepository.findByNomEquipe(nomEquipe);
	        return (equipe != null) ? joueurRepository.findByEquipe(equipe) : null;
	    }
    return null;
  }
}