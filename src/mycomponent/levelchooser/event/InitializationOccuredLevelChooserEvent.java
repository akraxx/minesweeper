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
public class InitializationOccuredLevelChooserEvent extends ComponentEvent {
    private String label;
    
    private int rows;
    private int columns;
    private int mines;

    /**
     *
     * @param source
     * @param label
     * @param rows
     * @param columns
     * @param mines
     */
    public InitializationOccuredLevelChooserEvent(Object source, String label, int rows, int columns, int mines) {
        super(source);
        this.label = label;
        this.rows = rows;
        this.columns = columns;
        this.mines = mines;
    }

    /**
     *
     * @param source
     * @param label
     */
    public InitializationOccuredLevelChooserEvent(Object source, String label) {
        this(source, label, 0, 0, 0);
    }
    
    

    /**
     *
     * @return
     */
    public String getLabel() {
        return label;
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
