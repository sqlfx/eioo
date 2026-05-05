package org.example.demo1123;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

public class LineTool implements ShapeTool {
    @Override
    public Shape create(double x, double y, Color color, double strokeWidth) {
        Line line = new Line(x, y, x, y);
        line.setStroke(color);
        line.setStrokeWidth(strokeWidth);
        return line;
    }
    @Override
    public void update(Shape shape, double startX, double startY, double endX, double endY) {
        Line line = (Line) shape;
        line.setEndX(endX);
        line.setEndY(endY);
    }
}
