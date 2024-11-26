package ljankai.Ui.Hotbar;

import ljankai.Draw.DrawPanel;
import ljankai.Ui.Button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Redo
        extends JButton
        implements Button {

    private final DrawPanel drawPanel;

    public Redo(DrawPanel drawPanel) {
        this.drawPanel = drawPanel;

        this.setText("Redo");
        this.setFont(hotbarFontStyle);
        this.setPreferredSize(new Dimension(150, 60));

        // ActionListener beállítása
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClick();
            }
        });
    }

    @Override
    public void onClick() {
        drawPanel.redoPoints();
        drawPanel.repaint();
    }
}
