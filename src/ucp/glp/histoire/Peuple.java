package ucp.glp.histoire;

public class Peuple {
	//attributs principaux
	protected int ressources,population,education,territoire,agressivite;
	//attributs secondaires
	protected int nbSoldat,imigration;
	protected float technologie,densite,richesse,attractivite,bellicisme,puissanceMilitaire,puissancePolitique;
	



	public Peuple(int ressources, int population, int education,int territoire, int agressivite) {
		this.ressources = ressources;
		this.population = population;
		this.education = education;
		this.territoire = territoire;
		this.agressivite = agressivite;
		genereEnsemble();
	}
	
	/* fonctions définissant les attributs secondaires */
	public void genereTechnologie(){
		this.technologie = ((float)this.ressources + (float)this.education)/2;
	}
	
	public void genereDensite(){
		this.densite = ((float)this.territoire - (float)this.population);
	}
	
	public void genereRichesse(){
		this.richesse = ((float)this.ressources + (float)this.territoire)/2;
	}
	
	public void genereNbSoldat(){
		this.nbSoldat = (this.population +this.agressivite)/2;
	}
	
	public void genereBellicisme(){
		this.bellicisme = ((float)this.richesse + (float)this.agressivite)/2;
	}
	
	public void genereAttractivite(){
		this.attractivite = (this.richesse + this.technologie)/2;
	}
	
	public void generePuissanceMilitaire(){
		this.puissanceMilitaire = (this.technologie + (float)this.nbSoldat)/2;
	}
	
	public void generePuissancePolitique(){
		this.puissancePolitique = (this.puissanceMilitaire + this.richesse)/2;
	}
	public void genereImigration(){
		this.imigration = ((int)this.densite + (int)this.richesse)/10;
	}
	
	public void genereEnsemble(){
		genereTechnologie();
		genereDensite();
		genereRichesse();
		genereNbSoldat();
		genereBellicisme();
		genereAttractivite();
		generePuissanceMilitaire();
		generePuissancePolitique();
		genereImigration();
	}
	
	/* Différent getter et setter */
	
	public int getRessources() {
		return ressources;
	}

	public void setRessources(int ressources) {
		this.ressources = ressources;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public int getEducation() {
		return education;
	}

	public void setEducation(int education) {
		this.education = education;
	}

	public int getTerritoire() {
		return territoire;
	}

	public void setTerritoire(int territoire) {
		this.territoire = territoire;
	}

	public int getAgressivite() {
		return agressivite;
	}

	public void setAgressivite(int agressivite) {
		this.agressivite = agressivite;
	}
	public int getNbSoldat() {
		return nbSoldat;
	}

	public int getImigration() {
		return imigration;
	}

	public float getTechnologie() {
		return technologie;
	}

	public float getDensite() {
		return densite;
	}

	public float getRichesse() {
		return richesse;
	}

	public float getAttractivite() {
		return attractivite;
	}

	public float getBelicisme() {
		return bellicisme;
	}

	public float getPuissanceMilitaire() {
		return puissanceMilitaire;
	}

	public float getPuissancePolitique() {
		return puissancePolitique;
	}
}
