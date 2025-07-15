/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package launch;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.ShannonsTheorem;
import presenter.ShannonsPresenter;
import view.ShannonsView;

/**
 * This main class is used for launching the application, incorporating the model, view, and presentation for use with the Application
 * @see ShannonsTheorem
 * @see ShannonsView
 * @see ShannonsPresenter
 * @author Nouraldin Hassan
 */
public class ShannonsLaunch extends Application {
    public static void main(String[] args){
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ShannonsTheorem model = new ShannonsTheorem();
        ShannonsView view = new ShannonsView();
        ShannonsPresenter presenter = new ShannonsPresenter(model, view);
        
        Scene scene = new Scene(view);
        
        primaryStage.setScene(scene);
	primaryStage.setTitle("Shannon-Hartley's Theorem Calculator");
        primaryStage.setMinHeight(160);
        primaryStage.setMinWidth(400); //320 to fit all content, 380 to fit window title
	primaryStage.show();
    }
}
