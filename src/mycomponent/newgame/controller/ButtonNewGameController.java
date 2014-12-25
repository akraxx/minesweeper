/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mycomponent.newgame.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import mycomponent.newgame.model.NewGameModel;

/**
 *
 * @author group12
 */
public class ButtonNewGameController extends NewGameController implements ActionListener {

    /**
     *
     * @param gameModel
     */
    public ButtonNewGameController(NewGameModel gameModel) {
        super(gameModel);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JButton) {
            if(this.currentSelectedLevel != null) {
                this.currentSelectedLevel.createGame();
                this.gameModel.panelVisibleChanged(false);
            }
            
        }
    }
    
    
}
