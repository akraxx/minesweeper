/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.minesweeper.view;

import component.ComponentObservable;
import game.cell.controller.GraphicalCellControler;
import game.cell.listener.CellActionListener;
import game.cell.model.MineSweeperCellModel;
import game.cell.view.MineSweeperGraphicalCellView;
import game.event.*;
import game.listener.GameListener;
import game.minesweeper.model.MineSweeperGameModel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author group12
 */
public class GraphicalMineSweeperGameView extends JPanel implements GameListener {
    private ComponentObservable<CellActionListener> observable = new ComponentObservable<>();
    private JPanel gridPanel = new JPanel();
    private GridLayout gridLayout = new GridLayout();
    
    
    private List<MineSweeperGraphicalCellView> cellsView = new LinkedList<>();

    /**
     * the visual part of the cell grid, using a gridLayout to organise the cells 
     */
    public GraphicalMineSweeperGameView() {
        this.setLayout(new BorderLayout());
        this.gridPanel.setLayout(this.gridLayout);
        this.add(this.gridPanel, BorderLayout.CENTER);
    }
    
    
    /**
     *
     * @param e
     */
    @Override
    public void gameStateChanged(GameStateChangedEvent e) {
        
    }

    /**
     *
     * @param e : event indicating that a Mine Sweeper game has been created 
     */
    @Override
    public void gameCreated(GameCreatedEvent e) {
        MineSweeperGameModel model = (MineSweeperGameModel)e.getModel();
        this.gridLayout.setRows(model.getRows());
        this.gridLayout.setColumns(model.getColumns());
        for(MineSweeperGraphicalCellView v : this.cellsView) {
            this.gridPanel.add(v);
        }
        this.revalidate();
    }

    /**
     *
     * @param e
     */
    @Override
    public void cellCreated(CellCreatedEvent e) {
        if(e.getCell() instanceof MineSweeperCellModel) {
            MineSweeperCellModel m = (MineSweeperCellModel)e.getCell();
            MineSweeperGraphicalCellView v = new MineSweeperGraphicalCellView(m.getCellState());
            GraphicalCellControler c = new GraphicalCellControler(m);

            v.addActionListener(c);
            v.addMouseListener(c);
            m.addListener(v);
            m.addActionListener(this.observable.getListeners());

            this.cellsView.add(v);
        }
    }
    

    /**
     *
     * @param e
     */
    @Override
    public void turnFinished(TurnFinishedEvent e) {

    }
    
    /**
     *
     * @param l
     */
    public void addListener(CellActionListener l) {
        this.observable.addListener(l);
    }

    /**
     *
     */
    @Override
    public void clearLevel() {
        this.gridPanel.removeAll();
        this.cellsView.clear();
    }

    /**
     *
     * @param e
     */
    @Override
    public void statisticsChanged(StatsChangedEvent e) {
        
    }
    
    
}
