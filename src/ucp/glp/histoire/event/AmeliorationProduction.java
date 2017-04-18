package ucp.glp.histoire.event;

public class AmeliorationProduction extends ReactionEvent{
	public AmeliorationProduction() {
		this.nom = "amélioration de la production";
        this.puissance = 1.0;
        this.type = 0;
        this.seuil = 60;
        this.conditionType = 0;
	}
}
