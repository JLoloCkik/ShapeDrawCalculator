package ljankai.Ui.Hotbar;

import ljankai.Draw.DrawPanel;

import javax.swing.*;
import java.awt.*;

public class Hotbar extends JPanel {
    public JPanel addHotbar(DrawPanel drawPanel) {
        JPanel hotbar = new JPanel();
        hotbar.setLayout(new BorderLayout());

        // A DrawPanel átadása a gomboknak
        Save save = new Save();
        Load load = new Load();
        Undo undo = new Undo(drawPanel);
        Redo redo = new Redo(drawPanel);
        Clear clear = new Clear(drawPanel);  // Átadjuk a DrawPanel-t

        JPanel buttonPanel = new JPanel();

        buttonPanel.add(save.showButton());
        buttonPanel.add(load.showButton());
        buttonPanel.add(undo);
        buttonPanel.add(redo);
        buttonPanel.add(clear);

        hotbar.add(buttonPanel, BorderLayout.WEST);

        hotbar.setBackground(Color.WHITE);
        return hotbar;
    }
}
