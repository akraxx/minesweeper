/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.minesweeper.view.sidegamepanel;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;


/**
 *
 * @author group12
 */
public class SideGamePanelController implements ComponentListener {
    SideGamePanelModel model;

    /**
     *
     * @param model
     */
    public SideGamePanelController(SideGamePanelModel model) {
        if(model != null) {
            this.model = model;
        }
        else {
            throw new NullPointerException("SideGamePanelModel can not be null");
        }
    }
    
    @Override
    public void componentResized(ComponentEvent e) {
        this.model.sideGamePanelChanged();
    }

    @Override
    public void componentMoved(ComponentEvent e) {
        
    }

    @Override
    public void componentShown(ComponentEvent e) {
        this.model.showComponent(e.getComponent());
    }

    @Override
    public void componentHidden(ComponentEvent e) {
        this.model.hideComponent(e.getComponent());
    }
    
}
