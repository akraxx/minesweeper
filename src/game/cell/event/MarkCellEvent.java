/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.cell.event;

import game.cell.model.CellModel;
import game.cell.state.CellState;

/**
 *
 * @author group12
 */
public class MarkCellEvent extends CellEvent {
    CellState state;

    /**
     *
     * @param source
     * @param cell
     * @param state
     */
    public MarkCellEvent(Object source, CellModel cell,CellState state) {
        super(source, cell);
        this.state = state;
    }

    /**
     *
     * @return
     */
    public CellState getState() {
        return state;
    }
}
