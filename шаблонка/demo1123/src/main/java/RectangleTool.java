package org.example.demo1123;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class RectangleTool implements ShapeTool {
    @Override
    public Shape create(double x, double y, Color color, double strokeWidth) {
        Rectangle rect = new Rectangle(x, y, 0, 0);
        rect.setFill(color);
        rect.setStrokeWidth(strokeWidth);
        return rect;
    }
    @Override
    public void update(Shape shape, double startX, double startY, double endX, double endY) {
        Rectangle rect = (Rectangle) shape;
        rect.setX(Math.min(startX, endX));
        rect.setY(Math.min(startY, endY));
        rect.setWidth(Math.abs(startX - endX));
        rect.setHeight(Math.abs(startY - endY));
    }
}
