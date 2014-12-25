/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.scores.model;

import component.ComponentObservable;
import game.scores.event.GameScoreDeserealizedEvent;
import game.scores.listener.GameScoreListListener;
import game.scores.listener.GameScoreSerializerListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author group12
 */
public class GameScoreSerializerModel {
    private ComponentObservable<GameScoreListListener> observable = new ComponentObservable<>();
    private ComponentObservable<GameScoreSerializerListener> observableSerializer = new ComponentObservable<>();
    private GameScoreListModel currentModel;
    
    private void fireDeserealizedEvent() {
        for(GameScoreSerializerListener l : this.observableSerializer.getListeners()) {
            l.gameScoreDeserialized(new GameScoreDeserealizedEvent(l, currentModel));
        }
    }
    /**
     *
     * @param l
     */
    public void addListener(GameScoreListListener l) {
        this.observable.addListener(l);
    }
    
    /**
     *
     * @param l
     */
    public void addSerializerListener(GameScoreSerializerListener l) {
        this.observableSerializer.addListener(l);
    } 
    
    /**
     *
     * @param fileName
     */
    public void serialize(String fileName) {
        if(this.currentModel != null) {
            try {
                FileOutputStream fos = new FileOutputStream(fileName);

                // création d'un "flux objet" avec le flux fichier
                ObjectOutputStream oos= new ObjectOutputStream(fos);
                try {
                        // sérialisation : écriture de l'objet dans le flux de sortie
                        oos.writeObject(this.currentModel); 
                        // on vide le tampon
                        oos.flush();
                } finally {
                        //fermeture des flux
                        try {
                                oos.close();
                        } finally {
                                fos.close();
                        }
                }
            }
            catch(IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
    
    /**
     *
     * @param file
     */
    public void dezerialize(File file) {
        try {
                // ouverture d'un flux d'entrée depuis le fichier "personne.serial"
                FileInputStream fis = new FileInputStream(file);
                // création d'un "flux objet" avec le flux fichier
                ObjectInputStream ois= new ObjectInputStream(fis);
                try {	
                        // désérialisation : lecture de l'objet depuis le flux d'entrée
                        this.currentModel = (GameScoreListModel) ois.readObject(); 
                        this.currentModel.initObservable();
                        this.currentModel.addListener(this.observable.getListeners());
                        this.currentModel.printScores();

                } finally {
                        // on ferme les flux
                        try {
                                ois.close();
                        } finally {
                                fis.close();
                        }
                }
        } catch(IOException ioe) {
                ioe.printStackTrace();
        } catch(ClassNotFoundException cnfe) {
                cnfe.printStackTrace();
        }
        if(this.currentModel != null) {
            this.fireDeserealizedEvent();
        }
    }

    /**
     *
     * @return
     */
    public GameScoreListModel getCurrentModel() {
        return currentModel;
    }

    /**
     *
     * @param currentModel
     */
    public void setCurrentModel(GameScoreListModel currentModel) {
        this.currentModel = currentModel;
    }
    
    
}
