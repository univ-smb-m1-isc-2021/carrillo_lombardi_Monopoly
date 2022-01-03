package Monopoly;

public class CaseFixe extends Case {
	//Les cases fixes sont les case de taxe
	private double taxe;
	private int type;
	
	//Constructeur
	public CaseFixe(String nom, double taxe,int type) {
		super();
		this.nom = nom;
		this.taxe = taxe;
		this.type = type;
	}

	//En marchant sur une case cette fonction s'active
	@Override
	public int ActionCase(Joueur j) {
		switch (type) {
		case 0:
			j.Ajoute(2000);
			System.out.println("Votre solde est " + j.getSolde());
			return 4;
		case 1:
			j.Retire(taxe);
			System.out.println("Votre solde est " + j.getSolde());
			return 5;
		}
		return 0;
	}

}
