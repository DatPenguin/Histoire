package ucp.glp.histoire.event.global;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Université de Cergy-Pontoise
 * @date 2016-2017
 */
public class Seisme extends GlobalHistoricEvent {
    public Seisme(){
        this.nom = "Seisme";
        this.puissance = -3.0;
        this.type = 1;
    }
}
