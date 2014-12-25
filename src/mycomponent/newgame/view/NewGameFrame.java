/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mycomponent.newgame.view;

import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 *
 * @author group12
 */
public class NewGameFrame extends JFrame {

    /**
     *
     * @param title
     * @throws HeadlessException
     */
    public NewGameFrame(String title) throws HeadlessException {
        super(title);
        
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
    
}
