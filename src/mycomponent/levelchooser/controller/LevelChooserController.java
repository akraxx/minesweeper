/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mycomponent.levelchooser.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import mycomponent.levelchooser.model.CustomLevelModel;
import mycomponent.levelchooser.model.LevelModel;

/**
 *
 * @author group12
 */
public class LevelChooserController implements ActionListener, MouseListener {
    LevelModel model;

    /**
     *
     * @param model
     */
    public LevelChooserController(LevelModel model) {
        if(model != null) {
            this.model = model;
        }
        else {
            throw new NullPointerException("LevelModel can not be null");
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JRadioButton) {
            JRadioButton radioButton = (JRadioButton)e.getSource();
            if(radioButton.isSelected()) {
                this.model.setSelected();
            }
        }
        else if(e.getSource() instanceof JMenuItem) {
            if(this.model instanceof CustomLevelModel) {
                this.model.setSelected();
                this.model.enablePredefinedPanel(false);
                this.model.setVisibleCustomPanel(true);
            }
            else {
                this.model.createGame();
                this.model.setVisibleCustomPanel(false);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1) {
            if(this.model instanceof CustomLevelModel) {
                this.model.enablePredefinedPanel(true);
                this.model.setVisibleCustomPanel(true);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
