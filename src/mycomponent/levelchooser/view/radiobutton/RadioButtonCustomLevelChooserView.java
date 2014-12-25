/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mycomponent.levelchooser.view.radiobutton;

import java.awt.BorderLayout;
import mycomponent.customgame.view.CustomGameView;
import mycomponent.levelchooser.event.CustomLevelSelectedEvent;
import mycomponent.levelchooser.event.InitializationOccuredLevelChooserEvent;
import mycomponent.levelchooser.event.PredefinedLevelSelectedEvent;
import mycomponent.levelchooser.listener.LevelSelectedListener;

/**
 *
 * @author group12
 */
public class RadioButtonCustomLevelChooserView extends RadioButtonLevelChooserView implements LevelSelectedListener {
    private CustomGameView view;
    
    private void createView(String label) {
        this.button.setText(label + ":");
        this.setLayout(new BorderLayout());
        this.add(this.button, BorderLayout.NORTH);
        this.add(view, BorderLayout.CENTER);
    }
    
    /**
     *
     * @param view
     */
    public RadioButtonCustomLevelChooserView(CustomGameView view) {
        if(view != null) {
            this.view = view;
        }
        else {
            throw new NullPointerException("CustomGameView can not be null");
        }
    }
    
    /**
     *
     * @param e
     */
    @Override
    public void initializationOccured(InitializationOccuredLevelChooserEvent e) {
        this.createView(e.getLabel());
    }

    /**
     *
     * @param e
     */
    @Override
    public void predefinedLevelSelected(PredefinedLevelSelectedEvent e) {
        this.button.setSelected(true);
    }

    /**
     *
     * @param e
     */
    @Override
    public void customLevelSelected(CustomLevelSelectedEvent e) {
        this.button.setSelected(true);
    }
    
}
