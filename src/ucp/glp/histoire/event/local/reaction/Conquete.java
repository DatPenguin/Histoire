package ucp.glp.histoire.event.local.reaction;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Université de Cergy-Pontoise
 * @date 2016-2017
 */
public class Conquete extends ReactionEvent {

    /**
     * Gagne en moyenne 2.0 de territoire
     * dépends du Nombres d'unités militaires
     */
    public Conquete() {
        this.nom = "conquête";
        this.puissance = 2.0;
        this.type = 4;
        this.seuil = 55;
        this.conditionType = 4;
    }

}
