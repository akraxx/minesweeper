/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package component.boundedvalue.model;

import component.ComponentObservable;
import component.boundedvalue.event.InitializationOccuredEvent;
import component.boundedvalue.event.LabelChangedEvent;
import component.boundedvalue.item.model.BoundedValueItemModel;
import component.boundedvalue.item.model.PredefinedBoundedValues;
import component.boundedvalue.listener.BoundedValueListener;
import java.util.List;

/**
 *
 * @author group12
 */
public class BoundedValueModel {
    private ComponentObservable<BoundedValueListener> observable = new ComponentObservable<>();
    
    private BoundedValueItemModel itemModel;
    private String label;
    
    /**
     *
     * fires an event notifying that an item's label changed
     */
    private void fireLabelChangedEvent() {
        List<BoundedValueListener> listeners = this.observable.getListeners();
        for(BoundedValueListener l : listeners) {
            l.labelChanged(new LabelChangedEvent(this, this.label));
        }
    }
    
    /**
     *
     * fires an event notifying that an item has been created and its values initialized
     */
    private void fireInitializationOccuredEvent() {
        List<BoundedValueListener> listeners = this.observable.getListeners();
        for(BoundedValueListener l : listeners) {
            l.initializationOccured(new InitializationOccuredEvent(this, this.itemModel, this.label));
        }
    }
    
    /**
     *
     * @param label
     * @param minimum
     * @param maximum
     * @param defaultValue
     * @param value
     */
    public BoundedValueModel(String label, int minimum, int maximum, int defaultValue, int value) {
        this.itemModel = new BoundedValueItemModel(minimum, maximum, defaultValue, value);

        this.label = label;
    }
    
    /**
     *
     * @param label : the label of the item represented by this model
     * @param minimum : the minimum value of the item
     * @param maximum : the maximum value of the item
     * @param defaultValue : the default value of the item
     */
    public BoundedValueModel(String label, int minimum, int maximum, int defaultValue) {
        this(label, minimum, maximum, defaultValue, defaultValue);
    }
    
    /**
     *
     * @param predefined : allows to set predefined values to the model created
     */
    public BoundedValueModel(PredefinedBoundedValues predefined) {
        this(predefined.getLabel(), predefined.getMinimum(), predefined.getMaximum(), predefined.getDefaultValue());
    }
    
    
    /**
     *
     * @param predefined : the predifined values of a item model
     * @return a reference on a newly created item model
     */
    public static BoundedValueModel PredefinedValues(PredefinedBoundedValues predefined) {
        return new BoundedValueModel(predefined);
    }

    /**
     *
     * @param itemModel : the model of the item
     * @param label : the on-screen text of the item
     */
    public BoundedValueModel(BoundedValueItemModel itemModel, String label) {
        if(itemModel != null) {
            this.itemModel = itemModel;
            this.label = label;
            this.fireInitializationOccuredEvent();
        }
        else {
            throw new NullPointerException("itemModel can not be null");
        }
    }

    /**
     *
     * @param itemModel : customized constructor
     */
    public BoundedValueModel(BoundedValueItemModel itemModel) {
        this(itemModel, "");
    }

    /**
     *
     * @return
     */
    public BoundedValueItemModel getItemModel() {
        return itemModel;
    }

    /**
     *
     * @param itemModel
     */
    public void setItemModel(BoundedValueItemModel itemModel) {
        this.itemModel = itemModel;
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
        this.fireLabelChangedEvent();
    }
    
    /**
     *
     * @param l : listener to add
     */
    public void addListener(BoundedValueListener l) {
        this.observable.addListener(l);
        l.initializationOccured(new InitializationOccuredEvent(this, this.itemModel, this.label));
    }
    
}
