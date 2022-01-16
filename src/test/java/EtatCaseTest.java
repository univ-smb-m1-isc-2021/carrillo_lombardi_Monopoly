
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class EtatCaseTest {

	@Test
	void testEstConstructible() {
        CasePropriete marron = new Terrain("Boulevard de Belleville", 2, 4, new double[] {2, 4, 6, 8, 10, 15});
		assertEquals(((Terrain)marron).etat.EstConstructible(), false);
        
        marron.changeEtat(1);
        assertEquals(((Terrain)marron).etat.EstConstructible(), false);

        marron.changeEtat(2);
        assertEquals(((Terrain)marron).etat.EstConstructible(), true);

        marron.changeEtat(3);
        assertEquals(((Terrain)marron).etat.EstConstructible(), false);
	}

	@Test
	void testValeurLoyer() {
        Terrain marron = new Terrain("Boulevard de Belleville", 2, 4, new double[] {2, 4, 6, 8, 10, 15});
		assertEquals(marron.valeurLoyer(), 0);
      
        ((CasePropriete)marron).changeEtat(2);
        assertEquals(marron.valeurLoyer(), 2); 

        marron.nbConstruction++;
        assertEquals(marron.valeurLoyer(), 4); 
	}

    @Test
	void testConstructionMaison() {
        Terrain marron = new Terrain("Boulevard de Belleville", 2, 4, new double[] {2, 4, 6, 8, 10, 15});
		assertEquals(marron.nbConstruction, 0);
      
        ((CasePropriete)marron).changeEtat(2);
        marron.ConstructionMaison();
        assertEquals(marron.nbConstruction, 1);
	}
}