/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.cell.listener;

import component.ComponentListener;
import game.cell.event.CellSelectedEvent;
import game.event.CellChangedEvent;
import game.event.CellEvent;

/**
 *
 * @author group12
 */
public interface CellListener extends ComponentListener {
    
    /**
     *
     * @param e : event notifying of a change in a cell (nature of the change to be worked on)
     */
    public void cellChanged(CellChangedEvent e);

}
