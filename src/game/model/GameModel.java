/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model;

import component.ComponentObservable;
import component.chronometer.listener.ChronometerManagerListener;
import component.chronometer.model.ChronometerModel;
import game.cell.model.CellModel;
import game.event.CellCreatedEvent;
import game.event.GameCreatedEvent;
import game.event.GameStateChangedEvent;
import game.event.TurnFinishedEvent;
import game.listener.GameListener;
import java.util.List;
import mycomponent.newgame.event.NewGameOccuredEvent;
import mycomponent.newgame.listener.GameActionListener;

/**
 *
 * @author group12
 */
public abstract class GameModel implements GameActionListener {
    /**
     *
     */
    protected ComponentObservable<GameListener> observable = new ComponentObservable<>();
    private GameState gameState = GameState.STOP;
    private ChronometerModel chronometerModel = new ChronometerModel();
    private ChronometerManagerListener chronometerManagerListener;
    
    /**
     *
     * @param rows
     * @param columns
     */
    protected void fireGameCreatedEvent(int rows, int columns) {
        List<GameListener> listeners = this.observable.getListeners();
        for(GameListener l : listeners) {
            l.gameCreated(new GameCreatedEvent(this, this));
        }
    }
    
    /**
     *
     */
    protected void fireGameStateChangedEvent() {
        for(GameListener l : this.observable.getListeners()) {
            l.gameStateChanged(new GameStateChangedEvent(this, this.gameState));
        }
    }
    
    /**
     *
     */
    protected void fireTurnFinishedEvent() {
        for(GameListener l : this.observable.getListeners()) {
            l.turnFinished(new TurnFinishedEvent(l, this));
        }
    }
    
    /**
     *
     * @param model
     */
    protected void fireCellCreatedEvent(CellModel model) {
        for(GameListener l : this.observable.getListeners()) {
            l.cellCreated(new CellCreatedEvent(l, model));
        }
    }
    
    /**
     *
     */
    protected void fireLevelCleanedEvent() {
        for(GameListener l : this.observable.getListeners()) {
            l.clearLevel();
        }
    }

    /**
     *
     */
    protected abstract void fireStatsChangedEvent();
    
    /**
     *
     * @param listener
     * @param model
     */
    public GameModel(ChronometerManagerListener listener, ChronometerModel model) {
        this.chronometerManagerListener = listener;
        this.chronometerModel = model;
    }
    
    /**
     *
     * @param l
     */
    public void addListener(GameListener l) {
        this.observable.addListener(l);
    }

    /**
     *
     * @return
     */
    public GameState getGameState() {
        return gameState;
    }

    /**
     *
     * @param gameState
     */
    public void setGameState(GameState gameState) {
        this.gameState = gameState;
        this.fireGameStateChangedEvent();
    }
    
    /**
     *
     * @param rows : horizontal dimension
     * @param columns : vertical dimension
     * @param mines : number of mines to place
     */
    public abstract void createNewGame(int rows, int columns, int mines);
    
    /**
     *
     */
    public void turnFinished() {
        this.fireTurnFinishedEvent();
    }
    
    /**
     *
     * @param e
     */
    @Override
    public void newGameOccured(NewGameOccuredEvent e) {
        this.createNewGame(e.getRows(), e.getColumns(), e.getMines());
    }

    /**
     *
     * @return
     */
    public ChronometerModel getChronometerModel() {
        return chronometerModel;
    }

    /**
     *
     * @return
     */
    public ChronometerManagerListener getChronometerManagerListener() {
        return chronometerManagerListener;
    }
    
}
