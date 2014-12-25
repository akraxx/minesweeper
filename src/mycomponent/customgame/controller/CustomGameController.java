/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mycomponent.customgame.controller;

import mycomponent.customgame.model.CustomGameModel;
import mycomponent.levelchooser.event.CustomLevelSelectedEvent;
import mycomponent.levelchooser.event.LevelChoosedEvent;
import mycomponent.levelchooser.event.PredefinedLevelSelectedEvent;
import mycomponent.levelchooser.listener.LevelSelectedListener;

/**
 *
 * @author group12
 */
public class CustomGameController implements LevelSelectedListener {
    CustomGameModel model;

    /**
     *
     * @param model
     */
    public CustomGameController(CustomGameModel model) {
        this.model = model;
    }

    /**
     *
     * @param e
     */
    @Override
    public void predefinedLevelSelected(PredefinedLevelSelectedEvent e) {
        this.model.changeValues(e.getRows(), e.getColumns(), e.getMines());
        this.model.setEnabled(false);
    }

    /**
     *
     * @param e
     */
    @Override
    public void customLevelSelected(CustomLevelSelectedEvent e) {
        this.model.setEnabled(true);
    }
}
