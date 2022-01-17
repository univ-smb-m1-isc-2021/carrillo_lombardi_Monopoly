

public class EtatCasePleine extends EtatCase{

	public EtatCasePleine(Terrain self) {
		super();
		terrain=self;
	}
	


	@Override
	public double valeurLoyer() {
		
		return terrain.loyer[terrain.loyer.length-1];
	}

	@Override
	public void actualiserEtat() {
		// rien
		
	}

	@Override
	public boolean EstConstructible() {
		return false;
	}

}
