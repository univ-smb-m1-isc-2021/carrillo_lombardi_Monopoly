package Monopoly;

//Class abstract pour les differents etat
public abstract class EtatCase {
	protected Terrain terrain;
	//Determine l'action de la case en fonctin de son etat
	public abstract int ActionCase(Joueur j);
	//Determine la valeur du loyer en fonction de l'etat
	public abstract double valeurLoyer();
	//Actualiser l'etat en fonction de certain parametre qui sont necessaires pour cahnger d'etat (comme on a le max de construction)
	public abstract void actualiserEtat();
	//Seul etat Libre peut utiliser cette fonction donc on la defini ici
	public void AchatCase(Joueur j) {
		double tempPrix=this.terrain.prixAchat;
		if(j.AssezArgent(tempPrix))
			j.Paye(tempPrix);
	}
	
	public abstract boolean EstConstructible();
	//Seul etat constructible peut utiliser cette fonction donc on la defini ici
	public void ConstructionMaison() {
		if(this instanceof EtatCaseConstructible) {
			this.terrain.nbConstruction++;
			this.actualiserEtat();
		}
	}
}
