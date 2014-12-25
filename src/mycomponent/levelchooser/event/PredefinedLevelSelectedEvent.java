/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mycomponent.levelchooser.event;

import component.event.ComponentEvent;

/**
 *
 * @author group12
 */
public class PredefinedLevelSelectedEvent extends ComponentEvent {
    private int mines;
    private int rows;
    private int columns;

    /**
     *
     * @param source
     * @param rows
     * @param columns
     * @param mines
     */
    public PredefinedLevelSelectedEvent(Object source, int rows, int columns, int mines) {
        super(source);
        this.mines = mines;
        this.rows = rows;
        this.columns = columns;
    }

    /**
     *
     * @return
     */
    public int getMines() {
        return mines;
    }

    /**
     *
     * @return
     */
    public int getRows() {
        return rows;
    }

    /**
     *
     * @return
     */
    public int getColumns() {
        return columns;
    }
    
}
