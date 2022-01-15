

import java.util.List;

public class Quartier {
	private String nom;

	private List<CasePropriete> listesCases;
	
	public Quartier(String nom, List<CasePropriete> listCase) {
		this.nom=nom;
		this.listesCases=listCase;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public boolean VerifiePossensionQuartier(Joueur j) {
		for (CasePropriete case1 : listesCases) {
			if(!j.equals(case1.getProprio())) {
				return false;
			}
		}
		
		return true;
	}
	
	public void ActualisationEtatCaseQuartier() {
		for (CasePropriete casePropriete : listesCases) {
			casePropriete.changeEtat(2);
		}
	}
	
	
}
