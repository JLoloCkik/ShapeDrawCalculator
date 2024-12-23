package ljankai.Ui.Hotbar;

import ljankai.Draw.EdgeDrawer;
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
    private EdgeDrawer edgeDrawer;

    public Clear(PointDrawer pointDrawer, EdgeDrawer edgeDrawer) {
        this.pointDrawer = pointDrawer;
        this.edgeDrawer = edgeDrawer;

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
