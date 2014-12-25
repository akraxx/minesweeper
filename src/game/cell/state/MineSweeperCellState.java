/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.cell.state;

import javax.swing.ImageIcon;

/**
 *
 * @author group12
 */
public enum MineSweeperCellState implements CellState {
    /**
     *
     */
    MASQUED_UNMARKED(MineSweeperCellState.MASQUED_UNMARKED_STRING, null),
    /**
     *
     */
    MASQUED_MINED(MineSweeperCellState.MASQUED_MINED_STRING, null),
    /**
     *
     */
    MASQUED_MARKED_MINED(MineSweeperCellState.MASQUED_MARKED_MINED_STRING, null),
    /**
     *
     */
    MASQUED_UNKNOWN(MineSweeperCellState.MASQUED_UNKNOWN_STRING, null),
    /**
     *
     */
    UNMASQUED_EMPTY_NOMINES(MineSweeperCellState.UNMASQUED_EMPTY_NOMINES_STRING, null),
    /**
     *
     */
    UNMASQUED_EMPTY_MINES(MineSweeperCellState.UNMASQUED_EMPTY_MINES_STRING, null),
    /**
     *
     */
    UNMASQUED_MINE(MineSweeperCellState.UNMASQUED_MINE_STRING, null),
    /**
     *
     */
    UNMASQUED_EXPLOSED_MINE(MineSweeperCellState.UNMASQUED_MINE_STRING, null);
    
    /**
     *
     */
    public static final String MASQUED_UNMARKED_STRING = "#";
    /**
     *
     */
    public static final String MASQUED_MINED_STRING = "M"; // CHANGE FOR DEBUG
    /**
     *
     */
    public static final String MASQUED_MARKED_MINED_STRING = "!";
    /**
     *
     */
    public static final String MASQUED_UNKNOWN_STRING = "?";
    /**
     *
     */
    public static final String UNMASQUED_EMPTY_NOMINES_STRING = ".";
    /**
     *
     */
    public static final String UNMASQUED_EMPTY_MINES_STRING = "n";
    /**
     *
     */
    public static final String UNMASQUED_MINE_STRING = "X";
    
    private String value;
    private ImageIcon icon;
    
    /****************************
    * CONSTRUCTOR
    ****************************/
    /**
     * Set the value of the enum
     * @param value Value of the enum
     */
    private MineSweeperCellState(String value, ImageIcon icon) {
            this.value = value;
            this.icon = icon;
    }
    
    /****************************
    * PUBLIC FUNCTION
    ****************************/
    /**
     * Return the string value
     * @return The value of the Enum
     */
    @Override
    public String toString() {
            return this.value;
    } 

    /**
     *
     * @return
     */
    public ImageIcon getIcon() {
        return icon;
    }

    /**
     *
     * @param icon
     */
    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }
}
