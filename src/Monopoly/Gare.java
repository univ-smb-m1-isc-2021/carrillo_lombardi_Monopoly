package Monopoly;

public class Gare extends CasePropriete{
	public String etat="libre";

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
		if(etat=="libre")
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

	@Override
	public void changeEtat(int i) {
		switch (i) {
		case 0:
			this.etat="libre";
			break;
		case 1:
			this.etat="acheter";
			break;

		default:
			break;
		}
		
	}

	@Override
	public void AchatCase(Joueur j) {
		double tempPrix=this.prixAchat;
		j.Paye(tempPrix);
		setProprio(j);
		changeEtat(1);
	}
	
}