package ucp.glp.histoire.managers;

import ucp.glp.histoire.utilities.ImmigrationPool;
import ucp.glp.histoire.utilities.Peuple;

import java.util.ArrayList;

/**
 * Gestionnaire de croissance et d'immigration
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Université de Cergy-Pontoise
 * @date 2016-2017
 */
public class GrowthManager {
    private final ImmigrationPool immigrationPool;
    private final ArrayList<Peuple> listePeuple;

    public GrowthManager(ArrayList<Peuple> listePeuple) {
        this.listePeuple = listePeuple;
        immigrationPool = new ImmigrationPool(this.listePeuple);
    }

    /**
     * Gère la croissance à chaque tour pour chaque pays
     */
    public void growthAction() {
        int growth = 1;
        for (Peuple aListePeuple : listePeuple)
            aListePeuple.setPopulation(aListePeuple.getPopulation() + growth);
    }

    /**
     * Gère l'immigration à chaque tour pour chaque pays
     */
    public void immigrationAction() {
        this.immigrationPool.fillPool();
        this.immigrationPool.emptyPool();
    }
}
