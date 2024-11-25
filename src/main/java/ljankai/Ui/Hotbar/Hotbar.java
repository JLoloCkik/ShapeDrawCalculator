package ljankai.Ui.Hotbar;

import javax.swing.*;
import java.awt.*;

public class Hotbar extends JPanel {
    public JPanel addHotbar() {
        JPanel hotbar = new JPanel();
        hotbar.setLayout(new BorderLayout());

        Save save = new Save();
        Load load = new Load();
        Undo undo = new Undo();
        Redo redo = new Redo();
        Clear clear = new Clear();

        JPanel buttonPanel = new JPanel();

        buttonPanel.add(save.showButton());
        buttonPanel.add(load.showButton());
        buttonPanel.add(undo.showButton());
        buttonPanel.add(redo.showButton());
        buttonPanel.add(clear.showButton());

        hotbar.add(buttonPanel, BorderLayout.WEST);

        hotbar.setBackground(Color.WHITE);
        return hotbar;
    }
}
