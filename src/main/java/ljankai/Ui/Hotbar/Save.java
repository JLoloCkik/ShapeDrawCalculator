package ljankai.Ui.Hotbar;

import ljankai.Ui.Button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Save
        extends JButton
        implements Button {


    public JButton showButton() {
        JButton saveButton = new JButton("Save");
        saveButton.setFont(hotbarFontStyle);
        saveButton.setPreferredSize(new Dimension(150, 60));

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClick();
            }
        });

        return saveButton;
    }

    @Override
    public void onClick() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
//            try {
//
//            } catch (IOException e) {
//                e.printStackTrace();
//                JOptionPane.showMessageDialog(null, "Hiba történt a mentés során.", "Hiba", JOptionPane.ERROR_MESSAGE);
//            }
        }
    }
}
