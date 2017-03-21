package ucp.glp.histoire.utilities;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Université de Cergy-Pontoise
 * @date 2016-2017
 */
public class Peuple {
	//attributs principaux
	private String nom;
	private int population;
	private double ressources,education,territoire,agressivite;
	//attributs secondaires
	private int nbSoldat,immigration;
	private double technologie,densite,richesse,attractivite,bellicisme,puissanceMilitaire,puissancePolitique;
	//attribut tertiaires
	private ArrayList<Peuple> listeEnnemies;
	private ArrayList<Peuple> listeTrade;
	private Color couleur;

	private ImageIcon icon;


	public Peuple(ImageIcon i) {
		this.icon = i;
	}

	public Peuple(int ressources, int population, int education, int territoire, int agressivite, String nom, Color couleur) {
		this.ressources = ressources;
		this.population = population;
		this.education = education;
		this.territoire = territoire;
		this.agressivite = agressivite;
		this.nom = nom;
		this.couleur = couleur;
	}

	public Color getColor() {
		return couleur;
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
    /*
    	@Override
	public String toString() {
		return "Peuple [nom=" + nom + ", population=" + population
				+ ", ressources=" + ressources + ", education=" + education
				+ ", territoire=" + territoire + ", agressivite=" + agressivite
				+ "]";
	}
	*/


	/* Différent getter et setter */
	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	@Override
	public String toString() {
		/*return "Peuple [nom=" + nom + ", population=" + population
				+ ", ressources=" + ressources + ", education=" + education
				+ ", territoire=" + territoire + ", agressivite=" + agressivite
				+ ", nbSoldat=" + nbSoldat + ", imigration=" + immigration
				+ ", technologie=" + technologie + ", densite=" + densite
				+ ", richesse=" + richesse + ", attractivite=" + attractivite
				+ ", bellicisme=" + bellicisme + ", puissanceMilitaire="
				+ puissanceMilitaire + ", puissancePolitique="
				+ puissancePolitique + "]";*/
		return this.nom;
	}
	public String displayInfo(){
		return "Peuple [nom=" + nom + ", population=" + population
		+ ", ressources=" + ressources + ", education=" + education
		+ ", territoire=" + territoire + ", agressivite=" + agressivite
		+ ", nbSoldat=" + nbSoldat + ", imigration=" + immigration
		+ ", technologie=" + technologie + ", densite=" + densite
		+ ", richesse=" + richesse + ", attractivite=" + attractivite
		+ ", bellicisme=" + bellicisme + ", puissanceMilitaire="
		+ puissanceMilitaire + ", puissancePolitique="
		+ puissancePolitique + "]";
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

	public int getImmigration() {
		return immigration;
	}

	public void setImmigration(int imigration) {
		this.immigration = imigration;
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

	public void addTrade(Peuple p1){
		this.listeTrade.add(p1);
	}

	public ArrayList<Peuple> getListeTrade() {
		return listeTrade;
	}

	public void setListeTrade(ArrayList<Peuple> listeTrade) {
		this.listeTrade = listeTrade;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}
