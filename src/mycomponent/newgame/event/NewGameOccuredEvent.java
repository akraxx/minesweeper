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
public class NewGameOccuredEvent extends ComponentEvent {
    private int rows;
    private int columns;
    private int mines;

    /**
     *
     * @param source
     * @param rows
     * @param columns
     * @param mines
     */
    public NewGameOccuredEvent(Object source, int rows, int columns, int mines) {
        super(source);
        this.rows = rows;
        this.columns = columns;
        this.mines = mines;
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

    /**
     *
     * @return
     */
    public int getMines() {
        return mines;
    }
    
}
