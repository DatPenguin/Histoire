package ucp.glp.histoire.managers;

import ucp.glp.histoire.utilities.Peuple;

import java.util.ArrayList;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Université de Cergy-Pontoise
 * @date 2016-2017
 */
public class PeupleManager {

    public static void genereEnsembleTotal(ArrayList<Peuple> listePeuple) {
        for (Peuple aListePeuple : listePeuple) {
            PeupleManager.genereEnsemble(aListePeuple);
        }
    }

    // Fonctions définissant les attributs secondaires
    private static void genereTechnologie(Peuple p) {
        p.setTechnologie((p.getRessources() + p.getEducation()) / 2);
    }

    private static void genereDensite(Peuple p) {
        p.setDensite(p.getTerritoire() - p.getPopulation());

    }

    private static void genereRichesse(Peuple p) {
        p.setRichesse((p.getRessources() + p.getTerritoire()) / 2);
    }

    private static void genereNbSoldat(Peuple p) {
        p.setNbSoldat((int) (p.getPopulation() + p.getAgressivite()) / 2);
    }

    private static void genereBellicisme(Peuple p) {
        if (p.getPopulation() < 15) { // Pour éviter les résultat NaN lié au ln
            p.setBellicisme(0);
        } else {
            p.setBellicisme((Math.log(p.getPopulation() + 1) / 4) * (p.getRichesse() + p.getAgressivite()) / 2);
        }
    }

    private static void genereAttractivite(Peuple p) {
        p.setAttractivite((p.getRichesse() + p.getTechnologie()) / 2);
    }

    private static void generePuissanceMilitaire(Peuple p) {
        p.setPuissanceMilitaire((p.getTechnologie() + (double) p.getNbSoldat()) / 2);
    }

    private static void generePuissancePolitique(Peuple p) {
        p.setPuissancePolitique((p.getPuissanceMilitaire() + p.getRichesse()) / 2);
    }

    private static void genereImigration(Peuple p) {
        p.setImmigration((int) (p.getDensite() + p.getRichesse()) / 10);
    }

    private static void genereEnsemble(Peuple p) {
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
