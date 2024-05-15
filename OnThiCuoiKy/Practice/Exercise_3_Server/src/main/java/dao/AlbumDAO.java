package dao;

import java.util.List;
import java.util.Map;

import entities.Albums;

public interface AlbumDAO {
	public boolean updatePriceOfAlbum(String id, Double newPrice);
	public boolean addPriceOfAlbum(Albums album);
	public List<Albums> listAlbumByGenre(String genreName);
	public Map<String, Long> getNumberOfAlbumByGenre(); //	Key la ten the loai, Value la so album
}
