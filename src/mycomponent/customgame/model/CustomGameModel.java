/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mycomponent.customgame.model;

import component.ComponentObservable;
import component.boundedvalue.item.model.BoundedValueItemModel;
import java.util.List;
import mycomponent.customgame.event.PanelEnableChangedEvent;
import mycomponent.customgame.listener.CustomGameListener;

/**
 *
 * @author group12
 */
public class CustomGameModel {
    private BoundedValueItemModel rowsModelItem;
    private BoundedValueItemModel columnsModelItem;
    private BoundedValueItemModel minesModelItem;
    
    private boolean enabled;
    
    private ComponentObservable<CustomGameListener> observable = new ComponentObservable<>();
    
    private void firePanelEnabledChangeEvent() {
        List<CustomGameListener> listeners = this.observable.getListeners();
        for(CustomGameListener l : listeners) {
            l.panelEnableChanged(new PanelEnableChangedEvent(this, this.enabled));
        }
    }
    
    /**
     *
     * @param rowsModelItem
     * @param columnsModelItem
     * @param minesModelItem
     */
    public CustomGameModel(BoundedValueItemModel rowsModelItem, BoundedValueItemModel columnsModelItem, BoundedValueItemModel minesModelItem) {
        this.rowsModelItem = rowsModelItem;
        this.columnsModelItem = columnsModelItem;
        this.minesModelItem = minesModelItem;
    }

    /**
     *
     * @return
     */
    public boolean isEnabled() {
        return enabled;
    }
    
    /**
     *
     * @param rowsValue
     * @param columnsValue
     * @param minesValue
     */
    public void changeValues(int rowsValue, int columnsValue, int minesValue) {
        this.rowsModelItem.setValue(rowsValue);
        this.columnsModelItem.setValue(columnsValue);
        this.minesModelItem.setValue(minesValue);
    }

    /**
     *
     * @param enabled
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
        this.firePanelEnabledChangeEvent();
    }
    
    /**
     *
     * @param l
     */
    public void addListener(CustomGameListener l) {
        observable.addListener(l);
    }
    
    /**
     *
     * @return
     */
    public int getRows() {
        return this.rowsModelItem.getValue();
    }
    
    /**
     *
     * @return
     */
    public int getColumns() {
        return this.columnsModelItem.getValue();
    }
    
    /**
     *
     * @return
     */
    public int getMines() {
        return this.minesModelItem.getValue();
    }

}
