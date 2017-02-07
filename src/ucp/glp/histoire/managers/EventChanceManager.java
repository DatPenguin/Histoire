package ucp.glp.histoire.managers;

import ucp.glp.histoire.utilitaires.Peuple;

import java.util.ArrayList;



public class EventChanceManager {

	// Le taux repr�sente la chance de d�clenchement d'un evenement
	private static int tauxLocal = 30;
	private static int tauxGlobal = 50;
	private static int tauxReaction = 80;
	private EventLocalManager eventLocalManager;
	private EventGlobalManager eventGlobalManager;
	private EventReactionManager eventReactionManager;

	// L'appel de leur constructeur permettra d'initialiser les diff�rentes listes d'events
	public EventChanceManager(){
		eventLocalManager = new EventLocalManager();
		eventGlobalManager = new EventGlobalManager();
		eventReactionManager = new EventReactionManager();
	}


	public void actionLocale(ArrayList<Peuple> al) {        // Va pour chaque pays tester si ils leur arrive un evenement ou non
		for(int i = 0; i < al.size(); i++){
			int randNumb = (int) (Math.random() * 101);    // Generera un nombre al�atoire compris entre [0,100]
			if(randNumb < tauxLocal){
				eventLocalManager.action(al.get(i));
			}
		}
		
	}
	public void actionGlobale(ArrayList<Peuple> al){
		int randNumb = (int) (Math.random() * 101);        // Generera un nombre al�atoire compris entre [0,100]
		if(randNumb < tauxGlobal){
			eventGlobalManager.action(al);
		}
	}
	public void reaction(ArrayList<Peuple> al){
		for(int i = 0; i < al.size(); i++){
			int randNumb = (int) (Math.random() * 101);    // Generera un nombre al�atoire compris entre [0,100]
			if(randNumb < tauxReaction){
				eventReactionManager.action(al.get(i));
			}
		}
	}
	

}
