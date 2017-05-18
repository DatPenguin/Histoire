package ucp.glp.histoire.event.local;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Université de Cergy-Pontoise
 * @date 2016-2017
 */
public class SurplusNourriture extends LocalHistoricEvent {
    public SurplusNourriture() {
        this.nom = "surplus de nourriture";
        this.puissance = 1.0;
        this.type = 0;
    }
}
