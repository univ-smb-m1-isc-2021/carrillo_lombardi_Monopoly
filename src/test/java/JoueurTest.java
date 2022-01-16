import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class JoueurTest {

	@Test
	void test() {
		
		assertEquals(true, true);
	}


	
	@Test
	public void AchatCaseTest() {
		Terrain t=new Terrain("Boulevard de Belleville", 2, 4, new double[] {2, 4, 6, 8, 10, 15});
		Joueur j = new Joueur("yo",t);
		List<CasePropriete> l = new ArrayList<CasePropriete>();
		l.add(t);
		t.quartier=new Quartier("oui",l);
		j.setSolde(20);
		j.AchatCase();
		assertEquals(j.getSolde(),18.0);
		assertEquals(j.listePropriete.get(0).equals(t),true);
		
	}
	
	@Test
	public void GetConstructibleTest(){
		Terrain t=new Terrain("Boulevard de Belleville", 2, 4, new double[] {2, 4, 6, 8, 10, 15});
		Terrain t1=new Terrain("Boulevard de Belleville", 2, 4, new double[] {2, 4, 6, 8, 10, 15});
		Terrain t2=new Terrain("Boulevard de Belleville", 2, 4, new double[] {2, 4, 6, 8, 10, 15});
		Joueur j = new Joueur("yo",t);
		List<CasePropriete> l = new ArrayList<CasePropriete>();
		l.add(t);
		l.add(t1);
		l.add(t2);
		t.quartier=new Quartier("oui",l);
		t1.quartier=new Quartier("oui",l);
		t2.quartier=new Quartier("oui",l);
		j.setSolde(20);
		j.AchatCase();
		j.currentCase=t2;
		j.AchatCase();
		j.currentCase=t1;
		j.AchatCase();
		
		assertEquals(j.GetConstructible().size(), 3);
	}
	
	@Test
	public void GetNbProprieteTest(){
		Terrain t=new Terrain("Boulevard de Belleville", 2, 4, new double[] {2, 4, 6, 8, 10, 15});
		Terrain t1=new Terrain("Boulevard de Belleville", 2, 4, new double[] {2, 4, 6, 8, 10, 15});
		Terrain t2=new Terrain("Boulevard de Belleville", 2, 4, new double[] {2, 4, 6, 8, 10, 15});
		Joueur j = new Joueur("yo",t);
		List<CasePropriete> l = new ArrayList<CasePropriete>();
		l.add(t);
		l.add(t1);
		l.add(t2);
		t.quartier=new Quartier("oui",l);
		t1.quartier=new Quartier("oui",l);
		t2.quartier=new Quartier("oui",l);
		j.setSolde(20);
		j.AchatCase();
		j.currentCase=t2;
		j.AchatCase();
		j.currentCase=t1;
		j.AchatCase();
		
		assertEquals(j.GetNbPropriete("oui"), 3);
	}

	
	
}
