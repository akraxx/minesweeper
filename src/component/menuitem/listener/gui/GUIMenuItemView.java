/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package component.menuitem.listener.gui;

import component.menuitem.event.LabelChangedMenuItemEvent;
import component.menuitem.event.MnemonicChangedMenuItemEvent;
import component.menuitem.listener.MenuItemListener;
import component.menuitem.model.MenuItemModel;
import javax.swing.JMenuItem;

/**
 *
 * @author group12
 */
public class GUIMenuItemView extends JMenuItem implements MenuItemListener {
    private MenuItemModel model;
    
    /**
     *
     * @param model : the model of a menuItem of the application
     */
    public GUIMenuItemView(MenuItemModel model) {
        if(model != null) {
            this.model = model;
        }
        else {
            throw new NullPointerException("MenuItemModel can not be null");
        }
    }

    /**
     *
     * @param e : event indicating that a menuItem's mnemonic changed
     */
    @Override
    public void mnemonicChanged(MnemonicChangedMenuItemEvent e) {
        
    }

    /**
     *
     * @param e : event indicating that a menuItem's on-screen display changed
     */
    @Override
    public void labelChanged(LabelChangedMenuItemEvent e) {
        
    }
    
}
