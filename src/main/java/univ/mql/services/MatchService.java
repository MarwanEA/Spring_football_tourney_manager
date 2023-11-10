package univ.mql.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import univ.mql.entities.Arbitre;
import univ.mql.entities.Match_foot;
import univ.mql.repositories.MatchRepository;

@Service
public class MatchService {

  @Autowired
  private MatchRepository matchRepository;

  public List<Match_foot> findAll() {
    return matchRepository.findAll();
  }


  public Match_foot findById(Long id) {
    return matchRepository.findById(id).orElse(null);
  }
  public Match_foot save(Match_foot match) {
    return matchRepository.save(match);
  }

  public Match_foot update(Long id, Match_foot match) {
    Match_foot tmp = matchRepository.findById(id).orElse(null);
    if (tmp != null) {
      match.setIdMatch(id);
      return matchRepository.save(match);
    }
    return null;
  }

  public Boolean deleteById(Long id) {
    Match_foot tmp = matchRepository.findById(id).orElse(null);
    if (tmp != null) {
      matchRepository.deleteById(id);
      return true;
    }
    return false;
  }

  public List<Match_foot> findByDate(LocalDate dateMatch) {
    return matchRepository.findByDateMatch(dateMatch);
  }

  public int deleteByDateMatchBefore(LocalDate dateMatch) {
    List<Match_foot> matchesToDelete = matchRepository.findByDateMatchBefore(dateMatch);

    int deletedCount = matchesToDelete.size();
    matchRepository.deleteAll(matchesToDelete);

    return deletedCount;
    // LocalDate now = LocalDate.now();
    // matchRepository.deleteByDateMatchBefore(now);
  }

}