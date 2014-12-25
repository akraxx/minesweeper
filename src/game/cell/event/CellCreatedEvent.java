/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.cell.event;

import game.cell.model.CellModel;

/**
 *
 * @author group12
 */
public class CellCreatedEvent extends CellEvent {

    /**
     *
     * @param source
     * @param cell
     */
    public CellCreatedEvent(Object source, CellModel cell) {
        super(source, cell);
    }
    
    
}
