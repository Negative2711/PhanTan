package entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Song implements Serializable{

	private static final long serialVersionUID = -8793015881984002212L;
	@Id
	private String id;
	private String name;
	private String runtime;
	private String lyric;
}
