package ucp.glp.histoire.event.global;

import ucp.glp.histoire.event.HistoricEvent;

/**
 * Classe-mère des évènements globaux
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Université de Cergy-Pontoise
 * @date 2016-2017
 */
public abstract class GlobalHistoricEvent extends HistoricEvent {
    public String toString() {
        String amp = "";
        switch (amplitude) {
            case 0:
                amp = "petit(e)";
                break;
            case 1:
                amp = "moyen(nne)";
                break;
            case 2:
                amp = "grand(e)";
                break;
            default:
                System.out.println("ERREUR ENTREE VALEUR EVENT" + this.nom);
        }
        return ("Un(e) " + amp + " " + this.nom + " touche la région, affectant tous les peuples");
    }
}
