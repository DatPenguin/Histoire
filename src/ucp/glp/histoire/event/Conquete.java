package ucp.glp.histoire.event;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Université de Cergy-Pontoise
 * @date 2016-2017
 */
public class Conquete extends ReactionEvent{

    /*
     * Gagne en moyenne 2.0 de territoire
     * dépends de l'agressivité
     */
    public Conquete() {
        this.nom = "Conquête";
        this.puissance = 2.0;
        this.type = 4;
        this.seuil = 25;
        this.conditionType = 2;
    }

}
