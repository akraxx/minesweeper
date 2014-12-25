/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package component.chronometer.controller;

import component.chronometer.listener.ChronometerManagerListener;
import component.chronometer.model.ChronometerModel;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author group12
 */

/*
 * Controller part of a custom chronometer
 */
public class ChronometerController implements ChronometerManagerListener {
    private Timer timer = new Timer();
    private TimerTask currentTask = null;
    private ChronometerModel model;
    private long period = 10;
    
    private class SecondsTask extends TimerTask {
        private ChronometerModel model;

        public SecondsTask(ChronometerModel model) {
            this.model = model;
        }
        
        @Override
        public void run() {
            this.model.incCentSeconds();
        }
        
        
    }
    
    /**
     *
     * @param model : the model part of the chronometer
     */
    public ChronometerController(ChronometerModel model) {
        this.model = model;
    }

    /**
     * starts a custom chronometer 
     */
    @Override
    public void startOccured() {
        if(currentTask == null) {
            this.currentTask = new SecondsTask(model);
            this.timer.scheduleAtFixedRate(this.currentTask, 0, this.period);
        }
    }

    /**
     * stops the currently functionning chronometer
     */
    @Override
    public void stopOccured() {
        if(this.currentTask != null) {
            this.currentTask.cancel();
            this.currentTask = null;
        }
    }
    
}
