package ucp.glp.histoire.managers;

import ucp.glp.histoire.utilities.Peuple;

import java.util.ArrayList;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Université de Cergy-Pontoise
 * @date 2016-2017
 */
public class PeupleManager {

    public static void genereEnsembleTotal(ArrayList<Peuple> listePeuple){
        for(int i = 0; i < listePeuple.size(); i++){
            PeupleManager.genereEnsemble(listePeuple.get(i));
        }
    }

    // Fonctions définissant les attributs secondaires
    private static void genereTechnologie(Peuple p){
        //p.technologie = (p.ressources + p.education)/2;
        p.setTechnologie((p.getRessources() + p.getEducation()) /2);
    }

    private static void genereDensite(Peuple p){
        //p.densite = (p.territoire - p.population);
        p.setDensite(p.getTerritoire() - p.getPopulation());

    }

    private static void genereRichesse(Peuple p){
        //p.richesse = (p.ressources + p.territoire)/2;
        p.setRichesse((p.getRessources() + p.getTerritoire()) /2);
    }

    private static void genereNbSoldat(Peuple p){
        //p.nbSoldat = (int)(p.population +p.agressivite)/2;
        p.setNbSoldat((int)(p.getPopulation() + p.getAgressivite()) /2);
    }

    private static void genereBellicisme(Peuple p){
        //p.bellicisme = (p.richesse + p.agressivite)/2;
    	if(p.getPopulation() < 15){ // Pour éviter les résultat NaN lié au ln
    		p.setBellicisme(0);
    	}
    	else{
    		p.setBellicisme((Math.log(p.getPopulation() + 1) / 4) * (p.getRichesse() + p.getAgressivite()) / 2);
    	}
    }

    private static void genereAttractivite(Peuple p){
        //p.attractivite = (p.richesse + p.technologie)/2;
        p.setAttractivite((p.getRichesse() + p.getTechnologie()) /2);
    }

    private static void generePuissanceMilitaire(Peuple p){
        //p.puissanceMilitaire = (p.technologie + p.nbSoldat)/2;
        p.setPuissanceMilitaire((p.getTechnologie() + (double)p.getNbSoldat()) /2);
    }

    private static void generePuissancePolitique(Peuple p){
        //p.puissancePolitique = (p.puissanceMilitaire + p.richesse)/2;
        p.setPuissancePolitique((p.getPuissanceMilitaire() + p.getRichesse()) /2);
    }

    private static void genereImigration(Peuple p){
        //p.imigration = (int)(p.densite + p.richesse)/10;
        p.setImmigration((int) (p.getDensite() + p.getRichesse()) / 10);
    }

    private static void genereEnsemble(Peuple p){
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
