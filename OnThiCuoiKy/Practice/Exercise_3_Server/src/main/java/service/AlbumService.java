package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.AlbumDAO;
import entities.Albums;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class AlbumService implements AlbumDAO {

	private EntityManager entityManager;

	public AlbumService(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public boolean updatePriceOfAlbum(String id, Double newPrice) {
		EntityTransaction trans = entityManager.getTransaction();
		try {
			trans.begin();
			Albums album = entityManager.find(Albums.class, id);
			album.setPrice(newPrice);
			entityManager.merge(album);
			trans.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if (trans.isActive()) {
				trans.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Albums> listAlbumByGenre(String genreName) {
		System.out.println("genreName=" + genreName);
		EntityTransaction trans = entityManager.getTransaction();
		try {
			trans.begin();
			List<Albums> results = entityManager.createNativeQuery("select a.* from albums a join genres g on g.genre_id = a.genre_id where g.name like :genreName and a.year_of_release = 1967", Albums.class)
					.setParameter("genreName", "%" + genreName + "%")
//					.setParameter("yearOfRelease", 1967)
					.getResultList();
			trans.commit();
			return results;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Map<String, Long> getNumberOfAlbumByGenre() {
		EntityTransaction trans = entityManager.getTransaction();
		Map<String, Long> groupedAlbums = new HashMap<>();
		
		try {
			trans.begin();
			
			List<Object[]> results = entityManager.createNativeQuery("select g.name, count(*) from albums a join genres g on g.genre_id = a.genre_id group by a.genre_id").getResultList();
			
			// Duyệt qua kết quả và xây dựng Map<String, Long>
	        for (Object[] result : results) {
	            String genreName = (String) result[0];
	            Long count = ((Number) result[1]).longValue();
	            groupedAlbums.put(genreName, count);
	        }
			
			System.out.println("groupedAlbums=" + groupedAlbums);
			
			trans.commit();
			
			return groupedAlbums;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean addPriceOfAlbum(Albums album) {
		// TODO Auto-generated method stub
		EntityTransaction trans = entityManager.getTransaction();
		try {
			trans.begin();
			entityManager.persist(album);
			trans.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if (trans.isActive()) {
				trans.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}

}
