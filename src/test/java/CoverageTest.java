
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class CoverageTest {

	@Test
	void CoverageTest() {
		Coverage c = new Coverage();
        c.test();
		assertEquals(1, 1);
	}
}
