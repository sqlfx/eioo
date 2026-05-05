package org.example.demo1123;

import java.net.URL;
import java.util.Date;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.AmbientLight;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.*;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

public class HelloController {


    private final java.util.Map<String, ShapeTool> tools = java.util.Map.of(
            "круг", new CircleTool(),
            "линия", new LineTool(),
            "прямоугольник", new org.example.demo1123.RectangleTool()
    );
    private Shape currentShape;
    private ShapeTool currentTool;


    @FXML
    private ResourceBundle resources;


    @FXML
    private URL location;

    @FXML
    private Box box = new Box(200, 200, 200);

    private Rotate rotateXAxis;
    private Rotate rotateYAxis;
    private Translate translate;
    private PhongMaterial material = new PhongMaterial();

    private final double mouseSensitivity = 0.1;
    private final double movementSpeed = 10.0;

    private double mouseOldX, mouseOldY;
    private double mouseDeltaX, mouseDeltaY;

    @FXML
    private AnchorPane pane3 = new AnchorPane();
    private PerspectiveCamera camera;
    private final double   rotationSpeed = 45.0;
    Group modelGroup = new Group();






    @FXML
    private Circle Circle;

    Random random = new Random();

    private Color generateRandomColor(Random random) {
        return Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }



    @FXML
    private Slider slider;


    double startMouseX;
    double startMouseY;


    @FXML
    private SplitMenuButton menucolor;
    @FXML
    private MenuItem menucolorblack;

    @FXML
    private MenuItem menucolorblue;

    @FXML
    private MenuItem menucolorred;

    @FXML
    private SplitMenuButton menuitem;

    @FXML
    private MenuItem menuitemcircle;

    @FXML
    private MenuItem menuitemline;

    @FXML
    private MenuItem menuitemrectange;

    @FXML
    private AnchorPane paneltwo;











    @FXML
    private Line Line;

    private double startAngle;
    private double anchorX, anchorY;

    @FXML
    private Rectangle Rectange;



    @FXML
    void OnMouseClick(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY) {
            Circle.setFill(generateRandomColor(random));

        } else if (event.getButton() == MouseButton.SECONDARY) {
            Circle.setFill(Paint.valueOf("Red"));
        }
    }


    @FXML
    void OnScroll(ScrollEvent event) {
        Object object = event.getTarget();
        if (object instanceof Circle) {
            if (event.getDeltaY() > 0) {
                Circle.setRadius(Circle.getRadius() + 5);
            } else if (event.getDeltaY() < 0) {
                Circle.setRadius(Circle.getRadius() - 5);
            }
        }
        else if (object instanceof Line) {
            if (event.getDeltaY() > 0) {
                Line.setStrokeWidth(Line.getStrokeWidth() * 1.05);
            } else if (event.getDeltaY() < 0) {
                Line.setStrokeWidth(Line.getStrokeWidth() / 1.05);
            }
        }
        else if (object instanceof Rectangle) {
            if (event.getDeltaY() > 0) {
                Rectange.setWidth(Rectange.getWidth() * 1.05);
                Rectange.setHeight(Rectange.getHeight() * 1.05);
            } else if (event.getDeltaY() < 0) {
                Rectange.setWidth(Rectange.getWidth() / 1.05);
                Rectange.setHeight(Rectange.getHeight() / 1.05);
            }
        }
    }

    @FXML
    void OnMouseExited(MouseEvent event) {
        Rectange.setFill(Paint.valueOf("red"));

    }

    @FXML
    void OnMouseMoved(MouseEvent event) {
        Rectange.setFill(generateRandomColor(random));

    }

    @FXML
    void LineMouseDragged(MouseEvent event) {
        double deltaX = event.getSceneX() - anchorX;
        double deltaY = event.getSceneY() - anchorY;
        double newAngle = Math.atan2(deltaY, deltaX) * 180 / Math.PI + 90;

        Line.setRotate(startAngle + newAngle);

    }

    @FXML
    void LineMousePressed(MouseEvent event) {
        anchorX = event.getSceneX();
        anchorY = event.getSceneY();
        startAngle =    Line.getRotate();

    }

    public void PaneClick(ActionEvent actionEvent) {
    }

    public void PaneDragged(MouseEvent event) {
        if (currentShape != null && currentTool != null) {
            currentTool.update(currentShape, startMouseX, startMouseY, event.getX(), event.getY());
        }
    }

    public void PaneMoved(ActionEvent actionEvent) {
    }

    @FXML
    void initialize() {
        Box();
        camera = new PerspectiveCamera(true);
        camera.setTranslateZ(-500);
        assert Circle != null : "fx:id=\"Circle\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert Line != null : "fx:id=\"Line\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert Rectange != null : "fx:id=\"Rectange\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert menucolor != null : "fx:id=\"menucolor\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert menucolorblack != null : "fx:id=\"menucolorblack\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert menucolorblue != null : "fx:id=\"menucolorblue\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert menucolorred != null : "fx:id=\"menucolorred\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert menuitem != null : "fx:id=\"menuitem\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert menuitemcircle != null : "fx:id=\"menuitemcircle\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert menuitemline != null : "fx:id=\"menuitemline\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert menuitemrectange != null : "fx:id=\"menuitemrectange\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert paneltwo != null : "fx:id=\"paneltwo\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert slider != null : "fx:id=\"slider\" was not injected: check your FXML file 'hello-view.fxml'.";

    }


    public void OnActionMenuItem(ActionEvent actionEvent) {
    }

    public void OnActionMenuItemCircle(ActionEvent actionEvent) {
        menuitem.setText("круг");
    }

    public void OnActionMenuItemLine(ActionEvent actionEvent) {
        menuitem.setText("линия");
    }

    public void OnActionMenuItemRectange(ActionEvent actionEvent) {
        menuitem.setText("прямоугольник");
    }
    @FXML
    void OnActionMenuColor(ActionEvent event) {
    }

    @FXML
    void OnActionMenuColorBlack(ActionEvent event) {
        menucolor.setText("черный");
    }

    @FXML
    void OnActionMenuColorBlue(ActionEvent event) {
        menucolor.setText("синий");
    }

    @FXML
    void OnActionMenuColorRed(ActionEvent event) {
        menucolor.setText("красный");

    }

    @FXML
    void PanePresed(MouseEvent event) {
        // 1. Определяем цвет через новый switch (компактно)
        String colorText = menucolor.getText().toLowerCase();
        Color selectedColor = switch (colorText) {
            case "красный" -> Color.RED;
            case "синий" -> Color.BLUE;
            case "черный" -> Color.BLACK;
            default -> Color.BLACK;
        };

        // 2. Сохраняем координаты начала клика
        startMouseX = event.getX();
        startMouseY = event.getY();

        // 3. Выбираем инструмент из нашей мапы (паттерн Strategy)
        currentTool = tools.get(menuitem.getText().toLowerCase());

        // 4. Если инструмент найден, создаем фигуру и добавляем на панель
        if (currentTool != null) {
            currentShape = currentTool.create(startMouseX, startMouseY, selectedColor, slider.getValue());
            paneltwo.getChildren().add(currentShape);

            // По желанию можно оставить лог в консоль для отладки
            System.out.println("Создана фигура: " + menuitem.getText());
        }
    }


    @FXML
    void OnActionPressed3(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY) {
            mouseOldX = event.getSceneX();
            mouseOldY = event.getSceneY();
            System.out.println("press");
        }
    }

    @FXML
    void pane3Dragged(MouseEvent event) {
        if (event.isPrimaryButtonDown()) {
            mouseDeltaX = event.getSceneX() - mouseOldX;
            mouseDeltaY = event.getSceneY() - mouseOldY;
            rotateXAxis.setAngle(rotateXAxis.getAngle() - mouseDeltaY * mouseSensitivity);
            rotateYAxis.setAngle(rotateYAxis.getAngle() + mouseDeltaX * mouseSensitivity);

            mouseOldX = event.getSceneX();
            mouseOldY = event.getSceneY();
            System.out.println("dragged");
        }
    }

    @FXML
    void ScrollPane3(ScrollEvent event) {
        double delta = event.getDeltaY();
        if (delta > 0) {
            translate.setZ(translate.getZ() + movementSpeed);
        } else {
            translate.setZ(translate.getZ() - movementSpeed);
        }
        System.out.println("scroll");
    }

    @FXML
    public void Box(){
        material.setDiffuseColor(Color.OLIVE);
        box.setMaterial(material);
        rotateXAxis = new Rotate(0, Rotate.X_AXIS);
        rotateYAxis = new Rotate(0, Rotate.Y_AXIS);
        translate = new Translate();
        modelGroup.getTransforms().addAll(translate, rotateXAxis, rotateYAxis);
        modelGroup.getChildren().add(box);
        AmbientLight ambientLight = new AmbientLight(Color.WHITE);
        PointLight pointLight = new PointLight(Color.WHITE);
        pointLight.setTranslateX(800);
        pointLight.setTranslateY(-700);
        pointLight.setTranslateZ(-300);
        pane3.getChildren().addAll(modelGroup, ambientLight, pointLight);
    }








}

