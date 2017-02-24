package ucp.glp.histoire.managers;

import java.util.ArrayList;

import ucp.glp.histoire.utilitaires.Peuple;

/**
 * Gestionnaire de croissance et d'immigration
 * @author mhannoun
 *
 */
public class GrowthManager {
	
	/**
	 * Gère la croissance à chaque tour pour chaque pays
	 * @param listePeuple
	 */
	public static void growthAction(ArrayList<Peuple> listePeuple){
		
		// TODO affiner la croissance
		int growth = 1;
		for(int i = 0 ; i < listePeuple.size() ; i++){
			listePeuple.get(i).setPopulation(listePeuple.get(i).getPopulation() + growth);
		}
	}
	
	/**
	 * Gère la croissance à chaque tour pour chaque pays
	 * @param listePeuple
	 */
	public static void immigrationAction (ArrayList<Peuple> listePeuple){
		// TODO affiner l'imigration
		for(int i = 0 ; i < listePeuple.size() ; i++){
			listePeuple.get(i).setPopulation(listePeuple.get(i).getPopulation() + listePeuple.get(i).getImigration());
		}
	}
	

}
