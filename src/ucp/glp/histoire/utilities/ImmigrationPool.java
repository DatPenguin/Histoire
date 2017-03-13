package ucp.glp.histoire.utilities;

import java.util.ArrayList;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Universit� de Cergy-Pontoise
 * @date 2016-2017
 */
public class ImmigrationPool {
	private int populationPool;
	private ArrayList<Peuple> listePeuple;

	public ImmigrationPool(ArrayList<Peuple> listePeuple){
		this.populationPool = 0;
		this.listePeuple = listePeuple;
	}

	/**
	 * Cette m�thode ferra immigr� la population d'un pays si il est surcharg� et remplira la populationPool en attente d'attribution
	 */
	public void fillPool(){
		for(int i = 0; i < this.listePeuple.size() ; i++){
			if (listePeuple.get(i).getImmigration() < 0) {
				this.populationPool -= listePeuple.get(i).getImmigration();
				listePeuple.get(i).setPopulation(listePeuple.get(i).getPopulation() + listePeuple.get(i).getImmigration());    //la population serra bien retir� aux pays
			}
		}
	}

	/**
	 * Cette m�thode attribuera les immigr�s aux pays en demande de population
	 * on se basera sur un parcours al�atoire de la liste de peuple pour rendre l'attribution �quitable
	 */
	public void emptyPool(){
		int index = (int) (Math.random() * this.listePeuple.size());   						// Generera un nombre al�atoire compris entre [0,listePeuple.size]
		int iteration = 0;
		for(iteration = 0 ; iteration < this.listePeuple.size() ; iteration++){
			if(index >= this.listePeuple.size()){
				index = 0;
			}
			if (this.listePeuple.get(index).getImmigration() > 0) {                            // Si le peuple � besoin d'immigr�s alors
				if (this.listePeuple.get(index).getImmigration() > this.populationPool) {        // Si la demande est sup�rieur � la quantit� disponible
                    /*listePeuple.get(index).setPopulation(listePeuple.get(index).getPopulation() + this.populationPool);		// On lui attribuera tout les immigr�s disponible
					this.populationPool = 0;*/
				} else{
					listePeuple.get(index).setPopulation(listePeuple.get(index).getPopulation() + +listePeuple.get(index).getImmigration());        // On lui attribuera uniquement les immigr�s qu'il demande si l'offre exc�de la demande
					this.populationPool -= listePeuple.get(index).getImmigration();
				}
			}
		}


	}

}
