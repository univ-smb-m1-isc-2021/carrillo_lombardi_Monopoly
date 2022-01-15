

public class EtatCasePleine extends EtatCase{

	public EtatCasePleine(Terrain self) {
		super();
		terrain=self;
	}
	
	@Override
	public int ActionCase(Joueur j) {
		double payeTemp;
		if(j.equals(terrain.getProprio()))
			return 0;//rien
		else {
			payeTemp = valeurLoyer();
			j.Paye(payeTemp);
			System.out.println("Vous devez payer " + terrain.getProprio().getNom() + " d'un montant " + payeTemp + "$");
			System.out.println("Votre nouveau solde est " + j.getSolde());
			double tempSolde = terrain.getProprio().getSolde();
			terrain.getProprio().Ajoute(payeTemp);
			System.out.println("Le solde de " + terrain.getProprio().getNom() + " est pass� de " + tempSolde + " � " + terrain.getProprio().getSolde());
			return 0;
		}
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
