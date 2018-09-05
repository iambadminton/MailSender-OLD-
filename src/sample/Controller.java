package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Controller extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            BorderPane root = new BorderPane();
            root.setLeft(new Button("Left"));
            root.setTop(new Button("Top"));
            root.setRight(new Button("Right"));
            root.setBottom(new Button("Bottom"));
            /*root.setCenter(new Button("Center"));*/
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Открыть папку");
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Excel files", "*.xlsx"),
                    new FileChooser.ExtensionFilter("Excel files 97-2003", "*.xls"));

            Button fileChooserButton = new Button("Выбрать файл");
            fileChooserButton.setOnAction(event -> fileChooser.showOpenDialog(primaryStage));
            root.setCenter(fileChooserButton);

            TextArea filePath = new TextArea();
            VBox vBox = new VBox(filePath);
            Scene scene2 = new Scene(vBox, 200, 200);

            Scene scene = new Scene(root, 400, 400);
            //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene2);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}