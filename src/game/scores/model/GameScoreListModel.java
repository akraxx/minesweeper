/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.scores.model;

import component.ComponentObservable;
import game.scores.event.GameScorePanelVisibleEvent;
import game.scores.event.ListChangedEvent;
import game.scores.listener.GameScoreListListener;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import mycomponent.levelchooser.model.LevelValues;

/**
 *
 * @author group12
 */
public class GameScoreListModel implements Serializable {
    private HashMap<LevelValues, List<GameScoreModel>> scoreList = new HashMap<>();
    transient private ComponentObservable<GameScoreListListener> observable ;
    
    private void initScoreList() {
        this.scoreList.put(LevelValues.BEGINNER, new LinkedList<GameScoreModel>());
        this.scoreList.put(LevelValues.INTERMEDIATE, new LinkedList<GameScoreModel>());
        this.scoreList.put(LevelValues.EXPERT, new LinkedList<GameScoreModel>());
    }
    
    private void fireListChangedEvent() {
        for(GameScoreListListener l : this.observable.getListeners()) {
            l.listChanged(new ListChangedEvent(this, this.scoreList));
        }
    }
    
    private void firePanelVisibleChangedEvent(boolean visible) {
        for(GameScoreListListener l : this.observable.getListeners()) {
            l.gameScorePanelVisibleChanged(new GameScorePanelVisibleEvent(l, visible));
        }
    }
    
    /**
     *
     */
    public void initObservable() {
        this.observable = new ComponentObservable<>();
    }

    /**
     *
     */
    public GameScoreListModel() {
        this.initObservable();
        this.initScoreList();
    }
    
    
    /**
     *
     * @param values : the score to save
     * @param nickname : the name wanted by the user
     * @param time : the time in which the user finished the game 
     */
    public void addScore(LevelValues values, String nickname, long time) {
        List<GameScoreModel> list;
        if(scoreList.containsKey(values)) {
            list = this.scoreList.get(values);
        }
        else {
            list = new LinkedList<>();
            this.scoreList.put(values, list);
        }
        list.add(new GameScoreModel(time, nickname));
        Collections.sort(list);
        this.fireListChangedEvent();
    }
    
    /**
     *
     */
    public void printScores() {
        this.fireListChangedEvent();
    }
    
    /**
     *
     * @param l
     */
    public void addListener(GameScoreListListener l) {
        this.observable.addListener(l);
    }
    
    /**
     *
     * @param l
     */
    public void addListener(List<GameScoreListListener> l) {
        this.observable.addListener(l);
        this.fireListChangedEvent();
    }
    
    /**
     *
     * @param visible
     */
    public void panelVisibleChanged(boolean visible) {
        this.firePanelVisibleChangedEvent(visible);
    }
}
