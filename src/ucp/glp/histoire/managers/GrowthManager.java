package ucp.glp.histoire.managers;

import ucp.glp.histoire.utilities.ImmigrationPool;
import ucp.glp.histoire.utilities.Peuple;

import java.util.ArrayList;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Université de Cergy-Pontoise
 * @date 2016-2017
 * Gestionnaire de croissance et d'immigration
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
	 */
	public void immigrationAction (){
		// TODO affiner l'imigration
		this.immigrationPool.fillPool();
		this.immigrationPool.emptyPool();
	}
	

}
