package ljankai.Ui.Hotbar;

import ljankai.Ui.Button;

import javax.swing.*;
import java.awt.*;


public class Load
        extends JButton
        implements Button{
    @Override
    public JButton showButton() {
        JButton loadButton = new JButton("Load");
        loadButton.setFont(hotbarFontStyle);
        loadButton.setPreferredSize(new Dimension(150, 60));

        return loadButton;
    }

    @Override
    public void onClick() {

    }
}
