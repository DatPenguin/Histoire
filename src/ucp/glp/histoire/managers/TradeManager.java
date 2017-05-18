package ucp.glp.histoire.managers;

import org.apache.log4j.Logger;
import ucp.glp.histoire.log.LoggerUtility;
import ucp.glp.histoire.utilities.Peuple;

import java.util.ArrayList;

/**
 * Gestionnaire de commerce
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Université de Cergy-Pontoise
 * @date 2016-2017
 */
public class TradeManager {
    private static int TRADE_SEUIL = 100;
    private static final Logger logger = LoggerUtility.getLogger(TradeManager.class);

    /**
     * Vérifie la possibilité de commerce entre tous les pays
     * @param listePeuple Liste des peuples en jeu
     */
    public static void TradeChecker(ArrayList<Peuple> listePeuple) {
        // Routine de déclenchement ou non du commerce (commerce ponctuel)
        for (Peuple aListePeuple : listePeuple) {
            aListePeuple.setListeTrade(new ArrayList<Peuple>());    // On réinitialise à chaque fois la liste des partenaires commerciaux
        }

        for (int i = 0; i < listePeuple.size(); i++)
            for (int j = (i + 1); j < listePeuple.size(); j++)      // De cette façon on évitera un dédoublement du commerce
                if (((int) (listePeuple.get(i).getAttractivite() + listePeuple.get(j).getAttractivite()) >= TRADE_SEUIL) && !(listePeuple.get(i).getListeEnnemies().contains(listePeuple.get(j))))    // Si la somme de leur attractivité est suffisante et si ils ne sont pas ennemis
                    TradeManager.trade(listePeuple.get(i), listePeuple.get(j));
    }

    /**
     * Conséquences du commerce
     * @param p1 Commerçant 1
     * @param p2 Commerçant 2
     */
    private static void trade(Peuple p1, Peuple p2) {
        double taux = 0.001;    // Evite un enrichissement trop rapide
        p1.setRessources(p1.getRessources() + (taux * (p2.getAttractivite() * p1.getPuissancePolitique())));
        p2.setRessources(p2.getRessources() + (taux * (p1.getAttractivite() * p2.getPuissancePolitique())));
        p1.addTrade(p2);
        p2.addTrade(p1);

        RunningLoop.addTotextLog("Commerce entre " + p1.getNom() + " et " + p2.getNom());

        logger.info("Commerce entre " + p1.getNom() + " et " + p2.getNom() + " iteration : " + RunningLoop.nbIteration);
    }
}
