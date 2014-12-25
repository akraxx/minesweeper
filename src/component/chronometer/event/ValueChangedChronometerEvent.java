/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package component.chronometer.event;

import component.event.ComponentEvent;

/**
 *
 * @author group12
 */
public class ValueChangedChronometerEvent extends ComponentEvent {
    private int centseconds;
    private int seconds;
    private int minutes;
    private int hours;

    /**
     *
     * @param source : the chronometer whose values changed
     * @param centseconds : the hundredth of seconds value of the chronometer
     * @param seconds : the seconds value of the chronometer
     * @param minutes : the minutes value of the chronometer
     * @param hours : : the hours value of the chronometer
     */
    public ValueChangedChronometerEvent(Object source, int centseconds, int seconds, int minutes, int hours) {
        super(source);
        this.centseconds = centseconds;
        this.seconds = seconds;
        this.minutes = minutes;
        this.hours = hours;
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
}
