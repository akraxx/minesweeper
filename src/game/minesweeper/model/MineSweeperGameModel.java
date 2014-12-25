/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.minesweeper.model;

import component.chronometer.listener.ChronometerManagerListener;
import component.chronometer.model.ChronometerModel;
import java.util.Random;
import game.model.GameState;
import game.cell.model.CellModel;
import game.cell.model.MineSweeperCellModel;
import game.cell.state.CellState;
import game.cell.state.MineSweeperCellState;
import game.event.StatsChangedEvent;
import game.listener.GameListener;
import game.model.GameModel;
import java.util.List;
import model.impl.GridModel;
import model.impl.ObjectGridEvent;
import model.impl.ObjectGridListener;

/**
 *
 * @author group12
 */
public class MineSweeperGameModel extends GameModel implements ObjectGridListener {
    private int nbMines;
    private int rows;
    private int columns;
    private GridModel<MineSweeperCellModel> gridModel = new GridModel();
    private boolean firstDiscovered = false;
    private int nbMarkedMined;
    
    @Override
    protected void fireStatsChangedEvent() {
        for(GameListener l : this.observable.getListeners()) {
            l.statisticsChanged(new StatsChangedEvent(this, nbMines, nbMines - nbMarkedMined));
        }
    }
    
    /*
     * this places the mines in the grid by randomizing the row and col index of 
     * a cell to trap and decrementing the number of mines to place (determined by the user-informed
     * percentage of trapped mines to place
     */
    private void placeMines(MineSweeperCellModel firstCell) {
        int rowFirstCell = firstCell.getRow();
        int columnFirstCell = firstCell.getColumn();
        Random r = new Random();
        
        int minesNotPlaces = this.nbMines;
        while (minesNotPlaces > 0) {
            int randNumberI = r.nextInt(this.gridModel.getHeight());
            int randNumberJ = r.nextInt(this.gridModel.getWidth());

            while ((rowFirstCell != randNumberI && columnFirstCell != randNumberJ) && this.getCell(randNumberI, randNumberJ).getCellState().equals(MineSweeperCellState.MASQUED_MINED)) {
                randNumberI = r.nextInt(this.gridModel.getHeight());
                randNumberJ = r.nextInt(this.gridModel.getWidth());
            }
            
            MineSweeperCellModel c = this.gridModel.getObject(randNumberI, randNumberJ);
            MineSweeperCellModel minesWeeperCellModel = this.getCell(randNumberI,randNumberJ);
            minesWeeperCellModel.setMined(true);
            minesWeeperCellModel.setCellState(MineSweeperCellState.MASQUED_MINED);

            for(CellModel cell : c.getNeighboors()) {
                ((MineSweeperCellModel)cell).incNbMines();
            }
            
            minesNotPlaces--;
        }
    }
    
    /**
     *
     * @param chronometerManagerListener : a custom chronometer is linked to the game in
     * case scores have to be saved in the scoreboard.
     * @param chronometerModel
     */
    public MineSweeperGameModel(ChronometerManagerListener chronometerManagerListener, ChronometerModel chronometerModel) {
        super(chronometerManagerListener, chronometerModel);
        this.gridModel.addListener(this);
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
    public int getRows() {
        return rows;
    }

    /**
     *
     * @return
     */
    public int getColumns() {
        return columns;
    }

    /**
     *
     * @return
     */
    public int getNbMarkedMined() {
        return nbMarkedMined;
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
     * @param nbMarkedMined
     */
    public void setNbMarkedMined(int nbMarkedMined) {
        this.nbMarkedMined = nbMarkedMined;
        this.fireStatsChangedEvent();
    }
    
    /**
     *
     * @param rows : horizontal dimension of the grid
     * @param columns : vertical dimension of the grid
     * @param mines : mines to place in the grid
     */
    @Override
    public void createNewGame(int rows, int columns, int mines) {
        this.firstDiscovered = false;
        this.nbMarkedMined = 0;
        this.rows = rows;
        this.columns = columns;
        this.getChronometerModel().reset();
        this.gridModel.cleanGrid();
        this.fireLevelCleanedEvent();
        this.gridModel.createNewGrid(rows, columns, new MineSweeperCellModel(MineSweeperCellState.MASQUED_UNMARKED, false));
        this.setGameState(GameState.RUN);
        this.nbMines = mines;
        this.fireGameCreatedEvent(rows, columns);
        this.getChronometerManagerListener().startOccured();
    }
    
    /**
     *
     * @param minesWeeperCellModel : model part of the cell to mark
     * @param state : state of the concerned cell (will be used graphically)
     */
    public void markCell(MineSweeperCellModel minesWeeperCellModel, MineSweeperCellState state) {
        System.out.println(state.toString());
        switch(state) {
            case MASQUED_MARKED_MINED:
                this.setNbMarkedMined(nbMarkedMined + 1);
                break;
            case MASQUED_UNKNOWN:
                if(minesWeeperCellModel.getCellState() == MineSweeperCellState.MASQUED_MARKED_MINED) {
                    this.setNbMarkedMined(nbMarkedMined - 1);
                }
                break;
            case MASQUED_UNMARKED:
                if(minesWeeperCellModel.getCellState() == MineSweeperCellState.MASQUED_MARKED_MINED) {
                    this.setNbMarkedMined(nbMarkedMined - 1);
                }
                break;
        }
        minesWeeperCellModel.setCellState(state);
    }
    
    /**
     *
     */
    public void discoverRemainingCells() {
        for(List<MineSweeperCellModel> row : this.getGrid()) {
            for(MineSweeperCellModel c : row) {
                switch(c.getCellState()) {
                    case MASQUED_UNMARKED:
                        c.setCellState(MineSweeperCellState.UNMASQUED_EMPTY_NOMINES);
                        break;
                    case MASQUED_MINED:
                        c.setCellState(MineSweeperCellState.UNMASQUED_MINE);
                        break;
                    case MASQUED_MARKED_MINED:
                        if(c.isMined()) {
                            c.setCellState(MineSweeperCellState.UNMASQUED_MINE);
                        }
                        else {
                            c.setCellState(MineSweeperCellState.UNMASQUED_EMPTY_NOMINES);
                        }
                        break;
                    case MASQUED_UNKNOWN:
                        if(c.isMined()) {
                            c.setCellState(MineSweeperCellState.UNMASQUED_MINE);
                        }
                        else {
                            c.setCellState(MineSweeperCellState.UNMASQUED_EMPTY_NOMINES);
                        }
                        break;
                }
            }
        }
    }
    /**
     *
     * @param c : model part of the cell to unveal
     */
    public void discoverCell(MineSweeperCellModel c) {
       if(!this.firstDiscovered) {
           this.placeMines(c);
           this.firstDiscovered = true;
       }
        
        MineSweeperCellModel minesWeeperCellModel = (MineSweeperCellModel)c; 
        
        if(minesWeeperCellModel.getCellState() == MineSweeperCellState.MASQUED_MARKED_MINED) {
            this.nbMarkedMined--;
        }
        
        if(minesWeeperCellModel.isMined()) {
            minesWeeperCellModel.setCellState(MineSweeperCellState.UNMASQUED_EXPLOSED_MINE);
            this.setGameState(GameState.LOST);  //unvealing a mine leads to a game over.
        }
        // On découvre tous les voisins récursivement
        else if(minesWeeperCellModel.getNbMines() == 0) {
            minesWeeperCellModel.setCellState(MineSweeperCellState.UNMASQUED_EMPTY_NOMINES);
            int i = c.getRow();
            int j = c.getColumn();
            for(int yc = i-1; yc <= i + 1; yc++) {
                for(int xc = j - 1; xc <= j + 1; xc++) {
                    if ((xc != j || yc != i) && xc >= 0 && yc >= 0 && xc < this.gridModel.getWidth() && yc < this.gridModel.getHeight()) {
                        if(this.getCell(yc, xc).getCellState() != MineSweeperCellState.UNMASQUED_EMPTY_NOMINES) {
                            this.discoverCell(this.getCell(yc, xc));    
                            /*
                             * chain reaction : unvealing an empty cell
                             * leads to unvealing its neighbors while while theirs neighbours are clean too
                             */
                        }
                    }
                }
            }
        }
        // if there is a mine in a adjacent cell it displays the number of mines
        else {
            minesWeeperCellModel.setCellState(MineSweeperCellState.UNMASQUED_EMPTY_MINES);
        }
    }
    
    /**
     *
     * @param i : row index
     * @param j : column index
     */
    public void discoverCell(int i, int j) {
        this.discoverCell(this.gridModel.getObject(i, j));
    }
    
    /**
     *
     */
    public void checkIfWon() {
        // Victory conditions
        //  No more UNMARKED #
        // No more indecisive ?
        // No more ! when there is no mine
        boolean win = true;
        if(this.getGameState() == GameState.LOST) {
            this.getChronometerManagerListener().stopOccured();
            this.discoverRemainingCells();
            win = false;
        }
        else {
            for (int i = 0; i < this.gridModel.getHeight() && win; i++) {
               for (int j = 0; j < this.gridModel.getWidth() && win; j++) {
                    MineSweeperCellModel minesWeeperCellModel = this.getCell(i, j);
                     CellState cellState = minesWeeperCellModel.getCellState();
                     if(  cellState == MineSweeperCellState.MASQUED_UNMARKED || 
                          cellState == MineSweeperCellState.MASQUED_UNKNOWN ||
                          (cellState == MineSweeperCellState.MASQUED_MARKED_MINED && !minesWeeperCellModel.isMined())) {
                         win = false;
                     }
               }
            }
        }
        
        if(win) {
            
            this.discoverRemainingCells();
            this.getChronometerManagerListener().stopOccured();
            this.setGameState(GameState.WON);
        }
    }
    
    /**
     *
     * @param i : row index
     * @param j : column index
     * @return the model part of the designated cell
     */
    public MineSweeperCellModel getCell(int i, int j) {
        return this.gridModel.getObject(i, j);
    }

    /**
     *
     * @param e : event that will notify that neighbors of a cell have been associated with it
     */
    @Override
    public void objectCreated(ObjectGridEvent e) {
        if(e.getObject() instanceof MineSweeperCellModel) {
            MineSweeperCellModel cell = (MineSweeperCellModel)e.getObject();
            int row = e.getRow();
            int column = e.getColumn();
        
            cell.setRow(row);
            cell.setColumn(column);
            if(column > 0) {
                cell.addNeighboor(this.gridModel.getObject(row, column-1));
            }
            //Du dessus
            if(row > 0) {
                cell.addNeighboor(this.gridModel.getObject(row-1, column));
            }
            //Diagonale gauche/droite
            if(row > 0 && column > 0) {
                cell.addNeighboor(this.gridModel.getObject(row-1, column-1));
            }
            if(row > 0 && column >= 0 && column < this.gridModel.getWidth() - 1) {
                 cell.addNeighboor(this.gridModel.getObject(row-1, column+1));
            }
            this.fireCellCreatedEvent(cell);
        }
        
    }

    /**
     *
     */
    @Override
    public void turnFinished() {
        this.checkIfWon();
        this.fireTurnFinishedEvent();
    }
    
    /**
     *
     * @return
     */
    public List< List<MineSweeperCellModel>> getGrid() {
        return this.gridModel.getGrid();
    }

    
}
