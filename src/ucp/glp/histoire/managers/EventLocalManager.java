package ucp.glp.histoire.managers;

import ucp.glp.histoire.event.CriseFinanciere;
import ucp.glp.histoire.event.Famine;
import ucp.glp.histoire.event.LocalHistoricEvent;
import ucp.glp.histoire.utilitaires.Peuple;

import java.util.ArrayList;

public class EventLocalManager extends EventManager{
	private ArrayList<LocalHistoricEvent> localEventList;
	public EventLocalManager(){
		localEventList = new ArrayList<LocalHistoricEvent>();
		genererEventList();
			
	}
	
	public static void actionOnPeuple(LocalHistoricEvent hEvent, Peuple p,int amplitude){


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
				    break;

		}
	}
	// TODO Remove
	/*
	public static double genereAmpReel(int amplitude) {    // Méthode gérant les différant coeficient multiplicateur
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
	*/
	public void genererEventList() {

		// On ajoutera une instance de chanque classe event
		localEventList.add(new Famine());
		localEventList.add(new CriseFinanciere());
	}

	public void action(Peuple p) {

		// TODO Ajouter : un systeme de condition directement dans les events et une methode de check
		// TODO Remplacer le System.out.println par un ajout a la file des messages a afficher
		int randEvent = (int) (Math.random() * (localEventList.size()));    // Generera un nombre aléatoire compris entre [0,size]
		int RandAmp = (int) (Math.random() * (3));                    // Generera un nombre aléatoire compris entre [0,2]
		//EventList.get(randEvent).action(p, RandAmp);
		EventLocalManager.actionOnPeuple(localEventList.get(randEvent), p, RandAmp);
		System.out.println(localEventList.get(randEvent).toString(p));
	}
			
	

}
