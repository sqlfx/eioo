package org.example.demo1123;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public class CircleTool implements ShapeTool {
    @Override
    public Shape create(double x, double y, Color color, double strokeWidth) {
        Circle circle = new Circle(x, y, 0);
        circle.setFill(color);
        circle.setStrokeWidth(strokeWidth);
        return circle;
    }
    @Override
    public void update(Shape shape, double startX, double startY, double endX, double endY) {
        Circle circle = (Circle) shape;
        double radius = Math.sqrt(Math.pow(startX - endX, 2) + Math.pow(startY - endY, 2));
        circle.setRadius(radius);
    }
}
