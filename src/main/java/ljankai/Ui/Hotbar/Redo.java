package ljankai.Ui.Hotbar;

import ljankai.Ui.Button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Redo
        extends JButton
        implements Button {

    public JButton showButton() {
        JButton redoButton = new JButton("Redo");
        redoButton.setFont(hotbarFontStyle);
        redoButton.setPreferredSize(new Dimension(150, 60));

        redoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClick();
            }
        });

        return redoButton;
    }

    @Override
    public void onClick() {

    }
}
