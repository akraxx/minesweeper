/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mycomponent.newgame.controller;

import mycomponent.levelchooser.event.LevelChoosedEvent;
import mycomponent.levelchooser.listener.LevelChoosedListener;
import mycomponent.levelchooser.model.LevelModel;
import mycomponent.newgame.model.NewGameModel;

/**
 *
 * @author group12
 */
public class NewGameController implements LevelChoosedListener {
    /**
     *
     */
    protected LevelModel currentSelectedLevel;
    /**
     *
     */
    protected NewGameModel gameModel;

    /**
     *
     * @param gameModel
     */
    public NewGameController(NewGameModel gameModel) {
        this.gameModel = gameModel;
    }
    
    /**
     *
     * @param e
     */
    @Override
    public void levelSelected(LevelChoosedEvent e) {
        LevelModel model = e.getModel();
        if(model != null) {
            this.currentSelectedLevel = e.getModel();
        }
        else {
            throw new NullPointerException("LevelModel can not be null");
        }
    }
    
}
