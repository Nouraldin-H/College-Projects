/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleDoubleProperty;

import model.ShannonsTheorem;
import view.ShannonsView;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.converter.NumberStringConverter;

/**
 * This class contains assignments and bindings for use with the program
 *
 * @author Nouraldin Hassan
 */
public class ShannonsPresenter {

    private final ShannonsTheorem model;
    private final ShannonsView view;
    private final SimpleDoubleProperty bWidthInternal = new SimpleDoubleProperty();
    private final SimpleDoubleProperty sPowerInternal = new SimpleDoubleProperty();
    private final SimpleDoubleProperty nPowerInternal = new SimpleDoubleProperty();

    /**
     * This constructor initializes variables and bindings
     *
     * @param model Shannon's Theorem model
     * @param view Shannon's Theorem program view
     * @author Nouraldin Hassan
     */
    public ShannonsPresenter(ShannonsTheorem model, ShannonsView view) {
        this.model = model;
        this.view = view;
        bindToModel();
        attachViewEvents();
    }

    /**
     * This method binds properties to the model
     *
     * @author Nouraldin Hassan
     */
    private void bindToModel() {
        bWidthInternal.bindBidirectional(model.bandWidthProperty());
        sPowerInternal.bindBidirectional(model.signalPowerProperty());
        nPowerInternal.bindBidirectional(model.noisePowerProperty());
    }

    /**
     * This method attaches events to the view
     *
     * @author Nouraldin Hassan
     */
    private void attachViewEvents() {
        // could use handlers instead, 
        // but TextField would need mult. for app to work correctly
        view.bWidthFld.textProperty().bindBidirectional(bWidthInternal, new NumberStringConverter());
        view.sPowerFld.textProperty().bindBidirectional(sPowerInternal, new NumberStringConverter());
        view.nPowerFld.textProperty().bindBidirectional(nPowerInternal, new NumberStringConverter());
        view.calcBtn.setOnAction(e -> calcMaxDataRate());
    }

    /**
     * This method calculates the maximum data rate, or C in Shannon's Theorem
     * @author Nouraldin Hassan
     */
    private void calcMaxDataRate() {
        try {
            boolean blankValuebWidthFld = view.bWidthFld.getText().equals("0");
            boolean blankValuesPowerFld = view.sPowerFld.getText().equals("0");
            boolean blankValuenPowerFld = view.nPowerFld.getText().equals("0");
            double maxDataRate = model.maxDataRate(Double.parseDouble(view.bWidthFld.getText()), Double.parseDouble(view.sPowerFld.getText()), Double.parseDouble(view.nPowerFld.getText()));
            System.out.println("Calculation: " + maxDataRate);
            System.out.println("Calculated");
            view.calcRes.textProperty().setValue("" + maxDataRate);
            if (blankValuebWidthFld && blankValuesPowerFld && blankValuenPowerFld) { //TODO: Create alert that says bandwidth cannot be 0, 
                CreateAlert(Alert.AlertType.ERROR, "Input Error", "All values cannot simultaniously be 0", "You typed " + view.bWidthFld.getText() + " and " + view.sPowerFld.getText() + " and " + view.nPowerFld.getText() + ", which causes the calculation to be null or not a number");
                ClearTextFields();
            } else if (blankValuesPowerFld && blankValuenPowerFld) {
                CreateAlert(Alert.AlertType.ERROR, "Input Error", "Signal and Noise Power cannot simultaniously be 0", "You typed " + view.bWidthFld.getText() + " and " + view.sPowerFld.getText() + " and " + view.nPowerFld.getText() + ", which causes the calculation to be null or not a number");
                ClearTextFields();
            } else if (blankValuebWidthFld && blankValuenPowerFld) {
                CreateAlert(Alert.AlertType.ERROR, "Input Error", "Bandwidth and Noise Power cannot simultaniously be 0", "You typed " + view.bWidthFld.getText() + " and " + view.sPowerFld.getText() + " and " + view.nPowerFld.getText() + ", which causes the calculation to be null or not a number");
                ClearTextFields();
            } else if (view.bWidthFld.getText().contains("-") || view.sPowerFld.getText().contains("-") || view.nPowerFld.getText().contains("-")) {
                CreateAlert(Alert.AlertType.ERROR, "Input Error", "Any value cannot be less than 0", "You typed " + view.bWidthFld.getText() + " and " + view.sPowerFld.getText() + " and " + view.nPowerFld.getText() + ", which causes the calculation to provide an irrational result");
                ClearTextFields();
            }
        } catch (NumberFormatException nfe) {
            CreateAlert(Alert.AlertType.ERROR, "Input Error", "Please enter a valid number", "You typed " + view.bWidthFld.getText() + " and " + view.sPowerFld.getText() + " and " + view.nPowerFld.getText() + ", or left some fields empty, which is not valid");
            ClearTextFields();
//                Alert alert = new Alert(Alert.AlertType.ERROR);
//                alert.setTitle("Input Error");
//                alert.setHeaderText("Please enter a valid number");
//                String alertFormat = "You typed " + view.bWidthFld.getText() + " and " + view.sPowerFld.getText() + " and " + view.nPowerFld.getText() + ", or left some fields empty, which is not valid";
//                alert.setContentText(alertFormat);
//                alert.showAndWait();
//                view.bWidthFld.setText("");
//                view.sPowerFld.setText("");
//                view.nPowerFld.setText("");
//                view.calcRes.setText("");
            //return;
        }
    }

    /**
     * Creates a new alert that pops up in a separate window
     *
     * @param alertType the type of Alert, such as an Error alert
     * @param alertTitle the title of the Alert window
     * @param headerText the header text of the alert that appears in the window
     * @param alertText the text of the alert that appears under the header text
     */
    private void CreateAlert(AlertType alertType, String alertTitle, String headerText, String alertText) {
        Alert alert = new Alert(alertType);
        alert.setTitle(alertTitle);
        alert.setHeaderText(headerText);
        alert.setContentText(alertText);
        alert.showAndWait();
    }

    /**
     * Clears all text fields (Bandwidth, Signal Power, Noise Power)
     */
    private void ClearTextFields() {
        view.bWidthFld.setText("");
        view.sPowerFld.setText("");
        view.nPowerFld.setText("");
        view.calcRes.setText("");
    }

}
