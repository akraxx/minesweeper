/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mycomponent.levelchooser.model;

import component.ComponentObservable;
import java.util.List;
import mycomponent.customgame.event.PanelEnableChangedEvent;
import mycomponent.levelchooser.event.LevelChoosedEvent;
import mycomponent.levelchooser.listener.LevelChoosedListener;
import mycomponent.levelchooser.listener.LevelChooserListener;
import mycomponent.levelchooser.listener.LevelSelectedListener;
import mycomponent.newgame.event.NewGameOccuredEvent;
import mycomponent.newgame.event.PredefinedLevelEnableEvent;
import mycomponent.newgame.listener.GameActionListener;
import mycomponent.newgame.listener.NewGameListener;

/**
 *
 * @author group12
 */
public abstract class LevelModel {
    ComponentObservable<LevelSelectedListener> observableSelected = new ComponentObservable<>();
    ComponentObservable<LevelChooserListener> observableChooser = new ComponentObservable<>();
    ComponentObservable<LevelChoosedListener> observableChoosed = new ComponentObservable<>();
    ComponentObservable<NewGameListener> observableNewLevel = new ComponentObservable<>();
    ComponentObservable<GameActionListener> observableGameAction = new ComponentObservable<>();

    String label;
    
    /**
     *
     */
    protected void fireLevelChoosedEvent() {
        List<LevelChoosedListener> listeners = this.observableChoosed.getListeners();
        for(LevelChoosedListener l : listeners) {
            l.levelSelected(new LevelChoosedEvent(this, this));
        }
    }
    
    /**
     *
     * @param enable
     */
    protected void firePredefinedLevelEnableEvent(boolean enable) {
        List<NewGameListener> listeners = this.observableNewLevel.getListeners();
        for(NewGameListener l : listeners) {
            l.predefinedLevelEnabled(new PredefinedLevelEnableEvent(this, enable));
        }
    }
    
    /**
     *
     */
    protected void fireNewGameOccuredEvent() {
        List<GameActionListener> listeners = this.observableGameAction.getListeners();
        for(GameActionListener l : listeners) {
            l.newGameOccured(new NewGameOccuredEvent(this, this.getRows(), this.getColumns(), this.getMines()));
        }
    }
    
    private void firePanelVisibleChangedEvent(boolean visible) {
        for(NewGameListener l : this.observableNewLevel.getListeners()) {
            l.panelVisibleChanged(new PanelEnableChangedEvent(this, visible));
        }
    }
    
    /**
     *
     */
    protected abstract void fireInitializationOccuredLevelChooserEvent();
    
    /**
     *
     * @param label
     */
    public LevelModel(String label) {
        this.label = label;
    }

    /**
     *
     */
    public abstract void setSelected();
    
    /**
     *
     * @param l
     */
    public void addLevelSelectedListener(LevelSelectedListener l) {
        this.observableSelected.addListener(l);
    }
    
    /**
     *
     * @param l
     */
    public void addLevelChoosedListener(LevelChoosedListener l) {
        this.observableChoosed.addListener(l);
    }
    
    /**
     *
     * @param l
     */
    public void addLevelChooserListener(LevelChooserListener l) {
        this.observableChooser.addListener(l);
        this.fireInitializationOccuredLevelChooserEvent();
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
     * @param label
     */
    public void setLabel(String label) {
        this.label = label;
    }
    
    /**
     *
     */
    public void createGame() {
        this.fireNewGameOccuredEvent();
    }
    
    
    
    /**
     *
     * @return
     */
    public abstract int getRows();
    
    /**
     *
     * @return
     */
    public abstract int getColumns();
    
    /**
     *
     * @return
     */
    public abstract int getMines();
    
    /**
     *
     * @param l
     */
    public void addNewGameListener(NewGameListener l) {
        this.observableNewLevel.addListener(l);
    }
    
    /**
     *
     * @param l
     */
    public void addGameActionListener(GameActionListener l) {
        this.observableGameAction.addListener(l);
    }
    
    
    /**
     *
     * @param visible 
     */
    public void setVisibleCustomPanel(boolean visible) {
        this.firePanelVisibleChangedEvent(visible);
    }
    
    /**
     *
     * @param enable
     */
    public void enablePredefinedPanel(boolean enable) {
        this.firePredefinedLevelEnableEvent(enable);
    }
    
}
