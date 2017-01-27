package ucp.glp.histoire.managers;

import java.util.ArrayList;

import ucp.glp.histoire.utilitaires.Peuple;



public class EventChanceManager {
	//Le taux représente la chance de déclenchement d'un evenement
	private static int taux = 30;
	EventLocalManager elm;

	public EventChanceManager(){
		elm = new EventLocalManager();
	}
	
	
	public void action(ArrayList<Peuple> al){	//va pour chaque pays tester si ils leur arrive un evenement ou non
		for(int i = 0; i < al.size(); i++){
			int randNumb = (int) (Math.random() * 101); //generera un nombre aléatoire compris entre [0,100]
			if(randNumb < taux){
				elm.action(al.get(i));
			}
		}
		
	}
	
	

}
