

public class EtatCaseLibre extends EtatCase {

	public EtatCaseLibre(Terrain self) {
		super();
		terrain=self;
	}

	@Override
	public int ActionCase(Joueur j) {
		///TODO 
		return 1;//achetable
	}

	@Override
	public double valeurLoyer() {
		return 0;
	}

	@Override
	public void actualiserEtat() {
		this.terrain.changeEtat(1);
		this.terrain.getEtat().actualiserEtat();
		
	}

	@Override
	public boolean EstConstructible() {
		return false;
	}
	

}
