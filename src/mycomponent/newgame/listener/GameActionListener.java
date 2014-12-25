/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mycomponent.newgame.listener;

import component.ComponentListener;
import mycomponent.newgame.event.NewGameOccuredEvent;

/**
 *
 * @author group12
 */
public interface GameActionListener extends ComponentListener {
    
    /**
     *
     * @param e
     */
    public void newGameOccured(NewGameOccuredEvent e);
    
}
