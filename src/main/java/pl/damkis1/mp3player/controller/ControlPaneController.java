package pl.damkis1.mp3player.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;

public class ControlPaneController {

    @FXML
    private Button nextButton;

    @FXML
    private ToggleButton playButton;

    @FXML
    private Button previousButton;

    @FXML
    private Slider progressSlider;

    @FXML
    private Slider volumeSlider;

    public void initialize(){
        System.out.println("Control controller created");
        configureVolume();
        configureButtons();
    }

    private void configureVolume(){
        volumeSlider.addEventFilter(MouseEvent.MOUSE_PRESSED, event ->{
            System.out.println("Wciśnięto przysisk na suwaku");
        });
    }

    private void configureButtons(){
        previousButton.setOnAction(actionEvent -> System.out.println("Poprzednia piosenka"));
        nextButton.setOnAction(actionEvent -> System.out.println("następna piosenka"));
        playButton.setOnAction(actionEvent -> {
            if (playButton.isSelected()){
                System.out.println("Play");
            }else System.out.println("Stop");
        });

    }

}