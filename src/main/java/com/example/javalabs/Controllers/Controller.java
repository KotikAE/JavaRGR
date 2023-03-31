package com.example.javalabs.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.javalabs.ProjectModels.ClientModel;
import javafx.collections.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Controller {
    private String userName = "";
    private ClientModel model = new ClientModel(this);
    private String UserAccountName = "";
    private String UserIngameName = "";
    private String UserAchievements = "";
    private String UserPlatform = "";
    private String UserGameStore = "";
    private String GameStatsTotal = "";
    private String GameStatsSession = "";
    private String GameStatsScore = "";
    ObservableList<String> userComboBoxItems = FXCollections.observableArrayList("PC", "PS", "XBOX");
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField gameStatsAccountNameTextField;

    @FXML
    private Label gameStatsScore;

    @FXML
    private Label gameStatsSession;

    @FXML
    private Button gameStatsShowDataButton;

    @FXML
    private Label gameStatsTotal;

    @FXML
    private ListView<String> genreGenresListView;

    @FXML
    private Button genreShowDataButton;

    @FXML
    private ListView<String> genreTagsListView;

    @FXML
    private Label userAccountName;

    @FXML
    private TextField userAccountNameTextField;

    @FXML
    private Label userAchievements;

    @FXML
    private ChoiceBox<String> userComboBox;

    @FXML
    private Label userGameStore;

    @FXML
    private Label userIngameName;

    @FXML
    private Label userPlatform;

    @FXML
    private Button userShowDataButton;

    void initUserComboBox() {
        userComboBox.setValue("PC");
        userComboBox.setItems(userComboBoxItems);
    }
    @FXML
    void initialize() {
        initUserComboBox();
        userAccountNameTextField.focusedProperty().addListener((obs, newValue, oldValue) -> {
            if (newValue){
                try {
                    model.userTabSend(userAccountNameTextField.getText());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        userShowDataButton.setOnAction(actionEvent -> {
            userAccountName.setText(UserAccountName);
            userIngameName.setText(UserIngameName);
            userAchievements.setText(UserAchievements);
            userPlatform.setText(UserPlatform);
            userGameStore.setText(UserGameStore);
        });

        gameStatsAccountNameTextField.focusedProperty().addListener((obs, newValue, oldValue) -> {
            if (newValue){
                try {
                    model.gameStatsTabSend(gameStatsAccountNameTextField.getText());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        gameStatsShowDataButton.setOnAction(actionEvent -> {
            gameStatsTotal.setText(GameStatsTotal);
            gameStatsSession.setText(GameStatsSession);
            gameStatsScore.setText(GameStatsScore);
        });

        genreShowDataButton.setOnAction(actionEvent -> {
            try {
                model.genreTabSend();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    void setUserTabData(String inAccountName, String inIngameName, Integer inAchievements, String inGameStore) {
        UserAccountName = inAccountName;
        UserIngameName = inIngameName;
        UserAchievements = inAchievements.toString();
        UserPlatform = userComboBox.getValue();
        UserGameStore = inGameStore;
    }

    void setGameStatsTabData(Integer inTotalTime, Integer inSessionTime, Integer inCurrentScore) {
        GameStatsTotal = inTotalTime.toString();
        GameStatsSession = inSessionTime.toString();
        GameStatsScore = inCurrentScore.toString();
    }

    void setGenreTabData(ObservableList<String> inGenreList, ObservableList<String> inTagList) {
        genreGenresListView.setItems(inGenreList);
        genreTagsListView.setItems(inTagList);
    }
}