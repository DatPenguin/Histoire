package ucp.glp.event;

import java.util.ArrayList;

import ucp.glp.histoire.utilitaires.Peuple;

public abstract class GlobalHistoricEvent extends HistoricEvent {

	//surcharge
	public void action(ArrayList<Peuple> listP,int amplitude){
		this.amplitude = amplitude;
		genereAmpReel();
		
		for(int i = 0; i < listP.size(); i++){
		
			switch(type){
				case 0 :
					listP.get(i).setRessources(listP.get(i).getRessources() + (this.puissance * this.ampReel));
					break;
				case 1 :
					listP.get(i).setPopulation(listP.get(i).getPopulation() + (int)(this.puissance * this.ampReel));
					break;
				case 2 : 
					listP.get(i).setAgressivite(listP.get(i).getAgressivite() + (this.puissance * this.ampReel));
					break;
				case 3 :
					listP.get(i).setEducation(listP.get(i).getEducation() + (this.puissance * this.ampReel));
					break;
				case 4 :
					listP.get(i).setTerritoire(listP.get(i).getTerritoire() + (this.puissance * this.ampReel));
					break;
				default:
					System.out.println("ERREUR ENTREE action EVENT" + this.nom);
			}
		
		}
	}
	
	//surcharge
	public String toString(){
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
		return ("un(e) " + amp + " " + this.nom + " touche la région, affectant tout les peuples");		
	}
}
