/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mycomponent.levelchooser.model;

import component.ComponentObservable;
import java.util.List;
import mycomponent.customgame.event.PanelEnableChangedEvent;
import mycomponent.customgame.model.CustomGameModel;
import mycomponent.levelchooser.event.CustomLevelSelectedEvent;
import mycomponent.levelchooser.event.InitializationOccuredLevelChooserEvent;
import mycomponent.levelchooser.listener.LevelChooserListener;
import mycomponent.levelchooser.listener.LevelSelectedListener;
import mycomponent.newgame.event.PredefinedLevelEnableEvent;
import mycomponent.newgame.listener.NewGameListener;

/**
 *
 * @author group12
 */
public class CustomLevelModel extends LevelModel {
    CustomGameModel model;
    
    /**
     *
     */
    @Override
    protected void fireInitializationOccuredLevelChooserEvent() {
        List<LevelChooserListener> listeners = this.observableChooser.getListeners();
        for(LevelChooserListener l : listeners) {
            l.initializationOccured(new InitializationOccuredLevelChooserEvent(this, this.label));
        }
    }
    
    private void fireCustomLevelSelectedEvent() {
        List<LevelSelectedListener> listeners = this.observableSelected.getListeners();
        for(LevelSelectedListener l : listeners) {
            l.customLevelSelected(new CustomLevelSelectedEvent(l));
        }
    }
    
    
    /**
     *
     * @param model
     * @param label
     */
    public CustomLevelModel(CustomGameModel model, String label) {
        super(label);
        if(model != null) {
            this.model = model;
        }
        else {
            throw new NullPointerException("CustomGameModel can not be null");
        }
        
    }

    /**
     *
     * @param model
     * @param values
     */
    public CustomLevelModel(CustomGameModel model, LevelValues values) {
        this(model, values.getLabel());
    }
    
    /**
     *
     */
    @Override
    public void setSelected() {
        this.fireCustomLevelSelectedEvent();
        this.fireLevelChoosedEvent();
    }

    /**
     *
     * @return
     */
    @Override
    public int getRows() {
        return this.model.getRows();
    }

    /**
     *
     * @return
     */
    @Override
    public int getColumns() {
        return this.model.getColumns();
    }

    /**
     *
     * @return
     */
    @Override
    public int getMines() {
        return this.model.getMines();
    }
    
    
}
