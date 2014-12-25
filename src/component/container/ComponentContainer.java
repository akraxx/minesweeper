/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package component.container;

import component.ComponentView;
import java.awt.Component;
import java.awt.Container;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @param <E> 
 * @author group12
 */
public class ComponentContainer<E extends ComponentView> extends JPanel {
    /**
     *
     */
    protected List<E> views = new LinkedList<>();
    
    /**
     *
     * @param container : generic container manipulated only as a template (contains components)
     * @param statut : status to set to the different components available in the game (certain may need to be disabled)
     */
    public void changeComponentStatut(Container container, boolean statut) {
        for(Component c : container.getComponents()) {
            c.setEnabled(statut);
            if(c instanceof Container) {
                this.changeComponentStatut((Container)c, statut);
            }
        }
    }
    
    /**
     *
     * @param v : template vision of a component
     */
    public void addComponentView(E v) {
        if(v != null) {
            this.views.add(v);
            if(v instanceof Component) {
                this.add((Component)v);
            }
        }
        else {
            throw new NullPointerException("BoundedValueView can not be null");
        }
    }

    /**
     *
     * @return
     */
    public List<E> getViews() {
        return views;
    }
    
}
