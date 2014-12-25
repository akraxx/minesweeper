/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.minesweeper.view;

import game.event.*;
import game.listener.GameListener;
import game.minesweeper.model.MineSweeperGameModel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author group12
 */
public class NbMinesRemainingGraphicalView extends JPanel implements GameListener {
    private JLabel label = new JLabel();
    
    /*
     * it is a view in itself, compound of a combination of a JPanel and a JLabel
     * to display its information
     */
    /**
     *
     */
    public NbMinesRemainingGraphicalView() {
        super(new BorderLayout());
        this.add(this.label, BorderLayout.CENTER);
    }

    
    /**
     *
     * @param e
     */
    @Override
    public void gameStateChanged(GameStateChangedEvent e) {
        
    }

    /**
     *
     * @param e
     */
    @Override
    public void gameCreated(GameCreatedEvent e) {
        MineSweeperGameModel model = (MineSweeperGameModel)e.getModel();
        this.label.setText("Mines remaining : " + (model.getNbMines() - model.getNbMarkedMined()));
    }

    /**
     *
     * @param e
     */
    @Override
    public void cellCreated(CellCreatedEvent e) {
        
    }

    /**
     *
     * @param e
     */
    @Override
    public void turnFinished(TurnFinishedEvent e) {
        
    }

    /**
     *
     */
    @Override
    public void clearLevel() {
        
    }

    /**
     *
     * @param e
     */
    @Override
    public void statisticsChanged(StatsChangedEvent e) {
        this.label.setText("Mines remaining : " + String.valueOf(e.getRemainingMines()));
    }
    
}
