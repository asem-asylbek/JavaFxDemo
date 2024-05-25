package com.example.javafxdemo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public Button answerButton;
    @FXML
    private TextArea questionArea;

    @FXML
    RadioButton answer1, answer2, answer3, answer4;
    @FXML
    private Button nextButton;
    @FXML
    ToggleGroup answers;
    private int currentQuestionIndex = 0;
    private String[][] questionsAndAnswers = {
            {"Ваш любимый фрукт?","Банан", "Киви", "Апельсин", "Мандарин","Апельсин"},
            {"Ваш любимый фильм?", "Interstellar", "1+1", "Dune", "Titanic","Dune"},
            {"Ваш любимый цвет?", "Красный", "Синий", "Зеленый", "Желтый", "Зеленый"}
    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        load();
    }
    public void load(){
        questionArea.setText(questionsAndAnswers[currentQuestionIndex][0]);
        answer1.setText(questionsAndAnswers[currentQuestionIndex][1]);
        answer2.setText(questionsAndAnswers[currentQuestionIndex][2]);
        answer3.setText(questionsAndAnswers[currentQuestionIndex][3]);
        answer4.setText(questionsAndAnswers[currentQuestionIndex][4]);
        answers.selectToggle(null);
        answerButton.setDisable(false);
    }
    public void tryToAnswer() {
        if(answers.getSelectedToggle() == null){
            Alert alert = new Alert(Alert.AlertType.WARNING, "Выберите ответ");
            alert.showAndWait();
            return;
        }
        if(((RadioButton)answers.getSelectedToggle()).getText().equals(questionsAndAnswers[currentQuestionIndex][5])) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Правильно!");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Не правильно!");
            alert.showAndWait();
        }
    }
    public void nextQuestion(){
        currentQuestionIndex++;
        if(currentQuestionIndex<questionsAndAnswers.length){
            load();
        } else {
            nextButton.setDisable(true);
            answerButton.setDisable(true);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Вы ответили на все вопросы");
            alert.showAndWait();
        }
    }
}