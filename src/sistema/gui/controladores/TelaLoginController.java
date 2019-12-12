package sistema.gui.controladores;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import sistema.controlador.Controlador;
import sistema.gui.TerraPlanizer;

public class TelaLoginController {
	boolean deveVerSenha = false;
	Controlador controlador = Controlador.getInstancia();
    @FXML
    private JFXTextField tfNome;
	
    @FXML
    private Label labelTopo;
    
    @FXML
    private JFXPasswordField pfSenha;

    @FXML
    private Label labelDown;
    
    @FXML
    private Pane paneVerSenha;

    @FXML
    private FontAwesomeIconView verSenha;

    @FXML
    private Pane paneNaoVerSenha;
    @FXML
    private JFXTextField tfSenha;

    @FXML
    private FontAwesomeIconView naoVerSenha;

    @FXML
    void abrirRegistrarConta(MouseEvent event) {
    	TerraPlanizer.trocarTela("registro");
    }

    @FXML
    void fecharTela(MouseEvent event) {
    	TerraPlanizer.fecharTela();
    }

    @FXML
    void logar(ActionEvent event) {
    	if(controlador.pesquisarPorLogin(tfNome.getText())!= null && !tfNome.getText().isEmpty()) {
    		labelTopo.setText("");
    		if (controlador.pesquisarPorLogin(tfNome.getText()).getSenha().contentEquals(pfSenha.getText())) {
    			labelDown.setText("");
    			controlador.setUsuarioLogado(controlador.pesquisarPorLogin(tfNome.getText()));
    			TerraPlanizer.initLogada();
    			TerraPlanizer.trocarTela("logada");
    		}
    		else {
    			labelDown.setText("Sua senha não corresponde");
        		labelDown.setTextFill(Color.DARKRED);
    		}
    		
    	}
    	else {
    		labelDown.setText("");
    		labelTopo.setText("Não existe esse login");
    		labelTopo.setTextFill(Color.DARKRED);
    	}
    }
    @FXML
    void digitar() {
    	pfSenha.setText(tfSenha.getText());
    }
    @FXML
    void digitar1() {
    	tfSenha.setText(pfSenha.getText());
    }
    @FXML
    void initialize() {
    	tfNome.setPromptText("Digite seu login");
    	pfSenha.setPromptText("Digite sua senha");
    	tfSenha.setPromptText("Digite sua senha");
    	tfSenha.setVisible(false);
    }
    @FXML
    void minimizarTela(MouseEvent event) {
    	TerraPlanizer.minimizarTela();
    }
    @FXML
    void pagarDinheiros(MouseEvent event) {
    	TerraPlanizer.abrirPagamentoDialog();
    }
    
    @FXML
    void verSenha(MouseEvent event) {
    	deveVerSenha = !deveVerSenha;
    	if(deveVerSenha) {
    		verSenha.setIcon(FontAwesomeIcon.EYE);
    		pfSenha.setVisible(false);
    		tfSenha.setVisible(true);
    	}
    	else {
    		verSenha.setIcon(FontAwesomeIcon.EYE_SLASH);
    		pfSenha.setVisible(true);
    		tfSenha.setVisible(false);
    	}
    	
    }
   
}
