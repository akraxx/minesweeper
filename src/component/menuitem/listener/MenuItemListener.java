/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package component.menuitem.listener;

import component.menuitem.event.LabelChangedMenuItemEvent;
import component.menuitem.event.MnemonicChangedMenuItemEvent;

/**
 *
 * @author group12
 */
public interface MenuItemListener {
    
    /**
     *
     * @param e : event indicating that a menuItem's mnemonic changed
     */
    public void mnemonicChanged(MnemonicChangedMenuItemEvent e);
    
    /**
     *
     * @param e : event indicating that a menuItem's on-screen display changed
     */
    public void labelChanged(LabelChangedMenuItemEvent e);
    
}
