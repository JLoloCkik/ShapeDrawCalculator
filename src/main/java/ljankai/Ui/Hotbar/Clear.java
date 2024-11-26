package ljankai.Ui.Hotbar;

import ljankai.Draw.PointDrawer;
import ljankai.Ui.Button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Clear
        extends JButton
        implements Button {
    private PointDrawer pointDrawer;

    public Clear(PointDrawer pointDrawer) {
        this.pointDrawer = pointDrawer;

        this.setText("Clear");
        this.setFont(hotbarFontStyle);
        this.setPreferredSize(new Dimension(150, 60));

        // ActionListener beállítása
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClick(); // Ha rákattintanak, törli a pontokat
            }
        });
    }

    @Override
    public void onClick() {
        pointDrawer.clearPoints();
        pointDrawer.repaint();
    }
}
