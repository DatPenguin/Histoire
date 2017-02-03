package ucp.glp.histoire.managers;

import java.util.ArrayList;

import ucp.glp.histoire.event.LocalHistoricEvent;
import ucp.glp.histoire.event.ReactionEvent;
import ucp.glp.histoire.utilitaires.Peuple;

public class EventReactionManager extends EventManager{
	
	protected ArrayList<ReactionEvent> ReactionEventList;
	public EventReactionManager(){
		ReactionEventList = new ArrayList<ReactionEvent>();
		genererEventList();
			
	}	
	
	public static void actionOnPeuple(ReactionEvent hEvent, Peuple p,int amplitude){

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

	public void genererEventList() {
	
		// On ajoutera une instance de chanque classe event
		
	}
	public void action(Peuple p) {

		// TODO Ajouter : un systeme de condition directement dans les events et une methode de check
		// TODO Remplacer le System.out.println par un ajout a la file des messages a afficher
		int randEvent = (int) (Math.random() * (ReactionEventList.size()));    // Generera un nombre aléatoire compris entre [0,size]
		int RandAmp = (int) (Math.random() * (3));                    // Generera un nombre aléatoire compris entre [0,2]
		
		switch(ReactionEventList.get(randEvent).getConditionType()) {			// Testera si l'attribut donné du peuple corresponds est bien supérieur au seuil
		case 0 :
			if(p.getRessources() >= ReactionEventList.get(randEvent).getSeuil()){
				EventReactionManager.actionOnPeuple(ReactionEventList.get(randEvent), p, RandAmp);
				System.out.println(ReactionEventList.get(randEvent).toString(p));
			}
			break;
		case 1 :
			if(p.getPopulation() >= ReactionEventList.get(randEvent).getSeuil()){
				EventReactionManager.actionOnPeuple(ReactionEventList.get(randEvent), p, RandAmp);
				System.out.println(ReactionEventList.get(randEvent).toString(p));
			}
			break;
		case 2:
			if(p.getAgressivite() >= ReactionEventList.get(randEvent).getSeuil()){
				EventReactionManager.actionOnPeuple(ReactionEventList.get(randEvent), p, RandAmp);
				System.out.println(ReactionEventList.get(randEvent).toString(p));
			}
			break;
		case 3 :
			if(p.getEducation() >= ReactionEventList.get(randEvent).getSeuil()){
				EventReactionManager.actionOnPeuple(ReactionEventList.get(randEvent), p, RandAmp);
				System.out.println(ReactionEventList.get(randEvent).toString(p));
			}
			break;
		case 4 :
			if(p.getTerritoire() >= ReactionEventList.get(randEvent).getSeuil()){
				EventReactionManager.actionOnPeuple(ReactionEventList.get(randEvent), p, RandAmp);
				System.out.println(ReactionEventList.get(randEvent).toString(p));
			}
			break;
		default:
		    System.out.println("ERREUR ENTREE action EVENT CHECK");
		    break;
		}
		
	}
	
	

}
