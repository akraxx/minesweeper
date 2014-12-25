/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package component.boundedvalue.item.model;

/**
 *
 * @author group12
 */
public enum PredefinedBoundedValues {
    /**
     * These are the default values associated to a bounded item
     */
    CHOOSE_ROWS("Rows", 9, 9, 24),
    /**
     *
     */
    CHOOSE_COLUMNS("Columns", 19, 9, 30),
    /**
     *
     */
    CHOOSE_MINES("Mines", 76, 10, (int)((0.85) * (9 * 19)));
    
    private String label;
    private int defaultValue;
    private int minimum;
    private int maximum;

    private PredefinedBoundedValues(String label, int defaultValue, int minimum, int maximum) {
        this.label = label;
        this.defaultValue = defaultValue;
        this.minimum = minimum;
        this.maximum = maximum;
    }

    /**
     *
     * @return
     */
    public String getLabel() {
        return label;
    }
    
    /**
     *
     * @return
     */
    public int getDefaultValue() {
        return defaultValue;
    }

    /**
     *
     * @return
     */
    public int getMinimum() {
        return minimum;
    }

    /**
     *
     * @return
     */
    public int getMaximum() {
        return maximum;
    }
    
    
}
