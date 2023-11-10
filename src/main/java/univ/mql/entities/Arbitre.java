package univ.mql.entities;

import java.util.List;

import com.fasterxml.jackson.databind.deser.DataFormatReaders.Match;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Arbitre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idArbitre;
	String nom;
	String nationalite;

	public Arbitre(Long id) {
		this.idArbitre = id;
	}

	// @OneToMany(mappedBy="arbitre")
	// private List<Match> matches;

}
