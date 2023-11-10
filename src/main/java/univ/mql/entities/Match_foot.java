package univ.mql.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Match_foot {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idMatch;
	LocalDate dateMatch;
	LocalTime heureMatch;

	@ManyToOne
	private Arbitre arbitre;

	@ManyToOne
	private Equipe equipeVisiteuse;

	@ManyToOne
	private Equipe equipeHote;

	@ManyToOne
	private Stade stade;
}
