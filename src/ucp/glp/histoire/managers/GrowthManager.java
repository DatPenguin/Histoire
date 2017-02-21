package ucp.glp.histoire.managers;

import java.util.ArrayList;

import ucp.glp.histoire.utilitaires.Peuple;

public class GrowthManager {
	public static void action(ArrayList<Peuple> listePeuple){
		
		// TODO affiner la croissance
		int growth = 1;
		for(int i = 0 ; i < listePeuple.size() ; i++){
			listePeuple.get(i).setPopulation(listePeuple.get(i).getPopulation() + growth);
		}
	}

}
