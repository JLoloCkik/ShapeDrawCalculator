package ljankai.Ui.Hotbar;

import ljankai.Draw.PointDrawer;
import ljankai.Ui.Button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Undo
        extends JButton
        implements Button {

    private final PointDrawer pointDrawer;

    public Undo(PointDrawer pointDrawer) {
        this.pointDrawer = pointDrawer;

        this.setText("Undo");
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
        pointDrawer.undoPoints();
        pointDrawer.repaint();
    }
}
