package Monopoly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Joueur {
	private String nom;
	private double solde;
	private Case currentCase;
	private List<CasePropriete> listePropriete ;
	private int action;
	
	public Joueur(String nom, Case pCase) {
		super();
		this.nom = nom;
		this.action = 0;
		this.solde = 5000;
		this.currentCase = pCase;
		this.listePropriete = new ArrayList<CasePropriete>();
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	
	
	public void LancerDe() throws IOException {
		int nb = (int) (Math.random() * ( 6 - 1 )) + 1;
		//Change la case actuelle en la bonne case
		this.Avancer(nb);
		System.out.println(nom + " est sur la case " + currentCase.nom);
		//Recuper quel type d'action possible definir par un int qui ensuite nous donne les propositionAction
		action = currentCase.ActionCase(this);
		propositionAction();
	}
	
	//Permet de tricher et de choisir de combien en avance
	public void LancerDeCheat() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("De combien de case voulez vous avancer ?");
		int nb = Integer.parseInt(reader.readLine());
		
		this.Avancer(nb);
		System.out.println(nom + " est sur la case " + currentCase.nom);
		
		if(currentCase instanceof CasePropriete) {
			Joueur tempJ = ((CasePropriete) currentCase).getProprio();
			if(tempJ != null)
				System.out.println("La case appartient à " + ((CasePropriete) currentCase).getProprio().getNom());
			else
				System.out.println("La case est libre");
		}
		
		action = currentCase.ActionCase(this);
		propositionAction();
	}
	//Si action == 1 alors on  propose l'achat  au joueur
	public void propositionAction() throws IOException {
		if(action == 1) {
			boolean buying = true;
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			while(buying) {
				System.out.println("Voulez-vous acheter " + currentCase.nom + " ?");
				System.out.println("Il vaut " + ((CasePropriete)currentCase).prixAchat + "$");
				System.out.println("1 - Oui");
				System.out.println("2 - Non");
				String choice = reader.readLine();
				
				if(choice.equals("1")) {
					this.AchatCase();
					System.out.println("Vous venez d'acheter " + this.currentCase.nom);
					//System.out.println("Votre solde est " + this.getSolde());
					buying = false;
				}
				
				if(choice.equals("2")) {
					buying = false;
				}
			}
		}
	}

	public void Avancer(int nb) {
		Case caseActuelle = currentCase.Suivante(nb);
		ActualisationEstSur(caseActuelle);
	}

	public void ActualisationEstSur(Case caseActuelle) {
		currentCase = caseActuelle;	
	}
	
	//Dis a la case qu'on l'achete ce qui permet qu'elle gere le paiement et le changement de propriete
	public void AchatCase() {
		//this.Paye((CasePropriete)c.getPrixAchat());
		CasePropriete tempCase=(CasePropriete)currentCase;
		tempCase.AchatCase(this);
		this.listePropriete.add((CasePropriete) currentCase);
	}
	
	public void AchatMaison(Terrain case1) {
		double prix = case1.getPrixAchat();
		if(AssezArgent(prix)) {
			Paye(prix);
			case1.ConstructionMaison();
		}
	}
	
	public void FinTour() throws IOException {
		System.out.println("Appuyer sur \"entrer\" pour terminer votre tour");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		reader.readLine();
	}
	
	public double Paye(double cout) {
		this.solde -= cout;
		return this.solde;
	}
	
	public boolean AssezArgent(double cout) {
		if(this.solde >= cout)
			return true;
		return false;
	}
	
	//Recuper dans sa liste de propriete celle qui ont l'etat constructibles
	public List<Terrain> GetConstructible() {
		List<Terrain> tempList=new ArrayList<Terrain>(); 
		for (CasePropriete case1 : listePropriete) {
			if(case1 instanceof Terrain) {
				if(((Terrain) case1).getEtat().EstConstructible()) {
					tempList.add((Terrain) case1);
				}
			}
		}
		return tempList;
	}
	
	public double Ajoute(double cout) {
		this.solde += cout;
		return this.solde;
	}
	
	public int GetNbPropriete(String name) {
		int temp = 0;
		for(int i = 0; i < listePropriete.size(); i++) {
			if(((CasePropriete)listePropriete.get(i)).quartier.getNom().equals(name))
				temp++;			
		}
		return temp;
	}

	public void Retire(double val) {
		this.solde -= val;

		
	}
}
