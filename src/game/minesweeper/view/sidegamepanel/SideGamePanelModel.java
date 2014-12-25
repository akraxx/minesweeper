/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.minesweeper.view.sidegamepanel;

import component.ComponentObservable;
import java.awt.Component;

/**
 *
 * @author group12
 */
public class SideGamePanelModel {
    private ComponentObservable<SideGamePanelListener> observable = new ComponentObservable<>();
    
    private void fireSideGamePanelChangedEvent() {
        for(SideGamePanelListener l : this.observable.getListeners()) {
            l.sideGamePanelChanged();
        }
    }
    
    private void fireShowComponentEvent(Component c) {
        for(SideGamePanelListener l : this.observable.getListeners()) {
            l.showComponent(new VisibleComponentEvent(this, c));
        }
    }
    
    private void fireHideComponentEvent(Component c) {
        for(SideGamePanelListener l : this.observable.getListeners()) {
            l.hideComponent(new VisibleComponentEvent(this, c));
        }
    }
    /**
     *
     */
    public void sideGamePanelChanged() {
        this.fireSideGamePanelChangedEvent();
    }
    
    /**
     *
     * @param c
     */
    public void showComponent(Component c) {
        this.fireShowComponentEvent(c);
        this.fireSideGamePanelChangedEvent();
    }
    
    /**
     *
     * @param c
     */
    public void hideComponent(Component c) {
        this.fireHideComponentEvent(c);
        this.fireSideGamePanelChangedEvent();
    }
    
    /**
     *
     * @param l
     */
    public void addListener(SideGamePanelListener l) {
        this.observable.addListener(l);
    }
}
