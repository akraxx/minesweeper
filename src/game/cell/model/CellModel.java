/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.cell.model;

import component.ComponentCloneable;
import component.ComponentObservable;
import game.cell.event.CellSelectedEvent;
import game.cell.listener.CellListener;
import game.event.CellChangedEvent;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author group12
 */
public class CellModel implements ComponentCloneable {
    private ComponentObservable<CellListener> observable = new ComponentObservable<>();
    
    /**
     *
     */
    protected List<CellModel> neighboors = new ArrayList<>();
    /**
     *
     */
    protected int row;
    /**
     *
     */
    protected int column;
    
    /**
     *
     */
    protected void fireCellChangedEvent() {
        for(CellListener l : this.observable.getListeners()) {
            l.cellChanged(new CellChangedEvent(this, this));
        }
    }
    
    
    /**
     *
     * @param neighboors : the immediate neighbours of the cell represented by this cellModel
     */
    public CellModel(List<CellModel> neighboors) {
        this.setNeighboors(neighboors);
    }
    
    
    /**
     *
     */
    public CellModel() {
        this(new ArrayList<CellModel>());
    }
    
    /**
     *
     * @param n : model of an immediate neighbour of a certain cell
     */
    public void addNeighboor(CellModel n) {
        if(n != null) {
            if(!this.neighboors.contains(n)) {
                this.neighboors.add(n);
                n.addNeighboor(this);
            }
        }
        else {
            throw new NullPointerException("Neighboor can not be null");
        }
    }

    /**
     *
     * @return
     */
    public int getRow() {
        return row;
    }

    /**
     *
     * @param row
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     *
     * @return
     */
    public int getColumn() {
        return column;
    }

    /**
     *
     * @param column
     */
    public void setColumn(int column) {
        this.column = column;
    }
    
    /**
     *
     * @param neighboors
     */
    public final void setNeighboors(List<CellModel> neighboors) {
        if(neighboors != null) {
            this.neighboors = neighboors;
        }
        else {
            throw new NullPointerException("List of neighboors can not be null");
        }
    }
    
    /**
     *
     * @return
     */
    public List<CellModel> getNeighboors() {
        return this.neighboors;
    }
    
    /**
     *
     * @return a copy of a cell's neighbours list 
     */
    protected List<CellModel> cloneNeighboorsList() {
        List<CellModel> clonedList = new ArrayList<>();
        for(CellModel c : this.neighboors) {
            clonedList.add(c.clone());
        }
        
        return clonedList;
    }
    
    @Override
    public CellModel clone() {
        return new CellModel(this.cloneNeighboorsList());
    }
    
    /**
     *
     * @param l
     */
    public void addListener(CellListener l) {
        this.observable.addListener(l);
    }
}
