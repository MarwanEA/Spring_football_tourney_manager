package univ.mql.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import univ.mql.entities.Match_foot;
import univ.mql.entities.Stade;
import univ.mql.repositories.MatchRepository;
import univ.mql.services.MatchService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/matchs")
public class MatchController {

	@Autowired
	MatchService matchService;
	@Autowired
	MatchRepository matchRepository;

	/**
	 * Récupérer tous les matchs.
	 */
	@GetMapping
	public List<Match_foot> getAllMatches() {
		return matchService.findAll();
	}
	 /**
	  * Récupérer un Match par ID
	  */
	 @GetMapping("/{id}")
	 public Match_foot getMatch(@PathVariable Long id) {
	   return matchService.findById(id);
	 }
	/**
	 * Créer un nouveau match.
	 */
	@PostMapping
	public Match_foot createMatch(@RequestBody Match_foot match) {
		return matchService.save(match);
	}

	/**
     * Mettre à jour un match par ID.
     */
	@PutMapping("/{id}")
	public ResponseEntity<Match_foot> updateMatch(@PathVariable Long id, @RequestBody Match_foot match) {
		Match_foot tmp = matchService.update(id, match);
		HttpStatus httpStatus;

		if (tmp != null) {
			httpStatus = HttpStatus.OK;
		} else {
			httpStatus = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<Match_foot>(tmp, httpStatus);
	}

	/**
	 * Supprimer un match par ID.
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteMatch(@PathVariable Long id) {
		boolean deleted = matchService.deleteById(id);

		HttpStatus httpStatus;
		String msg;

		if (deleted) {
			httpStatus = HttpStatus.OK;
			msg = "Match avec id:" + id + " est bien supprimé";
		} else {
			httpStatus = HttpStatus.NOT_FOUND;
			msg = "Match avec id:" + id + " n'existe pas";
		}

		return new ResponseEntity<String>(msg, httpStatus);
	}
	
	/**
	 * Récupérer les matchs par date.
	 */
	@GetMapping("/Date")
	public List<Match_foot> getMatchesByDate(@RequestParam String date) {
		DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendOptional(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                .appendOptional(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                .appendOptional(DateTimeFormatter.ofPattern("yyyy/MM/dd"))
                .toFormatter();
		
		return matchRepository.findByDateMatch(LocalDate.parse(date,formatter));
	}
	
	/**
	 * Supprimer les matchs avant une certaine date.
	 */
	@DeleteMapping("/Date/Before")
	public ResponseEntity<String> deleteMatchBefore(@RequestParam LocalDate date) {
		int count = matchService.deleteByDateMatchBefore(date);

		HttpStatus httpStatus;
		String msg;

		if (count > 1) {
			httpStatus = HttpStatus.OK;
			msg = count + " matchs avant " + date + " ont été bien supprimé";
		} else if (count == 1) {
			httpStatus = HttpStatus.OK;
			msg = "1 match avant " + date + " a été bien supprimé";
		} else {
			httpStatus = HttpStatus.NOT_FOUND;
			msg = "Aucun match trouvé avant " + date;
		}

		return new ResponseEntity<String>(msg, httpStatus);
	}
	/**
	 * Supprimer tous les matchs avant aujourd'hui.
	 */
	@DeleteMapping("/Date/Before/Now")
	public ResponseEntity<String> deleteMatchBeforeNow() {
		LocalDate date = LocalDate.now();
		int count = matchService.deleteByDateMatchBefore(date);

		HttpStatus httpStatus;
		String msg;

		if (count > 1) {
			httpStatus = HttpStatus.OK;
			msg = count + " matchs avant " + date + " ont été bien supprimé";
		} else if (count == 1) {
			httpStatus = HttpStatus.OK;
			msg = "1 match avant " + date + " a été bien supprimé";
		} else {
			httpStatus = HttpStatus.NOT_FOUND;
			msg = "Aucun match trouvé avant " + date;
		}

		return new ResponseEntity<String>(msg, httpStatus);
	}
}
