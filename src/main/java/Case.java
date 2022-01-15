

import java.io.IOException;

public abstract class Case {
	protected String nom;
	public Case caseSuivante;
	
	//Fonction pour pass� d'une case � une autre
	public  Case Suivante(double nb) {
		if(nb==0) {
			return this;
		}
		else {
			return caseSuivante.Suivante(nb-1);
		}
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public abstract int ActionCase(Joueur j) throws IOException;
	

}
