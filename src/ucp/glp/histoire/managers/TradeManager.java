package ucp.glp.histoire.managers;
import ucp.glp.histoire.log.LoggerUtility;
import ucp.glp.histoire.test.TestRunningLoop;
import ucp.glp.histoire.utilitaires.Peuple;

import java.util.ArrayList;

import org.apache.log4j.Logger;

public class TradeManager {
	private static Logger logger = LoggerUtility.getLogger(TradeManager.class);


	public TradeManager() {
		
	}
	public static void TradeChecker(ArrayList<Peuple> listePeuple){	//comparera si quel pays peut entrer en commerce avec un autre
		//routine de d�clenchement ou non du commerce (commerce ponctuel)
		int seuil =  100;
		
		for(int i = 0; i < listePeuple.size();i++){
			for(int j = (i+1); j < listePeuple.size(); j++ ){	 //de cette fa�on on �vitera un d�doublement du commerce
				
				if(((int)(listePeuple.get(i).getAttractivite() + listePeuple.get(j).getAttractivite()) >= seuil) && !(listePeuple.get(i).getListeEnnemies().contains(listePeuple.get(j)))){	//si la somme de leur attractivit�es est suffisante et si ils ne sont pas ennemies
					TradeManager.trade(listePeuple.get(i),listePeuple.get(j));
				}
				
			}
		}
	}
	
	private static void trade(Peuple p1,Peuple p2){	//Cons�quences de la guerre
		//A ajouter : un facteur al�atoire
		double taux = 0.001;	//� ajouter pour �viter un enrichissement trop rapide
		p1.setRessources(p1.getRessources() + (taux*(p2.getAttractivite()* p1.getPuissancePolitique())));
		p2.setRessources(p2.getRessources() + (taux*(p1.getAttractivite()* p2.getPuissancePolitique())));

		//System.out.println("Commerce entre " + p1.getNom() + " et " + p2.getNom());	  // TODO /!\ A REMPLACER PAR L'AJOUT DANS UNE FILE
		logger.info("Commerce entre " + p1.getNom() + " et " + p2.getNom() + " iteration : " + TestRunningLoop.nbIteration);


	}
}
