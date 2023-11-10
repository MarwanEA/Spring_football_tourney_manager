package univ.mql.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import univ.mql.entities.Arbitre;
import univ.mql.services.ArbitreService;

import java.util.List;

@RestController
@RequestMapping("/arbitres")
public class ArbitreController {

    @Autowired
    private ArbitreService arbitreService;

    /**
     * Récupérer tous les arbitres.
     */
    @GetMapping
    public List<Arbitre> getAllArbitres() {
        return arbitreService.findAll();
    }
    /**
     * Récupérer un arbitre par ID.
     */
    @GetMapping("/{id}")
    public Arbitre getArbitreById(@PathVariable Long id) {
        return arbitreService.findById(id);
    }
    /**
     * Créer un nouvel arbitre.
     */
    @PostMapping
    public Arbitre createArbitre(@RequestBody Arbitre arbitre) {
        return arbitreService.save(arbitre);
    }
    /**
     * Mettre à jour un arbitre par ID.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Arbitre> updateArbitre(@PathVariable Long id, @RequestBody Arbitre arbitre) {
    	Arbitre tmp = arbitreService.update(id,arbitre);
    	HttpStatus httpStatus;


        if (tmp!=null) {
        	httpStatus = HttpStatus.OK;
        } else {
        	httpStatus = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<Arbitre>(tmp,httpStatus);
    }
    /**
     * Supprimer un arbitre par ID.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteArbitre(@PathVariable Long id) {
    	boolean deleted = arbitreService.deleteById(id);

    	HttpStatus httpStatus;
    	String msg;


        if (deleted) {
        	httpStatus = HttpStatus.OK;
        	msg="Arbitre avec id:"+id+" est bien supprimé";
        } else {
        	httpStatus = HttpStatus.NOT_FOUND;
        	msg="Arbitre avec id:"+id+" n'existe pas";
        }
        
        return new ResponseEntity<String>(msg,httpStatus);
    }
}