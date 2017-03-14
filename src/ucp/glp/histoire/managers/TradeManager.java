package ucp.glp.histoire.managers;

import org.apache.log4j.Logger;
import ucp.glp.histoire.log.LoggerUtility;
import ucp.glp.histoire.utilities.Peuple;

import java.util.ArrayList;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Université de Cergy-Pontoise
 * @date 2016-2017
 */
public class TradeManager {
    private static Logger logger = LoggerUtility.getLogger(TradeManager.class);


    public TradeManager() {

    }

    public static void TradeChecker(ArrayList<Peuple> listePeuple){	//comparera si quel pays peut entrer en commerce avec un autre
        //routine de déclenchement ou non du commerce (commerce ponctuel)
        int seuil =  100;
        for(int x = 0; x < listePeuple.size(); x++){
            listePeuple.get(x).setListeTrade(new ArrayList<Peuple>());    // On réinitialise à chaque fois la liste des partenaires commerciaux
        }

        for(int i = 0; i < listePeuple.size(); i++){
            for(int j = (i+1); j < listePeuple.size(); j++ ){	 //de cette façon on évitera un dédoublement du commerce

                if(((int)(listePeuple.get(i).getAttractivite() + listePeuple.get(j).getAttractivite()) >= seuil) && !(listePeuple.get(i).getListeEnnemies().contains(listePeuple.get(j)))){	//si la somme de leur attractivitées est suffisante et si ils ne sont pas ennemies
                    TradeManager.trade(listePeuple.get(i),listePeuple.get(j));
                }

            }
        }
    }

    private static void trade(Peuple p1,Peuple p2){	//Conséquences de la guerre
        //A ajouter : un facteur aléatoire
        double taux = 0.001;	//à ajouter pour éviter un enrichissement trop rapide
        p1.setRessources(p1.getRessources() + (taux*(p2.getAttractivite()* p1.getPuissancePolitique())));
        p2.setRessources(p2.getRessources() + (taux*(p1.getAttractivite()* p2.getPuissancePolitique())));

        //System.out.println("Commerce entre " + p1.getNom() + " et " + p2.getNom());	  // TODO /!\ A REMPLACER PAR L'AJOUT DANS UNE FILE
        RunningLoop.addTotextLog("Commerce entre " + p1.getNom() + " et " + p2.getNom());

        logger.info("Commerce entre " + p1.getNom() + " et " + p2.getNom() + " iteration : " + RunningLoop.nbIteration);


    }
}
