package sistema.gui;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TerraPlanizer extends Application{
	static private Scene telaLogin;
	static private Scene telaRegistro;
	static private Stage estagio;
	@Override
	public void start(Stage primaryStage) {
		try {
			inicializa();
			URL url = new File("src/sistema/gui/view/TelaLogin.fxml").toURI().toURL();
			Parent rootMain = FXMLLoader.load(url);
			Scene cenaMain = new Scene(rootMain);
			estagio = primaryStage;
			primaryStage.setTitle("Teste de Algoritmos");
			primaryStage.setScene(cenaMain);
			primaryStage.initStyle(StageStyle.UNDECORATED);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void inicializa() throws MalformedURLException, IOException {
		telaLogin = new Scene(FXMLLoader.load(new File("src/sistema/gui/view/TelaLogin.fxml").toURI().toURL()));
		telaRegistro = new Scene(FXMLLoader.load(new File("src/sistema/gui/view/TelaRegistro.fxml").toURI().toURL()));
	}
	public static void main(String[] args) {
		launch(args);
	}
	static public void trocarTela(String tela) {
		switch (tela) {
		case "login": estagio.setScene(telaLogin); break;
		case "registro": estagio.setScene(telaRegistro); break;
		default: 
			System.out.println("Não foi possivel achar essa tela para fechar, favor use um dos seguintes: (login, registro)");
	}
	}
	static public void fecharTela () {
		estagio.close();
	}
	static public void minimizarTela () {
		estagio.setIconified(true);
	}
}
