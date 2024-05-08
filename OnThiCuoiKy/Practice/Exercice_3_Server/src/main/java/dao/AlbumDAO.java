package dao;

import java.util.List;
import java.util.Map;

import entities.Album;

public interface AlbumDAO {
	public boolean updatePriceOfAlbum(String id, Double newPrice);
	public List<Album> listAlbumByGenre(String genreName);
//	Key la ten the loai, Value la so album
	public Map<String, Long> getNumberOfAlbumByGenre();
}
