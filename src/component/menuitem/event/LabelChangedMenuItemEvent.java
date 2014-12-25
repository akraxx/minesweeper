/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package component.menuitem.event;

/**
 *
 * @author group12
 */
public class LabelChangedMenuItemEvent extends MenuItemEvent {
    private String newLabel;

    /**
     *
     * @param newLabel : new text to apply to a menuItem (to be displayed further after)
     */
    public LabelChangedMenuItemEvent(String newLabel) {
        this.newLabel = newLabel;
    }

    /**
     *
     * @return
     */
    public String getNewLabel() {
        return newLabel;
    }
    
}
