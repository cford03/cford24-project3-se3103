package view.statePattern;

import controller.App;
import view.AppWindow;

public class GameStateInIt implements GameState {

    public GameStateInIt(){
        App.win.startPauseButton.setText(AppWindow.START_ACTION);
        App.win.resartButton.setEnabled(false);
        App.win.startPauseButton.setEnabled(true);
        App.win.fastButton.setEnabled(true);

    }

    @Override
    public void goNext(AppWindow context) {
        context.setGameState(new GameStatePlaying());
    }

    @Override
    public void animate() {
        
    }
    
}
