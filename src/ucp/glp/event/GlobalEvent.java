package ucp.glp.event;

import java.util.ArrayList;

import ucp.glp.histoire.utilitaires.Peuple;

public abstract class GlobalEvent extends Event{

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
}
