/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.minesweeper.view;

import game.cell.model.MineSweeperCellModel;
import game.cell.state.MineSweeperCellState;
import game.event.CellCreatedEvent;
import game.event.GameCreatedEvent;
import game.event.GameStateChangedEvent;
import game.event.StatsChangedEvent;
import game.event.TurnFinishedEvent;
import game.listener.GameListener;
import game.minesweeper.model.MineSweeperGameModel;
import java.util.List;

/**
 *
 * @author group12
 */
public class TextMineSweeperGameView implements GameListener {
    
    private void checkAndPrintGameModel(Object model) {
        if(model instanceof MineSweeperGameModel) {
            System.out.println(this.printGrid((MineSweeperGameModel)model));
        }
        else {
            System.out.println("Can't print the model, Object is not an instance of MinesWeeperGameModel");
        }
    }
    
    /**
     *
     * @param model : the model to be displayed to the user
     * @return
     */
    public String printGrid(MineSweeperGameModel model) {
        String result = "";
        List< List<MineSweeperCellModel>> grid = model.getGrid();
        for(List<MineSweeperCellModel> row : grid) {
            for(MineSweeperCellModel c : row) {
                    if(c.getCellState() == MineSweeperCellState.UNMASQUED_EMPTY_MINES) {
                        result = result.concat(String.valueOf(c.getNbMines())).concat(" ");
                    }
                    else {
                        result = result.concat(c.getCellState().toString()).concat(" ");
                    }
            }
            result += System.getProperty("line.separator");
        }
        
        return result;
    }
    
    /**
     *
     * @param e
     */
    @Override
    public void gameStateChanged(GameStateChangedEvent e) {
        switch(e.getGameState()) {
            case WON:
                System.out.println("Game won, congratulation");
                break;
            case LOST:
                System.out.println("Game lost, try again");
        }
    }
    
    /**
     *
     * @param e
     */
    @Override
    public void gameCreated(GameCreatedEvent e) {
        this.checkAndPrintGameModel(e.getSource());
    }

    /**
     *
     * @param e
     */
    @Override
    public void cellCreated(CellCreatedEvent e) {
        
    }

    /**
     *
     * @param e : event indicating that a "turn" was finished, that is to say
     * that a cell has been unvealed and all the treatments after (losing, unvealing the neighbors ...)
     * have been done
     */
    @Override
    public void turnFinished(TurnFinishedEvent e) {
        this.checkAndPrintGameModel(e.getModel());
    }

    /**
     *
     */
    @Override
    public void clearLevel() {
        
    }

    /**
     *
     * @param e
     */
    @Override
    public void statisticsChanged(StatsChangedEvent e) {
        
    }
}
