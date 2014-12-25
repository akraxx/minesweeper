/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package component.chronometer.model;

import component.ComponentObservable;
import component.chronometer.event.ValueChangedChronometerEvent;
import component.chronometer.listener.ChronometerListener;

/**
 *
 * @author group12
 */
public class ChronometerModel {
    private ComponentObservable<ChronometerListener> observable = new ComponentObservable<>();
    
    private int centseconds;
    private int seconds;
    private int minutes;
    private int hours;
    
    private void fireValueChangedEvent() {
        for(ChronometerListener l : this.observable.getListeners()) {
            l.valueChanged(new ValueChangedChronometerEvent(this, this.centseconds, this.seconds, this.minutes, this.hours));
        }
    }
    
    /**
     *
     * @param l : listener to add
     */
    public void addListener(ChronometerListener l) {
        this.observable.addListener(l);
    }
    
    /**
     * increments the chronometer's hundredth of second value
     * and, if necessary, adjusts the seconds value and minutes value
     */
    public void incCentSeconds() {
        this.centseconds++;
        if(this.centseconds == 100) {
            this.seconds++;
            this.centseconds = 0;
        }
        if(this.seconds == 60) {
            this.minutes++;
            this.seconds = 0;
        }
        if(this.minutes == 60) {
            this.hours++;
            this.minutes = 0;
        }
        
        this.fireValueChangedEvent();
    }

    /**
     *
     * @return
     */
    public int getCentseconds() {
        return centseconds;
    }
    
    /**
     *
     * @return
     */
    public int getSeconds() {
        return seconds;
    }

    /**
     *
     * @return
     */
    public int getMinutes() {
        return minutes;
    }

    /**
     *
     * @return
     */
    public int getHours() {
        return hours;
    }
    
    /**
     * resets the chronometer's measure to 0
     */
    public void reset() {
        this.centseconds = 0;
        this.seconds = 0;
        this.minutes = 0;
        this.hours = 0;
    }
    
    /**
     *
     * @param m : model of a custom chronometer
     * @return a conversion of the chronometer's measure in a long (easier to manupulate then)
     */
    public static long convertTime(ChronometerModel m) {
        return convertTime(m.centseconds, m.seconds, m.minutes, m.hours);
    }
    
    /**
     *
     * @param centsseconds : hundredth of seconds
     * @param seconds
     * @param minutes
     * @param hours
     * @return
     */
    public static long convertTime(int centsseconds, int seconds, int minutes, int hours) {
        return centsseconds + (100 * (seconds + 60 * (minutes + 60 * hours))); 
    }
    
    /**
     *
     * @param cents
     * @return
     */
    public static String convertTime(long cents) {
        int hours = (int)cents / 360000;
        System.out.println(hours);
        int minutes = (int)(cents - (hours * 360000)) / 6000;
        int secondes = (int)(cents - (minutes * 6000)) / 60;
        int centssecondes = (int)(cents - (secondes * 60));
        
        return hours + "H" + minutes + "m" + secondes + "s" + centssecondes;
    }

    
}
