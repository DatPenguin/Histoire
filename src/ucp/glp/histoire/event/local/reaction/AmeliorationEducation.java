package ucp.glp.histoire.event.local.reaction;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Université de Cergy-Pontoise
 * @date 2016-2017
 */
public class AmeliorationEducation extends ReactionEvent {
    public AmeliorationEducation() {
        this.nom = "amélioration de l'éducation";
        this.puissance = 2;
        this.type = 3;
        this.seuil = 50;
        this.conditionType = 1;
    }
}
