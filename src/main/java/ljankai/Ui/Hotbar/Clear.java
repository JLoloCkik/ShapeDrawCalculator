package ljankai.Ui.Hotbar;

import ljankai.Ui.Button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Clear
        extends JButton
        implements Button {



    public JButton showButton() {
        JButton clearButton = new JButton("Clear");
        clearButton.setFont(hotbarFontStyle);
        clearButton.setPreferredSize(new Dimension(150, 60));

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClick();
            }
        });

        return clearButton;
    }

    @Override
    public void onClick() {

    }
}
