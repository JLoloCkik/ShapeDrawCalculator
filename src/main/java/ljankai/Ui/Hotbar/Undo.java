package ljankai.Ui.Hotbar;

import ljankai.Ui.Button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Undo
        extends JButton
        implements Button {

    public JButton showButton() {
        JButton undoButton = new JButton("Undo");
        undoButton.setFont(hotbarFontStyle);
        undoButton.setPreferredSize(new Dimension(150, 60));

        undoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClick();
            }
        });

        return undoButton;
    }

    @Override
    public void onClick() {

    }
}
