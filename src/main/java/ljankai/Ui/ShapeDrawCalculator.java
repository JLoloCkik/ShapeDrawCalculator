package ljankai.Ui;

import ljankai.Ui.Hotbar.FileManager;

public class ShapeDrawCalculator {
    public static void main(String[] args) {
        Display display = new Display();
        display.window();
        FileManager save = new FileManager(0, 0, 100, 100, "Save");
        save.saveManager();

    }
}
