/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mycomponent.levelchooser.view.menu;

import javax.swing.JMenuItem;
import mycomponent.levelchooser.event.InitializationOccuredLevelChooserEvent;
import mycomponent.levelchooser.listener.LevelChooserListener;

/**
 *
 * @author group12
 */
public class MenuItemLevelChooserView extends JMenuItem implements LevelChooserListener {
    
    /**
     *
     * @param mnemonic 
     */
    public MenuItemLevelChooserView(char mnemonic) {
        this.setMnemonic(mnemonic);
    }

    /**
     *
     * @param e
     */
    @Override
    public void initializationOccured(InitializationOccuredLevelChooserEvent e) {
        this.setText(e.getLabel());
    }
}
