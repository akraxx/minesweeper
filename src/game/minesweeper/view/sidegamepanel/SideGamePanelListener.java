/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.minesweeper.view.sidegamepanel;

import component.ComponentListener;

/**
 *
 * @author group12
 */
public interface SideGamePanelListener extends ComponentListener {
    
    /**
     *
     */
    public void sideGamePanelChanged();
    
    /**
     *
     * @param e
     */
    public void showComponent(VisibleComponentEvent e);
    
    /**
     *
     * @param e
     */
    public void hideComponent(VisibleComponentEvent e);
    
}
