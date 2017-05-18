package ucp.glp.histoire.managers;

/**
 * Classe-mère des gestionnaires d'évènements
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Université de Cergy-Pontoise
 * @date 2016-2017
 */
public abstract class EventManager {
    public static double genereAmpReel(int amplitude) {    // Méthode gérant les différant coeficient multiplicateur
        switch (amplitude) {
            case 0:
                return 0.5;
            case 1:
                return 1.0;
            case 2:
                return 2.0;
            default:
                System.out.println("ERREUR ENTREE genereAmpReel EVENT");
                return -1;
        }
    }

    public abstract void genererEventList();
}
