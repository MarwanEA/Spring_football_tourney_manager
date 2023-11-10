package univ.mql.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import univ.mql.services.JoueurService;
import univ.mql.entities.Joueur;

@RestController
@RequestMapping("/joueurs")
public class JoueurController {

  @Autowired
  private JoueurService joueurService;
  /**
   * Récupérer tous les joueurs.
   * @param @RequestParam poste : optionel
   * @param @RequestParam nomEquipe : optionel
   */
  @GetMapping
  public ResponseEntity<List<Joueur>> getAllJoueurs(@RequestParam(required = false) String poste,
      @RequestParam(required = false) String nomEquipe) {
    if (poste != null || nomEquipe != null) {
      return getJoueurByPosteAndEquipeName(poste, nomEquipe);
    }
    return new ResponseEntity<List<Joueur>>(joueurService.findAll(), HttpStatus.OK);
  }
  /**
   * Récupérer un joueur par ID.
   */
  @GetMapping("/{id}")
  public Joueur getJoueurById(@PathVariable Long id) {
    return joueurService.findById(id);
  }
  /**
   * Créer un nouveau joueur.
   */
  @PostMapping
  public Joueur createJoueur(@RequestBody Joueur joueur) {
    return joueurService.save(joueur);
  }
  /**
   * Mettre à jour un joueur par ID.
   */
  @PutMapping("/{id}")
  public ResponseEntity<Joueur> updateJoueur(@PathVariable Long id, @RequestBody Joueur joueur) {
    Joueur tmp = joueurService.update(id, joueur);
    HttpStatus httpStatus;

    if (tmp != null) {
      httpStatus = HttpStatus.OK;
    } else {
      httpStatus = HttpStatus.NOT_FOUND;
    }
    return new ResponseEntity<Joueur>(tmp, httpStatus);
  }
  /**
   * Supprimer un joueur par ID.
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteJoueur(@PathVariable Long id) {
    boolean deleted = joueurService.deleteById(id);

    HttpStatus httpStatus;
    String msg;

    if (deleted) {
      httpStatus = HttpStatus.OK;
      msg = "Joueur avec id:" + id + " est bien supprimé";
    } else {
      httpStatus = HttpStatus.NOT_FOUND;
      msg = "Joueur avec id:" + id + " n'existe pas";
    }

    return new ResponseEntity<String>(msg, httpStatus);
  }

  /***************/
  /**
   * Récupérer les joueurs par nom d'équipe.
   */
  @GetMapping("/equipe/{equipeName}")
  public ResponseEntity<List<Joueur>> getJoueurByEquipeName(@PathVariable String equipeName) {
    List<Joueur> tmp = joueurService.findByEquipeName(equipeName);
    HttpStatus httpStatus;

    if (tmp != null) {
      httpStatus = HttpStatus.OK;
    } else {
      httpStatus = HttpStatus.NOT_FOUND;
    }
    return new ResponseEntity<List<Joueur>>(tmp, httpStatus);
  }

  /**
   * Récupérer les joueurs par poste et nom d'équipe.
   */
  public ResponseEntity<List<Joueur>> getJoueurByPosteAndEquipeName(String poste, String nomEquipe) {
    List<Joueur> tmp = joueurService.findByPosteAndEquipeName(poste, nomEquipe);
    HttpStatus httpStatus;

    if (tmp != null) {
      httpStatus = HttpStatus.OK;
    } else {
      httpStatus = HttpStatus.NOT_FOUND;
    }
    return new ResponseEntity<List<Joueur>>(tmp, httpStatus);
  }

}