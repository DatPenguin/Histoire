package ucp.glp.histoire.managers;
import java.util.ArrayList;

import ucp.glp.event.*;
import ucp.glp.histoire.utilitaires.Peuple;

public class EventLocalManager {
	protected ArrayList<Event> EventList;
	public EventLocalManager(){
		EventList = new ArrayList<Event>();
		genererEventList();
			
	}
	
	public void genererEventList(){
		//on ajoutera une instance de chanque classe event
		EventList.add(new Famine());
		EventList.add(new CriseFinanciere());		
	}
	
	public void action(Peuple p){
		// a ajouter : un systeme de condition directement dans les events et une methode de check
		//remplacer le System.out.println par un ajout a la pile des messages a afficher
		int randEvent = (int)(Math.random() * (EventList.size() + 1)); //generera un nombre aléatoire compris entre [0,size]
		int RandAmp = (int)(Math.random() * (3)); //generera un nombre aléatoire compris entre [0,2]
		EventList.get(randEvent).action(p, RandAmp);
		System.out.println(EventList.get(randEvent).toString(p));
	}
	

}
