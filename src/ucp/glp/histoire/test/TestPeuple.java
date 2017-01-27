package ucp.glp.histoire.test;

import java.util.ArrayList;

import ucp.glp.histoire.managers.EventLocalManager;
import ucp.glp.histoire.managers.GuerreManager;
import ucp.glp.histoire.managers.PeupleManager;
import ucp.glp.histoire.managers.TradeManager;
import ucp.glp.histoire.utilitaires.Peuple;

public class TestPeuple {

	public static void main(String[] args) {
		Peuple p1 = new Peuple(90,40,10,70,10,"belge");
		Peuple p2 = new Peuple(75,10,10,25,22,"Grec");
		EventLocalManager ELM = new EventLocalManager();
		
		ArrayList<Peuple> listePeuple = new ArrayList<Peuple>();
		listePeuple.add(p1);
		
		for(int i=0; i < 3; i++){
		System.out.println(p1.toString());
		PeupleManager.genereEnsembleTotal(listePeuple);
		ELM.action(p1);
		System.out.println(p1.toString());

		GuerreManager.guerreChecker(listePeuple);
		TradeManager.TradeChecker(listePeuple);
		System.out.println(p1.toString());
		PeupleManager.genereEnsembleTotal(listePeuple);
		System.out.println(p1.toString());
		}

		
		
	}

}
