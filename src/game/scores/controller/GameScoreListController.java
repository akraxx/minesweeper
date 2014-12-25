/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.scores.controller;

import component.chronometer.model.ChronometerModel;
import game.event.CellCreatedEvent;
import game.event.GameCreatedEvent;
import game.event.GameStateChangedEvent;
import game.event.StatsChangedEvent;
import game.event.TurnFinishedEvent;
import game.listener.GameListener;
import game.minesweeper.model.MineSweeperGameModel;
import game.model.GameState;
import game.scores.event.GameScoreDeserealizedEvent;
import game.scores.listener.GameScoreSerializerListener;
import game.scores.model.GameScoreListModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import mycomponent.levelchooser.model.LevelValues;

/**
 *
 * @author group12
 */
public class GameScoreListController implements GameListener, ActionListener, GameScoreSerializerListener {
    private List<LevelValues> levelValues = new LinkedList<LevelValues>();
    GameScoreListModel model;
    
    private void initSupportedLevelValues() {
        this.levelValues.add(LevelValues.BEGINNER);
        this.levelValues.add(LevelValues.INTERMEDIATE);
        this.levelValues.add(LevelValues.EXPERT);
    }
    
    private LevelValues searchDefaultLevel(int rows, int columns, int nbMines) {
        LevelValues r = null;
        for(LevelValues level : this.levelValues) {
            if(rows == level.getRows() && columns == level.getColumns() && nbMines == level.getMines()) {
                r = level;
            }
        }
        
        return r;
    }

    /**
     *
     * @param model
     */
    public GameScoreListController(GameScoreListModel model) {
        if(model != null) {
            this.model = model;
            this.initSupportedLevelValues();
        }
        else {
            throw new NullPointerException("GameScoreModel can not be null");
        }
    }
    
    /**
     *
     * @param e
     */
    @Override
    public void gameStateChanged(GameStateChangedEvent e) {
        if(e.getSource() instanceof MineSweeperGameModel) {
            MineSweeperGameModel model = (MineSweeperGameModel)e.getSource();
            if(e.getGameState() == GameState.WON) {
                LevelValues values = this.searchDefaultLevel(model.getRows(), model.getColumns(), model.getNbMines());
                if(values != null) {
                    String name = JOptionPane.showInputDialog("Enter your name");
                    this.model.addScore(values, name, ChronometerModel.convertTime(model.getChronometerModel()));
                }
            }
        }
    }

    /**
     *
     * @param e
     */
    @Override
    public void gameCreated(GameCreatedEvent e) {
        
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

    @Override
    public void actionPerformed(ActionEvent e) {
        this.model.panelVisibleChanged(true);
    }

    /**
     *
     * @param e
     */
    @Override
    public void statisticsChanged(StatsChangedEvent e) {
        
    }

    /**
     *
     * @param e
     */
    @Override
    public void gameScoreDeserialized(GameScoreDeserealizedEvent e) {
        if(e.getModel() != null) {
            this.model = e.getModel();
        }
    }
    
}
