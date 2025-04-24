package controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;

import model.PlayStrategy;

public class GameModeListener implements ItemListener {

    @Override
    public void itemStateChanged(ItemEvent e) {
        JCheckBox option = (JCheckBox) e.getSource();
        boolean checked = option.isSelected();

        

        App.model.setStrategy(checked ? PlayStrategy.FAST : PlayStrategy.NORMAL);
        App.model.gamemode = "Game Mode " + App.model.getStrategy().name();
        App.timer.setDelay(checked ? 100 : 250);
        App.win.updateGameModeLabel(App.model.gamemode);

        // Set speed
        if (App.timer != null) {
            App.timer.setDelay(checked ? 100 : 250); // FAST: 100ms, NORMAL: 250ms
        }

    }

}
