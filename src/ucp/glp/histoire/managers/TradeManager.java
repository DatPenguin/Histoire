package ucp.glp.histoire.managers;
import ucp.glp.histoire.utilitaires.Peuple;

import java.util.ArrayList;

public class TradeManager {

	public TradeManager() {
		
	}
	public void TradeChecker(ArrayList<Peuple> listePeuple){	//comparera si quel pays peut entrer en commerce avec un autre
		//routine de déclenchement ou non du commerce (commerce ponctuel)
		int seuil =  100;
		
		for(int i = 0; i < listePeuple.size();i++){
			for(int j = (i+1); j < listePeuple.size(); j++ ){	 //de cette façon on évitera un dédoublement du commerce
				
				if(((int)(listePeuple.get(i).getAttractivite() + listePeuple.get(j).getAttractivite()) >= seuil) && !(listePeuple.get(i).getListeEnnemies().contains(listePeuple.get(j)))){	//si la somme de leur attractivitées est suffisante et si ils ne sont pas ennemies
					trade(listePeuple.get(i),listePeuple.get(j));
				}
				
			}
		}
	}
	
	public void trade(Peuple p1,Peuple p2){	//Conséquences de la guerre
		//A ajouter : un facteur aléatoire
		double taux = 0.1;	//à ajouter pour éviter un enrichissement trop rapide
		p1.setRessources(p1.getRessources() + (taux*(p2.getAttractivite()* p1.getPuissancePolitique())));
		p2.setRessources(p2.getRessources() + (taux*(p1.getAttractivite()* p2.getPuissancePolitique())));



	}
}
