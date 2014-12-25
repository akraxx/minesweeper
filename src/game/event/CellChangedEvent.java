/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.event;

import game.cell.model.CellModel;

/**
 *
 * @author group12
 */
public class CellChangedEvent extends CellEvent {

    /**
     *
     * @param source : component from which come the chage
     * @param cell : model cell which will be affected by the event 
     */
    public CellChangedEvent(Object source, CellModel cell) {
        super(source, cell);
    }
    
    
}
