package ucp.glp.histoire.managers;

import ucp.glp.histoire.event.local.reaction.AmeliorationEducation;
import ucp.glp.histoire.event.local.reaction.AmeliorationProduction;
import ucp.glp.histoire.event.local.reaction.Conquete;
import ucp.glp.histoire.event.local.reaction.ReactionEvent;
import ucp.glp.histoire.utilities.Peuple;

import java.util.ArrayList;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Universit� de Cergy-Pontoise
 * @date 2016-2017
 */
public class EventReactionManager extends EventManager {

    private final ArrayList<ReactionEvent> ReactionEventList;

    public EventReactionManager() {
        ReactionEventList = new ArrayList<ReactionEvent>();
        genererEventList();
    }

    /**
     * Les actions affecteront uniquements les ressources primaires
     *
     * @param hEvent
     * @param p
     * @param amplitude
     */
    private static void actionOnPeuple(ReactionEvent hEvent, Peuple p, int amplitude) {

        switch (hEvent.getType()) {
            case 0:
                p.setRessources(p.getRessources() + (hEvent.getPuissance() * EventLocalManager.genereAmpReel(amplitude)));
                break;
            case 1:
                p.setPopulation(p.getPopulation() + (int) (hEvent.getPuissance() * EventLocalManager.genereAmpReel(amplitude)));
                break;
            case 2:
                p.setAgressivite(p.getAgressivite() + (hEvent.getPuissance() * EventLocalManager.genereAmpReel(amplitude)));
                break;
            case 3:
                p.setEducation(p.getEducation() + (hEvent.getPuissance() * EventLocalManager.genereAmpReel(amplitude)));
                break;
            case 4:
                p.setTerritoire(p.getTerritoire() + (hEvent.getPuissance() * EventLocalManager.genereAmpReel(amplitude)));
                break;
            default:
                System.out.println("ERREUR ENTREE action EVENT" + hEvent.getNom());
                break;
        }
    }

    /**
     * Va ajouter tout les �venements neccessaire � la liste d'�venements possible
     */
    public void genererEventList() {
        // On ajoutera une instance de chaque classe event
        ReactionEventList.add(new Conquete());
        ReactionEventList.add(new AmeliorationEducation());
        ReactionEventList.add(new AmeliorationProduction());
    }

    /**
     * Les attributs utilis� sont ici les attributs secondaires
     * 0 : technologie
     * 1 : richesses
     * 2 : bellicisme
     * 3 : Densit� de population
     * 4 : Unit�s militaires
     * Testera si pour le peuple donn� son attribut est bien sup�rieur ou �gale au seuil de la r�action
     */
    public void action(Peuple p) {
        int randEvent = (int) (Math.random() * (ReactionEventList.size()));    // Generera un nombre al�atoire compris entre [0,size]
        int RandAmp = (int) (Math.random() * (3));                               // Generera un nombre al�atoire compris entre [0,2]

        switch (ReactionEventList.get(randEvent).getConditionType()) {            // Testera si l'attribut donn� du peuple corresponds est bien sup�rieur au seuil
            case 0:
                if (p.getTechnologie() >= ReactionEventList.get(randEvent).getSeuil()) {
                    EventReactionManager.actionOnPeuple(ReactionEventList.get(randEvent), p, RandAmp);
                    System.out.println(ReactionEventList.get(randEvent).toString(p));
                }
                break;
            case 1:
                if (p.getRichesse() >= ReactionEventList.get(randEvent).getSeuil()) {
                    EventReactionManager.actionOnPeuple(ReactionEventList.get(randEvent), p, RandAmp);
                    System.out.println(ReactionEventList.get(randEvent).toString(p));
                }
                break;
            case 2:
                if (p.getBellicisme() >= ReactionEventList.get(randEvent).getSeuil()) {
                    EventReactionManager.actionOnPeuple(ReactionEventList.get(randEvent), p, RandAmp);
                    System.out.println(ReactionEventList.get(randEvent).toString(p));
                }
                break;
            case 3:
                if (p.getDensite() >= ReactionEventList.get(randEvent).getSeuil()) {
                    EventReactionManager.actionOnPeuple(ReactionEventList.get(randEvent), p, RandAmp);
                    System.out.println(ReactionEventList.get(randEvent).toString(p));
                }
                break;
            case 4:
                if (p.getNbSoldat() >= ReactionEventList.get(randEvent).getSeuil()) {
                    EventReactionManager.actionOnPeuple(ReactionEventList.get(randEvent), p, RandAmp);
                    System.out.println(ReactionEventList.get(randEvent).toString(p));
                }
                break;
            default:
                System.out.println("ERREUR ENTREE action EVENT CHECK");
                break;
        }
        RunningLoop.addTotextLog(ReactionEventList.get(randEvent).toString(p));
    }
}
