package ime.flixing.entity;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table( name = "FLIX_PERSON_POSITION")
@Generated
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FlixPersonPosition {

	@EmbeddedId
	private FlixPersonPositionId id;
	
	@ManyToOne
	@MapsId("flixId")
	@JoinColumn(name = "fx_id")
	private Flix flix;
	
	@ManyToOne
	@MapsId("personId")
	@JoinColumn(name = "per_id")
	private Person person;
	
	@ManyToOne
	@MapsId("positionId")
	@JoinColumn(name = "pos_id")
	private Position position;

	
}
