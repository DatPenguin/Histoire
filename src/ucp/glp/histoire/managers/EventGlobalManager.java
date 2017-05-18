package ucp.glp.histoire.managers;

import ucp.glp.histoire.event.global.GlobalHistoricEvent;
import ucp.glp.histoire.event.global.GlobalWarming;
import ucp.glp.histoire.event.global.Seisme;
import ucp.glp.histoire.utilities.Peuple;

import java.util.ArrayList;

/**
 * Gestionnaire d'évènements globaux
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Université de Cergy-Pontoise
 * @date 2016-2017
 */
public class EventGlobalManager extends EventManager {
    private final ArrayList<GlobalHistoricEvent> GlobalEventList;

    public EventGlobalManager() {
        GlobalEventList = new ArrayList<GlobalHistoricEvent>();
        genererEventList();
    }

    /**
     * Gère les effets des actions sur chaque peuple
     * @param hEvent
     * @param listP
     * @param amplitude
     */
    private static void actionOnPeuple(GlobalHistoricEvent hEvent, ArrayList<Peuple> listP, int amplitude) {
        for (Peuple aListP : listP)
            calculEffect(hEvent, aListP, amplitude);
    }

    /**
     * Calcule les effets des actions sur un peuple
     * @param hEvent
     * @param p
     * @param amplitude
     */
    private static void calculEffect(GlobalHistoricEvent hEvent, Peuple p, int amplitude) {
        switch (hEvent.getType()) {
            case 0:
                p.setRessources(p.getRessources() + (hEvent.getPuissance() * EventLocalManager.genereAmpReel(amplitude)));
                break;
            case 1:
                p.setPopulation(p.getPopulation() + (int) (hEvent.getPuissance() * EventLocalManager.genereAmpReel(amplitude)));
                break;
            case 2:
                p.setAgressivite(p.getAgressivite() + (hEvent.getPuissance() * EventLocalManager.genereAmpReel(amplitude)));
                break;
            case 3:
                p.setEducation(p.getEducation() + (hEvent.getPuissance() * EventLocalManager.genereAmpReel(amplitude)));
                break;
            case 4:
                p.setTerritoire(p.getTerritoire() + (hEvent.getPuissance() * EventLocalManager.genereAmpReel(amplitude)));
                break;
            default:
                System.out.println("ERREUR ENTREE action EVENT" + hEvent.getNom());
                break;
        }
    }

    /**
     * Génère la liste des events possibles
     */
    public void genererEventList() {
        GlobalEventList.add(new Seisme());
        GlobalEventList.add(new GlobalWarming());
    }

    /**
     * Lance des évènements aléatoires
     * @param listP
     */
    public void action(ArrayList<Peuple> listP) {
        int randEvent = (int) (Math.random() * (GlobalEventList.size()));                            // Generera un nombre aléatoire compris entre [0,size]
        int RandAmp = (int) (Math.random() * (3));                                                   // Generera un nombre aléatoire compris entre [0,2]
        EventGlobalManager.actionOnPeuple(GlobalEventList.get(randEvent), listP, RandAmp);
        System.out.println(GlobalEventList.get(randEvent).toString());
        RunningLoop.addTotextLog(GlobalEventList.get(randEvent).toString());
    }

    /**
     * Lance les évènements choisis manuellement
     * @param listP
     * @param forcedEvent
     */
    public void forcedAction(ArrayList<Peuple> listP, GlobalHistoricEvent forcedEvent) {
        int RandAmp = (int) (Math.random() * (3));                                                  // Generera un nombre aléatoire compris entre [0,2]
        EventGlobalManager.actionOnPeuple(forcedEvent, listP, RandAmp);
        System.out.println(forcedEvent.toString());
        RunningLoop.addTotextLog(forcedEvent.toString());
    }
}
