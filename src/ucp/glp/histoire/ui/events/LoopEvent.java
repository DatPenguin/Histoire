package ucp.glp.histoire.ui.events;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Université de Cergy-Pontoise
 * @date 2016-2017
 */
public class LoopEvent {
    private final List<LoopListener> listeners = new ArrayList<LoopListener>();

    public void addListener(LoopListener toAdd) {
        listeners.add(toAdd);
    }

    public void hasLooped() {
        for (LoopListener hl : listeners)
            hl.looped();
    }
}