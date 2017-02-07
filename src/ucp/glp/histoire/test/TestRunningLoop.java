package ucp.glp.histoire.test;

import java.util.ArrayList;

import ucp.glp.histoire.managers.RunningLoop;
import ucp.glp.histoire.utilitaires.Peuple;

public class TestRunningLoop {

	public static void main(String[] args) {
		Peuple p1 = new Peuple(30,40,10,70,10,"belge");
		Peuple p2 = new Peuple(25,10,10,25,22,"Grec");
		ArrayList<Peuple> listePeuple = new ArrayList<Peuple>();
		listePeuple.add(p1);
		listePeuple.add(p2);
		
		RunningLoop runningLoop = new RunningLoop(listePeuple);
		System.out.println(p1.toString());
		runningLoop.loopAction();
		System.out.println(p1.toString()); 

		
		
	}

}
