/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mycomponent.customgame.view;

import component.boundedvalue.view.gui.BoundedValueView;
import component.container.ComponentContainer;
import java.awt.GridLayout;
import javax.swing.JPanel;
import mycomponent.customgame.event.PanelEnableChangedEvent;
import mycomponent.customgame.listener.CustomGameListener;

/**
 *
 * @author group12
 */
public class CustomGameView extends ComponentContainer<BoundedValueView> implements CustomGameListener {
    private GridLayout gridLayout = new GridLayout(0, 1);

    /**
     *
     */
    public CustomGameView() {
        this.setLayout(this.gridLayout);
    }
    
    /**
     *
     * @param e
     */
    @Override
    public void panelEnableChanged(PanelEnableChangedEvent e) {
        this.changeComponentStatut(this, e.isEnable());
    }

    /**
     *
     * @param v
     */
    @Override
    public void addComponentView(BoundedValueView v) {
        this.gridLayout.setRows(this.views.size() + 1);
        super.addComponentView(v);
    }
    
    
    
}
