package entities;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Album implements Serializable {

	private static final long serialVersionUID = 4607818484444629221L;
	@Id
	private String id;
	private String title;
	private double price;
	private int yearOfRelease;
	private String dowloadLink;

	@ManyToOne
	@JoinColumn(name = "genre_id")
	Genre genre;

	@ManyToMany
	@JoinTable(name = "albums_artists", joinColumns = {
			@JoinColumn(name = "album_id") }, inverseJoinColumns = @JoinColumn(name = "artist_id"))
	Set<Artist> artists;

	@ManyToMany
	@JoinTable(name = "albums_songs", joinColumns = { @JoinColumn(name = "album_id") }, inverseJoinColumns = {
			@JoinColumn(name = "song_id") })
	Set<Song> songs;
}
