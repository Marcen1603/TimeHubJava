/**
 * Sample Skeleton for 'Dashboard_UI.fxml' Controller Class
 */

package com.timehub.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class HelloController {

    @FXML // fx:id="menu_image_backlog"
    private ImageView menu_image_backlog; // Value injected by FXMLLoader

    @FXML // fx:id="menu_image_calender"
    private ImageView menu_image_calender; // Value injected by FXMLLoader

    @FXML // fx:id="menu_image_console"
    private ImageView menu_image_console; // Value injected by FXMLLoader

    @FXML // fx:id="menu_image_dashboard"
    private ImageView menu_image_dashboard; // Value injected by FXMLLoader

    @FXML // fx:id="menu_image_settings"
    private ImageView menu_image_settings; // Value injected by FXMLLoader

    @FXML // fx:id="menu_image_tickets"
    private ImageView menu_image_tickets; // Value injected by FXMLLoader

    @FXML // fx:id="menu_image_todos"
    private ImageView menu_image_todos; // Value injected by FXMLLoader

    @FXML // fx:id="menu_label_backlog"
    private Label menu_label_backlog; // Value injected by FXMLLoader

    @FXML // fx:id="menu_label_calender"
    private Label menu_label_calender; // Value injected by FXMLLoader

    @FXML // fx:id="menu_label_console"
    private Label menu_label_console; // Value injected by FXMLLoader

    @FXML // fx:id="menu_label_dashboard"
    private Label menu_label_dashboard; // Value injected by FXMLLoader

    @FXML // fx:id="menu_label_settings"
    private Label menu_label_settings; // Value injected by FXMLLoader

    @FXML // fx:id="menu_label_tickets"
    private Label menu_label_tickets; // Value injected by FXMLLoader

    @FXML // fx:id="menu_label_todos"
    private Label menu_label_todos; // Value injected by FXMLLoader

    @FXML // fx:id="menu_label_version"
    private Label menu_label_version; // Value injected by FXMLLoader

    @FXML // fx:id="menu_pane_backlog"
    private Pane menu_pane_backlog; // Value injected by FXMLLoader

    @FXML // fx:id="menu_pane_calender"
    private Pane menu_pane_calender; // Value injected by FXMLLoader

    @FXML // fx:id="menu_pane_console"
    private Pane menu_pane_console; // Value injected by FXMLLoader

    @FXML // fx:id="menu_pane_dashboard"
    private Pane menu_pane_dashboard; // Value injected by FXMLLoader

    @FXML // fx:id="menu_pane_settings"
    private Pane menu_pane_settings; // Value injected by FXMLLoader

    @FXML // fx:id="menu_pane_tickets"
    private Pane menu_pane_tickets; // Value injected by FXMLLoader

    @FXML // fx:id="menu_pane_todos"
    private Pane menu_pane_todos; // Value injected by FXMLLoader

    @FXML
    void changeDashboardOrange(MouseEvent event) {
        menu_image_dashboard.getStyleClass().remove("white-image");
        menu_image_dashboard.getStyleClass().add("orange-image");
        menu_label_dashboard.setStyle("-fx-text-fill: #FF5722;");
    }

    @FXML
    void changeDashboardWhite(MouseEvent event) {
        menu_image_dashboard.getStyleClass().remove("orange-image");
        menu_image_dashboard.getStyleClass().add("white-image");
        menu_label_dashboard.setStyle("-fx-text-fill: #FFFFFF;");
    }

    @FXML
    void changeBacklogOrange(MouseEvent event) {
        menu_image_backlog.getStyleClass().remove("white-image");
        menu_image_backlog.getStyleClass().add("orange-image");
        menu_label_backlog.setStyle("-fx-text-fill: #FF5722;");
    }

    @FXML
    void changeBacklogWhite(MouseEvent event) {
        menu_image_backlog.getStyleClass().remove("orange-image");
        menu_image_backlog.getStyleClass().add("white-image");
        menu_label_backlog.setStyle("-fx-text-fill: #FFFFFF;");
    }

    @FXML
    void changeCalenderOrange(MouseEvent event) {
        menu_image_calender.getStyleClass().remove("white-image");
        menu_image_calender.getStyleClass().add("orange-image");
        menu_label_calender.setStyle("-fx-text-fill: #FF5722;");
    }

    @FXML
    void changeCalenderWhite(MouseEvent event) {
        menu_image_calender.getStyleClass().remove("orange-image");
        menu_image_calender.getStyleClass().add("white-image");
        menu_label_calender.setStyle("-fx-text-fill: #FFFFFF;");
    }

    @FXML
    void changeConsoleOrange(MouseEvent event) {
        menu_image_console.getStyleClass().remove("white-image");
        menu_image_console.getStyleClass().add("orange-image");
        menu_label_console.setStyle("-fx-text-fill: #FF5722;");
    }

    @FXML
    void changeConsoleWhite(MouseEvent event) {
        menu_image_console.getStyleClass().remove("orange-image");
        menu_image_console.getStyleClass().add("white-image");
        menu_label_console.setStyle("-fx-text-fill: #FFFFFF;");
    }

    @FXML
    void changeSettingsOrange(MouseEvent event) {
        menu_image_settings.getStyleClass().remove("white-image");
        menu_image_settings.getStyleClass().add("orange-image");
        menu_label_settings.setStyle("-fx-text-fill: #FF5722;");
    }

    @FXML
    void changeSettingsWhite(MouseEvent event) {
        menu_image_settings.getStyleClass().remove("orange-image");
        menu_image_settings.getStyleClass().add("white-image");
        menu_label_settings.setStyle("-fx-text-fill: #FFFFFF;");
    }

    @FXML
    void changeTicketsOrange(MouseEvent event) {
        menu_image_tickets.getStyleClass().remove("white-image");
        menu_image_tickets.getStyleClass().add("orange-image");
        menu_label_tickets.setStyle("-fx-text-fill: #FF5722;");
    }

    @FXML
    void changeTicketsWhite(MouseEvent event) {
        menu_image_tickets.getStyleClass().remove("orange-image");
        menu_image_tickets.getStyleClass().add("white-image");
        menu_label_tickets.setStyle("-fx-text-fill: #FFFFFF;");
    }

    @FXML
    void changeTodosOrange(MouseEvent event) {
        menu_image_todos.getStyleClass().remove("white-image");
        menu_image_todos.getStyleClass().add("orange-image");
        menu_label_todos.setStyle("-fx-text-fill: #FF5722;");
    }

    @FXML
    void changeTodosWhite(MouseEvent event) {
        menu_image_todos.getStyleClass().remove("orange-image");
        menu_image_todos.getStyleClass().add("white-image");
        menu_label_todos.setStyle("-fx-text-fill: #FFFFFF;");
    }

}
