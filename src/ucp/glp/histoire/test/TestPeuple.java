package ucp.glp.histoire.test;

import ucp.glp.histoire.managers.EventChanceManager;
import ucp.glp.histoire.managers.GuerreManager;
import ucp.glp.histoire.managers.PeupleManager;
import ucp.glp.histoire.managers.TradeManager;
import ucp.glp.histoire.utilities.Peuple;

import java.awt.*;
import java.util.ArrayList;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Université de Cergy-Pontoise
 * @date 2016-2017
 */
public class TestPeuple {
	public static void main(String[] args) {
        Peuple p1 = new Peuple(90, 40, 10, 70, 10, "belge", Color.black);
        Peuple p2 = new Peuple(75, 10, 10, 25, 22, "Grec", Color.BLUE);
        EventChanceManager ecm = new EventChanceManager();
		ArrayList<Peuple> listePeuple = new ArrayList<Peuple>();
		listePeuple.add(p1);

		for(int i = 0; i < 50; i++){
			//System.out.println(p1.toString());
			PeupleManager.genereEnsembleTotal(listePeuple);
			ecm.actionLocale(listePeuple);
			ecm.actionGlobale(listePeuple);
			//System.out.println(p1.toString());

			GuerreManager.guerreChecker(listePeuple);
			TradeManager.TradeChecker(listePeuple);
			//System.out.println(p1.toString());
			PeupleManager.genereEnsembleTotal(listePeuple);
			//System.out.println(p1.toString());
			System.out.println(i + "");
		}


	}

}
