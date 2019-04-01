package com.adityak.wbs;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {

    static {
       // Font.loadFont(Main.class.getClassLoader().getResource("/font/fontawesome-webfont.ttf").toExternalForm(), 10);

    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        URL resource = getClass().getResource("sample.fxml");
        if (resource == null){
            resource = getClass().getClassLoader().getResource("sample.fxml");
        }

        Parent root = FXMLLoader.load(resource);
        primaryStage.setTitle("WBS");
        // Create the Scene
        Scene scene = new Scene(root);
        // Add  the Scene to the Stage
        primaryStage.setScene(scene);
        // Display the Stage
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
