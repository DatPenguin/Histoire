package ucp.glp.histoire.event;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Université de Cergy-Pontoise
 * @date 2016-2017
 */
public class ReactionEvent extends HistoricEvent{
    int conditionType;	// Attributs du quel dépends l'activation ou non de l'évent
    double seuil;		// Definis le seuil par dessus lequel l'attribut d'un peuple donné doit etre pour avoir une chance de s'activer

    public int getConditionType() {
        return conditionType;
    }

    public double getSeuil() {
        return seuil;
    }
}
