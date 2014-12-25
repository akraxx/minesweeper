/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.scores.controller;

import game.scores.model.GameScoreSerializerModel;
import java.awt.Component;

/**
 *
 * @author group12
 */
public class GameScoreSerialController {
    /**
     *
     */
    protected Component parent;
    /**
     *
     */
    protected GameScoreSerializerModel model;
    
    /**
     *
     * @param model
     * @param parent
     */
    public GameScoreSerialController(GameScoreSerializerModel model, Component parent) {
        this.model = model;
        this.parent = parent;
    }

    /**
     *
     * @return
     */
    public Component getParent() {
        return parent;
    }
}
