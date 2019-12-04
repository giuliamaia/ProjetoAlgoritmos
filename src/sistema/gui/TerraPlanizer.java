package sistema.gui;
import java.io.File;
import java.net.URL;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sistema.gui.controladores.TelaLoginController;

public class TerraPlanizer extends Application{
	static private Stage telaLogin;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			URL url = new File("src/sistema/gui/view/TelaLogin.fxml").toURI().toURL();
			Parent rootMain = FXMLLoader.load(url);
			Scene cenaMain = new Scene(rootMain);
			telaLogin = primaryStage;
			primaryStage.setTitle("Teste de Algoritmos");
			primaryStage.setScene(cenaMain);
			primaryStage.initStyle(StageStyle.UNDECORATED);
			primaryStage.show();
		} catch (Exception e) {
			
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
	static public void fecharTela (String tela) {
		switch (tela) {
			case "login": telaLogin.close(); break;
			case "registro": break;
			default: 
				System.out.println("Não foi possivel achar essa tela para fechar, favor use um dos seguintes: (login, registro)");
		}
	}
	static public void minimizarTela (String tela) {
		switch (tela) {
			case "login": telaLogin.setIconified(true); break;
			case "registro": break;
			default: 
				System.out.println("Não foi possivel achar essa tela para minimizar, favor use um dos seguintes: (login, registro)");
		}
	}
}
