package app;

import java.util.List;
import java.util.Map;

import dao.AlbumDAO;
import dao.EntityManagerFactoryUtil;
import entities.Albums;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import service.AlbumService;

public class Test {
	public static void main(String[] args) {
		// Khoi tao Application
		Persistence.createEntityManagerFactory("music_jpa");
		EntityManagerFactoryUtil mangerFactoryUtil = new EntityManagerFactoryUtil();
		
		// Init service - DAO
		EntityManager entityManager = mangerFactoryUtil.getEnManager(); // Lấy ra entity manager từ nhà máy
		AlbumDAO albumService = new AlbumService(entityManager);
		
		// Câu 3c
		Map<String, Long> numberOfAlbumByGenre = albumService.getNumberOfAlbumByGenre();
		System.out.println("numberOfAlbumByGenre=" + numberOfAlbumByGenre);
		
		// Câu 3b
		List<Albums> listAlbumByGenre = albumService.listAlbumByGenre("ock");
		System.out.println("listAlbumByGenre=" + listAlbumByGenre + "\n");
	}

}
