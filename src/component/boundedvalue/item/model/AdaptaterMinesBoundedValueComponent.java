/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package component.boundedvalue.item.model;

import component.boundedvalue.item.event.BoundsChangedEvent;
import component.boundedvalue.item.event.InitilializationOccuredEvent;
import component.boundedvalue.item.event.ValueChangedEvent;
import component.boundedvalue.item.listener.BoundedValueItemListener;
import component.boundedvalue.model.BoundedValueModel;

/**
 *
 * @author group12
 */
public class AdaptaterMinesBoundedValueComponent implements BoundedValueItemListener {
    private BoundedValueItemModel rows;
    private BoundedValueItemModel columns;
    private BoundedValueItemModel mines;
    
    private void initAdaptater() {
        this.rows.addListener(this);
        this.columns.addListener(this);
    }
    
    /**
     *
     * @param rows
     * @param columns
     * @param mines
     */
    public AdaptaterMinesBoundedValueComponent(BoundedValueModel rows, BoundedValueModel columns, BoundedValueModel mines) {
        if(rows != null && columns != null && mines != null) {
            this.rows = rows.getItemModel();
            this.columns = columns.getItemModel();
            this.mines = mines.getItemModel();
            this.initAdaptater();
        }
    }

    
    /**
     *
     * @param e
     */
    @Override
    public void valueChanged(ValueChangedEvent e) {
        this.mines.setMaximum((int)((this.rows.getValue() * this.columns.getValue()) * 0.85));
    }

    /**
     *
     * @param e
     */
    @Override
    public void boundsChanged(BoundsChangedEvent e) {
        
    }

    /**
     *
     * @param e
     */
    @Override
    public void initializationOccured(InitilializationOccuredEvent e) {
        
    }
    
    
}
