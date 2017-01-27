package ucp.glp.histoire.utilitaires;

import javax.swing.*;
import java.util.ArrayList;

public class Peuple {
	//attributs principaux
	protected String nom;
	protected int population;
	protected double ressources,education,territoire,agressivite;
	//attributs secondaires
	protected int nbSoldat,imigration;
	protected double technologie,densite,richesse,attractivite,bellicisme,puissanceMilitaire,puissancePolitique;
	//attribut tertiaires
	protected ArrayList<Peuple> listeEnnemies;
	private ImageIcon icon;



    public Peuple(ImageIcon i) {
        this.icon = i;
    }

    public Peuple(int ressources, int population, int education, int territoire, int agressivite,String nom) {
		this.ressources = ressources;
		this.population = population;
		this.education = education;
		this.territoire = territoire;
		this.agressivite = agressivite;
		this.nom = nom;
	}

	public ImageIcon getIcon() {
		return icon;
	}
	
	/* fonctions définissant les attributs secondaires */
    /*
	public void genereTechnologie(){
		this.technologie = (this.ressources + this.education)/2;
	}
	
	public void genereDensite(){
		this.densite = (this.territoire - this.population);
	}
	
	public void genereRichesse(){
		this.richesse = (this.ressources + this.territoire)/2;
	}
	
	public void genereNbSoldat(){
		this.nbSoldat = (int)(this.population +this.agressivite)/2;
	}
	
	public void genereBellicisme(){
		this.bellicisme = (this.richesse + this.agressivite)/2;
	}
	
	public void genereAttractivite(){
		this.attractivite = (this.richesse + this.technologie)/2;
	}
	
	public void generePuissanceMilitaire(){
		this.puissanceMilitaire = (this.technologie + this.nbSoldat)/2;
	}
	
	public void generePuissancePolitique(){
		this.puissancePolitique = (this.puissanceMilitaire + this.richesse)/2;
	}
	public void genereImigration(){
		this.imigration = (int)(this.densite + this.richesse)/10;
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
	*/
	/* Différent getter et setter */
	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public double getRessources() {
		return ressources;
	}

	public void setRessources(double ressources) {
		this.ressources = ressources;
	}

	public double getEducation() {
		return education;
	}

	public void setEducation(double education) {
		this.education = education;
	}

	public double getTerritoire() {
		return territoire;
	}

	public void setTerritoire(double territoire) {
		this.territoire = territoire;
	}

	public double getAgressivite() {
		return agressivite;
	}

	public void setAgressivite(double agressivite) {
		this.agressivite = agressivite;
	}

	public int getNbSoldat() {
		return nbSoldat;
	}

	public void setNbSoldat(int nbSoldat) {
		this.nbSoldat = nbSoldat;
	}

	public int getImigration() {
		return imigration;
	}

	public void setImigration(int imigration) {
		this.imigration = imigration;
	}

	public double getTechnologie() {
		return technologie;
	}

	public void setTechnologie(double technologie) {
		this.technologie = technologie;
	}

	public double getDensite() {
		return densite;
	}

	public void setDensite(double densite) {
		this.densite = densite;
	}

	public double getRichesse() {
		return richesse;
	}

	public void setRichesse(double richesse) {
		this.richesse = richesse;
	}

	public double getAttractivite() {
		return attractivite;
	}

	public void setAttractivite(double attractivite) {
		this.attractivite = attractivite;
	}

	public double getBellicisme() {
		return bellicisme;
	}

	public void setBellicisme(double bellicisme) {
		this.bellicisme = bellicisme;
	}

	public double getPuissanceMilitaire() {
		return puissanceMilitaire;
	}

	public void setPuissanceMilitaire(double puissanceMilitaire) {
		this.puissanceMilitaire = puissanceMilitaire;
	}

	public double getPuissancePolitique() {
		return puissancePolitique;
	}

	public void setPuissancePolitique(double puissancePolitique) {
		this.puissancePolitique = puissancePolitique;
	}
	
    public ArrayList<Peuple> getListeEnnemies() {
		return listeEnnemies;
	}

	public void setListeEnnemies(ArrayList<Peuple> listeEnnemies) {
		this.listeEnnemies = listeEnnemies;
	}
	public void addEnnemies(Peuple p1){
		this.listeEnnemies.add(p1);
	}
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}
