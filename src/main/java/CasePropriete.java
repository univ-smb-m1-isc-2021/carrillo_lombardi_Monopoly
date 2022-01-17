

import java.io.IOException;

public abstract class CasePropriete extends Case {
	//C'est pour les case achetable
	protected double[] loyer;
	protected double prixAchat;
	protected double prixMaison;
	
	protected Joueur proprio;
	public Quartier quartier;
	

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
	public abstract void changeEtat(int i);
	
	//Quand on achete la case o� l'on se trouve
	public abstract void AchatCase(Joueur j);

	public double getCoutMaison() {
		return this.prixMaison;
	}
}
