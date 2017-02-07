package ucp.glp.histoire.test;

import java.util.ArrayList;

import ucp.glp.histoire.managers.RunningLoop;
import ucp.glp.histoire.utilitaires.Peuple;

public class TestRunningLoop {

	public static void main(String[] args) {
		Peuple p1 = new Peuple(50,50,50,70,10,"belge");
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

		int nbIteration = 0;
		while(p1.getPopulation() > 0 && p2.getPopulation() > 0){
			nbIteration++;
			runningLoop.loopAction();
		}
		System.out.println(p1.toString()); 
		System.out.println(p2.toString());
		System.out.println(nbIteration); 


		
		
	}

}
