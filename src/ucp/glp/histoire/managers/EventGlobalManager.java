package ucp.glp.histoire.managers;

import java.util.ArrayList;

import ucp.glp.event.*;
import ucp.glp.histoire.utilitaires.Peuple;

public class EventGlobalManager {
	protected ArrayList<GlobalHistoricEvent> GlobalEventList;
	
	public EventGlobalManager(){
		GlobalEventList = new ArrayList<GlobalHistoricEvent>();
		genererEventList();
			
	}
	
	public void genererEventList(){
		//on ajoutera une instance de chanque classe global event
		GlobalEventList.add(new Seisme());
	}
	
	public void action(ArrayList<Peuple> listP){
		// a ajouter : un systeme de condition directement dans les events et une methode de check
		//remplacer le System.out.println par un ajout a la pile des messages a afficher
		int randEvent = (int)(Math.random() * (GlobalEventList.size() + 1)); //generera un nombre aléatoire compris entre [0,size]
		int RandAmp = (int)(Math.random() * (3)); //generera un nombre aléatoire compris entre [0,2]
		GlobalEventList.get(randEvent).action(listP, RandAmp);
		System.out.println(GlobalEventList.get(randEvent).toString());
	}
	

}
