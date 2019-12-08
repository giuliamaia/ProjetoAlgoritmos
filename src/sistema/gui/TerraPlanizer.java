package sistema.gui;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TerraPlanizer extends Application{
	static private Scene telaLogin;
	static private Scene telaRegistro;
	static private Stage estagio;
	static private Parent rootLogin;
	static private Parent rootRegistro;
	static private Stage telaPagamento;
	private double xOffset = 0;
    private double yOffset = 0;
	@Override
	public void start(Stage primaryStage) {
		try {
			inicializa();
			URL url = new File("src/sistema/gui/view/TelaLogin.fxml").toURI().toURL();
			Parent rootMain = FXMLLoader.load(url);
			rootMain.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        rootMain.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            }
        });
			Scene cenaMain = new Scene(rootMain);
			estagio = primaryStage;
			primaryStage.setTitle("Teste de Algoritmos");
			primaryStage.setScene(cenaMain);
			
			primaryStage.initStyle(StageStyle.UNDECORATED);
			//new Splash();
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void inicializa() throws MalformedURLException, IOException {
		rootLogin = FXMLLoader.load(new File("src/sistema/gui/view/TelaLogin.fxml").toURI().toURL());
		rootLogin.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        rootLogin.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                estagio.setX(event.getScreenX() - xOffset);
                estagio.setY(event.getScreenY() - yOffset);
            }
        });
		telaLogin = new Scene(rootLogin);
		
		
		rootRegistro = FXMLLoader.load(new File("src/sistema/gui/view/TelaRegistro.fxml").toURI().toURL());
		rootRegistro.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        rootRegistro.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                estagio.setX(event.getScreenX() - xOffset);
                estagio.setY(event.getScreenY() - yOffset);
            }
        });
        telaRegistro = new Scene(rootRegistro);
	}
	public static void main(String[] args) {
		launch(args);
	}
	static public File abrirFileChooser() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Abre tua foto ae fela duma puta, digo amém irmão");
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("jpeg, jpg, png", "*.jpeg", "*.jpg", "*.png"));
		return fileChooser.showOpenDialog(estagio);
	}
	static public void trocarTela(String tela) {
		switch (tela) {
		case "login": estagio.setScene(telaLogin); break;
		case "registro": estagio.setScene(telaRegistro); break;
		default: 
			System.out.println("Não foi possivel achar essa tela para fechar, favor use um dos seguintes: (login, registro)");
	}
	}
	static public void abrirPagamentoDialog() {
		AnchorPane conteudoDialog = null;
		try {
			conteudoDialog = (AnchorPane) FXMLLoader.load(new File("src/sistema/gui/view/TelaPagamento.fxml").toURI().toURL());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Stage novo = new Stage();
		novo.setTitle("TelaDeEnganaçãoDeTrouxas.exe");
		novo.initModality(Modality.WINDOW_MODAL);
		novo.setResizable(false);
		novo.initOwner(estagio);
		Scene cena = new Scene(conteudoDialog);
		novo.setScene(cena);
		telaPagamento=novo;
		novo.showAndWait();
	}
	static public void fecharTelaPagamento () {
		telaPagamento.close();
	}
	static public void fecharTela () {
		estagio.close();
	}
	static public void minimizarTela () {
		estagio.setIconified(true);
	}
}
