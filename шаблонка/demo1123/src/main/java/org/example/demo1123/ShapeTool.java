package org.example.demo1123;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public interface ShapeTool {
    // Создает фигуру
    Shape create(double x, double y, Color color, double strokeWidth);
    // Обновляет её размеры при движении мыши
    void update(Shape shape, double startX, double startY, double endX, double endY);
}
