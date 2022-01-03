package Monopoly;

import java.util.ArrayList;
import java.util.List;

public class Plateau {
	protected List<Case> listeCases;

	public List<Case> getListeCases() {
		return listeCases;
	}

	public void setListeCases(List<Case> listeCases) {
		this.listeCases = listeCases;
	}

	public Plateau() {
		super();
		creerCase();
	}

	private void creerCase() {
		
	    // Liste de toutes les cases propriétés 
		
		// Terrain(String pNom, double pPrixAchat, double pPrixMaison, double[] pLoyer)
		
	    CasePropriete marron1 = new Terrain("Boulevard de Belleville", 2, 4, new double[] {2, 4, 6, 8, 10, 15});
	    CasePropriete marron2 = new Terrain("Rue Lecourbe", 2, 4, new double[] {2, 4, 6, 8, 10, 15});
	    
	    CasePropriete bleuClair1 = new Terrain("Rue de Vaugirad", 2, 4, new double[] {2, 4, 6, 8, 10, 15});
	    CasePropriete bleuClair2 = new Terrain("Rue de Courcelles", 2, 4, new double[] {2, 4, 6, 8, 10, 15});
	    CasePropriete bleuClair3 = new Terrain("Avenue de la république", 2, 4, new double[] {2, 4, 6, 8, 10, 15});
	    
	    CasePropriete rose1 = new Terrain("Boulevard de la villette", 2, 4, new double[] {2, 4, 6, 8, 10, 15});
	    CasePropriete rose2 = new Terrain("Avenue de  Neuilly", 2, 4, new double[] {2, 4, 6, 8, 10, 15});
	    CasePropriete rose3 = new Terrain("Rue du paradis", 2, 4, new double[] {2, 4, 6, 8, 10, 15});
	    
	    CasePropriete orange1 = new Terrain("Avenue Mozart", 2, 4, new double[] {2, 4, 6, 8, 10, 15});
	    CasePropriete orange2 = new Terrain("Boulevard Saint-Michel", 2, 4, new double[] {2, 4, 6, 8, 10, 15});
	    CasePropriete orange3 = new Terrain("Place Pigalle", 2, 4, new double[] {2, 4, 6, 8, 10, 15});
	    
	    CasePropriete rouge1 = new Terrain("Avenue Matignon", 2, 4, new double[] {2, 4, 6, 8, 10, 15});
	    CasePropriete rouge2 = new Terrain("Boulevard Malesherbes", 2, 4, new double[] {2, 4, 6, 8, 10, 15});
	    CasePropriete rouge3 = new Terrain("Avenue Henri-Martin", 2, 4, new double[] {2, 4, 6, 8, 10, 15});
	    
	    CasePropriete jaune1 = new Terrain("Faubourg Saint-Honoré", 2, 4, new double[] {2, 4, 6, 8, 10, 15});
	    CasePropriete jaune2 = new Terrain("Place de la Bourse", 2, 4, new double[] {2, 4, 6, 8, 10, 15});
	    CasePropriete jaune3 = new Terrain("Rue de la fayette", 2, 4, new double[] {2, 4, 6, 8, 10, 15});
	    
	    CasePropriete vert1 = new Terrain("Avenue de Breteuil", 2, 4, new double[] {2, 4, 6, 8, 10, 15});
	    CasePropriete vert2 = new Terrain("Avenue Foch", 2, 4, new double[] {2, 4, 6, 8, 10, 15});
	    CasePropriete vert3 = new Terrain("Boulevard des capucines", 2, 4, new double[] {2, 4, 6, 8, 10, 15});
	    
	    CasePropriete bleuFonce1 = new Terrain("Avenue des Champs-Élysées", 2, 4, new double[] {2, 4, 6, 8, 10, 15});
	    CasePropriete bleuFonce2 = new Terrain("Rue de la paix", 2, 4, new double[] {2, 4, 6, 8, 10, 15});

	    
	    // Ajout des propriétés sous liste pour les quartiers
	    List<CasePropriete> Lmarron = new ArrayList<CasePropriete>();
	    Lmarron.add(marron1);
	    Lmarron.add(marron2);

	    List<CasePropriete> LbleuC = new ArrayList<CasePropriete>();
	    LbleuC.add(bleuClair1);
	    LbleuC.add(bleuClair2);
	    LbleuC.add(bleuClair3);
	    
	    List<CasePropriete> Lrose = new ArrayList<CasePropriete>();
	    Lrose.add(rose1);
	    Lrose.add(rose2);
	    Lrose.add(rose3);
	    
	    List<CasePropriete> Lorange = new ArrayList<CasePropriete>();
	    Lorange.add(orange1);
	    Lorange.add(orange2);
	    Lorange.add(orange3);
	    
	    List<CasePropriete> Lrouge = new ArrayList<CasePropriete>();
	    Lrouge.add(rouge1);
	    Lrouge.add(rouge2);
	    Lrouge.add(rouge3);
	    
	    
	    List<CasePropriete> Ljaune = new ArrayList<CasePropriete>();
	    Ljaune.add(jaune1);
	    Ljaune.add(jaune2);
	    Ljaune.add(jaune3);
	    

	    List<CasePropriete> Lvert = new ArrayList<CasePropriete>();
	    Lvert.add(vert1);
	    Lvert.add(vert2);
	    Lvert.add(vert3);
	    
	    List<CasePropriete> LbleuF = new ArrayList<CasePropriete>();
	    LbleuF.add(bleuFonce1);
	    LbleuF.add(bleuFonce2);
	    
	    // Les cases taxes
	    // Param : Nom, prixAPayer
	    CaseFixe taxe1 = new CaseFixe("Impôts sur le revenu", 200,1);
	    CaseFixe taxe2 = new CaseFixe("Taxe de luxe", 100,1);

	    // Les cases gares
	    // Param : Nom (loyer et prixAchat sont les mêmes pour tous)
	    Gare gare1 = new Gare("Gare Montparnasse");
	    Gare gare2 = new Gare("Gare de lyon");
	    Gare gare3 = new Gare("Gare du nord");
	    Gare gare4 = new Gare("Gare Saint-Lazard");
	    
	    List<CasePropriete> LGare = new ArrayList<CasePropriete>();
	    LGare.add(gare1);
	    LGare.add(gare2);
	    LGare.add(gare3);
	    LGare.add(gare4);
	    
	    Quartier gares = new Quartier("Gare", LGare);
	    gare1.quartier=gares;
	    gare2.quartier=gares;
	    gare3.quartier=gares;
	    gare4.quartier=gares;

	    // Les cases energies
	    // Param : Nom, PrixAchat (pourrait ne pas y être))
	    List<CasePropriete> LEnergie = new ArrayList<CasePropriete>();
	    Service energie1 = new Service("Compagnie de distribution d'électricité");
	    Service energie2 = new Service("Compagnie de distribution des eaux");
	    LEnergie.add(energie1);
	    LEnergie.add(energie2);

	    // Les 4 cases dans les angles 
	    CaseFixe depart = new CaseFixe("Depart",0,0);


	    // Les quartiers 
	    // Param : couleur, nombrePropriete, prixAchatMaison, prixAchatHotel, listePropriété
	    Quartier marron = new Quartier("Marron", Lmarron);
	    marron1.quartier=marron;
	    marron2.quartier=marron;
	    
	    Quartier bleuClair = new Quartier("Bleu Clair", LbleuC);
	    bleuClair1.quartier=bleuClair;
	    bleuClair2.quartier=bleuClair;
	    bleuClair3.quartier=bleuClair;
	    
	    Quartier rose = new Quartier("Rose", Lrose);
	    rose1.quartier=rose;
	    rose2.quartier=rose;
	    rose3.quartier=rose;
	    
	    Quartier orange = new Quartier("Orange", Lorange);
	    orange1.quartier=orange;
	    orange2.quartier=orange;
	    orange3.quartier=orange;
	    
	    Quartier rouge = new Quartier("Rouge",  Lrouge);
	    Quartier jaune = new Quartier("Jaune", Ljaune);
	    Quartier vert = new Quartier("Vert",  Lvert);
	    Quartier bleuFonce = new Quartier("Bleu Foncé", LbleuF);
	    Quartier energie = new Quartier("Energie", LEnergie);
	    
	    
	    // Liste de toutes les cases dans l'ordre du plateau 
	    List<Case> toutesLesCases = new ArrayList<Case>();
	    toutesLesCases.add(depart);
	    depart.caseSuivante=marron1;
	    
	    toutesLesCases.add(marron1);
	    marron1.caseSuivante=marron2;
	    
	    toutesLesCases.add(marron2);
	    marron2.caseSuivante=taxe1;
	    
	    toutesLesCases.add(taxe1);
	    taxe1.caseSuivante=gare1;
	    
	    toutesLesCases.add(gare1);
	    gare1.caseSuivante=bleuClair1;
	    
	    toutesLesCases.add(bleuClair1);
	    bleuClair1.caseSuivante=bleuClair2;
	    
	    toutesLesCases.add(bleuClair2);
	    bleuClair2.caseSuivante=bleuClair3;
	    
	    toutesLesCases.add(bleuClair3);
	    bleuClair3.caseSuivante=rose1;
	    
	    toutesLesCases.add(rose1);
	    rose1.caseSuivante=energie1;
	    
	    toutesLesCases.add(energie1);
	    energie1.caseSuivante=rose2;
	    
	    toutesLesCases.add(rose2);
	    rose2.caseSuivante=rose3;
	    
	    toutesLesCases.add(rose3);
	    rose3.caseSuivante=gare2;
	    
	    toutesLesCases.add(gare2);
	    gare2.caseSuivante=orange1;
	    
	    toutesLesCases.add(orange1);
	    orange1.caseSuivante=orange2;
	    
	    toutesLesCases.add(orange2);
	    orange2.caseSuivante=orange3;
	    
	    toutesLesCases.add(orange3);
	    orange3.caseSuivante=rouge1;
	    
	    toutesLesCases.add(rouge1);
	    rouge1.caseSuivante = rouge2;
	    rouge1.quartier = rouge;
	    
	    toutesLesCases.add(rouge2);
	    rouge2.caseSuivante = rouge3;
	    rouge2.quartier = rouge;
	    
	    toutesLesCases.add(rouge3);
	    rouge3.caseSuivante = gare3;
	    rouge3.quartier = rouge;
	    
	    toutesLesCases.add(gare3);
	    gare3.caseSuivante = jaune1;
	    gare3.quartier = gares;
	    
	    toutesLesCases.add(jaune1);
	    jaune1.caseSuivante = jaune2;
	    jaune1.quartier = jaune;
	    
	    toutesLesCases.add(jaune2);
	    jaune2.caseSuivante = energie2;
	    jaune2.quartier = jaune;
	    
	    toutesLesCases.add(energie2);
	    energie2.caseSuivante = jaune3;
	    energie2.quartier = energie;
	    
	    toutesLesCases.add(jaune3);
	    jaune3.caseSuivante = vert1;
	    jaune3.quartier = jaune;
	    
	    toutesLesCases.add(vert1);
	    vert1.caseSuivante = vert2;
	    vert1.quartier = vert;
	    
	    toutesLesCases.add(vert2);
	    vert2.caseSuivante = vert3;
	    vert2.quartier = vert;
	    
	    toutesLesCases.add(vert3);
	    vert3.caseSuivante = gare4;
	    vert3.quartier = vert;
	    
	    toutesLesCases.add(gare4);
	    gare4.caseSuivante = bleuFonce1;
	    gare4.quartier = gares;
	    
	    toutesLesCases.add(bleuFonce1);
	    bleuFonce1.caseSuivante = taxe2;
	    bleuFonce1.quartier = bleuFonce;
	    
	    toutesLesCases.add(taxe2);
	    taxe2.caseSuivante = bleuFonce2;
	    
	    toutesLesCases.add(bleuFonce2);
	    bleuFonce2.caseSuivante = depart;
	    bleuFonce2.quartier = bleuFonce;
	    
	    listeCases = toutesLesCases;
	}
}
