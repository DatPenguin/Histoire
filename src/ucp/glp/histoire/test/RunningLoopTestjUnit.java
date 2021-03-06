package ucp.glp.histoire.test;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ucp.glp.histoire.log.LoggerUtility;
import ucp.glp.histoire.managers.RunningLoop;
import ucp.glp.histoire.utilities.Peuple;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Universit� de Cergy-Pontoise
 * @date 2016-2017
 */
public class RunningLoopTestjUnit {
    private static final Logger logger = LoggerUtility.getLogger(RunningLoopTestjUnit.class);

    private RunningLoop runningLoop;
    private ArrayList<Peuple> listePeuple;
    private int index;

    @Before
    public void setUp() throws Exception {
        Peuple p1 = new Peuple(50, 50, 50, 70, 50, "belge", Color.black);
        Peuple p2 = new Peuple(90, 80, 50, 25, 22, "Grec", Color.blue);
        this.listePeuple = new ArrayList<Peuple>();

        listePeuple.add(p1);
        listePeuple.add(p2);

        runningLoop = new RunningLoop(listePeuple);

    }

    @Test
    public void test() {
        this.index = 0;

        // R�sultat incoh�rent pass� 100 000 it�ration
        for (int i = 0; i < 10000; i++) {
            runningLoop.loopAction();
            index = i;
        }
        // Testera si tout les peuples ont bien une population positive
        for (Peuple aListePeuple : listePeuple) {
            assertTrue(0 < aListePeuple.getPopulation());
            //logger.warn("POPULATION P" + n + " : " + listePeuple.get(n).getPopulation());

        }
    }

    @After
    public void after() {
        for (int n = 0; n < listePeuple.size(); n++) {
            logger.warn("POPULATION P" + n + " : " + listePeuple.get(n).getPopulation());
        }
    }

}
