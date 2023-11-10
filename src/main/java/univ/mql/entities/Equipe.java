package univ.mql.entities;

import java.util.List;

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
public class Equipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idEquipe;
	String nomEquipe;
	String pays;

	public Equipe(Long id) {
		this.idEquipe = id;
	}

	// @OneToMany(mappedBy = "equipeHote")
	// private List<Match> matchesAsHote;
	//
	// @OneToMany(mappedBy = "equipeVisiteuse")
	// private List<Match> matchesAsVisiteuse;
}
