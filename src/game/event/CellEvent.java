/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.event;

import component.event.ComponentEvent;
import game.cell.model.CellModel;

/**
 *
 * @author group12
 */
public class CellEvent extends ComponentEvent {
    private CellModel cell;

    /**
     *
     * @param source
     * @param cell
     */
    public CellEvent(Object source, CellModel cell) {
        super(source);
        if(cell != null) {
            this.cell = cell;
        }
        else {
            throw new NullPointerException("Cell can not be null");
        }
    }

    /**
     *
     * @return
     */
    public CellModel getCell() {
        return cell;
    }

}
