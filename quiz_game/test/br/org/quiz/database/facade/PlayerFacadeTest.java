package br.org.quiz.database.facade;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import br.org.quiz.database.entity.Player;

public class PlayerFacadeTest {

	private static PlayerFacade facade = new PlayerFacade();
	
	@BeforeClass
	public static void setupDeletePlayer() {
		createPlayer();
		Player player = facade.find(createPlayer().getEmail());
		if (player != null){
			facade.delete(player);
		}
		facade.insert(player);
	}

	private static Player createPlayer() {
		Player player = new Player();
		player.setEmail("name@server.com");
		player.setNome("name");
		return player;
	}

	@Test
	public void testPlayerExists() {
		boolean actual = facade.playerExists(createPlayer());
		assertTrue(actual);
	}
	
	
}
