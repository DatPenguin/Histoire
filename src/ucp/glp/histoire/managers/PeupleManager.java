package ucp.glp.histoire.managers;

import java.util.ArrayList;

import ucp.glp.histoire.utilitaires.Peuple;

public class PeupleManager {
	
	public static void genereEnsembleTotal(ArrayList<Peuple> listePeuple){
		for(int i = 0;i < listePeuple.size();i++){
			listePeuple.get(i).genereEnsemble();			
		}
	}

}
