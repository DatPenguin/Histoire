package ucp.glp.histoire.event.global;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Université de Cergy-Pontoise
 * @date 2016-2017
 */
public class GlobalWarming extends GlobalHistoricEvent {
    public GlobalWarming() {
        this.nom = "Réchauffement climatique";
        this.puissance = -1.0;
        this.type = 0;
    }
}
