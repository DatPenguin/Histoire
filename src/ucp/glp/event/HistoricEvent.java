package ucp.glp.event;

import ucp.glp.histoire.utilitaires.Peuple;

/*Different type :
 * 0 : Ressources
 * 1 : Population
 * 2 : Agressivité
 * 3 : Education
 * 4 : territoire 
 */

public abstract class HistoricEvent {
	//sprite location  = location + nom + .png
	protected String nom,spritesLocation;
	protected int amplitude; //multiplicateur du résultat
	protected int type;
	protected double ampReel,puissance;
	
	public HistoricEvent(){
	}
	
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
			    System.out.println("ERREUR ENTREE VALEUR EVENT" + this.nom);
		}
		return ("un(e) " + amp + " " + this.nom + " touche " + p.getNom());		
	}
	
	
	public void genereAmpReel(){	//méthode gérant les différant coeficient multiplicateur
		switch(this.amplitude){
		case 0:
			ampReel = 0.5;
			break;
		case 1 :
			ampReel = 1;
			break;
		case 2 :
			ampReel = 2;
			break;
		default:
		    System.out.println("ERREUR ENTREE genereAmpReel EVENT" + this.nom);
		}
	}
	
	
	
	public void action(Peuple p,int amplitude){
		this.amplitude = amplitude;
		genereAmpReel();
		
		switch(type){
			case 0 :
				p.setRessources(p.getRessources() + (this.puissance * this.ampReel));
				break;
			case 1 :
				p.setPopulation(p.getPopulation() + (int)(this.puissance * this.ampReel));
				break;
			case 2 : 
				p.setAgressivite(p.getAgressivite() + (this.puissance * this.ampReel));
				break;
			case 3 :
				p.setEducation(p.getEducation() + (this.puissance * this.ampReel));
				break;
			case 4 :
				p.setTerritoire(p.getTerritoire() + (this.puissance * this.ampReel));
				break;
			default:
			    System.out.println("ERREUR ENTREE action EVENT" + this.nom);
		
		}
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getSpritesLocation() {
		return spritesLocation;
	}

	public void setSpritesLocation(String spritesLocation) {
		this.spritesLocation = spritesLocation;
	}

	public int getAmplitude() {
		return amplitude;
	}

	public void setAmplitude(int amplitude) {
		this.amplitude = amplitude;
	}
	

}
