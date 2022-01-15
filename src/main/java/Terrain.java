

public class Terrain extends CasePropriete{
	protected int nbConstruction=0;
	
	private EtatCase etat;

	public Terrain() {
		super();
		this.setEtat(new EtatCaseLibre(this));
	}
	
	public Terrain(String pNom, double pPrixAchat, double pPrixMaison, double[] pLoyer) {
		super();
		this.setEtat(new EtatCaseLibre(this));
		
		this.nom = pNom;
		this.prixAchat = pPrixAchat;
		this.prixMaison = pPrixMaison;
		this.loyer = pLoyer;
	}

	@Override
	public double valeurLoyer() {
		return getEtat().valeurLoyer();
	}

	@Override
	public int ActionCase(Joueur j) {
		return getEtat().ActionCase(j);
	}

	@Override
	public void changeEtat(int i) {
		switch (i) {
		case 0: 
			setEtat(new EtatCaseLibre(this));
			break;
		
		case 1: 
			setEtat(new EtatCaseAchete(this));
			break;

		case 2: 
			setEtat(new EtatCaseConstructible(this));
			break;
		case 3: 
			setEtat(new EtatCasePleine(this));
			break;
		
		default:
			break;
		}
		
	}

	public EtatCase getEtat() {
		return etat;
	}

	public void setEtat(EtatCase etat) {
		this.etat = etat;
	}

	@Override
	public void AchatCase(Joueur j) {
		getEtat().AchatCase(j);
		setProprio(j);
		etat.actualiserEtat();
	}
	
	public void ConstructionMaison() {
		etat.ConstructionMaison();
	}
	
	

}
