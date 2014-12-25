/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.scores.listener;

import component.ComponentListener;
import game.scores.event.GameScoreDeserealizedEvent;

/**
 *
 * @author group12
 */
public interface GameScoreSerializerListener extends ComponentListener {
    
    /**
     *
     * @param e
     */
    public void gameScoreDeserialized(GameScoreDeserealizedEvent e);
            
}
