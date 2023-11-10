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
public class Stade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idStade;
	String nomStade;
	String ville;

	public Stade(Long id) {
		this.idStade = id;
	}
	// @OneToMany(mappedBy="stade")
	// private List<Match> matches;

}
