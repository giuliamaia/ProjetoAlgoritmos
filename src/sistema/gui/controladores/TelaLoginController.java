package sistema.gui.controladores;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import sistema.controlador.Controlador;
import sistema.gui.TerraPlanizer;

public class TelaLoginController {
	Controlador controlador = Controlador.getInstancia();
    @FXML
    private JFXTextField tfNome;
	
    @FXML
    private Label labelTopo;
    
    @FXML
    private JFXPasswordField pfSenha;

    @FXML
    void abrirRegistrarConta(ActionEvent event) {
    	TerraPlanizer.trocarTela("registro");
    }

    @FXML
    void fecharTela(MouseEvent event) {
    	TerraPlanizer.fecharTela();
    }

    @FXML
    void logar(ActionEvent event) {
    	TerraPlanizer.trocarTela("logada");
    }
    
    @FXML
    void minimizarTela(MouseEvent event) {
    	TerraPlanizer.minimizarTela();
    }

}
