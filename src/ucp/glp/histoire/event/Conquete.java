package ucp.glp.histoire.event;

public class Conquete extends ReactionEvent{

	/*
	 * Gagne en moyenne 2.0 de territoire
	 * dépends de l'agressivité
	 */
	public Conquete() {
		this.nom = "Conquête";
		this.puissance = 2.0;
		this.type = 4;
		this.seuil = 50;
		this.conditionType = 2;
	}

}
