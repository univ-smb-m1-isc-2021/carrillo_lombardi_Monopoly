

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Monopoly {
	
	private List<Joueur> listeJoueur;
	private Joueur currentJoueur;
	private Plateau plateau;
	private int mode;
	
	//Constructeur
	public Monopoly() {
		super();
		this.mode = 0;
		this.listeJoueur = new ArrayList();
	}

	//Pour am�liorer les propri�t�s
	public void upgradeProperties() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		List<Terrain> liste = currentJoueur.GetConstructible();
		boolean upgrading = liste.size() == 0?false:true;
		
		while(upgrading) {
			System.out.println("Voulez-vous am�liorer une de vos propri�t�s?");
			System.out.println("1 - Oui");
			System.out.println("2 - Non");
			String choice = reader.readLine();
			if(choice.equals("1")) {
				System.out.println("Quelle propri�t� voulez-vous am�liorer?");
				System.out.println("a - annuler");
				for(int i = 0; i < liste.size(); i++) {
					System.out.println(i + " - " + liste.get(i).getNom());
				}
				choice = reader.readLine();
				if(choice.equals("") || choice.equals("a"))
					upgrading = false;
				else {
					int choix = Integer.parseInt(choice);
					if(currentJoueur.AssezArgent(liste.get(choix).getCoutMaison())) {
						System.out.println("Une maison est ajout�");
						System.out.println("Votre solde est " + currentJoueur.getSolde());
						currentJoueur.Paye(liste.get(choix).getCoutMaison());
						liste.get(choix).ConstructionMaison();
					} else {
						System.out.println("Vous n'avez pas assez d'argent");
					}
				}
			}
			
			if(choice.equals("2"))
				upgrading = false;
		}
	}
	
	//Pour lanc� la partie
	public void StartGame() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		while(!CheckEndGame()) {
			System.out.println("C'est au tour de " + currentJoueur.getNom());
			System.out.println("Son solde est " + currentJoueur.getSolde());
			System.out.println("Appuyer sur \"entrer\" pour lancer le d�");
			reader.readLine();
			
			if(mode == 1) {
				currentJoueur.LancerDe();
			} else {
				currentJoueur.LancerDeCheat();
			}
			
			System.out.println("\nVotre solde est " + currentJoueur.getSolde());
			upgradeProperties();
			
			currentJoueur.FinTour();
			FinTour();
		}
	}
	
	//V�rifie si la partie est termin�
	public boolean CheckEndGame() {
		int nbJoueur = listeJoueur.size();
		int nb = 0;
		for(int i = 0; i < nbJoueur; i++)
		{
			if(listeJoueur.get(i).getSolde()<0)
				nb++;
		}
		if(nbJoueur - 1 == nb)
			return true;
		return false;
	}
	
	//Fonction de fin de tour
	public void FinTour() {
		int i = this.listeJoueur.indexOf(currentJoueur);
		if(i+1>=listeJoueur.size())
			currentJoueur = listeJoueur.get(0);
		else
			currentJoueur = listeJoueur.get(i+1);
	}
	
	//Fonction pour afficher le menu de cr�ation d'un joueur
	public static void createPlayersMenu() {
		System.out.println("1 - Ajouter un joueur");
		System.out.println("2 - Lancer la partie");
		System.out.println("3 - Quitter la partie");
	}
	
	//Fonction la cr�ation d'un joueur
	public static void createPlayers(Monopoly monopoly) throws IOException {
		boolean creatingPlayer = true;
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(creatingPlayer || monopoly.listeJoueur.size() < 2) {
			createPlayersMenu();
			String choice = reader.readLine();
			
			switch (choice) {
				case "1": {
					System.out.println("Entrer le nom du joueur");
					String name = reader.readLine();
				    monopoly.listeJoueur.add(new Joueur(name, monopoly.plateau.getListeCases().get(0)));
				}
				case "2": {
					creatingPlayer = false;
					if(monopoly.listeJoueur.size() < 2)
						System.out.println("Vous devez avoir au moins 2 joueurs");
				}
			}
		}
	}
	
	//Fonction o� l'on choisi si on est en mode de jeu normal ou en mode debug (triche)
	public static int chooseMod() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Choisissez votre mode de jeu");
		while(true) {
			System.out.println("1 - mode normal");
			System.out.println("2 - mode debug");
			String choice = reader.readLine();
			
			switch (choice) {
				case "1": {
					return 1;
				}
				case "2": {
					return 2;
				}
			}
		}
	}
	
	/////////////////////////////////////////////// MAIN Normale ////////////////////////////////////////////////////
//	public static void main(String[] args) throws IOException {
//		
//		Monopoly monopoly = new Monopoly();
//		monopoly.plateau = new Plateau();	
//		createPlayers(monopoly);
//		monopoly.mode = chooseMod();
//		monopoly.currentJoueur = monopoly.listeJoueur.get(0);
//		
//		System.out.println("Lancement de la partie");
//		monopoly.StartGame();
//	}
	
	/////////////////////////////////////////////// MAIN 2 - 1 et 2 - 2 ////////////////////////////////////////////////////
	// 2 - 1
	// On se trouve sur Taxe de luxe et on veut aller vers la Rue de la paix
	// Se d�placer de 1
	// Puis on ach�te la case
	// Et on finis notre tour
	//
	// 2 - 2
	// On se trouve sur Taxe de luxe et on veut aller vers la Rue de la paix
	// Il tombe sur la case de Luc, et donc paye Luc
	// Se d�placer de 1
	// Et on finis notre tour
	public static void main(String[] args) throws IOException {
	
		Monopoly monopoly = new Monopoly();
		monopoly.plateau = new Plateau();	
		
		monopoly.listeJoueur.add(new Joueur("Luc", monopoly.plateau.getListeCases().get(29)));
		monopoly.listeJoueur.add(new Joueur("Th�o", monopoly.plateau.getListeCases().get(29)));
		
		monopoly.mode = 2;
		monopoly.currentJoueur = monopoly.listeJoueur.get(0);
		
		System.out.println("Lancement de la partie");
		monopoly.StartGame();
	}
	
	/////////////////////////////////////////////// MAIN 2 - 3 ////////////////////////////////////////////////////
	// 2 - 3
	// On est Paul et on va sur la case Compagnie de distribution des eaux 
	// Se d�placer de 1
	// La case appartient � Th�o
	// On paye une taxe en fonction du lanc� de d� et du nombre de propri�t�
	
	/*public static void main(String[] args) throws IOException {
	
		Monopoly monopoly = new Monopoly();
		monopoly.plateau = new Plateau();	
		
		monopoly.listeJoueur.add(new Joueur("Luc", monopoly.plateau.getListeCases().get(29)));
		monopoly.listeJoueur.add(new Joueur("Th�o", monopoly.plateau.getListeCases().get(22)));
		monopoly.listeJoueur.add(new Joueur("Paul", monopoly.plateau.getListeCases().get(21)));
		
		monopoly.mode = 2;
		monopoly.listeJoueur.get(1).AchatCase();
		monopoly.currentJoueur = monopoly.listeJoueur.get(2);
		
		System.out.println("Lancement de la partie");
		monopoly.StartGame();
	}*/
	
	/////////////////////////////////////////////// MAIN 2 - 4  et 2 - 5 ////////////////////////////////////////////////////
	// 2 - 4
	// On se trouve sur Taxe de luxe et on veut aller vers la gare Montparnasse
	// Se d�placer de 1
	// Puis on paye Paul car la gare est deja acheter
	// On get les constructibles
	// Ameliorer propriete rue de la paix 1 fois
	// Et on finis notre tour
	//
	// 2 - 5
	// On se trouve sur Gare 4 et on tombe sur rue de la paix
	// Se d�placer de 1
	// Puis on paye Luc car la rue est deja acheter et en plus y'a une maison
	// Et on finis notre tour
	//
	/*public static void main(String[] args) throws IOException {
	
		Monopoly monopoly = new Monopoly();
		monopoly.plateau = new Plateau();	
		
		monopoly.listeJoueur.add(new Joueur("Luc", monopoly.plateau.getListeCases().get(28)));
		monopoly.listeJoueur.add(new Joueur("Theo", monopoly.plateau.getListeCases().get(29)));
		monopoly.listeJoueur.add(new Joueur("Paul", monopoly.plateau.getListeCases().get(4)));
		
		
		monopoly.mode = 2;
		monopoly.currentJoueur = monopoly.listeJoueur.get(0);
		
		monopoly.listeJoueur.get(2).AchatCase();
		
		monopoly.listeJoueur.get(0).setSolde(20000);
		monopoly.listeJoueur.get(0).AchatCase();
		monopoly.listeJoueur.get(0).ActualisationEstSur(monopoly.plateau.getListeCases().get(30));
		monopoly.listeJoueur.get(0).AchatCase();
		monopoly.listeJoueur.get(0).ActualisationEstSur(monopoly.plateau.getListeCases().get(3));
		
		System.out.println("Lancement de la partie");
		monopoly.StartGame();
	}*/
}