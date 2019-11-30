package sistema.gui;
import java.io.File;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	@Override
	public void start(Stage primaryStage) {
		new Splash();
		try {
			//Stage estagio = primaryStage;
			URL url = new File("src/sistema/gui/view/ola.fxml").toURI().toURL();
			Parent rootMain = FXMLLoader.load(url);
			Scene cenaMain = new Scene(rootMain);

			primaryStage.setTitle("Teste de Algoritmos");
			primaryStage.setScene(cenaMain);
			//primaryStage.getIcons().add(new Image(getClass().getResource("images/1492528.png").toExternalForm()));
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
