/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.cell.listener;

import component.ComponentListener;
import game.cell.event.MarkCellEvent;
import game.event.CellEvent;

/**
 *
 * @author group12
 */
public interface CellActionListener extends ComponentListener {
    
    /**
     *
     * @param e : the event which will trigger the unvealing of a cell
     */
    public void discoverCell(CellEvent e);
    
    /**
     *
     * @param e : the event which will trigger the tagging of a cell
     */
    public void markCell(MarkCellEvent e);
}
