package main;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dao.AlbumDAO;
import dao.EntityManagerFactoryUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import service.AlbumService;

public class JunitTest {
	private static EntityManagerFactoryUtil managerFactoryUtil;
	private static EntityManager entityManager;
	
	@BeforeAll
	static void setup() {
		managerFactoryUtil = new EntityManagerFactoryUtil();
				entityManager = managerFactoryUtil.getEnManager();
	}
	
	@Test
	@DisplayName("findAll")
	void findAll() {
		AlbumService albumService = new AlbumService(entityManager);
		System.out.println(albumService.find);
	}

}
