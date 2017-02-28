package ucp.glp.histoire.managers;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import ucp.glp.histoire.log.LoggerUtility;
import ucp.glp.histoire.test.TestRunningLoop;
import ucp.glp.histoire.utilitaires.Peuple;

public class RunningLoop {
	private EventChanceManager eventChanceManager;
	private ArrayList<Peuple> listePeuple;
	private GrowthManager growthManager;
	private static Logger logger = LoggerUtility.getLogger(RunningLoop.class);

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
