package ucp.glp.histoire.managers;

import ucp.glp.histoire.utilitaires.Peuple;

import java.util.ArrayList;

public class PeupleManager {
	
	public static void genereEnsembleTotal(ArrayList<Peuple> listePeuple){
		for(int i = 0;i < listePeuple.size();i++){
			PeupleManager.genereEnsemble(listePeuple.get(i));			
		}
	}
	
	/* fonctions définissant les attributs secondaires */
	public static void genereTechnologie(Peuple p){
		//p.technologie = (p.ressources + p.education)/2;
		p.setTechnologie((p.getRessources() + p.getEducation()) /2);
	}
	
	public static void genereDensite(Peuple p){
		//p.densite = (p.territoire - p.population);
		p.setDensite(p.getTerritoire() - p.getPopulation());
		
	}
	
	public static void genereRichesse(Peuple p){
		//p.richesse = (p.ressources + p.territoire)/2;
		p.setRichesse((p.getRessources() + p.getTerritoire()) /2);
	}
	
	public static void genereNbSoldat(Peuple p){
		//p.nbSoldat = (int)(p.population +p.agressivite)/2;
		p.setNbSoldat((int)(p.getPopulation() + p.getAgressivite()) /2);
	}
	
	public static void genereBellicisme(Peuple p){
		//p.bellicisme = (p.richesse + p.agressivite)/2;
		p.setBellicisme((p.getRichesse() + p.getAgressivite()) /2);
	}
	
	public static void genereAttractivite(Peuple p){
		//p.attractivite = (p.richesse + p.technologie)/2;
		p.setAttractivite((p.getRichesse() + p.getTechnologie()) /2);
	}
	
	public static void generePuissanceMilitaire(Peuple p){
		//p.puissanceMilitaire = (p.technologie + p.nbSoldat)/2;
		p.setPuissanceMilitaire((p.getTechnologie() + (double)p.getNbSoldat()) /2);
	}
	
	public static void generePuissancePolitique(Peuple p){
		//p.puissancePolitique = (p.puissanceMilitaire + p.richesse)/2;
		p.setPuissancePolitique((p.getPuissanceMilitaire() + p.getRichesse()) /2); 
	}
	public static void genereImigration(Peuple p){
		//p.imigration = (int)(p.densite + p.richesse)/10;
		p.setImigration((int)(p.getDensite() + p.getRichesse()) /10);
	}
	
	public static void genereEnsemble(Peuple p){
		PeupleManager.genereTechnologie(p);
		PeupleManager.genereDensite(p);
		PeupleManager.genereRichesse(p);
		PeupleManager.genereNbSoldat(p);
		PeupleManager.genereBellicisme(p);
		PeupleManager.genereAttractivite(p);
		PeupleManager.generePuissanceMilitaire(p);
		PeupleManager.generePuissancePolitique(p);
		PeupleManager.genereImigration(p);
	}
	

}
