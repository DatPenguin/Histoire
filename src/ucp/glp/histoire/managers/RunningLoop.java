package ucp.glp.histoire.managers;

import org.apache.log4j.Logger;
import ucp.glp.histoire.log.LoggerUtility;
import ucp.glp.histoire.test.TestRunningLoop;
import ucp.glp.histoire.utilities.Peuple;

import java.util.ArrayList;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Université de Cergy-Pontoise
 * @date 2016-2017
 */
public class RunningLoop {
    private static Logger logger = LoggerUtility.getLogger(RunningLoop.class);
    private EventChanceManager eventChanceManager;
    private ArrayList<Peuple> listePeuple;
    private GrowthManager growthManager;

    public RunningLoop (ArrayList<Peuple> listePeuple){
        this.listePeuple = listePeuple;
        eventChanceManager = new EventChanceManager();
        this.growthManager = new GrowthManager(this.listePeuple);
    }

    public void loopAction (){										//voir logigramme

        PeupleManager.genereEnsembleTotal(listePeuple);

        eventChanceManager.actionLocale(listePeuple);

        eventChanceManager.actionGlobale(listePeuple);

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

    }

    /**
     * Enverra toute les stats de chaque pays dans les logs
     */
    public void logDisplayGlobalStat(){
        for(int i = 0; i < listePeuple.size() ; i++){
            logger.trace(listePeuple.get(i).toString() + " iteration : " + TestRunningLoop.nbIteration);
        }
    }

}
