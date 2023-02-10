module mp3player {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires jid3lib;


    exports pl.damkis1.mp3player.main to javafx.graphics;

    opens pl.damkis1.mp3player.controller to javafx.fxml;
    opens pl.damkis1.mp3player.mp3;
}