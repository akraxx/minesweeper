/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.scores.event;

import component.event.ComponentEvent;

/**
 *
 * @author group12
 */
public class GameScorePanelVisibleEvent extends ComponentEvent {
    private boolean visible;

    /**
     *
     * @param source
     * @param visible
     */
    public GameScorePanelVisibleEvent(Object source, boolean visible) {
        super(source);
        this.visible = visible;
    }

    /**
     *
     * @return
     */
    public boolean isVisible() {
        return visible;
    }
}
