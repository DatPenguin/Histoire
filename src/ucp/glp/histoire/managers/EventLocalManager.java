package ucp.glp.histoire.managers;
import java.util.ArrayList;

import ucp.glp.event.*;
import ucp.glp.histoire.utilitaires.Peuple;

public class EventLocalManager {
	protected ArrayList<LocalHistoricEvent> EventList;
	public EventLocalManager(){
		EventList = new ArrayList<LocalHistoricEvent>();
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
		//EventList.get(randEvent).action(p, RandAmp);
		EventLocalManager.actionOnPeuple(EventList.get(randEvent),p,RandAmp);
		System.out.println(EventList.get(randEvent).toString(p));
	}
	public static void actionOnPeuple(LocalHistoricEvent hEvent, Peuple p,int amplitude){
	
			
			
			switch(hEvent.getType()){
				case 0 :
					p.setRessources(p.getRessources() + (hEvent.getPuissance() * EventLocalManager.genereAmpReel(amplitude)));
					break;
				case 1 :
					p.setPopulation(p.getPopulation() + (int)(hEvent.getPuissance()  * EventLocalManager.genereAmpReel(amplitude)));
					break;
				case 2 : 
					p.setAgressivite(p.getAgressivite() + (hEvent.getPuissance()  * EventLocalManager.genereAmpReel(amplitude)));
					break;
				case 3 :
					p.setEducation(p.getEducation() + (hEvent.getPuissance()  * EventLocalManager.genereAmpReel(amplitude)));
					break;
				case 4 :
					p.setTerritoire(p.getTerritoire() + (hEvent.getPuissance()  * EventLocalManager.genereAmpReel(amplitude)));
					break;
				default:
				    System.out.println("ERREUR ENTREE action EVENT" + hEvent.getNom());
			
			
			}
	}
	
	public static double genereAmpReel(int amplitude){	//méthode gérant les différant coeficient multiplicateur
		switch(amplitude){
		case 0:
			return 0.5;
		case 1 :
			return 1.0;
		case 2 :
			return 2.0;
		default:
		    System.out.println("ERREUR ENTREE genereAmpReel EVENT");
		    return -1;
		}

	}
			
	

}
