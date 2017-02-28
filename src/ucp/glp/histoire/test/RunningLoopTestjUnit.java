package ucp.glp.histoire.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ucp.glp.histoire.log.LoggerUtility;
import ucp.glp.histoire.managers.RunningLoop;
import ucp.glp.histoire.utilitaires.Peuple;

public class RunningLoopTestjUnit {
	private static Logger logger = LoggerUtility.getLogger(RunningLoopTestjUnit.class);

	private RunningLoop runningLoop;
	private ArrayList<Peuple> listePeuple;
	private int index;

	@Before
	public void setUp() throws Exception {
		Peuple p1 = new Peuple(50,50,50,70,50,"belge");
		Peuple p2 = new Peuple(90,80,50,25,22,"Grec");
		this.listePeuple = new ArrayList<Peuple>();

		listePeuple.add(p1);
		listePeuple.add(p2);
		
		runningLoop = new RunningLoop(listePeuple);

	}
	@Test
	public void test() {
		this.index = 0;
		
		// Résultat incohérent passé 100 000 itération
		for(int i = 0 ; i < 10000 ; i++){
			runningLoop.loopAction();
			index = i;
		}
		// Testera si tout les peuples ont bien une population positive
		for(int n = 0 ; n < listePeuple.size() ; n++){
			assertTrue(0<this.listePeuple.get(n).getPopulation());
			//logger.warn("POPULATION P" + n + " : " + listePeuple.get(n).getPopulation());

		}
	}
	
	@After
	public void after() {
		for(int n = 0 ; n < listePeuple.size() ; n++){
			logger.warn("POPULATION P" + n + " : " + listePeuple.get(n).getPopulation());
		}
	}

}
