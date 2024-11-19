package ljankai.Ui.Hotbar;

import javax.swing.*;
import java.awt.*;

public class Hotbar extends JPanel {
    public JPanel addHotbar() {
        JPanel hotbar = new JPanel();
        hotbar.setLayout(new BorderLayout());

        JButton buyButton = new JButton("Buy");
        Font font = new Font("Arial", Font.BOLD, 30);
        buyButton.setFont(font);
        buyButton.setPreferredSize(new Dimension(150, 60));

        // Gomb hozzáadása a hotbar-ra
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(buyButton);
        hotbar.add(buttonPanel, BorderLayout.WEST);

        hotbar.setBackground(Color.WHITE);
        return hotbar;
    }
}
