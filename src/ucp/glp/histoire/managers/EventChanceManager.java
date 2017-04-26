package ucp.glp.histoire.managers;

import ucp.glp.histoire.event.global.GlobalHistoricEvent;
import ucp.glp.histoire.utilities.Peuple;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Universit� de Cergy-Pontoise
 * @date 2016-2017
 */
public class EventChanceManager {

    // Le taux repr�sente la chance de d�clenchement d'un evenement
    private static final int tauxLocal = 10;
    private static final int tauxGlobal = 15;
    private static final int tauxReaction = 20;
    private final EventLocalManager eventLocalManager;
    private final EventGlobalManager eventGlobalManager;
    private final EventReactionManager eventReactionManager;

    // L'appel de leur constructeur permettra d'initialiser les diff�rentes listes d'events
    public EventChanceManager() {
        eventLocalManager = new EventLocalManager();
        eventGlobalManager = new EventGlobalManager();
        eventReactionManager = new EventReactionManager();
    }

    public void actionLocale(ArrayList<Peuple> listePeuple) {       // Va pour chaque pays tester si il leur arrive un evenement ou non
        for (Peuple aListePeuple : listePeuple) {
            int randNumb = (int) (Math.random() * 101);             // Generera un nombre al�atoire compris entre [0,100]
            if (randNumb < tauxLocal)
                eventLocalManager.action(aListePeuple);
        }
    }

    public void actionGlobale(ArrayList<Peuple> listePeuple) {
        int randNumb = (int) (Math.random() * 101);                 // Generera un nombre al�atoire compris entre [0,100]
        if (randNumb < tauxGlobal)
            eventGlobalManager.action(listePeuple);
    }

    public void reaction(ArrayList<Peuple> listePeuple) {
        for (Peuple aListePeuple : listePeuple) {
            int randNumb = (int) (Math.random() * 101);             // Generera un nombre al�atoire compris entre [0,100]
            if (randNumb < tauxReaction)
                eventReactionManager.action(aListePeuple);
        }
    }

    /**
     * Sera utilis� quand on voudra lancer des �v�ment manuellement depuis l'ihm
     *
     * @param listePeuple
     * @param fileGlobalEvent
     */
    public void forcedGlobale(ArrayList<Peuple> listePeuple, ArrayDeque<GlobalHistoricEvent> fileGlobalEvent) {
        while (!fileGlobalEvent.isEmpty())                          // Tant que la file n'est pas vide on effectuera les diff�rent �v�nements
            eventGlobalManager.forcedAction(listePeuple, fileGlobalEvent.pop());
    }
}
