package univ.mql.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import univ.mql.repositories.MatchRepository;
import univ.mql.repositories.StadeRepository;
import univ.mql.entities.Arbitre;
import univ.mql.entities.Match_foot;
import univ.mql.entities.Stade;

@Service
public class StadeService {

  @Autowired
  private StadeRepository stadeRepository;
  @Autowired
  private MatchRepository matchRepository;

  public List<Stade> findAll() {
    return stadeRepository.findAll();
  }

  public Stade findById(Long id) {
    return stadeRepository.findById(id).orElse(null);
  }

  public Stade save(Stade stade) {
    return stadeRepository.save(stade);
  }

  public Stade update(Long id, Stade stade) {
    Stade tmp = stadeRepository.findById(id).orElse(null);
    if (tmp != null) {
      stade.setIdStade(id);
      return stadeRepository.save(stade);
    }
    return null;
  }

  public Boolean deleteById(Long id) {
    Stade tmp = stadeRepository.findById(id).orElse(null);
    if (tmp != null) {
      stadeRepository.deleteById(id);
      return true;
    }
    return false;
  }

  /***************************/

  public Stade findByMatchId(Long id) {
    Match_foot tmp = matchRepository.findById(id).orElse(null);
    if (tmp != null) {
      return tmp.getStade();
    }
    return null;
  }
}