package view;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;


import controller.ButtonPressListener;
import controller.GameModeListener;
import controller.KeyPressListener;
import view.statePattern.GameState;
import view.statePattern.GameStateInIt;

public class AppWindow extends JFrame{
    
    private AppCanvas canvas;
    public static final int GRID_SIZE = 20;

    public JButton startPauseButton;
    public JButton resartButton;
    public JButton exitButton;
    public JCheckBox fastButton;
    public static final String START_ACTION = "Start";
    public static final String PAUSE_ACTION = "Pause";
    public static final String RESART_ACTION = "App Restart";
    public static final String EXIT_ACTION = "Exit";
    public static final String FAST_MODE = "Fast Mode";
    private JLabel gameModeLabel;


    private GameState gameState;


    public void init(){
        Container cp = getContentPane();
        gameModeLabel = new JLabel("Game Mode NORMAL", JLabel.CENTER);
        cp.add(gameModeLabel, BorderLayout.NORTH);

        canvas = new AppCanvas();
        cp.add(canvas, BorderLayout.CENTER);
        
        JPanel southPanel = new JPanel();
        startPauseButton = new JButton(START_ACTION);
        resartButton = new JButton(RESART_ACTION);
        exitButton = new JButton(EXIT_ACTION);

        fastButton = new JCheckBox(FAST_MODE);
        

        southPanel.add(startPauseButton);
        southPanel.add(resartButton);
        southPanel.add(exitButton);
        southPanel.add(fastButton);
        

        fastButton.addItemListener(new GameModeListener()); //added
        


        cp.add(BorderLayout.SOUTH, southPanel);

        ButtonPressListener ButtonPressListener = new ButtonPressListener();
        startPauseButton.addActionListener(ButtonPressListener);
        resartButton.addActionListener(ButtonPressListener);
        exitButton.addActionListener(ButtonPressListener);

    

        KeyPressListener keyPressListener = new KeyPressListener();
        canvas.addKeyListener(keyPressListener);
        canvas.requestFocusInWindow();
        canvas.setFocusable(true);

        //disable all focusable in all GUI components
        startPauseButton.setFocusable(false);
        resartButton.setFocusable(false);
        exitButton.setFocusable(false);
        fastButton.setFocusable(false);

        gameState = new GameStateInIt();

    }

    public void updateGameModeLabel(String gamemode) {
        if (gameModeLabel != null) {
            gameModeLabel.setText(gamemode);
        }
    }
    

    public void goNextState(){
        gameState.goNext(this);
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }


    public AppCanvas getCanvas() {
        return canvas;
    }
}
