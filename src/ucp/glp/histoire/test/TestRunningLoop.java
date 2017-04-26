package ucp.glp.histoire.test;

import org.apache.log4j.Logger;
import ucp.glp.histoire.log.LoggerUtility;
import ucp.glp.histoire.managers.RunningLoop;
import ucp.glp.histoire.utilities.Peuple;

import java.awt.*;
import java.util.ArrayList;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Université de Cergy-Pontoise
 * @date 2016-2017
 */
public class TestRunningLoop {
    // TODO placer nbIteration dans une classe directrice
    private static final Logger logger = LoggerUtility.getLogger(TestRunningLoop.class);

    public static void main(String[] args) {

        logger.info("Lancement test");

        Peuple p1 = new Peuple(50, 50, 50, 70, 50, "belge", Color.black);
        Peuple p2 = new Peuple(90, 80, 50, 25, 22, "Grec", Color.blue);
        ArrayList<Peuple> listePeuple = new ArrayList<Peuple>();
        listePeuple.add(p1);
        listePeuple.add(p2);

        RunningLoop runningLoop = new RunningLoop(listePeuple);
        System.out.println(p1.toString());
        System.out.println(p2.toString());

        runningLoop.loopAction();
        System.out.println(p1.toString());
        System.out.println(p2.toString());


        RunningLoop.nbIteration = 0;
        /*
        while(p1.getPopulation() > 0 && p2.getPopulation() > 0){
			TestRunningLoop.nbIteration++;
			runningLoop.loopAction();
		}
		*/
        for (int i = 0; i < 100; i++) {
            runningLoop.loopAction();
            if (p1.getPopulation() <= 0) {
                logger.warn("POPULATION NULLE p1 pop  = " + p1.getPopulation() + " iteration : " + RunningLoop.nbIteration);
            }
            if (p2.getPopulation() <= 0) {
                logger.warn("POPULATION NULLE p2 pop  = " + p2.getPopulation() + " iteration : " + RunningLoop.nbIteration);

            }
        }
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(RunningLoop.nbIteration);

        // Ce for est utilisé pour afficher le textLog de la runningLoop
		/*for(int i = 0 ; i < runningLoop.getTextLog().size() ; i++){
			System.out.println(runningLoop.getTextLog().get(i));
		}
		*/


    }

}
