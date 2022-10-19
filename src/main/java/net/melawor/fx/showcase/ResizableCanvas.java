package net.melawor.fx.showcase;

import javafx.scene.canvas.Canvas;

/**
 * Canvas which will handle a resize by its parent
 */
public class ResizableCanvas extends Canvas {

    @Override
    public boolean isResizable() {
        return true;
    }

    @Override
    public double minWidth(double height) {
        return 1;
    }

    @Override
    public double minHeight(double width) {
        return 1;
    }

    @Override
    public double maxWidth(double height) {
        return Double.MAX_VALUE;
    }

    @Override
    public double maxHeight(double width) {
        return Double.MAX_VALUE;
    }

    @Override
    public void resize(double width, double height) {
        setWidth(width);
        setHeight(height);
    }
}
