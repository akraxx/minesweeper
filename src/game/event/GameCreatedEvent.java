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
public class GameCreatedEvent extends ComponentEvent {
    private GameModel model;

    /**
     *
     * @param source
     * @param model  
     */
    public GameCreatedEvent(Object source, GameModel model) {
        super(source);
        this.model = model;
    }

    /**
     *
     * @return
     */
    public GameModel getModel() {
        return model;
    }
}
