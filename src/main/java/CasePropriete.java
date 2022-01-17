

import java.io.IOException;

public abstract class CasePropriete extends Case {
	//C'est pour les case achetable
	protected double[] loyer;
	protected double prixAchat;
	protected double prixMaison;
	
	protected Joueur proprio;
	public Quartier quartier;
	public String etat;
	

	public double getPrixAchat() {
		return prixAchat;
	}

	public void setPrixAchat(double prixAchat) {
		this.prixAchat = prixAchat;
	}

	public Joueur getProprio() {
		return proprio;
	}

	public void setProprio(Joueur proprio) {
		this.proprio = proprio;
	}

	public Boolean EstLibre() {
		return proprio==null?true:false;
	}
	
	//Retourne la valeur du loyer
	public abstract double valeurLoyer() throws IOException;

	//Change l'etat d'une case
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
	
	//Quand on achete la case o� l'on se trouve
	public void AchatCase(Joueur j) {
		double tempPrix=this.prixAchat;
		j.Paye(tempPrix);
		setProprio(j);
		changeEtat(1);
	}

	public double getCoutMaison() {
		return this.prixMaison;
	}
}
