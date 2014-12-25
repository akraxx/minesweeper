/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.minesweeper.controller;

import game.cell.event.MarkCellEvent;
import game.cell.listener.CellActionListener;
import game.cell.model.MineSweeperCellModel;
import game.cell.state.MineSweeperCellState;
import game.event.CellEvent;
import game.minesweeper.model.MineSweeperGameModel;

/**
 *
 * @author group12
 */
public class GraphicalMineSweeperGameController extends MineSweeperGameController implements CellActionListener {

    /**
     *
     * @param gameModel
     */
    public GraphicalMineSweeperGameController(MineSweeperGameModel gameModel) {
        super(gameModel);
    }
    
    /**
     *
     * @param e
     */
    @Override
    public void discoverCell(CellEvent e) {
        if(e.getCell() instanceof MineSweeperCellModel) {
            this.getGameModel().discoverCell((MineSweeperCellModel)e.getCell());
            this.getGameModel().turnFinished();
        }
    }

    /**
     *
     * @param e
     */
    @Override
    public void markCell(MarkCellEvent e) {
        if(e.getCell() instanceof MineSweeperCellModel && e.getState() instanceof MineSweeperCellState) {
            this.getGameModel().markCell((MineSweeperCellModel)e.getCell(), (MineSweeperCellState)e.getState());
        }
    }
    
}
