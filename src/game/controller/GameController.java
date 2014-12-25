/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.controller;

import game.model.GameModel;
import mycomponent.newgame.event.NewGameOccuredEvent;
import mycomponent.newgame.listener.GameActionListener;

/**
 *
 * @author group12
 */
public class GameController {
    private GameModel gameModel;

    /**
     *
     * @param gameModel : the model part of a game about to be controlled hereafter 
     */
    public GameController(GameModel gameModel) {
        if(gameModel != null) {
            this.gameModel = gameModel;
        }
        else {
            throw new NullPointerException("GameModel can not be null");
        }
    }

    /**
     *
     * @return
     */
    public GameModel getGameModel() {
        return gameModel;
    }
    
}
