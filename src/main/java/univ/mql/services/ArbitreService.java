package univ.mql.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import univ.mql.entities.Arbitre;
import univ.mql.repositories.ArbitreRepository;

import java.util.List;

@Service
public class ArbitreService {

    @Autowired
    private ArbitreRepository arbitreRepository;

    public List<Arbitre> findAll() {
        return arbitreRepository.findAll();
    }

    public Arbitre findById(Long id) {
        return arbitreRepository.findById(id).orElse(null);
    }

    public Arbitre save(Arbitre arbitre) {
        return arbitreRepository.save(arbitre);
    }

    public Arbitre update(Long id, Arbitre arbitre) {
        Arbitre tmp = arbitreRepository.findById(id).orElse(null);
        if (tmp != null) {
            arbitre.setIdArbitre(id);
            return arbitreRepository.save(arbitre);
        }
        return null;
    }

    public Boolean deleteById(Long id) {
        Arbitre tmp = arbitreRepository.findById(id).orElse(null);
        if (tmp != null) {
            arbitreRepository.deleteById(id);
            return true;
        }
        return false;
    }

}