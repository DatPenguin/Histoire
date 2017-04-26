package ucp.glp.histoire.managers;

import ucp.glp.histoire.event.global.GlobalHistoricEvent;
import ucp.glp.histoire.event.global.GlobalWarming;
import ucp.glp.histoire.event.global.Seisme;
import ucp.glp.histoire.utilities.Peuple;

import java.util.ArrayList;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Université de Cergy-Pontoise
 * @date 2016-2017
 */
public class EventGlobalManager extends EventManager{
    private ArrayList<GlobalHistoricEvent> GlobalEventList;

    public EventGlobalManager(){
        GlobalEventList = new ArrayList<GlobalHistoricEvent>();
        genererEventList();

    }

    public static void actionOnPeuple(GlobalHistoricEvent hEvent, ArrayList<Peuple> listP, int amplitude){
        for(int i = 0; i < listP.size(); i++){
            calculEffect(hEvent,listP.get(i),amplitude);
        }
    }

    public static void calculEffect(GlobalHistoricEvent hEvent, Peuple p, int amplitude){


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

        // On ajoutera une instance de chanque classe global event
        GlobalEventList.add(new Seisme());
        GlobalEventList.add(new GlobalWarming());
    }

    public void action(ArrayList<Peuple> listP) {

        // TODO Ajouter un systeme de condition directement dans les events et une methode de check
        // TODO Remplacer le System.out.println par un ajout a la pile des messages a afficher
        int randEvent = (int) (Math.random() * (GlobalEventList.size()));                            // Generera un nombre aléatoire compris entre [0,size]
        int RandAmp = (int) (Math.random() * (3));                                                   // Generera un nombre aléatoire compris entre [0,2]
        //GlobalEventList.get(randEvent).action(listP, RandAmp);
        EventGlobalManager.actionOnPeuple(GlobalEventList.get(randEvent), listP, RandAmp);
        System.out.println(GlobalEventList.get(randEvent).toString());
        RunningLoop.addTotextLog(GlobalEventList.get(randEvent).toString());

    }
    public void forcedAction(ArrayList<Peuple> listP,GlobalHistoricEvent forcedEvent) {
    	
        int RandAmp = (int) (Math.random() * (3));                                                  // Generera un nombre aléatoire compris entre [0,2]
        EventGlobalManager.actionOnPeuple(forcedEvent, listP, RandAmp);
        System.out.println(forcedEvent.toString());
        RunningLoop.addTotextLog(forcedEvent.toString());

    }


}
