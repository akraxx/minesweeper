/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.minesweeper.view.window;

import game.minesweeper.view.GraphicalMineSweeperGameView;
import game.minesweeper.view.sidegamepanel.SideGamePanelListener;
import game.minesweeper.view.sidegamepanel.SideGamePanelView;
import game.minesweeper.view.sidegamepanel.VisibleComponentEvent;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

/**
 *
 * @author group12
 */
public class MainPanelGameView extends JSplitPane implements SideGamePanelListener {

    /**
     *
     * @param orientation
     * @param sideGameView
     * @param gameView
     */
    public MainPanelGameView(int orientation, JPanel sideGameView, JPanel gameView) {
        super(orientation, sideGameView, gameView);
    }

    /**
     *
     */
    @Override
    public void sideGamePanelChanged() {
        this.resetToPreferredSizes();
    }

    /**
     *
     * @param e
     */
    @Override
    public void showComponent(VisibleComponentEvent e) {
        
    }

    /**
     *
     * @param e
     */
    @Override
    public void hideComponent(VisibleComponentEvent e) {
        
    }
}
