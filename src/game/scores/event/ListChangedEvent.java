/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.scores.event;

import component.event.ComponentEvent;
import game.scores.model.GameScoreModel;
import java.util.HashMap;
import java.util.List;
import mycomponent.levelchooser.model.LevelValues;

/**
 *
 * @author group12
 */
public class ListChangedEvent extends ComponentEvent {
    HashMap<LevelValues, List<GameScoreModel>> scoreList;


    /**
     *
     * @param source
     * @param scoreList
     */
    public ListChangedEvent(Object source, HashMap<LevelValues, List<GameScoreModel>> scoreList) {
        super(source);
        this.scoreList = scoreList;
    }

    /**
     *
     * @return
     */
    public HashMap<LevelValues, List<GameScoreModel>> getScoreList() {
        return scoreList;
    }
    
    

}
