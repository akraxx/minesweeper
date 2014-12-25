/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author group12
 */
public abstract class Model {
    /**
     *
     */
    protected int width;
    /**
     *
     */
    protected int height;
    
    /**
     *
     * @param width : horizontal dimension
     * @param height : vertical dimension
     */
    public Model(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /**
     *
     * @return
     */
    public int getWidth() {
        return width;
    }

    /**
     *
     * @return
     */
    public int getHeight() {
        return height;
    }
    
}
