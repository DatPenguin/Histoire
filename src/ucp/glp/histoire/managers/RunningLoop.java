package ucp.glp.histoire.managers;

import java.util.ArrayList;

import ucp.glp.histoire.utilitaires.Peuple;

public class RunningLoop {
	EventChanceManager eventChanceManager;
	ArrayList<Peuple> listePeuple;
	public RunningLoop (ArrayList<Peuple> listePeuple){
		this.listePeuple = listePeuple;
		eventChanceManager = new EventChanceManager();
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

	}
	

}
