package ucp.glp.histoire.event;

public class Conquete extends ReactionEvent{

	/*
	 * Gagne en moyenne 2.0 de territoire
	 * d�pends de l'agressivit�
	 */
	public Conquete() {
		this.nom = "Conqu�te";
		this.puissance = 2.0;
		this.type = 4;
		this.seuil = 50;
		this.conditionType = 2;
	}

}
