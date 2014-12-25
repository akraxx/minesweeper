/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.event;

import component.event.ComponentEvent;
import game.model.GameState;

/**
 *
 * @author group12
 */
public class GameStateChangedEvent extends ComponentEvent {
    private GameState gameState;

    /**
     *
     * @param source
     * @param gameState
     */
    public GameStateChangedEvent(Object source, GameState gameState) {
        super(source);
        if(gameState != null) {
            this.gameState = gameState;
        }
        else {
            throw new NullPointerException("GameState can not be null");
        }
    }

    /**
     *
     * @return
     */
    public GameState getGameState() {
        return gameState;
    }
}
