/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.impl;

import component.event.ComponentEvent;

/**
 *
 * @author group12
 */
public class ObjectGridEvent extends ComponentEvent {
    private Object object;
    private int row;
    private int column;
    
    /**
     *
     * @param source
     * @param object
     * @param row
     * @param column
     */
    public ObjectGridEvent(Object source, Object object, int row, int column) {
        super(source);
        this.object = object;
        this.row = row;
        this.column = column;
    }

    /**
     *
     * @return
     */
    public Object getObject() {
        return object;
    }

    /**
     *
     * @return
     */
    public int getRow() {
        return row;
    }

    /**
     *
     * @return
     */
    public int getColumn() {
        return column;
    }
}
