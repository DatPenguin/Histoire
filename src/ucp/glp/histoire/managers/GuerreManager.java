package ucp.glp.histoire.managers;

import ucp.glp.histoire.utilitaires.Peuple;

import java.util.ArrayList;

public class GuerreManager {

	//Il faudra lui passer une arraylist contenant tout les pays actuelement en jeu
	//Cette classe sera instanci�e une seule fois et apr�s travaillera par routine � chaque passage de temps

	public GuerreManager() {
	}

	public static void guerreChecker(ArrayList<Peuple> listePeuple) {    // Comparera si quel pays peut entrer en guerre avec un autre

		// Routine de d�clenchement ou non de la guerre (guerre ponctuelle)
		int seuil =  150;
		for(int x = 0; x < listePeuple.size();x++){
			listePeuple.get(x).setListeEnnemies(new ArrayList<Peuple>());    // On r�initialise � chaque fois la liste des ennemies
		}
		
		
		for(int i = 0; i < listePeuple.size();i++){


			for (int j = (i + 1); j < listePeuple.size(); j++) {     // De cette fa�on on �vitera un d�doublement des guerres
				
				if((int)(listePeuple.get(i).getBellicisme() + listePeuple.get(j).getBellicisme()) >= seuil){
					GuerreManager.guerre(listePeuple.get(i), listePeuple.get(j));
				}
				
				else if((int)(listePeuple.get(i).getBellicisme() + listePeuple.get(j).getAttractivite()) >= seuil){
					GuerreManager.guerre(listePeuple.get(i), listePeuple.get(j));
				}
				
				else if((int)(listePeuple.get(j).getBellicisme() + listePeuple.get(i).getAttractivite()) >= seuil){
					GuerreManager.guerre(listePeuple.get(i), listePeuple.get(j));
				}
			}
		}
	}
	
	public static void guerre(Peuple p1,Peuple p2){	//Cons�quences de la guerre

		// TODO Ajouter un facteur al�atoire
		p1.setPopulation(p1.getPopulation() - (int)(p2.getPuissanceMilitaire()/10));
		p2.setPopulation(p2.getPopulation() - (int)(p1.getPuissanceMilitaire()/10));

		// Les puissance millitaires seront recalcul�es apr�s
		int perteBrute = 10;    // TODO A ajouter pour �viter une guerre qui durerais infiniment
		p1.setRessources(p1.getRessources() + (p1.getPuissanceMilitaire() - p2.getPuissanceMilitaire() - perteBrute));    // A voir pour changer les ressources en float
		p2.setRessources(p2.getRessources() + (p2.getPuissanceMilitaire() - p1.getPuissanceMilitaire() - perteBrute));

		// Ajout dans la liste des ennemis
		p1.addEnnemies(p2);
		p2.addEnnemies(p1);

		System.out.println("La guerre � �clat� entre " + p1.getNom() + " et " + p2.getNom());    // TODO /!\ A REMPLACER PAR L'AJOUT DANS UNE FILE
	}
}
