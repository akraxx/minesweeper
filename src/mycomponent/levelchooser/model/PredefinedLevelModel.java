/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mycomponent.levelchooser.model;

import java.util.List;
import mycomponent.levelchooser.event.InitializationOccuredLevelChooserEvent;
import mycomponent.levelchooser.event.PredefinedLevelSelectedEvent;
import mycomponent.levelchooser.listener.LevelChooserListener;
import mycomponent.levelchooser.listener.LevelSelectedListener;

/**
 *
 * @author group12
 */
public class PredefinedLevelModel extends LevelModel {
    private int mines;
    private int columns;
    private int rows;
    
    @Override
    protected void fireInitializationOccuredLevelChooserEvent() {
        List listeners = this.observableChooser.getListeners();
        for(Object l : listeners) {
            if(l instanceof LevelChooserListener) {
                ((LevelChooserListener)l).initializationOccured(new InitializationOccuredLevelChooserEvent(this, this.label, rows, columns, mines));
            }
        }
    }
    
    private void firePredefinedLevelSelectedEvent() {
        List listeners = this.observableSelected.getListeners();
        for(Object l : listeners) {
            if(l instanceof LevelSelectedListener) {
                ((LevelSelectedListener)l).predefinedLevelSelected(new PredefinedLevelSelectedEvent(l, this.rows, this.columns, this.mines));
            }
        }
    }

    /**
     *
     * @param label
     * @param columns
     * @param rows
     * @param mines
     */
    public PredefinedLevelModel(String label, int columns, int rows, int mines) {
        super(label);
        this.mines = mines;
        this.columns = columns;
        this.rows = rows;
    }

    /**
     *
     * @param values
     */
    public PredefinedLevelModel(LevelValues values) {
        this(values.getLabel(), values.getColumns(), values.getRows(), values.getMines());
    }
    
    
    @Override
    public int getMines() {
        return mines;
    }

    @Override
    public int getColumns() {
        return columns;
    }

    @Override
    public int getRows() {
        return rows;
    }
    
    @Override
    public void setSelected() {
        this.firePredefinedLevelSelectedEvent();
        this.fireLevelChoosedEvent();
    }
    
}
