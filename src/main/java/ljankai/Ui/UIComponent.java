package ljankai.Ui;

public class UIComponent {
    public UIComponent(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw() {};

    private int x, y, width, height;
}
