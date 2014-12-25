/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.listener;

import component.ComponentListener;
import game.event.*;

/**
 *
 * @author group12
 */
public interface GameListener extends ComponentListener {
    
    /**
     *
     * @param e
     */
    public void gameStateChanged(GameStateChangedEvent e);
    
    /**
     *
     * @param e
     */
    public void gameCreated(GameCreatedEvent e);
    
    /**
     *
     * @param e
     */
    public void cellCreated(CellCreatedEvent e);
    
    /**
     *
     * @param e
     */
    public void turnFinished(TurnFinishedEvent e);
    
    /**
     *
     */
    public void clearLevel();
    
    /**
     *
     * @param e
     */
    public void statisticsChanged(StatsChangedEvent e);
}
