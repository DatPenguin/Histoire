package ucp.glp.histoire.event.local.reaction;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Université de Cergy-Pontoise
 * @date 2016-2017
 */
public class AmeliorationProduction extends ReactionEvent {
    public AmeliorationProduction() {
        this.nom = "amélioration de la production";
        this.puissance = 1.0;
        this.type = 0;
        this.seuil = 60;
        this.conditionType = 0;
    }
}
