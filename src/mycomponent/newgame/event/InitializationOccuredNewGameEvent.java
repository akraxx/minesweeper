/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mycomponent.newgame.event;

import component.event.ComponentEvent;

/**
 *
 * @author group12
 */
public class InitializationOccuredNewGameEvent extends ComponentEvent {
    private String sendButtonText;
    
    /**
     *
     * @param source
     * @param sendButtonText
     */
    public InitializationOccuredNewGameEvent(Object source, String sendButtonText) {
        super(source);
        this.sendButtonText = sendButtonText;
    }

    /**
     *
     * @return
     */
    public String getSendButtonText() {
        return sendButtonText;
    }
}
