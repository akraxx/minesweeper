/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.minesweeper.view.window;

import component.chronometer.view.LabelChronometerView;
import game.minesweeper.view.GraphicalMineSweeperGameView;
import game.minesweeper.view.NbMinesRemainingGraphicalView;
import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author group12
 */
public class GameView extends JPanel {
    private NbMinesRemainingGraphicalView minesRemainingGraphicalView;
    private LabelChronometerView chronometerView;
    private GraphicalMineSweeperGameView graphicalMinesWeeperGameView;
    
    private void initComponents() {
        this.add(this.minesRemainingGraphicalView, BorderLayout.SOUTH);
        this.add(this.chronometerView, BorderLayout.NORTH);
        this.add(this.graphicalMinesWeeperGameView, BorderLayout.CENTER);
    }
    
    /**
     *
     * @param minesRemainingGraphicalView
     * @param chronometerView
     * @param graphicalMinesWeeperGameView
     */
    public GameView(NbMinesRemainingGraphicalView minesRemainingGraphicalView, LabelChronometerView chronometerView, GraphicalMineSweeperGameView graphicalMinesWeeperGameView) {
        super(new BorderLayout());
        
        this.minesRemainingGraphicalView = minesRemainingGraphicalView;
        this.chronometerView = chronometerView;
        this.graphicalMinesWeeperGameView = graphicalMinesWeeperGameView;
        
        this.initComponents();
    }

    
    
}
