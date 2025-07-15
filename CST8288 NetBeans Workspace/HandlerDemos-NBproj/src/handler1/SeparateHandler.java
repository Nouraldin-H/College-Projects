package handler1;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

// example of using a separate handler class

public class SeparateHandler implements EventHandler <ActionEvent>{

	@Override
	public void handle(ActionEvent arg0) {
		System.out.println("Button CLICKED");
	}

}
