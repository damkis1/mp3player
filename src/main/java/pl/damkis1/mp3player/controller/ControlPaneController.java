package pl.damkis1.mp3player.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

    public Button getNextButton() {
        return nextButton;
    }

    public ToggleButton getPlayButton() {
        return playButton;
    }

    public Button getPreviousButton() {
        return previousButton;
    }

    public Slider getProgressSlider() {
        return progressSlider;
    }

    public Slider getVolumeSlider() {
        return volumeSlider;
    }

    public void initialize(){
        System.out.println("Control controller created");
        configureVolume();
        configureButtons();
    }

    private void configureVolume(){
        volumeSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("Zmiana głośności: " + newValue.doubleValue());
        });

        progressSlider.valueProperty().addListener(x ->
                System.out.println("Przesunięcie piosenki"));
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