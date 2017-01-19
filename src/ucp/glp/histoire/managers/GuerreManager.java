package ucp.glp.histoire.managers;

import ucp.glp.histoire.utilitaires.Peuple;

import java.util.ArrayList;

public class GuerreManager {
	//Il faudra lui passer une arraylist contenant tout les pays actuelement en jeu
	//Cette classe sera instanciée une seule fois et après travaillera par routine à chaque passage de temps
	
	public GuerreManager(){
		
	}
	public void guerreChecker(ArrayList<Peuple> listePeuple){	//comparera si quel pays peut entrer en guerre avec un autre
		//routine de déclenchement ou non de la guerre (guerre ponctuel)
		int seuil =  100;
		
		for(int i = 0; i < listePeuple.size();i++){
			
			listePeuple.get(i).setListeEnnemies(new ArrayList<Peuple>());	//on réinitialise à chaque fois la liste des ennemies
			for(int j = (i+1); j < listePeuple.size(); j++ ){	 //de cette façon on évitera un dédoublement des guerres
				
				if((int)(listePeuple.get(i).getBellicisme() + listePeuple.get(j).getBellicisme()) >= seuil){
					guerre(listePeuple.get(i), listePeuple.get(j));
				}
				
				else if((int)(listePeuple.get(i).getBellicisme() + listePeuple.get(j).getAttractivite()) >= seuil){
					guerre(listePeuple.get(i), listePeuple.get(j));
				}
				
				else if((int)(listePeuple.get(j).getBellicisme() + listePeuple.get(i).getAttractivite()) >= seuil){
					guerre(listePeuple.get(i), listePeuple.get(j));
				}
			}
		}
	}
	
	public void guerre(Peuple p1,Peuple p2){	//Conséquences de la guerre
		//A ajouter : un facteur aléatoire
		p1.setPopulation(p1.getPopulation() - (int)(p2.getPuissanceMilitaire()/10));
		p2.setPopulation(p2.getPopulation() - (int)(p1.getPuissanceMilitaire()/10));
		//les puissance millitaires seronts recalculées après
		int perteBrute = 10;	//à ajouter pour éviter une guerre qui durerais infiniment
		p1.setRessources(p1.getRessources() + (p1.getPuissanceMilitaire() - p2.getPuissanceMilitaire() - perteBrute)); //a voir pour changer les ressources en float
		p2.setRessources(p2.getRessources() + (p2.getPuissanceMilitaire() - p1.getPuissanceMilitaire() - perteBrute));
		//ajout dans la liste des ennemi
		p1.addEnnemies(p2);
		p2.addEnnemies(p1);
	}
}
