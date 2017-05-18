package ucp.glp.histoire.managers;

import org.apache.log4j.Logger;
import ucp.glp.histoire.log.LoggerUtility;
import ucp.glp.histoire.utilities.Peuple;

import java.util.ArrayList;

/**
 * Cette classe sera instanciée une seule fois et après travaillera par routine à chaque passage de temps
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Université de Cergy-Pontoise
 * @date 2016-2017
 */
public class GuerreManager {
    private static final int GUERRE_SEUIL = 150;
    private static final Logger logger = LoggerUtility.getLogger(GuerreManager.class);

    /**
     * Vérifie la possibilité de conflits
     * @param listePeuple Liste contenant tous les pays actuellement en jeu
     */
    public static void guerreChecker(ArrayList<Peuple> listePeuple) {

        // Routine de déclenchement ou non de la guerre (guerre ponctuelle)
        for (Peuple aListePeuple : listePeuple)
            aListePeuple.setListeEnnemies(new ArrayList<Peuple>());         // On réinitialise à chaque fois la liste des ennemies

        for (int i = 0; i < listePeuple.size(); i++)
            for (int j = (i + 1); j < listePeuple.size(); j++)              // De cette façon on évitera un dédoublement des guerres
                if ((int) (listePeuple.get(i).getBellicisme() + listePeuple.get(j).getBellicisme()) >= GUERRE_SEUIL)
                    GuerreManager.guerre(listePeuple.get(i), listePeuple.get(j));
    }

    /**
     * Conséquences de la guerre
     * @param p1 Belligérant 1
     * @param p2 Belligérant 2
     */
    private static void guerre(Peuple p1, Peuple p2) {
        double tauxReductionPop = 0.01;
        p1.setPopulation(p1.getPopulation() - (int) (tauxReductionPop * p2.getPuissanceMilitaire()));
        p2.setPopulation(p2.getPopulation() - (int) (tauxReductionPop * p1.getPuissanceMilitaire()));

        p1.setRessources(p1.getRessources() - (p1.getRessources() / 100));
        p2.setRessources(p2.getRessources() - (p2.getRessources() / 100));

        // Ajout dans la liste des ennemis
        p1.addEnnemies(p2);
        p2.addEnnemies(p1);

        logger.info("La guerre fait rage entre " + p1.getNom() + " et " + p2.getNom() + " itération : " + RunningLoop.nbIteration);
        RunningLoop.addTotextLog("La guerre fait rage entre " + p1.getNom() + " et " + p2.getNom());
    }
}
