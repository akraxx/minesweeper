/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package component.menuitem.event;

/**
 *
 * @author group12
 */
public class MnemonicChangedMenuItemEvent extends MenuItemEvent {
    private String Mnemonic;

    /**
     *
     * @param Mnemonic : new mnemonic to apply to a menuItem
     */
    public MnemonicChangedMenuItemEvent(String Mnemonic) {
        this.Mnemonic = Mnemonic;
    }

    /**
     *
     * @return
     */
    public String getMnemonic() {
        return Mnemonic;
    }
    
}
