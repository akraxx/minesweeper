/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mycomponent.levelchooser.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author group12
 */
public class QuitGameController implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
    
}
