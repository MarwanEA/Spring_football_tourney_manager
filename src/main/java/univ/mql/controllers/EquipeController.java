package univ.mql.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import univ.mql.entities.Arbitre;
import univ.mql.entities.Equipe;
import univ.mql.services.EquipeService;

@RestController
@RequestMapping("/equipes")
public class EquipeController {

  @Autowired
  private EquipeService equipeService;
  /**
   * Récupérer toutes les équipes.
   */
  @GetMapping
  public List<Equipe> getAllEquipes() {
    return equipeService.findAll();
  }
  /**
   * Récupérer une équipe par ID.
   */
  @GetMapping("/{id}")
  public Equipe getEquipe(@PathVariable Long id) {
    return equipeService.findById(id);
  }
  /**
   * Créer une nouvelle équipe.
   */
  @PostMapping
  public Equipe createEquipe(@RequestBody Equipe equipe) {
    return equipeService.save(equipe);
  }
  /**
   * Mettre à jour une équipe par ID.
   */
  @PutMapping("/{id}")
  public ResponseEntity<Equipe> updateEquipe(@PathVariable Long id, @RequestBody Equipe equipe) {
    Equipe tmp = equipeService.update(id, equipe);
    HttpStatus httpStatus;

    if (tmp != null) {
      httpStatus = HttpStatus.OK;
    } else {
      httpStatus = HttpStatus.NOT_FOUND;
    }
    return new ResponseEntity<Equipe>(tmp, httpStatus);
  }
  /**
   * Supprimer une équipe par ID.
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteEquipe(@PathVariable Long id) {
    boolean deleted = equipeService.deleteById(id);

    HttpStatus httpStatus;
    String msg;

    if (deleted) {
      httpStatus = HttpStatus.OK;
      msg = "Equipe avec id:" + id + " est bien supprimé";
    } else {
      httpStatus = HttpStatus.NOT_FOUND;
      msg = "Equipe avec id:" + id + " n'existe pas";
    }

    return new ResponseEntity<String>(msg, httpStatus);
  }

  /************************/
  /**
   * Récupérer les équipes par pays.
   */
  @GetMapping("/pays/{pays}")
  public ResponseEntity<List<Equipe>> updateEquipe(@PathVariable String pays) {
    List<Equipe> tmp = equipeService.findByPays(pays);
    HttpStatus httpStatus;

    if (tmp != null) {
      httpStatus = HttpStatus.OK;
    } else {
      httpStatus = HttpStatus.NOT_FOUND;
    }
    return new ResponseEntity<List<Equipe>>(tmp, httpStatus);
  }
  /**
   * Récupérer les équipes par ID de match.
   */
  @GetMapping("/match/{id}")
  public ResponseEntity<List<Equipe>> getEquipesByMatchId(@PathVariable Long id) {
    List<Equipe> tmp = equipeService.findByMatchId(id);
    HttpStatus httpStatus;

    if (tmp != null) {
      httpStatus = HttpStatus.OK;
    } else {
      httpStatus = HttpStatus.NOT_FOUND;
    }
    return new ResponseEntity<List<Equipe>>(tmp, httpStatus);
  }

}