

public class EtatCaseConstructible extends EtatCase {

	public EtatCaseConstructible(Terrain self) {
		super();
		terrain=self;
	}


	@Override
	public double valeurLoyer() {
		int tempNbMaison=terrain.nbConstruction;
		System.out.println("Il y a "+ tempNbMaison+" maison " );
		return terrain.loyer[tempNbMaison];
	}

	@Override
	public void actualiserEtat() {
		if(this.terrain.nbConstruction==5) {
			this.terrain.changeEtat(3);
		}
			
		
	}

	@Override
	public boolean EstConstructible() {
		return true;
	}

}
