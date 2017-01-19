package ucp.glp.event;

import ucp.glp.histoire.utilitaires.Peuple;

public abstract class Event {
	//sprite location  = location + nom + .png
	protected String nom,spritesLocation;
	protected int amplitude; //multiplicateur du résultat
	protected int type;
	protected double ampReel,puissance;
	
	public Event(){
		genereAmpReel();
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
		switch(amplitude){
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
	
	
	
	public void action(Peuple p){
		switch(type){
			case 0 :
				p.setRessources(p.getRessources() + (puissance * ampReel));
				break;
			case 1 :
				p.setPopulation(p.getPopulation() + (int)(puissance * ampReel));
				break;
			case 2 : 
				p.setAgressivite(p.getAgressivite() + (puissance * ampReel));
				break;
			case 3 :
				p.setEducation(p.getEducation() + (puissance * ampReel));
				break;
			case 4 :
				p.setTerritoire(p.getTerritoire() + (puissance * ampReel));
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
