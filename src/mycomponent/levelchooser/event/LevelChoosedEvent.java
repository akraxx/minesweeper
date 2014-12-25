/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mycomponent.levelchooser.event;

import component.event.ComponentEvent;
import mycomponent.levelchooser.model.LevelModel;

/**
 *
 * @author group12
 */
public class LevelChoosedEvent extends ComponentEvent {
    LevelModel model;
    
    /**
     *
     * @param source
     * @param model
     */
    public LevelChoosedEvent(Object source, LevelModel model) {
        super(source);
        if(model != null) {
            this.model = model;
        }
        else {
            throw new NullPointerException("LevelModle can not be null");
        }
    }

    /**
     *
     * @return
     */
    public LevelModel getModel() {
        return model;
    }
    
    
    
}
