package ucp.glp.histoire.event.local;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Universit� de Cergy-Pontoise
 * @date 2016-2017
 */
public class CriseFinanciere extends LocalHistoricEvent {
    public CriseFinanciere() {
        this.nom = "crise financi�re";
        this.puissance = -2.0;
        this.type = 0;
    }
}
