package ucp.glp.histoire;
import java.util.ArrayList;

public class TradeManager {

	public TradeManager() {
		
	}
	public void trade(Peuple p1,Peuple p2){	//Conséquences de la guerre
		//A ajouter : un facteur aléatoire
		double taux = 0.1;	//à ajouter pour éviter un enrichissement trop rapide
		p1.setRessources(p1.getRessources() + (p2.getAttractivite() * taux * p1.getPuissancePolitique()));
		p1.setRessources(p1.getRessources() + (p2.getAttractivite() * taux * p1.getPuissancePolitique()));


	}
}
