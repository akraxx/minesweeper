/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.minesweeper.view.sidegamepanel;

import game.scores.view.GameScoreListView;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import mycomponent.newgame.view.NewGameView;

/**
 *
 * @author group12
 */
public class SideGamePanelView extends JPanel implements SideGamePanelListener {
    private GameScoreListView gameScoreListView;
    private NewGameView newGameView;
    
    /**
     *
     * @param gameScoreListView
     * @param newGameView
     */
    public SideGamePanelView(GameScoreListView gameScoreListView, NewGameView newGameView) {
        super(new BorderLayout());
        if(gameScoreListView != null && newGameView != null) {
            this.gameScoreListView = gameScoreListView;
            this.newGameView = newGameView;
        }
        else {
            throw new NullPointerException("GameScoreListView can not be null");
        }
    }
    
    /**
     *
     */
    @Override
    public void sideGamePanelChanged() {
        
    }

    /**
     *
     * @param e
     */
    @Override
    public void showComponent(VisibleComponentEvent e) {
        if(e.getComponent() instanceof GameScoreListView) {
            this.newGameView.setVisible(false);
        }
        else {
            this.gameScoreListView.setVisible(false);
        }
        this.add(e.getComponent());
        this.revalidate();
    }

    /**
     *
     * @param e
     */
    @Override
    public void hideComponent(VisibleComponentEvent e) {
        this.remove(e.getComponent());
        this.revalidate();
    }
    
    
    
    

    
}
