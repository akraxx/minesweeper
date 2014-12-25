/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package component.menuitem.model;

import component.menuitem.event.LabelChangedMenuItemEvent;
import component.menuitem.event.MnemonicChangedMenuItemEvent;
import component.menuitem.listener.MenuItemListener;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author group12
 */
public class MenuItemModel {
    private List<MenuItemListener> listeners = new LinkedList<>();
    private String label;
    private String mnemonic;
    
    private void fireLabelChangedEvent() {
        for(MenuItemListener l : this.listeners) {
            l.labelChanged(new LabelChangedMenuItemEvent(this.label));
        }
    }
    
    private void fireMnemonicChangedEvent() {
        for(MenuItemListener l : this.listeners) {
            l.mnemonicChanged(new MnemonicChangedMenuItemEvent(this.mnemonic));
        }
    }
    
    /**
     *
     * @param label : the text displayed on-screen later
     * @param mnemonic : the mnemonic of the concerned menuItem
     */
    public MenuItemModel(String label, String mnemonic) {
        this.label = label;
        this.mnemonic = mnemonic;
    }

    /**
     *
     * @param label
     */
    public MenuItemModel(String label) {
        this(label, null);
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
     * @return
     */
    public String getMnemonic() {
        return mnemonic;
    }

    /**
     *
     * @param mnemonic
     */
    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }
    
}
