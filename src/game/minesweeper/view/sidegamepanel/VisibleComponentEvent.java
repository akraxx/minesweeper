/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.minesweeper.view.sidegamepanel;

import component.event.ComponentEvent;
import java.awt.Component;

/**
 *
 * @author group12
 */
public class VisibleComponentEvent extends ComponentEvent {
    private Component component; 
    
    /**
     *
     * @param source
     * @param component
     */
    public VisibleComponentEvent(Object source, Component component) {
        super(source);
        this.component = component;
    }

    /**
     *
     * @return
     */
    public Component getComponent() {
        return component;
    }
}
