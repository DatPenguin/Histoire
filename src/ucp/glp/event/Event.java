package ucp.glp.event;

import ucp.glp.histoire.utilitaires.Peuple;

public abstract class Event {
	//sprite location  = location + nom + .png
	protected String description,nom,spritesLocation;
	protected int amplitude; //multiplicateur du résultat
	
	public String toString(Peuple p){
		String amp = "";
		switch(amplitude){
			case 0:
				amp = "petit(e)";
				break;
			case 1 :
				amp = "moyen(nne)";
				break;
			case 2 :
				amp = "grand(e)";
				break;
			default:
			    System.out.println("ERREUR ENTREE VALEUR EVENT");
		}
		
		
		return ("un(e) " + amp + " " + this.nom + " touche " + p.getNom());
		
	}

}
