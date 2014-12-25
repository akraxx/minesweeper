/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package launcher;

import component.boundedvalue.item.controller.SliderBoundedValueItemController;
import component.boundedvalue.item.controller.TextFieldBoundedValueItemController;
import component.boundedvalue.item.model.AdaptaterMinesBoundedValueComponent;
import component.boundedvalue.item.model.BoundedValueItemModel;
import component.boundedvalue.item.model.PredefinedBoundedValues;
import component.boundedvalue.item.view.gui.SliderBoundedValueItemView;
import component.boundedvalue.item.view.gui.TextFieldBoundedValueItemView;
import component.boundedvalue.model.BoundedValueModel;
import component.boundedvalue.view.gui.BoundedValueView;
import component.chronometer.controller.ChronometerController;
import component.chronometer.listener.ChronometerManagerListener;
import component.chronometer.model.ChronometerModel;
import component.chronometer.view.LabelChronometerView;
import game.cell.state.MineSweeperCellState;
import game.minesweeper.controller.GraphicalMineSweeperGameController;
import game.minesweeper.controller.TextMineSweeperGameController;
import game.minesweeper.model.MineSweeperGameModel;
import game.minesweeper.view.GraphicalMineSweeperGameView;
import game.minesweeper.view.NbMinesRemainingGraphicalView;
import game.minesweeper.view.TextMineSweeperGameView;
import game.minesweeper.view.sidegamepanel.SideGamePanelController;
import game.minesweeper.view.sidegamepanel.SideGamePanelModel;
import game.minesweeper.view.sidegamepanel.SideGamePanelView;
import game.minesweeper.view.window.GameView;
import game.minesweeper.view.window.MainPanelGameView;
import game.scores.controller.GameScoreDeserializerController;
import game.scores.controller.GameScoreListController;
import game.scores.controller.GameScoreSerializerController;
import game.scores.model.GameScoreListModel;
import game.scores.model.GameScoreSerializerModel;
import game.scores.view.GameScoreListView;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import mycomponent.customgame.controller.CustomGameController;
import mycomponent.customgame.model.CustomGameModel;
import mycomponent.customgame.view.CustomGameView;
import mycomponent.levelchooser.controller.LevelChooserController;
import mycomponent.levelchooser.controller.QuitGameController;
import mycomponent.levelchooser.model.CustomLevelModel;
import mycomponent.levelchooser.model.LevelValues;
import mycomponent.levelchooser.model.PredefinedLevelModel;
import mycomponent.levelchooser.view.menu.MenuItemLevelChooserView;
import mycomponent.levelchooser.view.radiobutton.RadioButtonCustomLevelChooserView;
import mycomponent.levelchooser.view.radiobutton.RadioButtonPredefinedLevelChooserView;
import mycomponent.newgame.controller.ButtonNewGameController;
import mycomponent.newgame.model.NewGameModel;
import mycomponent.newgame.view.NewGameView;

/**
 *
 * @author group12
 */
public class CompleteGameLauncher extends JApplet {
    
    /*
     * loads the icons for the different states of a cell (game aspect)
     */
    private void initIcons() {
        Class loadClass = new CompleteGameLauncher().getClass();
        MineSweeperCellState.UNMASQUED_MINE.setIcon(new ImageIcon(loadClass.getResource("/resources/mine.png"), "mine"));
        MineSweeperCellState.MASQUED_UNKNOWN.setIcon(new ImageIcon(loadClass.getResource("/resources/unknown.png"), "unknown_mine"));
        MineSweeperCellState.MASQUED_MARKED_MINED.setIcon(new ImageIcon(loadClass.getResource("/resources/flag.png"), "flag"));
        MineSweeperCellState.UNMASQUED_EXPLOSED_MINE.setIcon(new ImageIcon(loadClass.getResource("/resources/mine_explosed.png"), "mine_explosed"));
    }

    /**
     *
     */
    public CompleteGameLauncher() {
        
    }

    @Override
    /*
     * creates the menus for custom and/or predefined games with their custom
     * sliders text fields etc..
     * 
     * creates a chronometer and associates it with the game so that scores can be saved
     * 
     * creates the predefined difficulty levels
     * 
     * adds listeners to views such as the score, specific of the game
     * once it has been created
     */
    public void init() {
        this.initIcons();
        BoundedValueModel rowsModel = new BoundedValueModel(PredefinedBoundedValues.CHOOSE_ROWS);
        BoundedValueModel columnsModel = new BoundedValueModel(PredefinedBoundedValues.CHOOSE_COLUMNS);
        BoundedValueModel minesModel = new BoundedValueModel(PredefinedBoundedValues.CHOOSE_MINES);
        
        BoundedValueItemModel rowsItemModel = rowsModel.getItemModel();
        BoundedValueItemModel columnsItemModel = columnsModel.getItemModel();
        BoundedValueItemModel minesItemModel = minesModel.getItemModel();
        
        /*
         *  ITEMS CONTROLLERS
         */
        // SLIDER CONTROLLERS
        SliderBoundedValueItemController sliderControllerRows = new SliderBoundedValueItemController(rowsItemModel);
        SliderBoundedValueItemController sliderControllerColumns = new SliderBoundedValueItemController(columnsItemModel);
        SliderBoundedValueItemController sliderControllerMines = new SliderBoundedValueItemController(minesItemModel);
        //TEXT FIELD CONTROLLERS
        TextFieldBoundedValueItemController textFieldControllerRows = new TextFieldBoundedValueItemController(rowsItemModel);
        TextFieldBoundedValueItemController textFieldControllerColumns = new TextFieldBoundedValueItemController(columnsItemModel);
        TextFieldBoundedValueItemController textFieldControllerMines = new TextFieldBoundedValueItemController(minesItemModel);
        
        /*
         * ITEMS VIEW
         */
        // SLIDER VIEW
        SliderBoundedValueItemView sliderViewRows = new SliderBoundedValueItemView();
        SliderBoundedValueItemView sliderViewColumns = new SliderBoundedValueItemView();
        SliderBoundedValueItemView sliderViewMines = new SliderBoundedValueItemView();
        // TEXT FIELD VIEW
        TextFieldBoundedValueItemView textFieldViewRows = new TextFieldBoundedValueItemView();
        TextFieldBoundedValueItemView textFieldViewColumns = new TextFieldBoundedValueItemView();
        TextFieldBoundedValueItemView textFieldViewMines = new TextFieldBoundedValueItemView();
        
        /*
         * ADD CONTROLLERS TO COMPONENT
         */
        //SLIDER LISTENERS
        sliderViewRows.addChangeListener(sliderControllerRows);
        sliderViewColumns.addChangeListener(sliderControllerColumns);
        sliderViewMines.addChangeListener(sliderControllerMines);
        //TEXTFIELD LISTENERS
        textFieldViewRows.addActionListener(textFieldControllerRows);
        textFieldViewColumns.addActionListener(textFieldControllerColumns);
        textFieldViewMines.addActionListener(textFieldControllerMines);
        
        /*
         * ADD VIEWS TO MODEL
         */
        //SLIDERS VIEWS
        rowsItemModel.addListener(sliderViewRows);
        columnsItemModel.addListener(sliderViewColumns);
        minesItemModel.addListener(sliderViewMines);
        //TEXTFIELD VIEWS
        rowsItemModel.addListener(textFieldViewRows);
        columnsItemModel.addListener(textFieldViewColumns);
        minesItemModel.addListener(textFieldViewMines);
        
        // BOUNDED VALUE VIEWS
        BoundedValueView rowsView = new BoundedValueView(sliderViewRows, textFieldViewRows);
        BoundedValueView columnsView = new BoundedValueView(sliderViewColumns, textFieldViewColumns);
        BoundedValueView minesView = new BoundedValueView(sliderViewMines, textFieldViewMines);
        
        // ADD BOUNDED VALUES VIEW TO MODEL
        rowsModel.addListener(rowsView);
        columnsModel.addListener(columnsView);
        minesModel.addListener(minesView);
        
        // ADAPT MINE VIEW TO CHANGE BOUNDS
        AdaptaterMinesBoundedValueComponent a = new AdaptaterMinesBoundedValueComponent(rowsModel, columnsModel, minesModel);
        
        // CREATE CUSTOM GAME - M - V - C
        CustomGameModel customGameModel = new CustomGameModel(rowsItemModel, columnsItemModel, minesItemModel);
        CustomGameView customGameView = new CustomGameView();
        CustomGameController customGameController = new CustomGameController(customGameModel);
        
        customGameModel.addListener(customGameView);
        
        // ADD COMPONENTS TO CUSTOM GAME
        customGameView.addComponentView(rowsView);
        customGameView.addComponentView(columnsView);
        customGameView.addComponentView(minesView);
        
        // CREATE ONE MODEL PER LEVEL
        PredefinedLevelModel levelModelBeginner = new PredefinedLevelModel(LevelValues.BEGINNER);
        PredefinedLevelModel levelModelIntermediate = new PredefinedLevelModel(LevelValues.INTERMEDIATE);
        PredefinedLevelModel levelModelExpert = new PredefinedLevelModel(LevelValues.EXPERT);
        CustomLevelModel levelModelCustom = new CustomLevelModel(customGameModel, LevelValues.CUSTOM);
        
        // CREATE A SPECIFIC VIEW PER MODEL (radiobutton)
        RadioButtonPredefinedLevelChooserView levelChooserViewBeginner = new RadioButtonPredefinedLevelChooserView();
        RadioButtonPredefinedLevelChooserView levelChooserViewIntermediate = new RadioButtonPredefinedLevelChooserView();
        RadioButtonPredefinedLevelChooserView levelChooserViewExpert = new RadioButtonPredefinedLevelChooserView();
        RadioButtonCustomLevelChooserView levelChooserViewCustom = new RadioButtonCustomLevelChooserView(customGameView);
        
        // LINK VIEW TO MODEL
        levelModelBeginner.addLevelChooserListener(levelChooserViewBeginner);
        levelModelIntermediate.addLevelChooserListener(levelChooserViewIntermediate);
        levelModelExpert.addLevelChooserListener(levelChooserViewExpert);
        levelModelCustom.addLevelChooserListener(levelChooserViewCustom);
        
        // CREATE ONE CHOOSER CONTROLLER PER MODEL (for radiobutton)
        LevelChooserController levelChooserControllerBeginner = new LevelChooserController(levelModelBeginner);
        LevelChooserController levelChooserControllerIntermediate = new LevelChooserController(levelModelIntermediate);
        LevelChooserController levelChooserControllerExpert = new LevelChooserController(levelModelExpert);
        LevelChooserController levelChooserControllerCustom = new LevelChooserController(levelModelCustom);
        
        // LINK RADIOBUTTON TO CONTROLLER
        levelChooserViewBeginner.getButton().addActionListener(levelChooserControllerBeginner);
        levelChooserViewIntermediate.getButton().addActionListener(levelChooserControllerIntermediate);
        levelChooserViewExpert.getButton().addActionListener(levelChooserControllerExpert);
        levelChooserViewCustom.getButton().addActionListener(levelChooserControllerCustom);
        
        // WHEN A LEVEL IS SELECTED, THE CUSTOM PANEL HAS TO BE NOTIFIED -> Link model to customController
        levelModelBeginner.addLevelSelectedListener(customGameController);
        levelModelIntermediate.addLevelSelectedListener(customGameController);
        levelModelExpert.addLevelSelectedListener(customGameController);
        levelModelCustom.addLevelSelectedListener(customGameController);
        
        // CREATE THE PANEL TO DISPLAY CUSTOM BOUNDED VALUE
        NewGameModel newGameModel = new NewGameModel("Create New Game");
        ButtonNewGameController buttonNewGameController = new ButtonNewGameController(newGameModel);
        NewGameView newGameView = new NewGameView();
        
        // ADD A LINK BETWEEN THE BUTTON CREATEGAME AND THE MODEL
        levelModelBeginner.addLevelChoosedListener(buttonNewGameController);
        levelModelIntermediate.addLevelChoosedListener(buttonNewGameController);
        levelModelExpert.addLevelChoosedListener(buttonNewGameController);
        levelModelCustom.addLevelChoosedListener(buttonNewGameController);
        
        // CREATE NEWGAMEVIEW
        newGameView.addCustomLevelView(levelChooserViewCustom);
        newGameView.addPredefinedLevelView(levelChooserViewBeginner);
        newGameView.addPredefinedLevelView(levelChooserViewIntermediate);
        newGameView.addPredefinedLevelView(levelChooserViewExpert);
        
        // LINK BUTTON TO CONTROLLER
        newGameView.getSendButton().addActionListener(buttonNewGameController);
        
        levelModelCustom.addLevelSelectedListener(levelChooserViewCustom);
        levelModelCustom.addNewGameListener(newGameView);
        
        levelModelBeginner.addNewGameListener(newGameView);
        levelModelIntermediate.addNewGameListener(newGameView);
        levelModelExpert.addNewGameListener(newGameView);
        newGameModel.addListener(newGameView);
        
        levelModelCustom.setSelected();

        
        
        MenuItemLevelChooserView beginnerMenuItemLevelChooserView = new MenuItemLevelChooserView('B');
        MenuItemLevelChooserView intermediateMenuItemLevelChooserView = new MenuItemLevelChooserView('I');
        MenuItemLevelChooserView expertMenuItemLevelChooserView = new MenuItemLevelChooserView('E');
        MenuItemLevelChooserView customMenuItemLevelChooserView = new MenuItemLevelChooserView('C');
        
        levelModelBeginner.addLevelChooserListener(beginnerMenuItemLevelChooserView);
        levelModelIntermediate.addLevelChooserListener(intermediateMenuItemLevelChooserView);
        levelModelExpert.addLevelChooserListener(expertMenuItemLevelChooserView);
        levelModelCustom.addLevelChooserListener(customMenuItemLevelChooserView);
        
        // INIT MENU BAR
        JMenu gameMenu = new JMenu("Game");
        JMenu newMenu = new JMenu("New");
        JMenuItem quitMenu = new JMenuItem("Quit");
        
        newMenu.add(beginnerMenuItemLevelChooserView);
        newMenu.add(intermediateMenuItemLevelChooserView);
        newMenu.add(expertMenuItemLevelChooserView);
        newMenu.add(customMenuItemLevelChooserView);
        
        quitMenu.addActionListener(new QuitGameController());
        
        gameMenu.add(newMenu);
        gameMenu.add(quitMenu);
        
        JMenuBar bar = new JMenuBar();
        bar.add(gameMenu);
        this.setJMenuBar(bar);
        
        beginnerMenuItemLevelChooserView.addActionListener(levelChooserControllerBeginner);
        intermediateMenuItemLevelChooserView.addActionListener(levelChooserControllerIntermediate);
        expertMenuItemLevelChooserView.addActionListener(levelChooserControllerExpert);
        customMenuItemLevelChooserView.addActionListener(levelChooserControllerCustom);
        
        newMenu.addMouseListener(levelChooserControllerCustom);

        ChronometerModel chronometerModel = new ChronometerModel();
        LabelChronometerView labelChronometerView = new LabelChronometerView();
        chronometerModel.addListener(labelChronometerView);
        ChronometerManagerListener chronometerManagerListener = new ChronometerController(chronometerModel);

        MineSweeperGameModel m = new MineSweeperGameModel(chronometerManagerListener, chronometerModel);
        TextMineSweeperGameView v = new TextMineSweeperGameView();
        GraphicalMineSweeperGameView graphicalMinesWeeperGameView = new GraphicalMineSweeperGameView();

        m.addListener(graphicalMinesWeeperGameView);
        m.addListener(v);

        TextMineSweeperGameController c = new TextMineSweeperGameController(m);
        GraphicalMineSweeperGameController c2 = new GraphicalMineSweeperGameController(m);

        graphicalMinesWeeperGameView.addListener(c2);

        levelModelBeginner.addGameActionListener(m);
        levelModelIntermediate.addGameActionListener(m);
        levelModelExpert.addGameActionListener(m);
        levelModelCustom.addGameActionListener(m);

        Thread t = new Thread(c);
        t.start();
        
        GameScoreListModel gameScoreListModel = new GameScoreListModel();
        GameScoreListView gameScoreListView = new GameScoreListView();
        
        gameScoreListModel.addListener(gameScoreListView);
        
        GameScoreListController gameScoreListController = new GameScoreListController(gameScoreListModel);
        
        m.addListener(gameScoreListController);
        
        SideGamePanelModel sideGamePanelModel = new SideGamePanelModel();
        SideGamePanelController sideGamePanelController = new SideGamePanelController(sideGamePanelModel);
        
        gameScoreListView.addComponentListener(sideGamePanelController);
        newGameView.addComponentListener(sideGamePanelController);
        SideGamePanelView sideGameView = new SideGamePanelView(gameScoreListView, newGameView);
        newGameView.setVisible(false);
        gameScoreListView.setVisible(false);
        
        JMenu scoreMenu = new JMenu("Scores");
        JMenuItem showScore = new JMenuItem("Show HighScores");
        JMenuItem saveScore = new JMenuItem("Save HighScores");
        JMenuItem loadScore = new JMenuItem("Load HighScores");
        showScore.addActionListener(gameScoreListController);
        
        scoreMenu.add(showScore);
        scoreMenu.add(saveScore);
        scoreMenu.add(loadScore);
        bar.add(scoreMenu);
        
        NbMinesRemainingGraphicalView minesRemainingGraphicalView = new NbMinesRemainingGraphicalView();
        m.addListener(minesRemainingGraphicalView);
        
        GameView gameView = new GameView(minesRemainingGraphicalView, labelChronometerView, graphicalMinesWeeperGameView);
        
        MainPanelGameView mainPanelGameView = new MainPanelGameView(SwingConstants.VERTICAL, sideGameView, gameView);
        sideGamePanelModel.addListener(sideGameView);
        sideGamePanelModel.addListener(mainPanelGameView);
        
        this.add(mainPanelGameView);
        
        GameScoreSerializerModel gameScoreSerializerModel = new GameScoreSerializerModel();
        gameScoreSerializerModel.setCurrentModel(gameScoreListModel);
        gameScoreSerializerModel.addListener(gameScoreListView);
        gameScoreSerializerModel.addSerializerListener(gameScoreListController);
        
        GameScoreSerializerController gameScoreSerializerController = new GameScoreSerializerController(gameScoreSerializerModel, this);
        GameScoreDeserializerController gameScoreDeserializerController = new GameScoreDeserializerController(gameScoreSerializerModel, this);
        
        saveScore.addActionListener(gameScoreSerializerController);
        loadScore.addActionListener(gameScoreDeserializerController);
        
        
        
    }
    /*
     * contains a JFrame in which the game takes place
     */
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        CompleteGameLauncher completeGameLauncher = new CompleteGameLauncher();
        completeGameLauncher.init();
        
        JFrame f = new JFrame("MineSweeper - Group12");
        f.setSize(800, 800);
        f.setLayout(new BorderLayout());
        
        f.add(completeGameLauncher);
        
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
}
