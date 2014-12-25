/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.cell.model;

import component.ComponentObservable;
import game.cell.event.MarkCellEvent;
import game.cell.listener.CellActionListener;
import game.cell.state.CellState;
import game.cell.state.MineSweeperCellState;
import game.event.CellEvent;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author group12
 */
public class MineSweeperCellModel extends CellModel {
    private int nbMines;
    private boolean mined;
    private MineSweeperCellState cellState;
    private ComponentObservable<CellActionListener> observable = new ComponentObservable<>();
    private List<MineSweeperCellState> routine = new ArrayList<>();
    
    private void initRoutine() {
        routine.add(MineSweeperCellState.MASQUED_UNMARKED);
        routine.add(MineSweeperCellState.MASQUED_MARKED_MINED);
        routine.add(MineSweeperCellState.MASQUED_UNKNOWN);
    }
    
    private void fireDiscoverCellEvent() {
        for(CellActionListener l : observable.getListeners()) {
            l.discoverCell(new CellEvent(this, this));
        }
    }
    
    private void fireMarkedCellEvent(CellState state) {
        for(CellActionListener l : observable.getListeners()) {
            l.markCell(new MarkCellEvent(this, this, state));
        }
    }
    
    /**
     *
     * @param cellState
     * @param mined
     * @param nbMines
     * @param neighboors
     */
    public MineSweeperCellModel(MineSweeperCellState cellState, boolean mined, int nbMines, List<CellModel> neighboors) {
        super(neighboors);
        this.initRoutine();
        this.cellState = cellState;
        this.mined = mined;
        this.nbMines = nbMines;
    }
    
    /**
     *
     * @param cellState
     * @param mined
     * @param nbMines
     */
    public MineSweeperCellModel(MineSweeperCellState cellState, boolean mined, int nbMines) {
        this(cellState, mined, nbMines, new ArrayList<CellModel>());
    }
    
    /**
     *
     * @param cellState
     * @param mined
     */
    public MineSweeperCellModel(MineSweeperCellState cellState, boolean mined) {
        this(cellState, mined, 0);
    }
    
    /**
     *
     * @return
     */
    public int getNbMines() {
        return nbMines;
    }

    /**
     *
     * @param nbMines
     */
    public void setNbMines(int nbMines) {
        this.nbMines = nbMines;
    }

    /**
     *
     * @return
     */
    public boolean isMined() {
        return mined;
    }
    
    /**
     *
     */
    public void incNbMines() {
        this.nbMines++;
    }
    
    /**
     *
     * @param mined
     */
    public void setMined(boolean mined) {
        this.mined = mined;
    }

    /**
     *
     * @return
     */
    public MineSweeperCellState getCellState() {
        return cellState;
    }

    /**
     *
     * @param cellState
     */
    public void setCellState(MineSweeperCellState cellState) {
        this.cellState = cellState;
        this.fireCellChangedEvent();
    }
    
    /**
     *
     */
    public void discoverSelected() {
        this.fireDiscoverCellEvent();
    }
    

    @Override
    public MineSweeperCellModel clone() {
        return new MineSweeperCellModel(this.cellState, this.mined, this.nbMines, this.cloneNeighboorsList());
    }
    
    /**
     *
     */
    public void selectedCell() {
        this.fireDiscoverCellEvent();
    }
    
    /**
     *
     */
    public void markedCell() {
        if(this.routine.contains(this.cellState) || this.cellState == MineSweeperCellState.MASQUED_MINED) {
            int index;
            if(this.cellState == MineSweeperCellState.MASQUED_MINED) {
                index = 0;
            }
            else {
                index = this.routine.indexOf(this.cellState);
            }
            
            this.fireMarkedCellEvent(this.routine.get(( index+1 ) % (this.routine.size())));
        }
    }
    
    /**
     *
     * @param listeners
     */
    public void addActionListener(List<CellActionListener> listeners) {
        for(CellActionListener l : listeners) {
            this.observable.addListener(l);
        }
    }
    
    /**
     *
     * @param l
     */
    public void addActionListener(CellActionListener l) {
        this.observable.addListener(l);
    }
}
