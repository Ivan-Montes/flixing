package ime.flixing.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.HashSet;
import jakarta.persistence.OneToMany;

@Entity
@Table( name = "FLIXES" )
@Generated
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Flix {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column( name = "flix_id" )
	@Max(33)
	private Long flixId;
	
	@Column( nullable = false, length = 100 )
	@Size(min=1, max=50)
	@Pattern( regexp = "[a-zA-Z0-9\\s\\-&\\?\\¿\\!\\¡]+")
	private String title;
		
	@ManyToOne
	@JoinColumn( name = "genre_id")
	private Genre genre;
	
	@OneToMany( mappedBy = "flix")
	private Set<FlixPersonPosition> flixPersonPosition = new HashSet<>();

	@Override
	public String toString() {
		return "Flix [flixId=" + flixId + ", title=" + title + ", genre=" + genre + "]";
	}
		
	
}
