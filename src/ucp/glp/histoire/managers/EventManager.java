package ucp.glp.histoire.managers;

/**
 * Classe-m�re des gestionnaires d'�v�nements
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Universit� de Cergy-Pontoise
 * @date 2016-2017
 */
public abstract class EventManager {
    public static double genereAmpReel(int amplitude) {    // M�thode g�rant les diff�rant coeficient multiplicateur
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
