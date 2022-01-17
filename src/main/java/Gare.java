

public class Gare extends CasePropriete{

	public Gare(String nom) {
		this.nom=nom;
		this.loyer=new double[] {50,100,150,200};
		this.prixAchat=200;
	}

	@Override
	public double valeurLoyer() {
		double aPayer =loyer[0];
		Joueur j = proprio;
		aPayer=loyer[j.GetNbPropriete("Gare")-1];
		return aPayer;
	}

	@Override
	public int ActionCase(Joueur j) {
		if(etat.equals("libre"))
			return 1;//achetable
		if(j.getNom().equals(this.proprio.getNom()))
			return 0;//rien n'est fait
		else {
			j.Paye(valeurLoyer());
			System.out.println("Vous devez payer " + this.getProprio().getNom() + " d'un montant " + valeurLoyer() + "$");
			System.out.println("Votre nouveau solde est " + j.getSolde());
			double tempSolde = this.getProprio().getSolde();
			double aEtePayer=valeurLoyer();
			this.proprio.Ajoute(aEtePayer);
			System.out.println("Le solde de " + this.getProprio().getNom() + " est pass� de " + tempSolde + " � " + this.getProprio().getSolde());
			
		}
		
		return 0;
	}


	
}
