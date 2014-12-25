/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.scores.model;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author group12
 */
public class GameScoreExtensionFilter extends FileFilter {
    /**
     *
     */
    public static final String DEFAULT_EXTENSION = "gamescore";
    /**
     *
     */
    public static final String DEFAULT_DIR = ".\\maps\\";

    String description;
    String extensions[];

    /**
     *
     * @param description
     * @param extension
     */
    public GameScoreExtensionFilter(String description, String extension) {
        this(description, new String[]{extension});
    }

    /**
     *
     * @param description
     * @param extensions
     */
    public GameScoreExtensionFilter(String description, String extensions[]) {
        if (description == null) {
            this.description = extensions[0];
        } else {
            this.description = description;
        }
        this.extensions = (String[]) extensions.clone();
        toLower(this.extensions);
    }

    private void toLower(String array[]) {
        for (int i = 0, n = array.length; i < n; i++) {
            array[i] = array[i].toLowerCase();
        }
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean accept(File file) {
        if (file.isDirectory()) {
            return true;
        } else {
            String path = file.getAbsolutePath().toLowerCase();
            for (int i = 0, n = extensions.length; i < n; i++) {
                String extension = extensions[i];
                if ((path.endsWith(extension) && (path.charAt(path.length() - extension.length() - 1)) == '.')) {
                    return true;
                }
            }
        }
        return false;
    }
}
