package ucp.glp.histoire.managers;


import org.apache.log4j.Logger;
import ucp.glp.histoire.event.global.GlobalHistoricEvent;
import ucp.glp.histoire.log.LoggerUtility;
import ucp.glp.histoire.utilities.Peuple;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Université de Cergy-Pontoise
 * @date 2016-2017
 */
public class RunningLoop {
    private static final Logger logger = LoggerUtility.getLogger(RunningLoop.class);
    public static ArrayDeque<GlobalHistoricEvent> fileGlobalEvent;  // File d'événement passée manuellement
    public static int nbIteration = 0;                              // Permettra de connaitre à quelle itération l'on se trouve pour les logs
    private static ArrayList<String> textLog;                       // A été rendu static pour faciliter son accès depuis les différentes classes
    private final EventChanceManager eventChanceManager;
    private final ArrayList<Peuple> listePeuple;
    private final GrowthManager growthManager;

    public RunningLoop(ArrayList<Peuple> listePeuple) {
        RunningLoop.fileGlobalEvent = new ArrayDeque<GlobalHistoricEvent>();
        RunningLoop.textLog = new ArrayList<String>();
        this.listePeuple = listePeuple;
        eventChanceManager = new EventChanceManager();
        this.growthManager = new GrowthManager(this.listePeuple);
    }

    /**
     * Permettra depuis d'autre classe (Cf : Managers) d'ajouter des lignes au logs
     * @param stringToAdd
     */
    public static void addTotextLog(String stringToAdd) {
        textLog.add(stringToAdd);
    }

    /**
     * Voir logigramme
     */
    public void loopAction() {
        PeupleManager.genereEnsembleTotal(listePeuple);
        eventChanceManager.actionLocale(listePeuple);
        eventChanceManager.actionGlobale(listePeuple);
        eventChanceManager.forcedGlobale(listePeuple, RunningLoop.fileGlobalEvent);
        PeupleManager.genereEnsembleTotal(listePeuple);
        GuerreManager.guerreChecker(listePeuple);
        PeupleManager.genereEnsembleTotal(listePeuple);
        TradeManager.TradeChecker(listePeuple);
        PeupleManager.genereEnsembleTotal(listePeuple);
        eventChanceManager.reaction(listePeuple);
        PeupleManager.genereEnsembleTotal(listePeuple);
        this.growthManager.growthAction();
        PeupleManager.genereEnsembleTotal(listePeuple);
        this.growthManager.immigrationAction();
        this.logDisplayGlobalStat();
        RunningLoop.nbIteration++;
    }

    /**
     * Enverra toute les stats de chaque pays dans les logs
     */
    private void logDisplayGlobalStat() {
        for (Peuple aListePeuple : listePeuple) {
            logger.trace(aListePeuple.displayInfo() + " iteration : " + RunningLoop.nbIteration);
        }
    }

    public ArrayList<String> getTextLog() {
        return textLog;
    }
}
