/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mycomponent.levelchooser.model;

import java.io.Serializable;

/**
 *
 * @author group12
 */
public enum LevelValues implements Serializable {
    /**
     *
     */
    BEGINNER("Beginner", 10, 9, 9),
    /**
     *
     */
    INTERMEDIATE("Intermediate", 40, 16, 16),
    /**
     *
     */
    EXPERT("Expert", 99, 30, 16),
    /**
     *
     */
    CUSTOM("Custom");
    
    private String label;
    private int mines;
    private int columns;
    private int rows;

    private LevelValues(String label, int mines, int columns, int rows) {
        this.label = label;
        this.mines = mines;
        this.columns = columns;
        this.rows = rows;
    }

    private LevelValues(String label) {
        this(label, 0, 0, 0);
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
    public int getColumns() {
        return columns;
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
    public int getMines() {
        return mines;
    }

}
