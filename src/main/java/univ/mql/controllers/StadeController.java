package univ.mql.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import univ.mql.entities.Arbitre;
import univ.mql.entities.Stade;
import univ.mql.services.StadeService;

@RestController
@RequestMapping("/stades")
public class StadeController {

  @Autowired
  private StadeService stadeService;
  /**
   * Récupérer tous les stades
   */
  @GetMapping
  public List<Stade> getAllStades() {
    return stadeService.findAll();
  }
  /**
   * Récupérer un stade par ID
   */
  @GetMapping("/{id}")
  public Stade getStade(@PathVariable Long id) {
    return stadeService.findById(id);
  }
  /**
   * Créer un nouveau stade
   */
  @PostMapping
  public Stade createStade(@RequestBody Stade stade) {
    return stadeService.save(stade);
  }
  /**
   * Mettre à jour un stade
   */
  @PutMapping("/{id}")
  public ResponseEntity<Stade> updateStade(@PathVariable Long id, @RequestBody Stade stade) {
    Stade tmp = stadeService.update(id, stade);
    HttpStatus httpStatus;

    if (tmp != null) {
      httpStatus = HttpStatus.OK;
    } else {
      httpStatus = HttpStatus.NOT_FOUND;
    }
    return new ResponseEntity<Stade>(tmp, httpStatus);
  }
  /**
   * Supprimer un stade
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteStade(@PathVariable Long id) {
    boolean deleted = stadeService.deleteById(id);

    HttpStatus httpStatus;
    String msg;

    if (deleted) {
      httpStatus = HttpStatus.OK;
      msg = "Stade avec id:" + id + " est bien supprimé";
    } else {
      httpStatus = HttpStatus.NOT_FOUND;
      msg = "Stade avec id:" + id + " n'existe pas";
    }

    return new ResponseEntity<String>(msg, httpStatus);
  }
  /**
   * Récupérer le stade par ID de match
   */
  @GetMapping("/match/{id}")
  public ResponseEntity<Stade> getStadeByMatchId(@PathVariable Long id) {
    Stade tmp = stadeService.findByMatchId(id);
    HttpStatus httpStatus;

    if (tmp != null) {
      httpStatus = HttpStatus.OK;
    } else {
      httpStatus = HttpStatus.NOT_FOUND;
    }
    return new ResponseEntity<Stade>(tmp, httpStatus);
  }
}