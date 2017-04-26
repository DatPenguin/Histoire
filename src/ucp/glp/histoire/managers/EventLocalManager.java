package ucp.glp.histoire.managers;

import ucp.glp.histoire.event.local.*;
import ucp.glp.histoire.utilities.Peuple;

import java.util.ArrayList;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Université de Cergy-Pontoise
 * @date 2016-2017
 */
public class EventLocalManager extends EventManager {
    private final ArrayList<LocalHistoricEvent> localEventList;

    public EventLocalManager() {
        localEventList = new ArrayList<LocalHistoricEvent>();
        genererEventList();
    }

    private static void actionOnPeuple(LocalHistoricEvent hEvent, Peuple p, int amplitude) {
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

    public void genererEventList() {
        // On ajoutera une instance de chanque classe event
        localEventList.add(new Famine());
        localEventList.add(new CriseFinanciere());
        localEventList.add(new Babyboom());
        localEventList.add(new Inondation());
        localEventList.add(new SurplusNourriture());
    }

    public void action(Peuple p) {
        int randEvent = (int) (Math.random() * (localEventList.size()));    // Generera un nombre aléatoire compris entre [0,size]
        int RandAmp = (int) (Math.random() * (3));                    // Generera un nombre aléatoire compris entre [0,2]
        EventLocalManager.actionOnPeuple(localEventList.get(randEvent), p, RandAmp);
        System.out.println(localEventList.get(randEvent).toString(p));
        RunningLoop.addTotextLog(localEventList.get(randEvent).toString(p));

    }
}
