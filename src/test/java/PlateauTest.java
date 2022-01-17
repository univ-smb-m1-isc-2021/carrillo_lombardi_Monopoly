
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class PlateauTest {

	@Test
	void creerCase() {
		Plateau p = new Plateau();
		assertEquals(p.getListeCases().size(), 31);
	}
}
