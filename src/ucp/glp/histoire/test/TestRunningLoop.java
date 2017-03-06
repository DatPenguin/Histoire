package ucp.glp.histoire.test;

import org.apache.log4j.Logger;
import ucp.glp.histoire.log.LoggerUtility;
import ucp.glp.histoire.managers.RunningLoop;
import ucp.glp.histoire.utilities.Peuple;

import java.util.ArrayList;


public class TestRunningLoop {
		// TODO placer nbIteration dans une classe directrice
		public static int nbIteration = 0;	// Permettra de connaitre à quel itération l'on se trouve pour les logs
    private static Logger logger = LoggerUtility.getLogger(TestRunningLoop.class);

	public static void main(String[] args) {
		
		logger.info("Lancement test");

		Peuple p1 = new Peuple(50,50,50,70,50,"belge");
		Peuple p2 = new Peuple(90,80,50,25,22,"Grec");
		ArrayList<Peuple> listePeuple = new ArrayList<Peuple>();
		listePeuple.add(p1);
		listePeuple.add(p2);
		
		RunningLoop runningLoop = new RunningLoop(listePeuple);
		System.out.println(p1.toString());
		System.out.println(p2.toString());

		runningLoop.loopAction();
		System.out.println(p1.toString()); 
		System.out.println(p2.toString());

		
		TestRunningLoop.nbIteration = 0;
		/*
		while(p1.getPopulation() > 0 && p2.getPopulation() > 0){
			TestRunningLoop.nbIteration++;
			runningLoop.loopAction();
		}
		*/
		for(int i = 0 ; i < 100 ; i++){
			TestRunningLoop.nbIteration++;
			runningLoop.loopAction();
			if(p1.getPopulation() <= 0 ){
				logger.warn("POPULATION NULLE p1 pop  = " + p1.getPopulation() + " iteration : " + TestRunningLoop.nbIteration);
			}
			if(p2.getPopulation() <= 0 ){
				logger.warn("POPULATION NULLE p2 pop  = " + p2.getPopulation() + " iteration : " + TestRunningLoop.nbIteration);

			}
		}
		System.out.println(p1.toString()); 
		System.out.println(p2.toString());
		System.out.println(nbIteration); 


		
		
	}

}
