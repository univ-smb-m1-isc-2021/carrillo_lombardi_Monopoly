package Monopoly;

public class EtatCaseAchete extends EtatCase {

	public EtatCaseAchete(Terrain self) {
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
			System.out.println("Le solde de " + terrain.getProprio().getNom() + " est passé de " + tempSolde + " à " + terrain.getProprio().getSolde());
			return 0;
		}
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
