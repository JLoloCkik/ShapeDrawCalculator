package ljankai.Ui;

import java.util.ArrayList;
import java.util.List;

public class UIManager {
    private List<UIComponent> components;

    public UIManager() {
        components = new ArrayList<>();
    }

    public void addComponent(UIComponent component) {
        components.add(component);
    }

    public void drawAll() {
        for (UIComponent component : components) {
            component.draw();
        }
    }
}
