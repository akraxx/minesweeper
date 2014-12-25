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
import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author group12
 */
public class GameScoreDeserializerController extends GameScoreSerialController implements ActionListener {

    /**
     *
     * @param model
     * @param parent
     */
    public GameScoreDeserializerController(GameScoreSerializerModel model, Component parent) {
        super(model, parent);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SecurityManager sm = new SecurityManager();
        try {
            JFileChooser chooser = new JFileChooser(new File(GameScoreExtensionFilter.DEFAULT_DIR));
            GameScoreExtensionFilter filter = new GameScoreExtensionFilter("Game Score File", GameScoreExtensionFilter.DEFAULT_EXTENSION);
            chooser.setFileFilter(filter);
            int returnVal = chooser.showOpenDialog(this.getParent());

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                this.model.dezerialize(chooser.getSelectedFile());
            }
        }
        catch(SecurityException exc) {
            System.out.println(exc.getMessage());
        }
    }
}
