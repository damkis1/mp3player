package pl.damkis1.mp3player.main;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("MP3Player");
        stage.show();
    }
}
