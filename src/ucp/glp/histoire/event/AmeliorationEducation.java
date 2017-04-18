package ucp.glp.histoire.event;

public class AmeliorationEducation extends ReactionEvent{
	public AmeliorationEducation(){
		this.nom = "amélioration de l'éducation";
        this.puissance = 2;
        this.type = 3;
        this.seuil = 50;
        this.conditionType = 1;
	}
}
