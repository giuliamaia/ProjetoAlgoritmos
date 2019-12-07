package sistema.gui;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TerraPlanizer extends Application{
	static private Scene telaLogin;
	static private Scene telaRegistro;
	static private Scene telaLogada;
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
		telaLogada = new Scene(FXMLLoader.load(new File("src/sistema/gui/view/TelaLogada.fxml").toURI().toURL()));
	}
	public static void main(String[] args) {
		launch(args);
	}
	static public File abrirFileChooser() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Imagem", "*.jpeg", "*.jpg", "*.png"));
		return fileChooser.showOpenDialog(estagio);
	}
	static public void trocarTela(String tela) {
		switch (tela) {
		case "login": estagio.setScene(telaLogin); break;
		case "registro": estagio.setScene(telaRegistro); break;
		case "logada": estagio.setScene(telaLogada); break;
		default: 
			System.out.println("Não foi possivel achar essa tela para fechar, favor use um dos seguintes: (login, registro, logada)");
		}
	}
	static public void fecharTela () {
		estagio.close();
	}
	static public void minimizarTela () {
		estagio.setIconified(true);
	}
	static public void abrirTermosDeUso() {
		try {
			URL url = new File("src/sistema/gui/view/TelaTermos.fxml").toURI().toURL();
			Parent rootTermos = FXMLLoader.load(url);
			Scene cenaTermos = new Scene(rootTermos);
			Stage estagioTermos = new Stage();
			estagioTermos.setTitle("Termos de uso");
			estagioTermos.setScene(cenaTermos);
			estagioTermos.initModality(Modality.WINDOW_MODAL);
			estagioTermos.showAndWait();
		}catch(Exception e) {
			System.out.println("tela termos n carregada!");
		}
	}
}
