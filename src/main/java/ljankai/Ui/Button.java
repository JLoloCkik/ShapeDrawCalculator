package ljankai.Ui;

import javax.swing.*;

public class Button extends UIComponent{
    private final String label;

    public Button(int x, int y, int width, int height, String label) {
        super(x, y, width, height);
        this.label = label;
    }

    @Override
    public void draw() {
        super.draw();
    }
    public void onClick() {
    }
    public String getLabel() {
        return label;
    }


}
