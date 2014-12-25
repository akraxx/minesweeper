/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.event;

import component.event.ComponentEvent;
import game.model.GameModel;

/**
 *
 * @author group12
 */
public class TurnFinishedEvent extends ComponentEvent {
    private GameModel model;

    /**
     *
     * @param source
     * @param model
     */
    public TurnFinishedEvent(Object source, GameModel model) {
        super(source);
        if(model != null) {
            this.model = model;
        }
        else {
            throw new NullPointerException("GameModel can not be null");
        }
    }

    /**
     *
     * @return
     */
    public GameModel getModel() {
        return model;
    }
    
}
