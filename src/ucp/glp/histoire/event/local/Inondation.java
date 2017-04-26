package ucp.glp.histoire.event.local;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Université de Cergy-Pontoise
 * @date 2016-2017
 */
public class Inondation extends LocalHistoricEvent {
    public Inondation() {
        this.nom = "inondation";
        this.puissance = 1.0;
        this.type = 4;
    }
}
