/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * This class provides the view of the program in a grid form
 * @author Nouraldin Hassan
 */
public class ShannonsView extends GridPane {
    // Labels
    Label bWidthLbl = new Label("Bandwidth (In Hertz or Hz):");
    Label sPowerLbl = new Label("Signal Power (In Watts):");
    Label nPowerLbl = new Label("Noise Power (In Watts):");
    Label calcLbl = new Label("Calculation (Max Data Rate):");
    public Label calcRes = new Label("");

    // Fields
    public TextField bWidthFld = new TextField();
    public TextField sPowerFld = new TextField();
    public TextField nPowerFld = new TextField();

    // Buttons
    public Button calcBtn = new Button("Calculate");
    /**
     * This constructor initializes the form layout for the view
     */
    public ShannonsView() {
            layoutForm();
    }

    /**
     * This method adds the form components to the view, to be used in {@link ShannonsView()}
     */
    private void layoutForm() {
            this.setHgap(5);
            this.setVgap(5);

            this.add(bWidthLbl, 1, 2); // try to make this an addrow
            this.add(sPowerLbl, 1, 3); // try to make this an addrow
            this.add(nPowerLbl, 1, 4); // try to make this an addrow

            this.add(bWidthFld, 2, 2); // try to make this an addrow
            this.add(sPowerFld, 2, 3); // try to make this an addrow
            this.add(nPowerFld, 2, 4); // try to make this an addrow
            
            this.add(calcLbl, 1, 5); // try to make this an addrow
            this.add(calcRes, 2, 5); // try to make this an addrow

            // Add buttons and make them the same width
            VBox buttonBox = new VBox(calcBtn);
            calcBtn.setMaxWidth(Double.MAX_VALUE);

            this.add(buttonBox, 3, 1, 1, 5);
    }//layoutform()

}
