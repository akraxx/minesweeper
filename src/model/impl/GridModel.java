/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.impl;

import component.ComponentCloneable;
import component.ComponentObservable;
import java.util.ArrayList;
import java.util.List;
import model.Model;

/**
 *
 * @param <E> 
 * @author group12
 */
public class GridModel<E extends ComponentCloneable> extends Model {
    /**
     *
     */
    protected List< List<E>> grid = new ArrayList<>();
    private ComponentObservable<ObjectGridListener> observable = new ComponentObservable<>();
    
    private void fireCreatedObjectEvent(E e, int row, int column) {
        
        for(ObjectGridListener l : this.observable.getListeners()) {
            l.objectCreated(new ObjectGridEvent(this, e, row, column));
        }
        
    }
    /**
     *
     * @param height 
     * @param width
     * @param defaultObject
     */
    public void createNewGrid(int height, int width, E defaultObject) {
        this.width = width;
        this.height = height;
        ((ArrayList)this.grid).ensureCapacity(this.height);
        for(int i = 0; i < this.height; i++) {
            this.grid.add(new ArrayList<E>());
            ArrayList<E> row = (ArrayList<E>)this.grid.get(i);
            row.ensureCapacity(this.width);
            for(int j = 0; j < this.width; j++) {
                row.add((E)defaultObject.clone());
                this.fireCreatedObjectEvent(row.get(j), i, j);
            }
        }

    }
    
    /**
     *
     * @return 
     */
    public List< List<E>> getGrid() {
        return this.grid;
    }
    
    
    /**
     *
     * @param width
     * @param height
     */
    public GridModel(int width, int height) {
        super(width, height);
    }
    
    /**
     *
     */
    public GridModel() {
        this(0, 0);
    }

    /**
     *
     * @param i
     * @param j
     * @return
     */
    public E getObject(int i, int j) {
        if(i >= 0 && i < this.height && j >= 0 && j < this.width) {
            return this.grid.get(i).get(j);
        }
        else {
            throw new IllegalArgumentException("Coord of the cell can not be null : [" + i + ", " + j + "]");
        }
    }
    
    /**
     *
     */
    public void cleanGrid() {
        this.grid.clear();
    }
    
    /**
     *
     * @param l
     */
    public void addListener(ObjectGridListener l) {
        this.observable.addListener(l);
    }
}


