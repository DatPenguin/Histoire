package ucp.glp.histoire.event;


public class CriseFinanciere extends LocalHistoricEvent {
	
	public CriseFinanciere(){
		this.nom = "Crise Financiere";
		this.puissance = -2.0;
		this.type = 0;
	}

}
