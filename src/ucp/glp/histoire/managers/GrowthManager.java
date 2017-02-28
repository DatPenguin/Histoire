package ucp.glp.histoire.managers;

import java.util.ArrayList;

import ucp.glp.histoire.utilitaires.ImmigrationPool;
import ucp.glp.histoire.utilitaires.Peuple;

/**
 * Gestionnaire de croissance et d'immigration
 * @author mhannoun
 *
 */
public class GrowthManager {
	private ImmigrationPool immigrationPool;
	private ArrayList<Peuple> listePeuple;
	
	public GrowthManager(ArrayList<Peuple> listePeuple){
		this.listePeuple = listePeuple;
		immigrationPool = new ImmigrationPool(this.listePeuple);
	}
	
	
	/**
	 * Gère la croissance à chaque tour pour chaque pays
	 * @param listePeuple
	 */
	public void growthAction(){
		
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
	public void immigrationAction (){
		// TODO affiner l'imigration
		this.immigrationPool.fillPool();
		this.immigrationPool.emptyPool();
	}
	

}
