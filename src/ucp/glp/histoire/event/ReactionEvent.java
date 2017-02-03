package ucp.glp.histoire.event;

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
