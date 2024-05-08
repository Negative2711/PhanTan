package service;

import java.util.List;
import java.util.Map;

import dao.AlbumDAO;
import entities.Album;
import jakarta.persistence.EntityManager;

public class AlbumService implements AlbumDAO {

	private EntityManager entityManager;

	public public AlbumService(EntityManager entityManager) {
		// TODO Auto-generated constructor stub
		this.entityManager = entityManager;
	}

	@Override
	public boolean updatePriceOfAlbum(String id, Double newPrice) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Album> listAlbumByGenre(String genreName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Long> getNumberOfAlbumByGenre() {
		// TODO Auto-generated method stub
		return null;
	}

}
