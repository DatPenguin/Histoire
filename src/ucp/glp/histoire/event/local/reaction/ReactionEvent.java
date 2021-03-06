package ucp.glp.histoire.event.local.reaction;

import ucp.glp.histoire.event.HistoricEvent;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Universit� de Cergy-Pontoise
 * @date 2016-2017
 */
public class ReactionEvent extends HistoricEvent {
    protected int conditionType;    // Attributs du quel d�pends l'activation ou non de l'�vent
    protected double seuil;        // Definis le seuil par dessus lequel l'attribut d'un peuple donn� doit etre pour avoir une chance de s'activer

    public int getConditionType() {
        return conditionType;
    }

    public double getSeuil() {
        return seuil;
    }
}
