package pl.damkis1.mp3player.controller;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

public class MenuPaneController {

    @FXML
    private MenuItem aboutMenuItem;

    @FXML
    private MenuItem closeMenuItem;

    @FXML
    private MenuItem dirMenuItem;

    @FXML
    private MenuItem fileMenuItem;

    public MenuItem getAboutMenuItem() {
        return aboutMenuItem;
    }

    public MenuItem getCloseMenuItem() {
        return closeMenuItem;
    }

    public MenuItem getDirMenuItem() {
        return dirMenuItem;
    }

    public MenuItem getFileMenuItem() {
        return fileMenuItem;
    }

    public void initialize() {
        System.out.println("Menu controller created");
    }

}
