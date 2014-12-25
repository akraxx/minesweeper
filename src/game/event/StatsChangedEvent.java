/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.event;

import component.event.ComponentEvent;

/**
 *
 * @author group12
 */
public class StatsChangedEvent extends ComponentEvent {
    private int nbMines;
    private int remainingMines;

    /*
     * event that will notify that the displaying of the number of remaining mines will 
     * have to adapt itself
     */
    /**
     *
     * @param source
     * @param nbMines
     * @param remainingMines
     */
    public StatsChangedEvent(Object source, int nbMines, int remainingMines) {
        super(source);
        this.nbMines = nbMines;
        this.remainingMines = remainingMines;
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
     * @return
     */
    public int getRemainingMines() {
        return remainingMines;
    }
}
