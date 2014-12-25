/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mycomponent.levelchooser.view.radiobutton;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import mycomponent.levelchooser.event.InitializationOccuredLevelChooserEvent;
import mycomponent.levelchooser.listener.LevelChooserListener;

/**
 *
 * @author group12
 */
public abstract class RadioButtonLevelChooserView extends JPanel implements LevelChooserListener {
    /**
     *
     */
    protected JRadioButton button = new JRadioButton();
    
    /**
     *
     */
    public RadioButtonLevelChooserView() {
        
    }

    /**
     *
     * @return
     */
    public JRadioButton getButton() {
        return button;
    }

    /**
     *
     * @param e
     */
    @Override
    public abstract void initializationOccured(InitializationOccuredLevelChooserEvent e);
}
