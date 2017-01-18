package ucp.glp.histoire;

import java.util.ArrayList;

public class GuerreManager {
	//Il faudra lui passer une arraylist contenant tout les pays actuelement en jeu
	//Cette classe sera instanciée une seule fois et après travaillera par routine à chaque passage de temps
	ArrayList<Peuple> listePeuple;
	public GuerreManager(ArrayList<Peuple> listePeuple){
		this.listePeuple = listePeuple;
	}
	public void guerreChecker(){	//comparera si quel pays peut entrer en guerre avec lequel
		
	}
	
	public void guerre(Peuple p1,Peuple p2){	//Conséquences de la guerre
		//A ajouter : un facteur aléatoire
		p1.setPopulation(p1.getPopulation() - (int)(p2.getPuissanceMilitaire()/10));
		p2.setPopulation(p2.getPopulation() - (int)(p1.getPuissanceMilitaire()/10));
		//les puissance millitaires seronts recalculées après
		p1.setRessources(p1.getRessources() + (int)(p1.getPuissanceMilitaire() - p2.getPuissanceMilitaire())); //a voir pour changer les ressources en float
		p2.setRessources(p2.getRessources() + (int)(p2.getPuissanceMilitaire() - p1.getPuissanceMilitaire()));
	}
}
