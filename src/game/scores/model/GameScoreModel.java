/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.scores.model;

import java.io.Serializable;

/**
 *
 * @author group12
 */
public class GameScoreModel implements Comparable, Serializable {
    private long time;
    private String nickname;

    /**
     *
     * @param time
     * @param nickname
     */
    public GameScoreModel(long time, String nickname) {
        this.time = time;
        this.nickname = nickname;
    }

    /**
     *
     * @return
     */
    public long getTime() {
        return time;
    }

    /**
     *
     * @param time
     */
    public void setTime(long time) {
        this.time = time;
    }

    /**
     *
     * @return
     */
    public String getNickname() {
        return nickname;
    }

    /**
     *
     * @param nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    /*
     * compares two saved scoes by comparing their own time values
     */
    public int compareTo(Object o) {
        if(o instanceof GameScoreModel) {
            GameScoreModel other = (GameScoreModel)o;
            if(other.time > this.time) {
                return 1;
            }
            else if(other.time == this.time) {
                return 0;
            }
            else {
                return -1;
            }
        }
        return -1;
    }


}
