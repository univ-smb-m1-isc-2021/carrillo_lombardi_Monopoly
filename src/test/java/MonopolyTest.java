
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class MonopolyTest {

	@Test
	void ChechEndGameTest() {
		Monopoly monopoly = new Monopoly();
		monopoly.listeJoueur.add(new Joueur("yo", null));
		monopoly.listeJoueur.add(new Joueur("yo1", null));
		monopoly.listeJoueur.add(new Joueur("yo2", null));
		monopoly.listeJoueur.get(1).setSolde(-1);
		monopoly.listeJoueur.get(2).setSolde(-1);
		assertEquals(monopoly.CheckEndGame(), true);
	}

}
