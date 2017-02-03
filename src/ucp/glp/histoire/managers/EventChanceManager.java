package ucp.glp.histoire.managers;

import ucp.glp.histoire.utilitaires.Peuple;

import java.util.ArrayList;



public class EventChanceManager {

	// Le taux représente la chance de déclenchement d'un evenement
	private static int tauxLocal = 30;
	private static int tauxGlobal = 50;
	EventLocalManager elm;
	EventGlobalManager egm;

	public EventChanceManager(){
		elm = new EventLocalManager();
		egm = new EventGlobalManager();
	}


	public void actionLocale(ArrayList<Peuple> al) {        // Va pour chaque pays tester si ils leur arrive un evenement ou non
		for(int i = 0; i < al.size(); i++){
			int randNumb = (int) (Math.random() * 101);    // Generera un nombre aléatoire compris entre [0,100]
			if(randNumb < tauxLocal){
				elm.action(al.get(i));
			}
		}
		
	}
	public void actionGlobale(ArrayList<Peuple> al){
		int randNumb = (int) (Math.random() * 101);        // Generera un nombre aléatoire compris entre [0,100]
		if(randNumb < tauxLocal){
			egm.action(al);
		}
	}
	
	

}
