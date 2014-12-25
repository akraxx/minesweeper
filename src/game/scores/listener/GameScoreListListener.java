/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.scores.listener;

import component.ComponentListener;
import game.scores.event.GameScorePanelVisibleEvent;
import game.scores.event.ListChangedEvent;

/**
 *
 * @author group12
 */
public interface GameScoreListListener extends ComponentListener {
    
    /**
     *
     * @param e
     */
    public void listChanged(ListChangedEvent e);
    
    /**
     *
     * @param e
     */
    public void gameScorePanelVisibleChanged(GameScorePanelVisibleEvent e);
    
    
}
