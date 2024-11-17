package ljankai.Ui;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Panel extends UIComponent {
    private List<UIComponent> components;

    public Panel(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.components = new ArrayList<>();
    }

    public void addComponent(UIComponent component) {
        components.add(component);
    }

    @Override
    public void draw() {
        super.draw();
        for (UIComponent component : components) {
            component.draw();
        }
    }
}
