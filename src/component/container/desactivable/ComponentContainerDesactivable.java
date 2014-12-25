/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package component.container.desactivable;

import component.ComponentView;
import component.container.ComponentContainer;
import java.awt.Component;
import java.awt.Container;

/**
 *
 * @param <E> 
 * @author group12
 */
public class ComponentContainerDesactivable<E extends ComponentView> extends ComponentContainer<E> {
    
    /**
     *
     * @param container : generic container of component 
     * @param statut : status to apply to a component in the container
     */
    @Override
    public void changeComponentStatut(Container container, boolean statut) {
        for(Component c : container.getComponents()) {
            c.setEnabled(statut);
            if(c instanceof Container) {
                this.changeComponentStatut((Container)c, statut);
            }
        }
    }
    
}
