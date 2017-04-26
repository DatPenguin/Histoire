package ucp.glp.histoire.managers;

import ucp.glp.histoire.event.global.GlobalHistoricEvent;
import ucp.glp.histoire.utilities.Peuple;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Université de Cergy-Pontoise
 * @date 2016-2017
 */
public class EventChanceManager {

	// Le taux représente la chance de déclenchement d'un evenement
	private static int tauxLocal = 10;
	private static int tauxGlobal = 15;
	private static int tauxReaction = 20;
	private EventLocalManager eventLocalManager;
	private EventGlobalManager eventGlobalManager;
	private EventReactionManager eventReactionManager;

	// L'appel de leur constructeur permettra d'initialiser les différentes listes d'events
	public EventChanceManager(){
		eventLocalManager = new EventLocalManager();
		eventGlobalManager = new EventGlobalManager();
		eventReactionManager = new EventReactionManager();
	}


	public void actionLocale(ArrayList<Peuple> listePeuple) {        // Va pour chaque pays tester si ils leur arrive un evenement ou non
		for(int i = 0; i < listePeuple.size(); i++){
			int randNumb = (int) (Math.random() * 101);   			 // Generera un nombre aléatoire compris entre [0,100]
			if(randNumb < tauxLocal){
				eventLocalManager.action(listePeuple.get(i));
			}
		}
		
	}
	public void actionGlobale(ArrayList<Peuple> listePeuple){
		int randNumb = (int) (Math.random() * 101);					// Generera un nombre aléatoire compris entre [0,100]
		if(randNumb < tauxGlobal){
			eventGlobalManager.action(listePeuple);
		}
	}
	public void reaction(ArrayList<Peuple> listePeuple){
		for(int i = 0; i < listePeuple.size(); i++){
			int randNumb = (int) (Math.random() * 101);				// Generera un nombre aléatoire compris entre [0,100]
			if(randNumb < tauxReaction){
				eventReactionManager.action(listePeuple.get(i));
			}
		}
	}
	/**
	 * Sera utilisé quand on voudra lancer des évément manuellement depuis l'ihm
	 * @param listePeuple
	 * @param fileGlobalEvent
	 */
	public void forcedGlobale(ArrayList<Peuple> listePeuple, ArrayDeque<GlobalHistoricEvent> fileGlobalEvent){
		while( ! fileGlobalEvent.isEmpty() ){							// tant que la file n'es pas vide on effectuera les différent évément
			eventGlobalManager.forcedAction(listePeuple, fileGlobalEvent.pop());
		}
	}
	

}
