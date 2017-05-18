package ucp.glp.histoire.event;

import ucp.glp.histoire.utilities.Peuple;

/*Different type :
 * 0 : Ressources
 * 1 : Population
 * 2 : Agressivité
 * 3 : Education
 * 4 : Territoire
 */

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Université de Cergy-Pontoise
 * @date 2016-2017
 */
public abstract class HistoricEvent {

    protected String nom;
    protected int amplitude; //multiplicateur du résultat
    protected int type;
    protected double puissance;

    public String toString(Peuple p) {
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
        return ("Un(e) " + amp + " " + this.nom + " touche " + p.getNom());
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getType() {
        return type;
    }

    public double getPuissance() {
        return puissance;
    }
}
