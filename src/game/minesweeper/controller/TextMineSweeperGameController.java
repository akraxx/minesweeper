/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.minesweeper.controller;

import game.cell.model.MineSweeperCellModel;
import game.cell.state.CellState;
import game.cell.state.MineSweeperCellState;
import game.minesweeper.model.MineSweeperGameModel;
import game.model.GameState;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 *
 * @author group12
 */
public class TextMineSweeperGameController extends MineSweeperGameController implements Runnable {
    /**
     *
     */
    public static final int INDEX_COMMAND = 0;
    /**
     *
     */
    public static final int INDEX_I = 1;
    /**
     *
     */
    public static final int INDEX_J = 2;
    /**
     *
     */
    public static final int INDEX_SIGN = 3;
    
    /**
     *
     * @param gameModel
     */
    public TextMineSweeperGameController(MineSweeperGameModel gameModel) {
        super(gameModel);
    }
    
    private void askForCommand() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your command :");

        try {
            doAction(sc.nextLine());
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            this.askForCommand();
        }
    }
    
    private void doAction(String str) {
        MineSweeperGameModel model = this.getGameModel();
        //check bound if coords
        if(Pattern.matches("^([d|m] \\d* \\d*.*)", str)) {
            String[] elements = str.split(" ");
            
            String cmd = elements[INDEX_COMMAND];
            
            int i = Integer.valueOf(elements[INDEX_I]);
            int j = Integer.valueOf(elements[INDEX_J]);
            
            MineSweeperCellModel c = model.getCell(i, j);
            CellState state = c.getCellState();
            if(state == MineSweeperCellState.UNMASQUED_EMPTY_MINES || state == MineSweeperCellState.UNMASQUED_EMPTY_NOMINES) {
                throw new IllegalArgumentException("You can not modify this cell, already discovered");
            }
            switch (cmd) {
                case "d":
                    model.discoverCell(c);
                    break;
                case "m":
                    String sign = elements[INDEX_SIGN];
                    switch(sign) {
                        case "!":
                            model.markCell(c, MineSweeperCellState.MASQUED_MARKED_MINED);
                            break;
                        case "?":
                            model.markCell(c, MineSweeperCellState.MASQUED_UNKNOWN);
                            break;
                        case "#":
                            model.markCell(c, MineSweeperCellState.MASQUED_UNMARKED);
                            break;
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Command not found");    
            }
        }
        //Quitter le jeu
        else if(Pattern.matches("^[q]$", str)) {
            System.out.println("Game aborted");
            System.exit(0);
        }
        else {
            System.out.println("Unknown command");
        }
        
        model.turnFinished();
        
        if(model.getGameState() == GameState.RUN) {
            this.askForCommand();
        }
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(50);
                if(this.getGameModel().getGameState() == GameState.RUN) {
                    this.askForCommand();
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(TextMineSweeperGameController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    
}
