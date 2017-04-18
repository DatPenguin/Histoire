package ucp.glp.histoire.managers;

import org.apache.log4j.Logger;
import ucp.glp.histoire.log.LoggerUtility;
import ucp.glp.histoire.utilities.Peuple;

import java.util.ArrayList;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Universit� de Cergy-Pontoise
 * @date 2016-2017
 */
public class GuerreManager {
    private static final int GUERRE_SEUIL = 150;
    private static Logger logger = LoggerUtility.getLogger(GuerreManager.class);

    //Il faudra lui passer une arraylist contenant tout les pays actuelement en jeu
    //Cette classe sera instanci�e une seule fois et apr�s travaillera par routine � chaque passage de temps

    public GuerreManager() {
    }

    public static void guerreChecker(ArrayList<Peuple> listePeuple) {    // Comparera si quel pays peut entrer en guerre avec un autre

        // Routine de d�clenchement ou non de la guerre (guerre ponctuelle)
        for(int x = 0; x < listePeuple.size(); x++){
            listePeuple.get(x).setListeEnnemies(new ArrayList<Peuple>());    // On r�initialise � chaque fois la liste des ennemies
        }


        for(int i = 0; i < listePeuple.size(); i++){

            // TODO affiner
            for (int j = (i + 1); j < listePeuple.size(); j++) {     // De cette fa�on on �vitera un d�doublement des guerres

                if ((int) (listePeuple.get(i).getBellicisme() + listePeuple.get(j).getBellicisme()) >= GUERRE_SEUIL) {
                    GuerreManager.guerre(listePeuple.get(i), listePeuple.get(j));
                }
				
				/*
				 * Algorithmes � revoir, la guerre dure �ternelement � cause d'un enrichissement des deux camps
				 */
				/*else if((int)(listePeuple.get(i).getBellicisme() + listePeuple.get(j).getAttractivite()) >= seuil){
					GuerreManager.guerre(listePeuple.get(i), listePeuple.get(j));
				}*/
				
				/*else if((int)(listePeuple.get(j).getBellicisme() + listePeuple.get(i).getAttractivite()) >= seuil){
					GuerreManager.guerre(listePeuple.get(i), listePeuple.get(j));
				}*/
            }
        }
    }

    private static void guerre(Peuple p1,Peuple p2){	//Cons�quences de la guerre

        // TODO Ajouter un facteur al�atoire
        double tauxReductionPop = 0.01;
        p1.setPopulation(p1.getPopulation() - (int)(tauxReductionPop * p2.getPuissanceMilitaire()));
        p2.setPopulation(p2.getPopulation() - (int)(tauxReductionPop * p1.getPuissanceMilitaire()));

        // Les puissance millitaires seront recalcul�es apr�s
        //int perteBrute = 1;    // TODO A ajouter pour �viter une guerre qui durerais infiniment
        //double tauxReductionRessources = 0.01;
        //p1.setRessources(p1.getRessources() + tauxReductionRessources * (p1.getPuissanceMilitaire() - p2.getPuissanceMilitaire() - perteBrute));    // A voir pour changer les ressources en float
        //p2.setRessources(p2.getRessources() + tauxReductionRessources * (p2.getPuissanceMilitaire() - p1.getPuissanceMilitaire() - perteBrute));
        p1.setRessources(p1.getRessources() - (p1.getRessources() / 100));
        p2.setRessources(p2.getRessources() - (p2.getRessources() / 100));
        // Ajout dans la liste des ennemis
        p1.addEnnemies(p2);
        p2.addEnnemies(p1);
        

        //System.out.println("La guerre � �clat� entre " + p1.getNom() + " et " + p2.getNom());    // TODO /!\ A REMPLACER PAR L'AJOUT DANS UNE FILE
        logger.info("La guerre � �clat� entre " + p1.getNom() + " et " + p2.getNom() + " iteration : " + RunningLoop.nbIteration);
        RunningLoop.addTotextLog("La guerre � �clat� entre " + p1.getNom() + " et " + p2.getNom());
 }
}
