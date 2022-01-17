

public class EtatCaseAchete extends EtatCase {

	public EtatCaseAchete(Terrain self) {
		super();
		terrain=self;
	}
	

	@Override
	public double valeurLoyer() {
		return terrain.loyer[0];
	}

	@Override
	public void actualiserEtat() {
		boolean tempVerif =this.terrain.quartier.VerifiePossensionQuartier(this.terrain.getProprio());
		if(tempVerif) {
			this.terrain.quartier.ActualisationEtatCaseQuartier();
		}
	}

	@Override
	public boolean EstConstructible() {
		return false;
	}

}
