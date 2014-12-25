/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.cell.view;

import game.cell.listener.CellListener;
import game.cell.model.MineSweeperCellModel;
import game.cell.state.MineSweeperCellState;
import game.event.CellChangedEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author group12
 */
public class MineSweeperGraphicalCellView extends JButton implements CellListener, ComponentListener {
    /*
     * creates a graphical cell visible on-screen which will react to what its listener tells it to do
     */
    /**
     *
     * @param defaultState
     */
    public MineSweeperGraphicalCellView(MineSweeperCellState defaultState) {
        this.addComponentListener(this);
        this.setIcon(defaultState.getIcon());
    }
    
    /*
     * resizes the image of a cell to adapt itself to a new scale  
     */
    private ImageIcon resizeImage(ImageIcon currentImageIcon) {
        if(currentImageIcon != null) {
            Image icon = currentImageIcon.getImage();
            Image resizedImage = icon.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
            return new ImageIcon(resizedImage);
        }
        else {
            return null;
        }
    }
    
    private int getMinimum(int height, int width) {
        if(height > width) {
            return width;
        }
        else {
            return height;
        }
    }
    /**
     *
     * @param e : generic event, notifying the change in a cell
     */
    @Override
    public void cellChanged(CellChangedEvent e) {
        if(e.getCell() instanceof MineSweeperCellModel) {
            MineSweeperCellModel minesWeeperCellModel = (MineSweeperCellModel)e.getCell();
            
            /*
             * if a cell is visually masqued, it will be either displayed as a # or ! or ? depending on whether and how it is tagged 
             * if a cell is unmasqued, the JButton method setEnabled will be called to notify it visually
             * see the different MineSweeperCellStates for further information
             */
            switch(minesWeeperCellModel.getCellState()) {
                case MASQUED_MARKED_MINED:
                    this.setIcon(this.resizeImage(MineSweeperCellState.MASQUED_MARKED_MINED.getIcon()));
                    break;
                case MASQUED_UNKNOWN:
                    this.setIcon(this.resizeImage(MineSweeperCellState.MASQUED_UNKNOWN.getIcon()));
                    break;
                case MASQUED_UNMARKED:
                    this.setIcon(this.resizeImage(MineSweeperCellState.MASQUED_UNMARKED.getIcon()));
                    break;
                case UNMASQUED_EMPTY_MINES:
                    this.setEnabled(false);
                    this.setIcon(null);
                    this.setText(String.valueOf(minesWeeperCellModel.getNbMines()));
                    break;
                case UNMASQUED_EMPTY_NOMINES:
                    this.setEnabled(false);
                    this.setIcon(this.resizeImage(MineSweeperCellState.UNMASQUED_EMPTY_NOMINES.getIcon()));
                    break;
                case UNMASQUED_MINE:
                    this.setEnabled(false);
                    this.setIcon(this.resizeImage(MineSweeperCellState.UNMASQUED_MINE.getIcon()));
                    break;
                case UNMASQUED_EXPLOSED_MINE:
                    this.setEnabled(false);
                    this.setIcon(this.resizeImage(MineSweeperCellState.UNMASQUED_EXPLOSED_MINE.getIcon()));
                    break;
            }
        }
    }
    
    @Override
    public void componentResized(ComponentEvent e) {
        if(this.getIcon() != null && this.getIcon() instanceof ImageIcon) {
            this.setIcon(this.resizeImage((ImageIcon)this.getIcon()));
        }
        
        this.setFont(new Font(this.getFont().getName(),this.getFont().getStyle(),this.getMinimum(this.getHeight(), this.getWidth()) / 6));
    }

    @Override
    public void componentMoved(ComponentEvent e) {
        
    }

    @Override
    public void componentShown(ComponentEvent e) {
        
    }

    @Override
    public void componentHidden(ComponentEvent e) {
        
    }

    
}
