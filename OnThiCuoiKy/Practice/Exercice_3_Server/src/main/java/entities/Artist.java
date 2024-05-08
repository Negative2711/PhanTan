package entities;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Artist implements Serializable{

	private static final long serialVersionUID = -152269388788828458L;
	@Id
	private String id;
	private String name;
	private LocalDate birthDate;
	private String url;
	
}
