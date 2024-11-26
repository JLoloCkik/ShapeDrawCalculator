package ljankai.Ui.Hotbar;

import ljankai.Draw.PointDrawer;

import javax.swing.*;
import java.awt.*;

public class Hotbar extends JPanel {
    public JPanel addHotbar(PointDrawer pointDrawer) {
        JPanel hotbar = new JPanel();
        hotbar.setLayout(new BorderLayout());

        // A DrawPanel átadása a gomboknak
        Save save = new Save();
        Load load = new Load();
        Undo undo = new Undo(pointDrawer);
        Redo redo = new Redo(pointDrawer);
        Clear clear = new Clear(pointDrawer);  // Átadjuk a DrawPanel-t

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
