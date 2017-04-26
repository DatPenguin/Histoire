package ucp.glp.histoire.event.local;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Université de Cergy-Pontoise
 * @date 2016-2017
 */
public class Famine extends LocalHistoricEvent {

    public Famine() {
        this.nom = "famine";
        this.puissance = -2.0;
        this.type = 1;
    }
}
