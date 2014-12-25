/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.scores.event;

import component.event.ComponentEvent;
import game.scores.model.GameScoreListModel;

/**
 *
 * @author group12
 */
public class GameScoreDeserealizedEvent extends ComponentEvent {
    private GameScoreListModel model;

    /**
     *
     * @param source
     * @param model
     */
    public GameScoreDeserealizedEvent(Object source, GameScoreListModel model) {
        super(source);
        this.model = model;
    }

    /**
     *
     * @return
     */
    public GameScoreListModel getModel() {
        return model;
    }
    
}
