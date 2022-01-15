

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Service extends CasePropriete {
	public String etat="libre";
	
	public Service(String nom) {
		this.nom=nom;
		this.loyer=new double[] {4,10};
		this.prixAchat=150;
	}

	@Override
	public double valeurLoyer() throws IOException{
		double aPayer = loyer[0];
		Joueur j = proprio;
		
		System.out.println("Le loyer d�pend de votre lancer de d� (150 * " + loyer[j.GetNbPropriete("Energie") - 1] + " * valeur du d�)");
		System.out.println("Appuyer sur \"entrer\" pour lancer le d�");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		reader.readLine();
		
		int nb = (int) (Math.random() * ( 6 - 1 )) + 1;
		System.out.println("Vous avez fait un " + nb);
		
		aPayer = 150 * loyer[j.GetNbPropriete("Energie") - 1] * nb;
		System.out.println("Vous devez payer " + aPayer);
		return aPayer;
	}

	@Override
	public int ActionCase(Joueur j) throws IOException {
		if(etat=="libre")
			return 1;//achetable
		if(j.getNom().equals(this.proprio.getNom()))
			return 0;//rien n'est fait
		else {
			double aEtePayer=valeurLoyer();
			j.Paye(aEtePayer);
			this.proprio.Ajoute(aEtePayer);
		}
		return 0;
	}

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
		this.changeEtat(1);
	}

}
