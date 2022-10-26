package net.melawor.fx.showcase;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class ResizableCanvasApp extends Application {

    private Stage primaryStage;

    private ResizableCanvas canvas;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        Parent root = createContent();

        primaryStage.setTitle("FX-Showcase ResizableCanvas");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    private Parent createContent() {
        BorderPane root = new BorderPane();
        root.setStyle("-fx-border-color: #ff00d5; -fx-border-width: 5px;");

        canvas = new ResizableCanvas();
        canvas.widthProperty().addListener(observable -> canvasRender());
        canvas.heightProperty().addListener(observable -> canvasRender());
        root.setCenter(canvas);

        return root;
    }

    private void canvasRender() {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Background
        gc.setFill(Color.CORNFLOWERBLUE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        // Border
        gc.setLineWidth(10);
        gc.setStroke(Color.DARKRED);
        gc.strokeRect(0, 0, canvas.getWidth(), canvas.getHeight());
        // Lines
        gc.setLineWidth(5);
        gc.strokeLine(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.strokeLine(canvas.getWidth(), 0, 0, canvas.getHeight());

        // Label
        gc.setFill(Color.BLACK);
        gc.setTextAlign(TextAlignment.CENTER);
        gc.fillText("Canvas size: " + canvas.getWidth() + "x" + canvas.getHeight(), canvas.getWidth() / 2, 20);

        // Parent
        BorderPane pane = (BorderPane) canvas.getParent();
        gc.fillText("Parent size: " + pane.getWidth() + "x" + pane.getHeight() + " (Border: 5 on each side)", canvas.getWidth() / 2, 40);

        // Scene
        Scene scene = canvas.getScene();
        gc.fillText("Scene size: " + scene.getWidth() + "x" + scene.getHeight(), canvas.getWidth() / 2, 60);

        // Stage (will be valid after resize)
        gc.fillText("Stage size: " + primaryStage.getWidth() + "x" + primaryStage.getHeight(), canvas.getWidth() / 2, 80);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
