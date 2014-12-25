/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mycomponent.newgame.model;

import component.ComponentObservable;
import mycomponent.customgame.event.PanelEnableChangedEvent;
import mycomponent.newgame.event.InitializationOccuredNewGameEvent;
import mycomponent.newgame.listener.NewGameListener;

/**
 *
 * @author group12
 */
public class NewGameModel {
    ComponentObservable<NewGameListener> observable = new ComponentObservable<>();
    
    private void firePanelVisibleChangedEvent(boolean visible) {
        for(NewGameListener l : this.observable.getListeners()) {
            l.panelVisibleChanged(new PanelEnableChangedEvent(this, visible));
        }
    }
    
    private String sendButtonText;

    /**
     *
     * @param sendButtonText
     */
    public NewGameModel(String sendButtonText) {
        this.sendButtonText = sendButtonText;
    }
    
    /**
     *
     * @param l
     */
    public void addListener(NewGameListener l) {
        this.observable.addListener(l);
        l.initializationOccured(new InitializationOccuredNewGameEvent(this, this.sendButtonText));
    }
    
    /**
     *
     * @param visible
     */
    public void panelVisibleChanged(boolean visible) {
        this.firePanelVisibleChangedEvent(visible);
    }
    
}
