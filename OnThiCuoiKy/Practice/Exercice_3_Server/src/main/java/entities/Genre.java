package entities;


import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Genre implements Serializable{

	private static final long serialVersionUID = -6563674801930025594L;
	@Id
	private String id;
	private String name;
	private String description;
	
	@OneToMany(mappedBy = "genre")
	Set<Album>albums;
}
