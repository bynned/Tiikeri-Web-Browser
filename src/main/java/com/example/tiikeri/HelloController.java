package com.example.tiikeri;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;

public class HelloController implements Initializable {
    @FXML
    private WebView webView;

    @FXML
    private TextField textField;

    private WebEngine engine;

    private String homePage;
    private WebHistory history;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        engine = webView.getEngine();
        homePage = "www.google.com";
        textField.setText(homePage);
        loadPage();
    }

    public void loadPage() {
        //engine.load("https://www.google.com");
        engine.load("http://"+textField.getText());
    }

    public void refreshPage() {
        engine.reload();
    }

    public void displayHistory() {
        history = engine.getHistory();
        ObservableList<WebHistory.Entry> entries = history.getEntries();

        // For-each loop to iterate through browser-history
        for(WebHistory.Entry entry : entries) {
            System.out.println(entry.getUrl()+" "+entry.getLastVisitedDate());
        }
    }

    public void back() {
        history = engine.getHistory();
       ObservableList<WebHistory.Entry> entries = history.getEntries();
       history.go(-1);
       textField.setText(entries.get(history.getCurrentIndex()).getUrl());
    }
    public void forward() {
        history = engine.getHistory();
        ObservableList<WebHistory.Entry> entries = history.getEntries();
        history.go(1);
        textField.setText(entries.get(history.getCurrentIndex()).getUrl());

    }
}