/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.scores.view;

import component.chronometer.model.ChronometerModel;
import game.scores.event.GameScorePanelVisibleEvent;
import game.scores.event.ListChangedEvent;
import game.scores.listener.GameScoreListListener;
import game.scores.model.GameScoreModel;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import mycomponent.levelchooser.model.LevelValues;

/**
 *
 * @author group12
 */
public class GameScoreListView extends JPanel implements GameScoreListListener {
    private GridLayout layout = new GridLayout(0, 1);
    
    /**
     *
     */
    public GameScoreListView() {
        this.setLayout(layout);
    }
    
    /**
     *
     * @param e
     */
    @Override
    public void listChanged(ListChangedEvent e) {
        this.removeAll();
        this.layout.setRows(0);
        
        List<Component> temp = new LinkedList<>();
        int rows = 0;
        for(Entry<LevelValues, List<GameScoreModel>> entry : e.getScoreList().entrySet()) {
            LevelValues value = entry.getKey();
            List<GameScoreModel> list = entry.getValue();

            JLabel title = new JLabel(value.toString());
            title.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            temp.add(title);
            rows++;
            Iterator<GameScoreModel> i = list.iterator();
            int index = 1;
            while(i.hasNext() && index <= 5) {
                rows++;
                GameScoreModel model = i.next();
                temp.add(new JLabel(index + " - " + model.getNickname() + " : " + ChronometerModel.convertTime(model.getTime())));
                index++;
            }
        }
        this.layout.setRows(rows);
        for(Component c : temp) {
            this.add(c);
        }
        
        this.revalidate();
    }

    /**
     *
     * @param e
     */
    @Override
    public void gameScorePanelVisibleChanged(GameScorePanelVisibleEvent e) {
        this.setVisible(e.isVisible());
    }
    
    
    
    
}
