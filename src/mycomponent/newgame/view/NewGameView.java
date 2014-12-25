/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mycomponent.newgame.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import mycomponent.customgame.event.PanelEnableChangedEvent;
import mycomponent.levelchooser.view.radiobutton.RadioButtonCustomLevelChooserView;
import mycomponent.levelchooser.view.radiobutton.RadioButtonPredefinedLevelChooserView;
import mycomponent.newgame.event.InitializationOccuredNewGameEvent;
import mycomponent.newgame.event.NewGameOccuredEvent;
import mycomponent.newgame.event.PredefinedLevelEnableEvent;
import mycomponent.newgame.listener.NewGameListener;

/**
 *
 * @author group12
 */
public class NewGameView extends JPanel implements NewGameListener {
    private GridLayout layoutPredefinedLevels = new GridLayout(0, 1);
    private JPanel predefinedLevelsPanel = new JPanel(layoutPredefinedLevels);
    private JPanel customLevelsPanel = new JPanel(new BorderLayout());
    private JButton sendButton = new JButton();
    private ButtonGroup group = new ButtonGroup();
    
    /**
     *
     */
    public NewGameView() {
        super(new BorderLayout());
    }
    
    /**
     *
     * @param view
     */
    public void addPredefinedLevelView(RadioButtonPredefinedLevelChooserView view) {
        this.layoutPredefinedLevels.setRows(this.layoutPredefinedLevels.getRows() + 1);
        this.predefinedLevelsPanel.add(view);
        this.group.add(view.getButton());
    }
    
    /**
     *
     * @param view
     */
    public void addCustomLevelView(RadioButtonCustomLevelChooserView view) {
        this.customLevelsPanel.add(view);
        this.group.add(view.getButton());
    }

    /**
     *
     * @param e
     */
    @Override
    public void initializationOccured(InitializationOccuredNewGameEvent e) {
        this.sendButton.setText(e.getSendButtonText());
        
        this.add(this.predefinedLevelsPanel, BorderLayout.NORTH);
        this.add(this.customLevelsPanel, BorderLayout.CENTER);
        this.add(this.sendButton, BorderLayout.SOUTH);
    }
    
    /**
     *
     * @return
     */
    public JButton getSendButton() {
        return sendButton;
    }

    /**
     *
     * @param e
     */
    @Override
    public void predefinedLevelEnabled(PredefinedLevelEnableEvent e) {
        this.predefinedLevelsPanel.setVisible(e.isEnable());
    }

    /**
     *
     * @param e
     */
    @Override
    public void panelVisibleChanged(PanelEnableChangedEvent e) {
        this.setVisible(e.isEnable());
    }
    
    
}
