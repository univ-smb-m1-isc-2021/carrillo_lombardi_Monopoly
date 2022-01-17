
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class CaseTest {

	@Test
	void setNomTest() {
		CasePropriete marron = new Terrain("Boulevard de Belleville", 2, 4, new double[] {2, 4, 6, 8, 10, 15});
		assertEquals(marron.getNom(), "Boulevard de Belleville");

        marron.setNom("test");
		assertEquals(marron.getNom(), "test");
	}

	@Test
	void CaseSuivanteTest() {
		CasePropriete marron = new Terrain("Boulevard de Belleville", 2, 4, new double[] {2, 4, 6, 8, 10, 15});
        CasePropriete marron2 = new Terrain("Rue Lecourbe", 2, 4, new double[] {2, 4, 6, 8, 10, 15});
        marron.caseSuivante = marron2;
        assertEquals(marron.Suivante(1), marron2);
	}
}
