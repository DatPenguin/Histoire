package ucp.glp.histoire.managers;

import ucp.glp.histoire.event.GlobalHistoricEvent;
import ucp.glp.histoire.event.Seisme;
import ucp.glp.histoire.utilitaires.Peuple;

import java.util.ArrayList;

public class EventGlobalManager {
	protected ArrayList<GlobalHistoricEvent> GlobalEventList;
	
	public EventGlobalManager(){
		GlobalEventList = new ArrayList<GlobalHistoricEvent>();
		genererEventList();
			
	}
	
	public static void actionOnPeuple(GlobalHistoricEvent hEvent,ArrayList<Peuple> listP,int amplitude){
		for(int i = 0; i < listP.size();i++){
			calculEffect(hEvent,listP.get(i),amplitude);
		}
	}
	
	public static void calculEffect(GlobalHistoricEvent hEvent, Peuple p,int amplitude){


		switch(hEvent.getType()){
			case 0 :
				p.setRessources(p.getRessources() + (hEvent.getPuissance() * EventLocalManager.genereAmpReel(amplitude)));
				break;
			case 1 :
				p.setPopulation(p.getPopulation() + (int)(hEvent.getPuissance()  * EventLocalManager.genereAmpReel(amplitude)));
				break;
			case 2:
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

	public void genererEventList() {
		//on ajoutera une instance de chanque classe global event
		GlobalEventList.add(new Seisme());
	}

	public void action(ArrayList<Peuple> listP) {
		// a ajouter : un systeme de condition directement dans les events et une methode de check
		//remplacer le System.out.println par un ajout a la pile des messages a afficher
		int randEvent = (int) (Math.random() * (GlobalEventList.size() + 1)); //generera un nombre aléatoire compris entre [0,size]
		int RandAmp = (int) (Math.random() * (3)); //generera un nombre aléatoire compris entre [0,2]
		//GlobalEventList.get(randEvent).action(listP, RandAmp);
		EventGlobalManager.actionOnPeuple(GlobalEventList.get(randEvent), listP, RandAmp);
		System.out.println(GlobalEventList.get(randEvent).toString());
	}
	

}
