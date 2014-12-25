/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.scores.controller;

import game.scores.model.GameScoreExtensionFilter;
import game.scores.model.GameScoreSerializerModel;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author group12
 */
public class GameScoreSerializerController extends GameScoreSerialController implements ActionListener {

    /**
     *
     * @param model
     * @param parent
     */
    public GameScoreSerializerController(GameScoreSerializerModel model, Component parent) {
        super(model, parent);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        SecurityManager sm = new SecurityManager();
        try {
            
            String fileName = JOptionPane.showInputDialog("Choose a file name");
        
            if(fileName != null) {
                fileName = GameScoreExtensionFilter.DEFAULT_DIR + fileName + "." + GameScoreExtensionFilter.DEFAULT_EXTENSION;
                this.model.serialize(fileName);
            }
        }
        catch(SecurityException exc) {
            System.out.println(exc.getMessage());
        }
    }
}
