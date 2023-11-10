package univ.mql.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import univ.mql.entities.Arbitre;
import univ.mql.entities.Equipe;
import univ.mql.entities.Match_foot;
import univ.mql.repositories.MatchRepository;
import univ.mql.repositories.EquipeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class EquipeService {

  @Autowired
  private EquipeRepository equipeRepository;
  @Autowired
  private MatchRepository matchRepository;

  public List<Equipe> findAll() {
    return equipeRepository.findAll();
  }

  public Equipe findById(Long id) {
    return equipeRepository.findById(id).orElse(null);
  }

  public Equipe save(Equipe equipe) {
    return equipeRepository.save(equipe);
  }

  public Equipe update(Long id, Equipe equipe) {
    Equipe tmp = equipeRepository.findById(id).orElse(null);
    if (tmp != null) {
      equipe.setIdEquipe(id);
      return equipeRepository.save(equipe);
    }
    return null;
  }

  public Boolean deleteById(Long id) {
    Equipe tmp = equipeRepository.findById(id).orElse(null);
    if (tmp != null) {
      equipeRepository.deleteById(id);
      return true;
    }
    return false;
  }

  public List<Equipe> findByPays(String pays) {
    return equipeRepository.findByPays(pays);
  }

  public List<Equipe> findByMatchId(Long id) {
    Match_foot tmp = matchRepository.findById(id).orElse(null);
    List<Equipe> l = null;
    if (tmp != null) {
      l = new ArrayList<Equipe>();
      l.add(tmp.getEquipeHote());
      l.add(tmp.getEquipeVisiteuse());
    }
    return l;
  }
}