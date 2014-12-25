/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.minesweeper.controller;

import game.controller.GameController;
import game.minesweeper.model.MineSweeperGameModel;

/**
 *
 * @author group12
 */
public abstract class MineSweeperGameController extends GameController {

    /**
     *
     * @param gameModel
     */
    public MineSweeperGameController(MineSweeperGameModel gameModel) {
        super(gameModel);
    }
    
    /**
     *
     * @return
     */
    @Override
    public MineSweeperGameModel getGameModel() {
        return (MineSweeperGameModel)super.getGameModel();
    }
    
}
