package ljankai.Ui.Hotbar;

import ljankai.Ui.Button;

import javax.swing.*;

public class UndoClearHandler extends JButton implements Button {
    public UndoClearHandler(String label) {
        super(label);
    }

    public void undo(){}
    public void redo(){}
    public void clear(){}


    @Override
    public void onClick() {

    }
}
