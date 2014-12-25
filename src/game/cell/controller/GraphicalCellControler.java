/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.cell.controller;

import game.cell.model.CellModel;
import game.cell.model.MineSweeperCellModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author group12
 */
public class GraphicalCellControler implements ActionListener, MouseListener {
    private MineSweeperCellModel model;

    /**
     *
     * @param model
     */
    public GraphicalCellControler(MineSweeperCellModel model) {
        if(model != null) {
            this.model = model;
        }
        else {
            throw new NullPointerException("CellModel can not be null");
        }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.model.selectedCell();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON3) {
            this.model.markedCell();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
    
    
}
