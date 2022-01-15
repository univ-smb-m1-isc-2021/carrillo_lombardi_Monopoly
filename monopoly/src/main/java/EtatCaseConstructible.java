

public class EtatCaseConstructible extends EtatCase {

	public EtatCaseConstructible(Terrain self) {
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
