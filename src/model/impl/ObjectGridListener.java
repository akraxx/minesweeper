/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.impl;

import component.ComponentListener;

/**
 *
 * @author group12
 */
public interface ObjectGridListener extends ComponentListener {
    
    /**
     *
     * @param e
     */
    public void objectCreated(ObjectGridEvent e);
    
}
